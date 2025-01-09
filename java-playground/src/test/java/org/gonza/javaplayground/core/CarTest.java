package org.gonza.javaplayground.core;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {

    @Test
    @DisplayName("자동차를 생성할 수 있다.")
    void createCarSuccessTest() throws Exception {
        Car car = new Car("hong", new Position());

        assertThat(car.getName()).isEqualTo("hong");
        assertThat(car.getPosition().getDistance()).isEqualTo(0);
    }

    @Test
    @DisplayName("이름이 비어있을 경우 예외가 발생한다.")
    void createCarFailTest_emptyName() throws Exception {
        assertThatThrownBy(() -> new Car("", new Position()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 필수입니다.");
    }

    @Test
    @DisplayName("이름이 5글자 이상일 경우 예외발 생")
    void createCarFailTest_NameLengthIsOver5() throws Exception {
        assertThatThrownBy(() -> new Car("h ongkim", new Position()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 5자 이하여야 합니다.");
    }

}
