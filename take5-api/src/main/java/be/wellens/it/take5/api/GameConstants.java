package be.wellens.it.take5.api;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class GameConstants {

    public static final int MINIMUM_NUMBER_OF_PLAYERS = 2;
    public static final int MAXIMUM_NUMBER_OF_PLAYERS = 4;

    public static final int MINIMUM_NUMBER_OF_TURNS = 1;
}
