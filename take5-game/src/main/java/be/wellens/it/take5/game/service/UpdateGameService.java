package be.wellens.it.take5.game.service;

import be.wellens.it.take5.api.Game;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UpdateGameService {

    public Game updateGame(Game game) {
        int nextTurn = game.getCurrentTurn() + 1;
        return new Game(game.getDeck(), game.getPlayers(), game.getTable(), nextTurn);
    } // TODO test
}
