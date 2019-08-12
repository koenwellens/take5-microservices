package be.wellens.it.take5.game.service;

import be.wellens.it.take5.api.Game;
import be.wellens.it.take5.api.Player;
import be.wellens.it.take5.game.response.WinnerResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.ListUtils;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;
import static org.apache.commons.collections4.ListUtils.select;

@Service
@Slf4j
public class ComputeWinnerService {

    public WinnerResponse computeWinner(Game game) {
        List<Player> sortedListOfPlayers = game.getPlayers()
                .stream()
                .sorted(comparing(Player::getScore))
                .collect(toList());

        List<Player> winners = select(sortedListOfPlayers, player -> player.getScore().equals(sortedListOfPlayers.get(0).getScore()));
        return new WinnerResponse(winners);
    } // TODO test
}
