package be.wellens.it.take5.score.controller;

import be.wellens.it.take5.score.request.CalculateScoreRequest;
import be.wellens.it.take5.score.response.CalculateScoreResponse;
import be.wellens.it.take5.score.service.CalculateScoreService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "score")
@Validated
public class ScoreController {

    private final CalculateScoreService calculateScoreService;

    public ScoreController(CalculateScoreService calculateScoreService) {
        this.calculateScoreService = calculateScoreService;
    }

    @PostMapping
    public CalculateScoreResponse calculateScore(@RequestBody @Valid CalculateScoreRequest calculateScoreRequest) {
        return calculateScoreService.calculateScore(calculateScoreRequest.getCards());
    }
}
