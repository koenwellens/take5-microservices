package be.wellens.it.take5.cards.requests;

import be.wellens.it.take5.api.Deck;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.Value;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor(force = true) // JSON
@ToString
@Value
public class DealRequest {

    @NotNull
    @Valid
    private Deck deck;
    @NotNull
    @Min(4)
    @Max(10)
    private Integer numberOfCards;
}
