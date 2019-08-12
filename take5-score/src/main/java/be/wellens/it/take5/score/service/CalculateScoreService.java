package be.wellens.it.take5.score.service;

import be.wellens.it.take5.api.Card;
import be.wellens.it.take5.score.response.CalculateScoreResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Collections.emptyList;
import static org.apache.commons.collections4.ListUtils.defaultIfNull;

@Service
@Slf4j
public class CalculateScoreService {

    public CalculateScoreResponse calculateScore(List<Card> cards) {
        int score = defaultIfNull(cards, emptyList())
                .stream()
                .mapToInt(Card::getScore)
                .sum();

        return new CalculateScoreResponse(score);
    }
}
