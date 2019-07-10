package be.wellens.it.take5.cards.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.IntPredicate;

import static be.wellens.it.take5.api.CardConstants.MAXIMUM_SCORE;
import static be.wellens.it.take5.api.CardConstants.MINIMUM_SCORE;
import static java.util.Arrays.asList;

@Service
@Slf4j
public class ScoreCalculationService {

    private static final List<Score> SCORES = asList(
            new Score(MAXIMUM_SCORE, number -> number == 55),
            new Score(5, number -> number % 11 == 0),
            new Score(3, number -> number % 10 == 0),
            new Score(2, number -> number % 5 == 0)
    );

    public int computeScore(int cardNumber) {
        return SCORES.stream()
                .filter(score -> score.isApplicableFor(cardNumber))
                .map(Score::getValue)
                .findFirst()
                .orElse(MINIMUM_SCORE);
    }

    @AllArgsConstructor
    static class Score {
        @Getter
        private int value;
        private IntPredicate applicableForCardNumber;

        boolean isApplicableFor(int number) {
            return applicableForCardNumber.test(number);
        }
    }
}
