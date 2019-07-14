package be.wellens.it.take5.table.controller;

import be.wellens.it.take5.api.Table;
import be.wellens.it.take5.table.request.AddCardToTableRequest;
import be.wellens.it.take5.table.request.IsTableArrayFullRequest;
import be.wellens.it.take5.table.service.AddCardToTableService;
import be.wellens.it.take5.table.service.IsTableArrayFullService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@Validated
public class TableController implements TableRestApi {

    private final IsTableArrayFullService isTableArrayFullService;
    private final AddCardToTableService addCardToTableService;

    public TableController(IsTableArrayFullService isTableArrayFullService,
                           AddCardToTableService addCardToTableService) {
        this.isTableArrayFullService = isTableArrayFullService;
        this.addCardToTableService = addCardToTableService;
    }

    public boolean isTableArrayFull(@RequestBody @Valid IsTableArrayFullRequest isTableArrayFullRequest) {
        return isTableArrayFullService.isTableArrayFull(isTableArrayFullRequest.getCards());
    }

    public Table addCardToTable(@RequestBody @Valid AddCardToTableRequest addCardToTableRequest) {
        return addCardToTableService.addCardToTable(addCardToTableRequest.getTable(), addCardToTableRequest.getCard());
    }
}
