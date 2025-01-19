package org.gonza.javaplayground;

import org.gonza.javaplayground.game.Game;
import org.gonza.javaplayground.game.InputHandler;
import org.gonza.javaplayground.game.OutputHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class RequirementsTest {
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
    public void 차량이름은_5자를_초과할_수_없다() {
        Integer count = 1;
        when(inputHandler.getIntegerInput(anyString())).thenReturn(count);

        String names = "too-long-name";
        when(inputHandler.getStringInput(anyString())).thenReturn(names);

        assertThrows(IllegalArgumentException.class, () -> {
            sut.race();
        });
    }

    @Test
    public void 전진하는_자동차를_출력할_때_자동차_이름을_같이_출력한다() {
        Integer count = 1;
        when(inputHandler.getIntegerInput(anyString())).thenReturn(count);

        String names = "car1";
        when(inputHandler.getStringInput(anyString())).thenReturn(names);

        sut.race();

        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(outputHandler, times(2)).println(captor.capture());

        assertTrue(captor.getAllValues().get(0).contains(names));
    }

    @Test
    public void 자동차_이름은_comma로_구분한다() {
    }

    @Test
    public void 전진하는_조건은_0_9_사이의_랜덤값_이어야한다() {
    }

    @Test
    public void 전진하는_조건은_random_값이_4이상일_경우이다() {
        when(random.nextInt(10))
                .thenReturn(1)
                .thenReturn(4);

        Integer count = 2;
        when(inputHandler.getIntegerInput(anyString())).thenReturn(count);

        String names = "car1";
        when(inputHandler.getStringInput(anyString())).thenReturn(names);

        sut.race();

        verify(outputHandler).println("car1:" + 0);
        verify(outputHandler).println("car1:" + 1);
    }

    @Test
    public void 자동차_경주_완료_후_우승자를_알려준다() {
        when(random.nextInt(10))
                .thenReturn(1)
                .thenReturn(4);

        Integer count = 2;
        when(inputHandler.getIntegerInput(anyString())).thenReturn(count);

        String names = "car1";
        when(inputHandler.getStringInput(anyString())).thenReturn(names);

        sut.race();

        verify(outputHandler).println("car1");
    }
}
