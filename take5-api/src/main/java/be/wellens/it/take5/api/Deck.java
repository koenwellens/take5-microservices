package be.wellens.it.take5.api;

import lombok.AllArgsConstructor;
import lombok.ToString;
import lombok.Value;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@AllArgsConstructor
@ToString
@Value
public class Deck {

    @NotNull
    private List<@NotNull @Valid Card> cards;
}
