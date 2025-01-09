package org.gonza.javaplayground.core;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PositionTest {
    @Test
    @DisplayName("포지션을 생성할 수 있다.")
    void createPositionSuccessTest() throws Exception {
        Position position = new Position();

        assertThat(position.getDistance()).isEqualTo(0);
    }

    @Test
    @DisplayName("부여받은 랜덤 숫자가 기준 숫자보다 크면 1칸 전진한다.")
    void moveForwardSuccessTest() throws Exception {

        Position position1 = new Position();
        Position position2 = new Position();

        position1.moveForward(5);
        position2.moveForward(3);

        assertThat(position1.getDistance()).isEqualTo(1);
        assertThat(position2.getDistance()).isEqualTo(0);
    }
}
