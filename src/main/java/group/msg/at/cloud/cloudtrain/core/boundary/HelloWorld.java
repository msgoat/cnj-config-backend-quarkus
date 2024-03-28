package group.msg.at.cloud.cloudtrain.core.boundary;

import group.msg.at.cloud.cloudtrain.core.entity.Message;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import java.util.Locale;
import java.util.UUID;

/**
 * Simple {@code Boundary} that returns welcome messages.
 */
@ApplicationScoped
@Transactional
public class HelloWorld {

    @Inject
    @ConfigProperty(name = "cloudtrain.config.stringValue", defaultValue = "???cloudtrain.config.stringValue???")
    String stringConfigValue;


    @Inject
    @ConfigProperty(name = "cloudtrain.config.numericValue", defaultValue = "-1")
    int numericConfigValue;

    public Message getHelloMessage() {
        Message result = new Message(UUID.randomUUID());
        result.setCode("hello");
        result.setText("Welcome to Cloud Native Java with Quarkus!");
        result.setStringConfigValue(stringConfigValue);
        result.setNumericConfigValue(numericConfigValue);
        result.setLocale(Locale.ENGLISH);
        return result;
    }
}
