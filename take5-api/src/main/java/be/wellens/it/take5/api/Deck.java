package be.wellens.it.take5.api;

import lombok.AllArgsConstructor;
import lombok.Value;

import java.util.List;

@AllArgsConstructor
@Value
public class Deck {

    private List<Card> cards;
}
