package be.wellens.it.take5.cards.responses;

import be.wellens.it.take5.api.Card;
import be.wellens.it.take5.api.Deck;
import lombok.AllArgsConstructor;
import lombok.Value;

import java.util.List;

@AllArgsConstructor
@Value
public class DealResponse {

    private List<Card> deltCards;
    private Deck newDeck;
}
