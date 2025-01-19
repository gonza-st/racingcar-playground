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
    public void 경주마다_랜덤한_숫자만큼_이동한다() {
        when(random.nextInt(10))
                .thenReturn(0)
                .thenReturn(12)
                .thenReturn(6)
                .thenReturn(1)
                .thenReturn(0)
                .thenReturn(6);

        Integer count = 2;
        when(scanner.nextInt()).thenReturn(count);

        String names = "car1,car2,car3";
        when(scanner.nextLine()).thenReturn(names);

        sut.race();

        verify(printStream).println("car1:" + 1);
        verify(printStream).println("car1:" + 3);

        verify(printStream).println("car2:" + 13);
        verify(printStream).println("car2:" + 14);

        verify(printStream).println("car3:" + 7);
        verify(printStream).println("car3:" + 14);
        verify(printStream).println("car2,car3");
    }
}
