package org.gonza.javaplayground.game.count;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RacingCountTest {

    @Test
    public void should_accept_positive_number_only() {
        assertThrows(IllegalArgumentException.class, () ->
            new RacingCount(-1)
        );

        assertThrows(IllegalArgumentException.class, () ->
                new RacingCount(0)
        );
    }

    @Test
    public void should_show_that_player_can_play_more_or_not() {
        RacingCount racingCount = new RacingCount(1);
        Boolean hasRound = racingCount.isAvailable();

        assertTrue(hasRound);
    }

    @Test
    public void should_return_false_if_no_more_round_left() {
        RacingCount racingCount = new RacingCount(1);
        racingCount.consume();
        Boolean hasRound = racingCount.isAvailable();

        assertFalse(hasRound);
    }
}
