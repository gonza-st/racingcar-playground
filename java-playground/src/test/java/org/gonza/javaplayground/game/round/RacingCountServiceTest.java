package org.gonza.javaplayground.game.round;

import org.gonza.javaplayground.game.RacingCountReader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class RacingCountServiceTest {

    @Mock
    private RacingCountReader racingCountReader;

    private RacingCountService sut;

    @BeforeEach
    public void setUp() {
        sut = new RacingCountService(racingCountReader);
    }

    @Test
    public void should_return_RacingRound_with_rounds_that_user_entered() {
        Integer expectedCount = 1;

        when(racingCountReader.getRacingCount()).thenReturn(expectedCount);
        RacingCount round = sut.createRacingCount();

        for (int i = 0; i < expectedCount; i++) {
            round.consume();
        }

        assertFalse(round.isAvailable());
    }
}
