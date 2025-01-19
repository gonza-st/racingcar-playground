package org.gonza.javaplayground.io.handler;

import org.gonza.javaplayground.io.handler.IOHandler;
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
        private static final String INT_GUIDE_MSG = "시도할 회수는 몇회인가요?";

        @Test
        public void 부적절한_정수가_입력될_경우_다시_입력플로우를_시작한다() {
            Integer count = 1;

            when(scanner.nextInt())
                    .thenThrow(new IllegalArgumentException("wrong input"))
                    .thenReturn(count);

            Integer result = sut.getIntegerInput(INT_GUIDE_MSG);

            verify(printStream, times(2)).println(INT_GUIDE_MSG);
            assertEquals(count, result);
        }

        @Test
        public void 정수를_입력_전에_안내_문구를_보여준다() {
            sut.getIntegerInput(INT_GUIDE_MSG);

            verify(printStream).println(INT_GUIDE_MSG);
        }

        @Test
        public void 정수를_입력_받을_수_있다() {
            Integer count = 1;
            when(scanner.nextInt()).thenReturn(count);

            Integer result = sut.getIntegerInput(INT_GUIDE_MSG);
            assertEquals(count, result);
        }
    }

    @Nested
    class GetStringInputTest {
        private static final String NAME_GUIDE_MSG =
                "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";

        @Test
        public void 부적절한_문자열이_입력될_경우_다시_입력플로우를_시작한다() {
            String carName = "car1";

            when(scanner.nextLine())
                    .thenThrow(new IllegalArgumentException("wrong input"))
                    .thenReturn(carName);

            String result = sut.getStringInput(NAME_GUIDE_MSG);

            verify(printStream, times(2)).println(NAME_GUIDE_MSG);
            assertEquals(carName, result);
        }

        @Test
        public void 문자열을_입력_전에_안내_문구를_보여준다() {
            sut.getStringInput(NAME_GUIDE_MSG);

            verify(printStream).println(NAME_GUIDE_MSG);
        }

        @Test
        public void 문자열을_입력_받을_수_있다() {
            String input = "car1";
            when(scanner.nextLine()).thenReturn(input);

            String carName = sut.getStringInput(NAME_GUIDE_MSG);
            assertEquals(input, carName);
        }
    }
}
