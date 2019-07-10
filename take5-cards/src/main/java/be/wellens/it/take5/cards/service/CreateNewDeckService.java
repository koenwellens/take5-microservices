package be.wellens.it.take5.cards.service;

import be.wellens.it.take5.api.Card;
import be.wellens.it.take5.api.Deck;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.IntStream;

import static be.wellens.it.take5.api.CardConstants.FIRST_CARD;
import static be.wellens.it.take5.api.CardConstants.LAST_CARD;
import static java.util.stream.Collectors.toList;

@Service
@Slf4j
public class CreateNewDeckService {

    private final ScoreCalculationService scoreCalculationService;

    public CreateNewDeckService(ScoreCalculationService scoreCalculationService) {
        this.scoreCalculationService = scoreCalculationService;
    }

    public Deck createNew() {
        List<Card> cards = IntStream.range(FIRST_CARD, LAST_CARD)
                .mapToObj(this::mapNumberToCard)
                .collect(toList());

        return new Deck(cards);
    }

    private Card mapNumberToCard(int number) {
        return new Card(number, scoreCalculationService.computeScore(number));
    }
}
