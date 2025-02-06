package org.gonza.javaplayground.io;

import org.gonza.javaplayground.game.count.RacingCountReader;
import org.gonza.javaplayground.io.handler.InputHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class RacingCountReaderImplTest {

    @Mock
    private InputHandler inputHandler;

    private RacingCountReader sut;

    @BeforeEach
    public void setUp() {
        this.sut = new RacingCountReaderImpl(inputHandler);
    }

    @Test
    public void contextLoads() {
    }

    @Test
    public void 입력된_횟수가_null인_경우_예외를_던진다() {
        when(inputHandler.getIntegerInputWithGuideMsg(anyString())).thenReturn(null);
        assertThrows(IllegalArgumentException.class, () -> {
            sut.getRacingCount();
        });
    }

    @Test
    public void 입력된_횟수가_0인_경우_예외를_던진다() {
        when(inputHandler.getIntegerInputWithGuideMsg(anyString())).thenReturn(0);
        assertThrows(IllegalArgumentException.class, () -> {
            sut.getRacingCount();
        });
    }

    @Test
    public void 입력된_횟수가_음수인_경우_예외를_던진다() {
        when(inputHandler.getIntegerInputWithGuideMsg(anyString())).thenReturn(-1);
        assertThrows(IllegalArgumentException.class, () -> {
            sut.getRacingCount();
        });
    }
}