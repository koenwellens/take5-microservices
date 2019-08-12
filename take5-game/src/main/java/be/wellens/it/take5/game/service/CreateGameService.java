package be.wellens.it.take5.game.service;

import be.wellens.it.take5.api.Deck;
import be.wellens.it.take5.api.Game;
import be.wellens.it.take5.api.Player;
import be.wellens.it.take5.api.Table;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Stream.concat;

@Service
@Slf4j
public class CreateGameService {

    private static final Random RANDOM_GENERATOR = new Random();
    private static final int FIRST_TURN = 1;
    private static final List<String> PLAYER_NAMES = asList();

    public Game createGame(Deck deck, int numberOfPlayers, String playerName) {
        List<Player> players = concat(
                Stream.of(createPlayer(playerName)),
                IntStream.range(1, numberOfPlayers)
                        .mapToObj(index -> createRandomPlayer())
        ).collect(toList());

        return new Game(deck, players, new Table(), FIRST_TURN);
    } // TODO test

    private Player createRandomPlayer() {
        int randomIndex = RANDOM_GENERATOR.nextInt(PLAYER_NAMES.size());
        String randomName = PLAYER_NAMES.get(randomIndex);
        return createPlayer(randomName);
    }

    private Player createPlayer(String name) {
        return new Player(name, 0, emptyList());
    }
}
