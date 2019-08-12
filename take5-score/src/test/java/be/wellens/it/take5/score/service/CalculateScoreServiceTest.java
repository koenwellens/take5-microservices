package be.wellens.it.take5.score.service;

import be.wellens.it.take5.api.Card;
import be.wellens.it.take5.score.response.CalculateScoreResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static be.wellens.it.take5.score.service.CalculateScoreResponseAssert.assertThat;
import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;

class CalculateScoreServiceTest {

    private CalculateScoreService calculateScoreService;

    @BeforeEach
    void setUp() {
        calculateScoreService = new CalculateScoreService();
    }

    @Test
    void returnsZeroWhenListIsNull() {
        CalculateScoreResponse result = calculateScoreService.calculateScore(null);

        assertThat(result).hasScoreZero();
    }

    @Test
    void returnsZeroWhenListIsEmpty() {
        CalculateScoreResponse result = calculateScoreService.calculateScore(emptyList());

        assertThat(result).hasScoreZero();
    }

    @Test
    void returnsSumCorrectly() {
        List<Card> cards = asList(new Card(1, 1), new Card(5, 2), new Card(55, 7));
        CalculateScoreResponse result = calculateScoreService.calculateScore(cards);

        assertThat(result).hasScore(10);
    }
}