package be.wellens.it.take5.cards.controller;

import be.wellens.it.take5.api.Deck;
import be.wellens.it.take5.cards.requests.CheckEmptyRequest;
import be.wellens.it.take5.cards.requests.DealRequest;
import be.wellens.it.take5.cards.requests.ShuffleRequest;
import be.wellens.it.take5.cards.responses.DealResponse;
import be.wellens.it.take5.cards.service.CheckForEmptyService;
import be.wellens.it.take5.cards.service.DealService;
import be.wellens.it.take5.cards.service.ShuffleService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController("cards")
@Validated
public class CardsController {

    private final DealService dealService;
    private final ShuffleService shuffleService;
    private final CheckForEmptyService checkForEmptyService;

    public CardsController(DealService dealService,
                           ShuffleService shuffleService,
                           CheckForEmptyService checkForEmptyService) {
        this.dealService = dealService;
        this.shuffleService = shuffleService;
        this.checkForEmptyService = checkForEmptyService;
    }

    @PostMapping(value = "deal")
    public DealResponse deal(@RequestBody @Valid DealRequest dealRequest) {
        return dealService.deal(dealRequest.getDeck(), dealRequest.getNumberOfCards());
    }

    @PostMapping(value = "shuffle")
    public Deck shuffle(@RequestBody @Valid ShuffleRequest shuffleRequest) {
        return shuffleService.shuffle(shuffleRequest.getCards());
    }

    @GetMapping(value = "empty")
    public boolean isEmpty(@RequestBody @Valid CheckEmptyRequest checkEmptyRequest) {
        return checkForEmptyService.isEmpty(checkEmptyRequest.getCards());
    }
}
