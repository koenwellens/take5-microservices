package be.wellens.it.take5.cards.requests;

import be.wellens.it.take5.api.Card;
import lombok.AllArgsConstructor;
import lombok.Value;

import javax.validation.constraints.NotNull;
import java.util.List;

@AllArgsConstructor
@Value
public class CheckEmptyRequest {

    @NotNull
    private List<@NotNull Card> cards;
}
