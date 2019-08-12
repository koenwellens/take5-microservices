package be.wellens.it.take5.game.response;

import be.wellens.it.take5.api.Player;
import lombok.AllArgsConstructor;
import lombok.Value;

import java.util.List;

@AllArgsConstructor
@Value
public class WinnerResponse {

    private List<Player> players;
}
