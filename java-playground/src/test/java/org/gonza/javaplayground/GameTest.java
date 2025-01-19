package org.gonza.javaplayground;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.PrintStream;
import java.util.Random;
import java.util.Scanner;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class GameTest {

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
    public void 경주마다_이동거리가_4보다_큰경우만_누적한다() {
        when(random.nextInt(10))
                .thenReturn(1)
                .thenReturn(2)
                .thenReturn(1)
                .thenReturn(4);

        Integer count = 2;
        when(scanner.nextInt()).thenReturn(count);

        String names = "car1,car2";
        when(scanner.nextLine()).thenReturn(names);

        sut.race();

        verify(printStream, times(2)).println("car1:" + 0);
        verify(printStream).println("car2:" + 0);
        verify(printStream).println("car2:" + 5);

        verify(printStream).println("car2");
    }
}
