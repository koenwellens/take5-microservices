package be.wellens.it.take5.cards.controller;

import be.wellens.it.take5.api.Deck;
import be.wellens.it.take5.cards.requests.DealRequest;
import be.wellens.it.take5.cards.responses.DealResponse;
import be.wellens.it.take5.cards.service.CreateNewDeckService;
import be.wellens.it.take5.cards.service.DealService;
import be.wellens.it.take5.cards.service.ShuffleService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("cards")
@Validated
public class CardsController {

    private final CreateNewDeckService createNewDeckService;
    private final DealService dealService;
    private final ShuffleService shuffleService;

    public CardsController(CreateNewDeckService createNewDeckService,
                           DealService dealService,
                           ShuffleService shuffleService) {
        this.createNewDeckService = createNewDeckService;
        this.dealService = dealService;
        this.shuffleService = shuffleService;
    }

    @GetMapping(value = "new")
    public Deck getNewDeck() {
        return createNewDeckService.createNew();
    }

    @PostMapping(value = "deal")
    public DealResponse deal(@RequestBody @Valid DealRequest dealRequest) {
        return dealService.deal(dealRequest.getDeck(), dealRequest.getNumberOfCards());
    }

    @PostMapping(value = "shuffle")
    public Deck shuffle(@RequestBody @Valid Deck deck) {
        return shuffleService.shuffle(deck.getCards());
    }
}
