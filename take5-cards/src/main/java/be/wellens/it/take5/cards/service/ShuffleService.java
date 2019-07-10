package be.wellens.it.take5.cards.service;

import be.wellens.it.take5.api.Card;
import be.wellens.it.take5.api.Deck;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@Slf4j
public class ShuffleService {

    public Deck shuffle(List<Card> cards) {
        List<Card> shuffledCards = new ArrayList<>(cards);
        Collections.shuffle(shuffledCards);

        return new Deck(shuffledCards);
    }
}
