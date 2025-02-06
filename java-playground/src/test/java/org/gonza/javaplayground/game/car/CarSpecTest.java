package org.gonza.javaplayground.game.car;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarSpecTest {
    private static final Integer MAX_NAME_LENGTH = 5;
    private static final Integer MAX_DISTANCE = 10;

    private CarSpec sut;

    @BeforeEach
    public void setUp() {
        this.sut = new CarSpec(MAX_NAME_LENGTH, MAX_DISTANCE);
    }


    @Test
    public void 차량이름의_최대_글자수를_알수_있다() {
        Integer maxNameLength = sut.getMaxNameLength();
        assertEquals(MAX_NAME_LENGTH, maxNameLength);
    }

    @Test
    public void 차량의_최대_이동_거리를_알수_있다() {
        Integer maxDistance = sut.getMaxDistance();
        assertEquals(MAX_DISTANCE, maxDistance);
    }
}
