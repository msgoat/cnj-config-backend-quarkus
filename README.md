# cnj-config-backend-quarkus

Cloud native Java backend based demonstrating application configuration
with [MicroProfile Config](https://microprofile.io/specifications/microprofile-config/)
based on Quarkus.

The application is packaged as a multi-architecture docker image which supports the following platforms:
* linux/amd64
* linux/arm64/v8

## Synopsis

Please check [Maven POM](pom.xml) for details on how-to integrate `MicroProfile Config`
into your application.

The `MicroProfile Config` feature or - more specific - Quarkus implementation of it 
handles multiple configuration sources which
can provide values for configuration parameters. By default, there are the
following configuration sources:
* properties in property file at [application.properties](src/main/resources/application.properties)
* system properties defined as `-D` JVM command line arguments
* environment variables

> __Info__: Although Quarkus supports the default properties file named `microprofile-config.properties` 
> of MicroProfile Config as well, we are using the Quarkus way by adding all configuration properties 
> to `application.properties`.

Values passed as environment variables override values passed as system properties
override values provided via property file.

> __Tip__: Store all static non-confidential configuration values in property files.
> Pass all environment-dependent or confidential configuration values as environment variables.

From an application point of view, configuration values are referenced via
property names and injected via annotation `@ConfigProperty` fields
(see class [HelloWorld](src/main/java/group/msg/at/cloud/cloudtrain/core/boundary/HelloWorld.java)):

```java
    @Inject
    @ConfigProperty(name = "cloudtrain.config.stringValue", defaultValue = "???cloudtrain.config.stringValue???")
    String configStringValue;
```

`MicroProfile Config` will handle all required type conversions.
Annotation attribute `name` defines the property name of the configuration value.
The mapping from property names to environment variable names will be done by `MicroProfile Config`
automatically.
Default values for missing configuration values can be defined using the `defaultValue` attribute.

> __Attention__: If a value for a referenced configuration value is missing and no
> default value has been provided, the application will fail to start!

`MicroProfile Config` provided an injectable `Config` object which provides access
to the API of `MicroProfile Config`:

```java
    @Inject
    Config config;
```

This `Config` object exposes methods to read configuration values programmatically, if needed.

## Status

![Build status](ttps://codebuild.eu-west-1.amazonaws.com/badges?uuid=eyJlbmNyeXB0ZWREYXRhIjoidURBcHVMS3hEYmZRVlRqN20yUGVCeGlYZk5Fc2tGaEIya0lQRFE0SXdOZCtKQklGODVkTnE4dlBMOVNaWnI3ZGM0VlVhNndUVTk0eUZqT0xzdTdXY2Z3PSIsIml2UGFyYW1ldGVyU3BlYyI6ImpvT0ZFVk1ZSWNnb2VSOXAiLCJtYXRlcmlhbFNldFNlcmlhbCI6MX0%3D&branch=main)

## Release Information

A changelog can be found in [changelog.md](changelog.md).

## Docker Pull Command

`docker pull docker.cloudtrain.aws.msgoat.eu/cloudtrain/cnj-config-backend-quarkus`

## Helm Pull Command

`helm pull oci://docker.cloudtrain.aws.msgoat.eu/cloudtrain-charts/cnj-config-backend-quarkus`

## HOW-TO build this application locally

If all prerequisites are met, just run the following Maven command in the project folder:

```shell 
mvn clean verify -P pre-commit-stage
```

Build results: a Docker image containing the showcase application.

## HOW-TO start and stop this showcase locally

In order to run the whole showcase locally, just run the following docker commands in the project folder:

```shell 
docker compose up -d
docker compose logs -f 
```

Press `Ctlr+c` to stop tailing the container logs and run the following docker command to stop the show case:

```shell 
docker compose down
```

## HOW-TO demo this showcase

The showcase application will be accessible:
* locally via `http://localhost:38080`
* remotely via `https://train2023-dev.k8s.cloudtrain.aws.msgoat.eu/cloudtrain/cnj-config-backend-quarkus` (if the training cluster is up and running)

Send a simple GET request to endpoint URI `/api/v1/hello` and you will get a simple welcome message in JSON format:

```json
{ 
  "code":"hello",
  "id":"73127522-d6ca-4a9f-916c-790e3c8aea77",
  "text":"Welcome to Cloud Native Java with environmentVariables! configNumericValue : 456"
}
```

As you can see, the actual configuration values are pulled from environment variables rather than properties in the `microprofile-config.properties`.