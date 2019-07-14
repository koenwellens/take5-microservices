package be.wellens.it.take5.table.service;

import be.wellens.it.take5.api.Card;
import be.wellens.it.take5.api.Table;
import be.wellens.it.take5.table.exception.CardCannotBeAddedToTableException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;
import static java.util.stream.Collectors.toList;
import static org.apache.commons.collections4.ListUtils.defaultIfNull;
import static org.apache.commons.collections4.ListUtils.indexOf;
import static org.apache.commons.collections4.ListUtils.union;

@Service
@Slf4j
public class AddCardToTableService {

    public Table addCardToTable(Table table, Card card) {
        List<List<Card>> cardsOnTheTable = asList(table.getRow1(), table.getRow2(), table.getRow3(), table.getRow4());

        int indexOfRowToUpdate = findIndexOfRowToUpdate(cardsOnTheTable, card);

        List<Card> firstRow = adaptRowIfNecessary(cardsOnTheTable, 0, card, indexOfRowToUpdate);
        List<Card> secondRow = adaptRowIfNecessary(cardsOnTheTable, 1, card, indexOfRowToUpdate);
        List<Card> thirdRow = adaptRowIfNecessary(cardsOnTheTable, 2, card, indexOfRowToUpdate);
        List<Card> fourthRow = adaptRowIfNecessary(cardsOnTheTable, 3, card, indexOfRowToUpdate);

        return new Table(firstRow, secondRow, thirdRow, fourthRow);
    }

    private List<Card> adaptRowIfNecessary(List<List<Card>> cardsOnTheTable, int currentRowIndex, Card card, int indexOfRowToUpdate) {
        List<Card> row = cardsOnTheTable.get(currentRowIndex);

        if (currentRowIndex == indexOfRowToUpdate) {
            List<Card> rowToUpdate = defaultIfNull(row, emptyList());
            return union(rowToUpdate, singletonList(card));
        }

        return row;
    }

    private int findIndexOfRowToUpdate(List<List<Card>> cardsOnTheTable, Card card) {
        int indexOfFirstEmptyRow = indexOf(cardsOnTheTable, CollectionUtils::isEmpty);

        if (indexOfFirstEmptyRow > -1) {
            return indexOfFirstEmptyRow;
        }

        return findIndexBasedOnCard(cardsOnTheTable, card);
    }

    private int findIndexBasedOnCard(List<List<Card>> cardsOnTheTable, Card card) {
        List<Integer> differencesWithLastCards = cardsOnTheTable.stream()
                .map(CollectionUtils::lastElement)
                .map(Card::getNumber)
                .map(lastCardNumber -> card.getNumber() - lastCardNumber)
                .collect(toList());

        return differencesWithLastCards.stream()
                .filter(difference -> difference > 0)
                .sorted()
                .findFirst()
                .map(differencesWithLastCards::indexOf)
                .orElseThrow(CardCannotBeAddedToTableException::new);
    }
}
