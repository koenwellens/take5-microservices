package be.wellens.it.take5.cards.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties("project")
public class CardsProperties {
    private String version;
    private String artifactId;
}