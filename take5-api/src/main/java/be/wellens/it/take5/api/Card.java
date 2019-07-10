package be.wellens.it.take5.api;

import lombok.AllArgsConstructor;
import lombok.Value;

@AllArgsConstructor
@Value
public class Card {

    private int number;
    private int score;

}
