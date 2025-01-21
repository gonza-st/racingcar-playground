package org.gonza.javaplayground.game.car;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CarTest {
    private static final String CAR_NAME = "car1";

    @Mock
    private Random random;

    @Test
    public void 차량은_이름을_가지고_있다() {
        Car sut = new Car(CAR_NAME, random);
        assertEquals(CAR_NAME, sut.getName());
    }

    @Test
    public void 차량의_이동거리를_알_수_있다() {
        Car sut = new Car(CAR_NAME, random);
        Integer distance = sut.move();
        assertEquals(1, distance);
    }

    @Test
    public void 차량의_이동거리는_매번_다르다() {
        when(random.nextInt(10)).thenReturn(0).thenReturn(1);
        Car sut = new Car(CAR_NAME, random);

        Integer distance1 = sut.move();
        Integer distance2 = sut.move();

        assertNotEquals(distance1, distance2);
    }

    @Test
    public void 차량의_이동거리는_1보다_작으면_다시_이동한다() {
        when(random.nextInt(10)).thenReturn(-1).thenReturn(0);
        Car sut = new Car(CAR_NAME, random);

        Integer distance = sut.move();
        assertEquals(1, distance);
        verify(random, times(2)).nextInt(10);
    }

    @Test
    public void 차량의_이동거리는_10보다_클_수_없다() {
        when(random.nextInt(10)).thenReturn(10).thenReturn(0);
        Car sut = new Car(CAR_NAME, random);

        Integer distance = sut.move();
        assertEquals(1, distance);
        verify(random, times(2)).nextInt(10);
    }
}
