package be.wellens.it.take5.cards.service;

import be.wellens.it.take5.api.Card;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class CheckForEmptyService {

    public boolean isEmpty(List<Card> cards) {
        return new ArrayList<>(cards).isEmpty();
    }
}
