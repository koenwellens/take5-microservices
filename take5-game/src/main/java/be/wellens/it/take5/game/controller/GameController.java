package be.wellens.it.take5.game.controller;

import be.wellens.it.take5.api.Game;
import be.wellens.it.take5.game.request.CreateGameRequest;
import be.wellens.it.take5.game.response.WinnerResponse;
import be.wellens.it.take5.game.service.ComputeWinnerService;
import be.wellens.it.take5.game.service.CreateGameService;
import be.wellens.it.take5.game.service.UpdateGameService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "game")
@Validated
public class GameController {

    private final CreateGameService createGameService;
    private final UpdateGameService updateGameService;
    private final ComputeWinnerService computeWinnerService;

    public GameController(CreateGameService createGameService,
                          UpdateGameService updateGameService,
                          ComputeWinnerService computeWinnerService) {
        this.createGameService = createGameService;
        this.updateGameService = updateGameService;
        this.computeWinnerService = computeWinnerService;
    }

    @PostMapping
    public Game createGame(@RequestBody @Valid CreateGameRequest createGameRequest) {
        return createGameService.createGame(
                createGameRequest.getDeck(),
                createGameRequest.getNumberOfPlayers(),
                createGameRequest.getPlayerName()
        );
    }

    @PutMapping
    public Game updateGame(@RequestBody @Valid Game game) {
        return updateGameService.updateGame(game);
    }

    @PostMapping(value = "winner")
    public WinnerResponse computeWinner(@RequestBody @Valid Game game) {
        return computeWinnerService.computeWinner(game);
    }
}
