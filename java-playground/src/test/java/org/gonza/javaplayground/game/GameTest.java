package org.gonza.javaplayground.game;

import org.gonza.javaplayground.game.car.Car;
import org.gonza.javaplayground.game.car.CarNameReader;
import org.gonza.javaplayground.game.car.CarService;
import org.gonza.javaplayground.game.car.CarSpec;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class GameTest {
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
    public void 차량이름이_5글자_초과하는_경우_예외가_발생한다() {
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
    public void 경주의_결과는_이동거리가_아닌_이동횟수를_기록한다() {
        Integer count = 1;
        when(racingCountReader.getRacingCount()).thenReturn(count);

        List<String> names = List.of("car1", "car2");
        Car car1 = mock(Car.class);
        when(car1.getName()).thenReturn(names.get(0));
        when(car1.move()).thenReturn(5);

        Car car2 = mock(Car.class);
        when(car2.getName()).thenReturn(names.get(1));
        when(car2.move()).thenReturn(1);
        when(carService.createCars()).thenReturn(List.of(car1, car2));

        sut.race();

        verify(gamePrinter).showDistance("car1", 1);
        verify(gamePrinter).showDistance("car2", 0);
    }


    @Test
    public void 경주마다_이동거리가_4보다_큰경우만_누적한다() {
        Integer count = 2;
        when(racingCountReader.getRacingCount()).thenReturn(count);

        List<String> names = List.of("car1", "car2");
        Car car1 = mock(Car.class);
        when(car1.getName()).thenReturn(names.get(0));
        when(car1.move()).thenReturn(1).thenReturn(1);

        Car car2 = mock(Car.class);
        when(car2.getName()).thenReturn(names.get(1));
        when(car2.move()).thenReturn(2).thenReturn(4);
        when(carService.createCars()).thenReturn(List.of(car1, car2));

        sut.race();

        verify(gamePrinter, times(2)).showDistance("car1" , 0);
        verify(gamePrinter).showDistance("car2", 0);
        verify(gamePrinter).showDistance("car2", 1);

        verify(gamePrinter).showResult(List.of("car2"));
    }
}
