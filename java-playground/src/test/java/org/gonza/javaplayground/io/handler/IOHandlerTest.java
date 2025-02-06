package org.gonza.javaplayground.io.handler;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class IOHandlerTest {
    @Mock
    private PrintStream printStream;

    @Mock
    private Scanner scanner;

    private IOHandler sut;

    @BeforeEach
    public void setUp() {
        this.sut = new IOHandler(scanner, printStream);
    }

    @Nested
    class PrintlnTest {
        @Test
        public void 인자로_전달된_문자열을_출력한다() {
            String text = "should print this sentence";
            sut.println(text);

            verify(printStream).println(text);
        }
    }

    @Nested
    class GetIntegerInputTest {
        @Test
        public void 부적절한_정수가_입력될_경우_다시_입력플로우를_시작한다() {
            Integer count = 1;

            when(scanner.nextInt())
                    .thenThrow(new IllegalArgumentException("wrong input"))
                    .thenReturn(count);

            Integer result = sut.getIntegerInput();

            assertEquals(count, result);
        }

        @Test
        public void 정수를_입력_받을_수_있다() {
            Integer count = 1;
            when(scanner.nextInt()).thenReturn(count);

            Integer result = sut.getIntegerInput();
            assertEquals(count, result);
        }
    }

    @Nested
    class GetStringInputTest {
        @Test
        public void 부적절한_문자열이_입력될_경우_다시_입력플로우를_시작한다() {
            String carName = "car1";

            when(scanner.nextLine())
                    .thenThrow(new IllegalArgumentException("wrong input"))
                    .thenReturn(carName);

            String result = sut.getStringInput();
            assertEquals(carName, result);
        }

        @Test
        public void 문자열을_입력_받을_수_있다() {
            String input = "car1";
            when(scanner.nextLine()).thenReturn(input);

            String carName = sut.getStringInput();
            assertEquals(input, carName);
        }
    }
}
