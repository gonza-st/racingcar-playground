package org.gonza.javaplayground;

import org.gonza.javaplayground.game.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class RequirementsTest {
    @Mock
    private RacingCountReader racingCountReader;

    @Mock
    private CarNameReader carNameReader;

    @Mock
    private GamePrinter gamePrinter;

    private Game sut;

    @BeforeEach
    public void setup() {
        sut = new Game(carNameReader, racingCountReader, gamePrinter);
    }

    @Test
    public void 차량이름은_5자를_초과할_수_없다() {
        Integer count = 1;
        when(racingCountReader.getRacingCount()).thenReturn(count);

        List<String> names = List.of("too-long-name");
        when(carNameReader.getCarNames()).thenReturn(names);

        assertThrows(IllegalArgumentException.class, () -> {
            sut.race();
        });
    }

    @Test
    public void 전진하는_자동차를_출력할_때_자동차_이름을_같이_출력한다() {
        Integer count = 1;
        when(racingCountReader.getRacingCount()).thenReturn(count);

        List<String> names = List.of("car1");
        when(carNameReader.getCarNames()).thenReturn(names);

        sut.race();

        ArgumentCaptor<String> carNameCaptor = ArgumentCaptor.forClass(String.class);
        ArgumentCaptor<Integer> countCaptor = ArgumentCaptor.forClass(Integer.class);
        verify(gamePrinter)
                .showDistance(carNameCaptor.capture(), countCaptor.capture());

        assertTrue(carNameCaptor.getAllValues().get(0).contains(names.get(0)));
    }

    @Test
    public void 자동차_이름은_comma로_구분한다() {
    }

    @Test
    public void 전진하는_조건은_0_9_사이의_랜덤값_이어야한다() {
    }

    @Test
    @Disabled("차량 이동 랜덤 로직 추가 필요")
    public void 전진하는_조건은_random_값이_4이상일_경우이다() {
//        when(random.nextInt(10))
//                .thenReturn(1)
//                .thenReturn(4);

        Integer count = 2;
        when(racingCountReader.getRacingCount()).thenReturn(count);

        List<String> names = List.of("car1");
        when(carNameReader.getCarNames()).thenReturn(names);

        sut.race();

        verify(gamePrinter).showDistance("car1", 1);
    }

    @Test
    @Disabled("차량 이동 랜덤 로직 추가 필요")
    public void 자동차_경주_완료_후_우승자를_알려준다() {
//        when(random.nextInt(10))
//                .thenReturn(1)
//                .thenReturn(4);

        Integer count = 2;
        when(racingCountReader.getRacingCount()).thenReturn(count);

        List<String> names = List.of("car1");
        when(carNameReader.getCarNames()).thenReturn(names);

        sut.race();

        verify(gamePrinter).showResult(names);
    }
}
