package org.gonza.javaplayground.game.car;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CarNameTest {
    @Test
    public void 이름이_5보다_길면_예외가_발생한다() {
        String longName = "too-long-name";
        assertThrows(IllegalArgumentException.class, () -> new CarName(longName));
    }

    @Test
    public void 이름의_실제_값을_알_수_있다() {
        String name = "test1";
        CarName carName = new CarName(name);
        assertEquals(name, carName.getValue());
    }
}