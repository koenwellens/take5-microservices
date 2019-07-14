package be.wellens.it.take5.api;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.Value;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

import static be.wellens.it.take5.api.GameConstants.MAXIMUM_NUMBER_OF_PLAYERS;
import static be.wellens.it.take5.api.GameConstants.MINIMUM_NUMBER_OF_PLAYERS;

@AllArgsConstructor
@NoArgsConstructor(force = true) // JSON
@ToString
@Value
public class Game {

    @NotNull
    @Valid
    private Deck deck;
    @NotNull
    @Min(MINIMUM_NUMBER_OF_PLAYERS)
    @Max(MAXIMUM_NUMBER_OF_PLAYERS)
    private List<@NotNull @Valid Player> players;
    @NotNull
    @Valid
    private Table table;
}
