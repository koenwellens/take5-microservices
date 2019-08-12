package be.wellens.it.take5.game.request;

import be.wellens.it.take5.api.Deck;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.Value;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import static be.wellens.it.take5.api.GameConstants.MAXIMUM_NUMBER_OF_PLAYERS;
import static be.wellens.it.take5.api.GameConstants.MINIMUM_NUMBER_OF_PLAYERS;

@AllArgsConstructor
@NoArgsConstructor(force = true) // JSON
@ToString
@Value
public class CreateGameRequest {

    @NotNull
    @Valid
    private Deck deck;
    @NotNull
    @Min(MINIMUM_NUMBER_OF_PLAYERS)
    @Max(MAXIMUM_NUMBER_OF_PLAYERS)
    private Integer numberOfPlayers;
    @NotEmpty
    private String playerName;
}
