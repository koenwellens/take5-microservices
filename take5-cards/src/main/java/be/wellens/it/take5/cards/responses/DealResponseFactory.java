package be.wellens.it.take5.cards.responses;

import be.wellens.it.take5.api.Card;
import be.wellens.it.take5.api.Deck;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.Collections.emptyList;

@Component
public class DealResponseFactory {

    public DealResponse create(List<Card> cards) {
        return create(cards, emptyList());
    }

    public DealResponse create(List<Card> deltCards, List<Card> newDeck) {
        return new DealResponse(deltCards, new Deck(newDeck));
    }
}
