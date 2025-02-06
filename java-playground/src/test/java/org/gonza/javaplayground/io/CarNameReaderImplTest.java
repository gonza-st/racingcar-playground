package org.gonza.javaplayground.io;

import org.gonza.javaplayground.game.car.CarNameReader;
import org.gonza.javaplayground.io.handler.InputHandler;
import org.gonza.javaplayground.io.handler.OutputHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CarNameReaderImplTest {

    @Mock
    private OutputHandler outputHandler;

    @Mock
    private InputHandler inputHandler;

    private CarNameReader sut;

    @BeforeEach
    public void setUp() {
        this.sut = new CarNameReaderImpl(outputHandler, inputHandler);
    }

    @Test
    public void contextLoads() {}

    @Test
    public void 입력된_차량이름이_null인_경우_예외를_던진다() {
        when(inputHandler.getStringInput()).thenReturn(null);
        assertThrows(IllegalArgumentException.class, () -> {
            sut.getCarNames();
        });
    }

    @Test
    public void 입력된_차량이름이_공백인_경우_예외를_던진다() {
        when(inputHandler.getStringInput()).thenReturn(" ");
        assertThrows(IllegalArgumentException.class, () -> {
            sut.getCarNames();
        });
    }

    @Test
    public void 입력된_차량이름은_trim_처리하여_반환한다() {
        when(inputHandler.getStringInput()).thenReturn("car1 ");
        List<String> carName = sut.getCarNames();

        assertEquals("car1", carName.get(0));
    }
}
