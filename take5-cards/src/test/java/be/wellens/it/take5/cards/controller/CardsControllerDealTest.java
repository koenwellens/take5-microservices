package be.wellens.it.take5.cards.controller;

import be.wellens.it.take5.api.Deck;
import be.wellens.it.take5.cards.requests.DealRequest;
import be.wellens.it.take5.cards.responses.DealResponse;
import be.wellens.it.take5.cards.service.CreateNewDeckService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static be.wellens.it.take5.api.CardConstants.LAST_CARD;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ContextConfiguration(classes = ControllerTestConfig.class)
@ExtendWith(SpringExtension.class)
@WebMvcTest(value = CardsController.class)
class CardsControllerDealTest {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    private static final ObjectReader OBJECT_READER = OBJECT_MAPPER.readerFor(DealResponse.class);
    private static final ObjectWriter OBJECT_WRITER = OBJECT_MAPPER.writerFor(DealRequest.class);

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CreateNewDeckService createNewDeckService;

    @Test
    void deals4CardsCorrectly() throws Exception {
        dealsCardsCorrectly(4);
    }

    @Test
    void deals10CardsCorrectly() throws Exception {
        dealsCardsCorrectly(10);
    }

    void dealsCardsCorrectly(int numberOfCards) throws Exception {
        Deck deck = createNewDeckService.createNew();

        MvcResult mvcResult = mockMvc.perform(
                post("/cards/deal")
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(OBJECT_WRITER.writeValueAsString(new DealRequest(deck, numberOfCards)))
        )
                .andExpect(status().isOk())
                .andReturn();

        String jsonResponseBody = mvcResult.getResponse().getContentAsString();
        DealResponse response = OBJECT_READER.readValue(jsonResponseBody);

        assertThat(response).isNotNull();
        assertThat(response.getDeltCards()).hasSize(numberOfCards);
        assertThat(response.getNewDeck()).isNotNull();
        assertThat(response.getNewDeck().getCards()).hasSize(LAST_CARD - numberOfCards);
    }
}