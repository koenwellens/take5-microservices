package be.wellens.it.take5.cards.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.assertj.core.api.Assertions.assertThat;

class ScoreCalculationServiceTest {

    private ScoreCalculationService scoreCalculationService;

    @BeforeEach
    void setUp() {
        scoreCalculationService = new ScoreCalculationService();
    }

    @ParameterizedTest(name = "a card with number {0} has score {1}")
    @CsvFileSource(resources= "/calculation.csv", numLinesToSkip = 1)
    void worksCorrectly(int input, int expected) {
        int computedScore = scoreCalculationService.computeScore(input);

        assertThat(computedScore).isEqualTo(expected);
    }
}