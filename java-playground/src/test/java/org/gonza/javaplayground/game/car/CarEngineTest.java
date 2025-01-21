package org.gonza.javaplayground.game.car;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CarEngineTest {
    private static final Integer MAX_POWER = 10;

    @Mock
    private Random random;

    private CarEngine sut;

    @BeforeEach
    public void setUp() {
        this.sut = new CarEngine(random, MAX_POWER);
    }

    @Test
    public void 엔진은_이동거리를_제공한다() {
        when(random.nextInt(MAX_POWER)).thenReturn(1);

        Integer distance = sut.cycle();

        assertEquals(2, distance);
    }

    @Test
    public void 이동거리는_1_10_사이의_랜덤한_숫자이다() {
        when(random.nextInt(MAX_POWER)).thenReturn(1).thenReturn(3);

        Integer distance1 = sut.cycle();
        Integer distance2 = sut.cycle();

        assertNotEquals(distance1, distance2);
    }
}
