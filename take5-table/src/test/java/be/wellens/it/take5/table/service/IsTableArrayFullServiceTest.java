package be.wellens.it.take5.table.service;

import be.wellens.it.take5.api.Card;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static be.wellens.it.take5.table.service.CardGenerator.aRandomCard;
import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;
import static org.assertj.core.api.Assertions.assertThat;

class IsTableArrayFullServiceTest {

    private IsTableArrayFullService isTableArrayFullService;

    @BeforeEach
    void setUp() {
        isTableArrayFullService = new IsTableArrayFullService();
    }

    @Test
    void returnsFalseWhenRowIsNull() {
        boolean result = isTableArrayFullService.isTableArrayFull(null);

        assertThat(result).isFalse();
    }

    @Test
    void returnsFalseWhenRowIsEmpty() {
        boolean result = isTableArrayFullService.isTableArrayFull(emptyList());

        assertThat(result).isFalse();
    }

    @Test
    void returnsFalseWhenRowIsNotAtMaximum() {
        boolean result = isTableArrayFullService.isTableArrayFull(singletonList(aRandomCard()));

        assertThat(result).isFalse();
    }

    @Test
    void returnsFalseWhenRowIsAtMaximum() {
        List<Card> cards = asList(aRandomCard(), aRandomCard(), aRandomCard(), aRandomCard());
        boolean result = isTableArrayFullService.isTableArrayFull(cards);

        assertThat(result).isFalse();
    }

    @Test
    void returnsTrueWhenRowIsOverMaximum() {
        List<Card> cards = asList(aRandomCard(), aRandomCard(), aRandomCard(), aRandomCard(), aRandomCard());
        boolean result = isTableArrayFullService.isTableArrayFull(cards);

        assertThat(result).isTrue();
    }
}