package group.msg.at.cloud.cloudtrain.core.boundary;

import group.msg.at.cloud.cloudtrain.core.entity.Message;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import java.util.UUID;

/**
 * Simple {@code Boundary} that returns welcome messages.
 */
@ApplicationScoped
@Transactional
public class HelloWorld {

    @Inject
    @ConfigProperty(name = "cloudtrain.config.stringValue", defaultValue = "???cloudtrain.config.stringValue???")
    String configStringValue;

    @Inject
    @ConfigProperty(name = "cloudtrain.config.numericValue", defaultValue = "-1")
    int configNumericValue;

    public Message getHelloMessage() {
        return new Message(UUID.randomUUID(), "hello", String.format("Welcome to Cloud Native Java with %s! configNumericValue : %d", this.configStringValue, this.configNumericValue));
    }
}
