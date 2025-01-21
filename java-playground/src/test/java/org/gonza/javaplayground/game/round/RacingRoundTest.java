package org.gonza.javaplayground.game.round;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RacingRoundTest {

    @Test
    public void should_accept_positive_number_only() {
        assertThrows(IllegalArgumentException.class, () ->
            new RacingRound(-1)
        );

        assertThrows(IllegalArgumentException.class, () ->
                new RacingRound(0)
        );
    }

    @Test
    public void should_show_that_player_can_play_more_or_not() {
        RacingRound racingRound = new RacingRound(1);
        Boolean hasRound = racingRound.isAvailable();

        assertTrue(hasRound);
    }

    @Test
    public void should_return_false_if_no_more_round_left() {
        RacingRound racingRound = new RacingRound(1);
        racingRound.consume();
        Boolean hasRound = racingRound.isAvailable();

        assertFalse(hasRound);
    }
}
