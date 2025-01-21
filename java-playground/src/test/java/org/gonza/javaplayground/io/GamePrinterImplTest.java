package org.gonza.javaplayground.io;

import org.gonza.javaplayground.game.OutputHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class GamePrinterImplTest {

    @Mock
    private OutputHandler outputHandler;

    private GamePrinterImpl sut;

    @BeforeEach
    public void setUp() {
        this.sut = new GamePrinterImpl(outputHandler);
    }

    @Test
    public void contextLoads() {}

    @Test
    public void 차량이름과_이동거리를_유저에게_보여준다() {
        String carName = "car1";
        Integer distance = 1;

        String message = "car1:1";
        doNothing().when(outputHandler).println(message);
        sut.showDistance(carName, distance);

        verify(outputHandler).println(message);
    }

    @Test
    public void 차량이름을_보여준다() {
        List<String> carNames = List.of("car1", "car2");

        String message = "car1, car2";
        doNothing().when(outputHandler).println(message);

        sut.showResult(carNames);
        verify(outputHandler).println(message);
    }

    @Test
    public void 차량이름이_없는_경우_예외를_던진다() {
        List<String> carNames = List.of();

        assertThrows(IllegalStateException.class, () -> {
            sut.showResult(carNames);
        });
    }
}
