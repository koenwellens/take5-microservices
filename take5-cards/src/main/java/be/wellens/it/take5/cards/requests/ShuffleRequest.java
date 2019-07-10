package be.wellens.it.take5.cards.requests;

import be.wellens.it.take5.api.Card;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.Value;

import javax.validation.constraints.NotNull;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor(force = true) // JSON
@ToString
@Value
public class ShuffleRequest {

    @NotNull
    private List<@NotNull Card> cards;
}
