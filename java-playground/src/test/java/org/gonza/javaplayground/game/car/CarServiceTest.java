package org.gonza.javaplayground.game.car;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CarServiceTest {

    @Mock
    private CarNameReader carNameReader;

    private CarService sut;

    @BeforeEach
    public void setup() {
        CarSpec carSpec = new CarSpec(5, 10);
        sut = new CarService(carNameReader, carSpec);
    }


    @Test
    public void 유저가_입력한_이름의_길이가_5_이상이면_예외가_발생한다() {
        List<String> userInputCarName = List.of("too-long-car-name");
        when(carNameReader.getCarNames()).thenReturn(userInputCarName);

        assertThrows(IllegalArgumentException.class, () -> {
            sut.createCars();
        });
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
