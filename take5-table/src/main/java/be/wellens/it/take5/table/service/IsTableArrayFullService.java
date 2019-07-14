package be.wellens.it.take5.table.service;

import be.wellens.it.take5.api.Card;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.apache.commons.collections4.CollectionUtils.isEmpty;

@Service
@Slf4j
public class IsTableArrayFullService {

    private static final int NUMBER_OF_ROWS_ON_TABLE = 4;

    public boolean isTableArrayFull(List<Card> row) {
        if (isEmpty(row)) {
            return false;
        }

        return row.size() > NUMBER_OF_ROWS_ON_TABLE;
    }
}
