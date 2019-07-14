package be.wellens.it.take5.table.service;

import be.wellens.it.take5.api.Card;
import be.wellens.it.take5.api.Table;
import be.wellens.it.take5.table.exception.CardCannotBeAddedToTableException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static be.wellens.it.take5.table.service.CardGenerator.aRandomCard;
import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class AddCardToTableServiceTest {

    private static final Random RANDOM_GENERATOR = new Random();
    private AddCardToTableService addCardToTableService;
    private Card card;

    @BeforeEach
    void setUp() {
        addCardToTableService = new AddCardToTableService();
        card = new Card(55, 7);
    }

    @Test
    void worksCorrectlyForTableWithNoRows() {
        Table table = new Table(emptyList(), emptyList(), emptyList(), emptyList());

        Table result = addCardToTableService.addCardToTable(table, card);
        assertThat(result.getRow1()).containsExactly(card);
        assertThat(result.getRow2()).isEmpty();
        assertThat(result.getRow3()).isEmpty();
        assertThat(result.getRow4()).isEmpty();
    }

    @Test
    void addsCardToSomeEmptyRow() {
        Card card1 = aRandomCard();
        Card card2 = aRandomCard();
        Card card3 = aRandomCard();
        Card card4 = aRandomCard();
        Table table = new Table(singletonList(card1), asList(card2, card3), emptyList(), singletonList(card4));

        Table result = addCardToTableService.addCardToTable(table, this.card);
        assertThat(result.getRow1()).containsExactly(card1);
        assertThat(result.getRow2()).containsExactly(card2, card3);
        assertThat(result.getRow3()).containsExactly(this.card);
        assertThat(result.getRow4()).containsExactly(card4);
    }

    @Test
    void addsCardToRowWithLeastDifference() {
        Card card1 = new Card(13, 1);
        Card card2 = aRandomCard();
        Card card3 = new Card(33, 5);
        Card card4 = new Card(54, 1);
        Card card5 = new Card(100, 3);
        Card card6 = new Card(81, 1);
        Table table = new Table(singletonList(card1), asList(card2, card3), asList(card6, card5), singletonList(card4));

        Table result = addCardToTableService.addCardToTable(table, this.card);
        assertThat(result.getRow1()).containsExactly(card1);
        assertThat(result.getRow2()).containsExactly(card2, card3);
        assertThat(result.getRow3()).containsExactly(card6, card5);
        assertThat(result.getRow4()).containsExactly(card4, this.card);
    }

    @Test
    void addsCardToRowEvenThoughItIsFull() {
        Card card1 = new Card(13, 1);
        Card card2 = new Card(33, 5);
        Card card3 = new Card(35, 5);
        Card card4 = new Card(53, 1);
        Card card5 = new Card(54, 1);
        Card card6 = new Card(100, 3);
        Card card7 = new Card(81, 1);
        Table table = new Table(singletonList(card1), asList(card2, card3, card4, card5), singletonList(card6), singletonList(card7));

        Table result = addCardToTableService.addCardToTable(table, this.card);
        assertThat(result.getRow1()).containsExactly(card1);
        assertThat(result.getRow2()).containsExactly(card2, card3, card4, card5, this.card);
        assertThat(result.getRow3()).containsExactly(card6);
        assertThat(result.getRow4()).containsExactly(card7);
    }

    @Test
    void throwExceptionWhenCardCantBeAdded() {
        Card card1 = new Card(56, 1);
        Card card2 = aRandomCard();
        Card card3 = new Card(70, 5);
        Card card4 = new Card(104, 1);
        Card card5 = new Card(100, 3);
        Card card6 = new Card(81, 1);
        Table table = new Table(singletonList(card1), asList(card2, card3), asList(card6, card5), singletonList(card4));

        assertThatThrownBy(() -> addCardToTableService.addCardToTable(table, this.card))
                .hasMessage("Card cannot be added to the table. There is no row in which it can be played.")
                .isInstanceOf(CardCannotBeAddedToTableException.class);
    }
}