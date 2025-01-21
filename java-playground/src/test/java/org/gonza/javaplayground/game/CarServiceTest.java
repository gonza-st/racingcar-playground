package org.gonza.javaplayground.game;

import org.gonza.javaplayground.game.car.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CarServiceTest {

    @Mock
    private CarNameReader carNameReader;

    private CarService sut;

    @BeforeEach
    public void setup() {
        sut = new CarService(carNameReader);
    }

    @Test
    public void 유저가_입력한_이름으로_차를_만든다() {
        List<String> userInputCarName = List.of("car1");
        when(carNameReader.getCarNames()).thenReturn(userInputCarName);
        List<Car> cars = sut.createCars();

        for (int i = 0; i <cars.size(); i++) {
            assertEquals(userInputCarName.get(i), cars.get(i).getName());
        }
    }

    @Test
    public void 유저가_이름을_여러_개_입력할_경우_차도_여러_개가_생성된다() {
        List<String> userInputCarName = List.of("car1", "car2");
        when(carNameReader.getCarNames()).thenReturn(userInputCarName);
        List<Car> cars = sut.createCars();

        assertEquals(userInputCarName.size(), cars.size());
    }
}
