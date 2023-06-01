# cnj-config-backend-quarkus

Cloud native Java backend based demonstrating application configuration with MP Config based on Quarkus.

## Status

![Build status](ttps://codebuild.eu-west-1.amazonaws.com/badges?uuid=eyJlbmNyeXB0ZWREYXRhIjoidURBcHVMS3hEYmZRVlRqN20yUGVCeGlYZk5Fc2tGaEIya0lQRFE0SXdOZCtKQklGODVkTnE4dlBMOVNaWnI3ZGM0VlVhNndUVTk0eUZqT0xzdTdXY2Z3PSIsIml2UGFyYW1ldGVyU3BlYyI6ImpvT0ZFVk1ZSWNnb2VSOXAiLCJtYXRlcmlhbFNldFNlcmlhbCI6MX0%3D&branch=main)

## Release Information

A changelog can be found in [changelog.md](changelog.md).

## Docker Pull Command

`docker pull docker.cloudtrain.aws.msgoat.eu/cloudtrain/cnj-config-backend-quarkus`

## Run this application

```shell 
docker run --name cnj-config-backend-quarkus -p 8080:8080 docker.cloudtrain.aws.msgoat.eu/cloudtrain/cnj-config-backend-quarkus
```

## Build this application

```shell 
mvn clean verify -P pre-commit-stage
```

Build results: a Docker image containing a Quarkus application.
