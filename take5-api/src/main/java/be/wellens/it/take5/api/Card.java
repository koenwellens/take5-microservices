package be.wellens.it.take5.api;

import lombok.AllArgsConstructor;
import lombok.ToString;
import lombok.Value;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@ToString
@Value
public class Card {

    @NotNull
    @Min(1)
    @Max(104)
    private Integer number;

    @NotNull
    @Min(1)
    @Max(7)
    private Integer score;

}
