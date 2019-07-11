package be.wellens.it.take5.cards.controller;

import be.wellens.it.take5.api.Deck;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static be.wellens.it.take5.api.CardConstants.LAST_CARD;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ContextConfiguration(classes = ControllerTestConfig.class)
@ExtendWith(SpringExtension.class)
@WebMvcTest(value = CardsController.class)
class CardsControllerGetNewDeckTest {

    private static final ObjectReader OBJECT_READER = new ObjectMapper().readerFor(Deck.class);

    @Autowired
    private MockMvc mockMvc;

    @Test
    void returns104Cards() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/cards/new"))
                .andExpect(status().isOk())
                .andReturn();

        String jsonResponseBody = mvcResult.getResponse().getContentAsString();
        Deck response = OBJECT_READER.readValue(jsonResponseBody);

        assertThat(response).isNotNull();
        assertThat(response.getCards()).isNotNull();
        assertThat(response.getCards()).hasSize(LAST_CARD);
    }
}