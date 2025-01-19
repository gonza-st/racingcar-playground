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
    public void 경주가_진행되면_결과가_출력된다() {
        doNothing().when(printStream).println("hi");
        sut.race();

        verify(printStream, times(1)).println("hi");
    }

    @Test
    public void 입력받은_경주_횟수만큼_결과가_출력된다() {
        Integer count = 3;
        when(scanner.nextInt()).thenReturn(count);
        sut.race();
        verify(printStream, times(count)).println("hi");
    }

    @Test
    public void 경주가_끝나면_입력받은_차량이름을_출력한다() {
        Integer count = 3;
        when(scanner.nextInt()).thenReturn(count);

        String names = "car1,car2,car3";
        when(scanner.nextLine()).thenReturn(names);

        sut.race();

        verify(printStream, times(count)).println("car1");
        verify(printStream, times(count)).println("car2");
        verify(printStream, times(count)).println("car3");
    }

    @Test
    public void 게임이_끝나면_결과를_출력한다() {
        Integer count = 3;
        when(scanner.nextInt()).thenReturn(count);

        String names = "car1,car2,car3";
        when(scanner.nextLine()).thenReturn(names);

        sut.race();

        verify(printStream, times(1)).println("result");
    }
}
