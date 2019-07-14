package be.wellens.it.take5.table.request;

import be.wellens.it.take5.api.Card;
import be.wellens.it.take5.api.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.Value;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor(force = true) // JSON
@ToString
@Value
public class AddCardToTableRequest {

    @NotNull
    @Valid
    private Table table;
    @NotNull
    @Valid
    private Card card;
}
