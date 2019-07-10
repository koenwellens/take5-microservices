package be.wellens.it.take5.api;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.Value;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import static be.wellens.it.take5.api.CardConstants.FIRST_CARD;
import static be.wellens.it.take5.api.CardConstants.LAST_CARD;
import static be.wellens.it.take5.api.CardConstants.MAXIMUM_SCORE;
import static be.wellens.it.take5.api.CardConstants.MINIMUM_SCORE;

@AllArgsConstructor
@NoArgsConstructor(force = true) // JSON
@ToString
@Value
public class Card {

    @NotNull
    @Min(FIRST_CARD)
    @Max(LAST_CARD)
    private Integer number;

    @NotNull
    @Min(MINIMUM_SCORE)
    @Max(MAXIMUM_SCORE)
    private Integer score;

}
