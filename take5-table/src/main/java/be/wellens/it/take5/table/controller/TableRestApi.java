package be.wellens.it.take5.table.controller;

import be.wellens.it.take5.api.Table;
import be.wellens.it.take5.table.request.AddCardToTableRequest;
import be.wellens.it.take5.table.request.IsTableArrayFullRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

import static be.wellens.it.take5.table.controller.TableRestApi.PATH;

@RequestMapping(value = PATH)
public interface TableRestApi {

    static final String PATH = "table";

    @PostMapping(value = "/is-array-full")
    boolean isTableArrayFull(@RequestBody @Valid IsTableArrayFullRequest isTableArrayFullRequest);

    @PutMapping
    Table addCardToTable(@RequestBody @Valid AddCardToTableRequest addCardToTableRequest);
}
