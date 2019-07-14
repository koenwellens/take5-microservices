package be.wellens.it.take5.table.request;

import be.wellens.it.take5.api.Card;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.Value;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor(force = true) // JSON
@ToString
@Value
public class IsTableArrayFullRequest {

    private List<Card> cards;
}
