package be.wellens.it.take5.cards.service;

import be.wellens.it.take5.api.Card;
import be.wellens.it.take5.api.Deck;
import be.wellens.it.take5.cards.responses.DealResponse;
import be.wellens.it.take5.cards.responses.DealResponseFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

@Service
@Slf4j
public class DealService {

    private final DealResponseFactory dealResponseFactory;

    public DealService(DealResponseFactory dealResponseFactory) {
        this.dealResponseFactory = dealResponseFactory;
    }

    public DealResponse deal(Deck deck, int numberOfCardsToDeal) {
        List<Card> cards = getCards(deck);
        if (cards.size() <= numberOfCardsToDeal) {
            return dealResponseFactory.create(cards);
        }

        List<Card> deltCards = IntStream.range(0, numberOfCardsToDeal)
                .mapToObj(cards::remove)
                .collect(toList());

        return dealResponseFactory.create(deltCards, cards);
    }

    private List<Card> getCards(Deck deck) {
        return new ArrayList<>(deck.getCards());
    }
}
