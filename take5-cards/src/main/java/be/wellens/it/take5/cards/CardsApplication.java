package be.wellens.it.take5.cards;

import be.wellens.it.take5.cards.config.CardsProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class CardsApplication {

    public CardsApplication(CardsProperties cardsProperties) {
        log.info("version: " + cardsProperties.getVersion());
        log.info("artifactId: " + cardsProperties.getArtifactId());
    }

    public static void main(String[] args) {
        SpringApplication.run(CardsApplication.class, args);
    }
}
