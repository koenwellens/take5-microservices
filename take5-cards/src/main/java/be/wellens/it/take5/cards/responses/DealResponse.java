package be.wellens.it.take5.cards.responses;

import be.wellens.it.take5.api.Card;
import be.wellens.it.take5.api.Deck;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor(force = true) // JSON
@Value
public class DealResponse {

    private List<Card> deltCards;
    private Deck newDeck;
}
