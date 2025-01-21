package org.gonza.javaplayground;

import org.gonza.javaplayground.game.*;
import org.gonza.javaplayground.game.car.Car;
import org.gonza.javaplayground.game.car.CarNameReader;
import org.gonza.javaplayground.game.car.CarService;
import org.gonza.javaplayground.game.car.CarSpec;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class RequirementsTest {
    @Mock
    private RacingCountReader racingCountReader;

    @Mock
    private CarService carService;

    @Mock
    private GamePrinter gamePrinter;

    private Game sut;

    @BeforeEach
    public void setup() {
        sut = new Game(carService, racingCountReader, gamePrinter);
    }

    @Test
    public void 차량이름은_5자를_초과할_수_없다() {
        CarNameReader carNameReader = mock(CarNameReader.class);
        CarSpec carSpec = new CarSpec(5, 10);
        CarService carService = new CarService(carNameReader, carSpec);
        Game game = new Game(carService, racingCountReader, gamePrinter);

        Integer count = 1;
        when(racingCountReader.getRacingCount()).thenReturn(count);

        List<String> names = List.of("too-long-name");
        when(carNameReader.getCarNames()).thenReturn(names);

        assertThrows(IllegalArgumentException.class, () -> {
            game.race();
        });
    }

    @Test
    public void 전진하는_자동차를_출력할_때_자동차_이름을_같이_출력한다() {
        Integer count = 1;
        when(racingCountReader.getRacingCount()).thenReturn(count);

        List<String> names = List.of("car1");

        Car car = mock(Car.class);
        when(car.getName()).thenReturn(names.get(0));
        when(carService.createCars()).thenReturn(List.of(car));

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
    public void 전진하는_조건은_random_값이_4이상일_경우이다() {
        Integer count = 2;
        when(racingCountReader.getRacingCount()).thenReturn(count);

        List<String> names = List.of("car1");

        Car car = mock(Car.class);
        when(car.getName()).thenReturn(names.get(0));
        when(car.move()).thenReturn(1).thenReturn(4);
        when(carService.createCars()).thenReturn(List.of(car));

        sut.race();

        verify(gamePrinter).showDistance("car1", 1);
    }

    @Test
    public void 자동차_경주_완료_후_우승자를_알려준다() {
        Integer count = 2;
        when(racingCountReader.getRacingCount()).thenReturn(count);

        List<String> names = List.of("car1");

        Car car = mock(Car.class);
        when(car.getName()).thenReturn(names.get(0));
        when(car.move()).thenReturn(1).thenReturn(4);
        when(carService.createCars()).thenReturn(List.of(car));

        sut.race();

        verify(gamePrinter).showResult(names);
    }
}
