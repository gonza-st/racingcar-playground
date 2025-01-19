package org.gonza.javaplayground;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.PrintStream;
import java.util.Scanner;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class GameTest {

    @Mock
    private Scanner scanner;

    @Mock
    private PrintStream printStream;

    private Game sut;

    @BeforeEach
    public void setup() {
        sut = new Game(printStream, scanner);
    }

    @Test
    public void 경주가_한번_끝날_때_마다_이전_경주의_결과를_누적해서_보여준다() {
        Integer count = 3;
        when(scanner.nextInt()).thenReturn(count);

        String names = "car1,car2,car3";
        when(scanner.nextLine()).thenReturn(names);

        sut.race();

        verify(printStream).println("car1:" + 1);
        verify(printStream).println("car2:" + 1);
        verify(printStream).println("car3:" + 1);
        verify(printStream).println("car1:" + 2);
        verify(printStream).println("car2:" + 2);
        verify(printStream).println("car3:" + 2);
        verify(printStream).println("car1:" + 3);
        verify(printStream).println("car2:" + 3);
        verify(printStream).println("car3:" + 3);

    }

    @Test
    public void 게임이_끝나면_우승자한_차량이름을_출력한다() {
        Integer count = 3;
        when(scanner.nextInt()).thenReturn(count);

        String names = "car1,car2,car3";
        when(scanner.nextLine()).thenReturn(names);

        sut.race();

        verify(printStream, times(1)).println("car1,car2,car3");
    }
}
