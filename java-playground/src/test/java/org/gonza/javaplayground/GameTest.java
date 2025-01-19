package org.gonza.javaplayground;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class GameTest {
    @Mock
    private InputHandler inputHandler;

    @Mock
    private OutputHandler outputHandler;

    @Mock
    private Random random;

    private Game sut;

    @BeforeEach
    public void setup() {
        sut = new Game(random, inputHandler, outputHandler);
    }

    @Test
    public void 차량이름이_5글자_초과하는_경우_예외가_발생한다() {
        Integer count = 1;
        when(inputHandler.getIntegerInput(anyString())).thenReturn(count);

        String names = "too-long-name";
        when(inputHandler.getStringInput(anyString())).thenReturn(names);

        assertThrows(IllegalArgumentException.class, () -> {
            sut.race();
        });
    }

    @Test
    public void 경주의_결과는_이동거리가_아닌_이동횟수를_기록한다() {
        when(random.nextInt(10))
                .thenReturn(5)
                .thenReturn(1);

        Integer count = 1;
        when(inputHandler.getIntegerInput(anyString())).thenReturn(count);

        String names = "car1,car2";
        when(inputHandler.getStringInput(anyString())).thenReturn(names);

        sut.race();

        verify(outputHandler).println("car1:" + 1);
        verify(outputHandler).println("car2:" + 0);
    }


    @Test
    public void 경주마다_이동거리가_4보다_큰경우만_누적한다() {
        when(random.nextInt(10))
                .thenReturn(1)
                .thenReturn(2)
                .thenReturn(1)
                .thenReturn(4);

        Integer count = 2;
        when(inputHandler.getIntegerInput(anyString())).thenReturn(count);

        String names = "car1,car2";
        when(inputHandler.getStringInput(anyString())).thenReturn(names);

        sut.race();

        verify(outputHandler, times(2)).println("car1:" + 0);
        verify(outputHandler).println("car2:" + 0);
        verify(outputHandler).println("car2:" + 1);

        verify(outputHandler).println("car2");
    }
}
