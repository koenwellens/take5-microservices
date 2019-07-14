package be.wellens.it.take5.table.service;

import be.wellens.it.take5.api.Card;

import java.util.Random;

import static be.wellens.it.take5.api.CardConstants.FIRST_CARD;
import static be.wellens.it.take5.api.CardConstants.LAST_CARD;

public class CardGenerator {

    private static final Random RANDOM_GENERATOR = new Random();

    public static Card aRandomCard() {
        int cardNumber = FIRST_CARD + RANDOM_GENERATOR.nextInt(LAST_CARD - FIRST_CARD);
        return new Card(cardNumber, 1);
    }
}
