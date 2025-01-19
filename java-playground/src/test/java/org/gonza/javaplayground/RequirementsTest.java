package org.gonza.javaplayground;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.PrintStream;
import java.util.Random;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class RequirementsTest {
    @Mock
    private Scanner scanner;

    @Mock
    private PrintStream printStream;

    @Mock
    private Random random;

    private Game sut;

    @BeforeEach
    public void setup() {
        sut = new Game(printStream, scanner, random);
    }

    @Test
    public void 차량이름은_5자를_초과할_수_없다() {
        Integer count = 1;
        when(scanner.nextInt()).thenReturn(count);

        String names = "too-long-name";
        when(scanner.nextLine()).thenReturn(names);

        assertThrows(IllegalArgumentException.class, () -> {
            sut.race();
        });
    }

    @Test
    public void 전진하는_자동차를_출력할_때_자동차_이름을_같이_출력한다() {
        Integer count = 1;
        when(scanner.nextInt()).thenReturn(count);

        String names = "car1";
        when(scanner.nextLine()).thenReturn(names);

        sut.race();

        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(printStream, times(2)).println(captor.capture());

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
        when(scanner.nextInt()).thenReturn(count);

        String names = "car1";
        when(scanner.nextLine()).thenReturn(names);

        sut.race();

        verify(printStream).println("car1:" + 0);
        verify(printStream).println("car1:" + 1);
    }

    @Test
    public void 자동차_경주_완료_후_우승자를_알려준다() {
        when(random.nextInt(10))
                .thenReturn(1)
                .thenReturn(4);

        Integer count = 2;
        when(scanner.nextInt()).thenReturn(count);

        String names = "car1";
        when(scanner.nextLine()).thenReturn(names);

        sut.race();

        verify(printStream).println("car1");
    }
}
