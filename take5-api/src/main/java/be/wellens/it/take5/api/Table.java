package be.wellens.it.take5.api;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.Value;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor(force = true) // JSON
@ToString
@Value
public class Table {

    @NotNull
    private List<@NotNull @Valid Card> row1 = new ArrayList<>();
    @NotNull
    private List<@NotNull @Valid Card> row2 = new ArrayList<>();
    @NotNull
    private List<@NotNull @Valid Card> row3 = new ArrayList<>();
    @NotNull
    private List<@NotNull @Valid Card> row4 = new ArrayList<>();
}
