package be.wellens.it.take5.cards.controller;

import be.wellens.it.take5.api.Card;
import be.wellens.it.take5.api.Deck;
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

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ContextConfiguration(classes = ControllerTestConfig.class)
@ExtendWith(SpringExtension.class)
@WebMvcTest(value = CardsController.class)
class CardsControllerShuffleTest {

    private static final ObjectReader OBJECT_READER = new ObjectMapper().readerFor(Deck.class);
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    private static final ObjectWriter OBJECT_WRITER = OBJECT_MAPPER.writerFor(Deck.class);

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private CreateNewDeckService createNewDeckService;

    @Test
    void shufflesTheDeck() throws Exception {
        Deck deck = createNewDeckService.createNew();

        MvcResult mvcResult = mockMvc.perform(
                post("/cards/shuffle")
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(OBJECT_WRITER.writeValueAsString(deck))
        )
                .andExpect(status().isOk())
                .andReturn();

        String jsonResponseBody = mvcResult.getResponse().getContentAsString();
        Deck response = OBJECT_READER.readValue(jsonResponseBody);

        assertThat(response).isNotNull();
        assertThat(response.getCards()).isNotNull();
        assertThat(response.getCards()).containsExactlyInAnyOrder(deck.getCards().toArray(new Card[0]));
        assertThat(response.getCards().get(0)).isNotEqualTo(deck.getCards().get(0));
    }
}