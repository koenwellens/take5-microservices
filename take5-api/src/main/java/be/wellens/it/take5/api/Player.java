package be.wellens.it.take5.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Value
public class Player {

    private String name;
    private int score;
    @Builder.Default
    private List<Card> hand = new ArrayList<>();
}
