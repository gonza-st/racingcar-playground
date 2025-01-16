package org.gonza.javaplayground.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RandomTest {
    @Test
    public void 랜덤하게_숫자가_나온다() {
        for (int i = 0; i < 10000; i++) {
            Integer random = Random.between(0, 9);

            Assertions.assertTrue(random >= 0 && random <= 9);
        }
    }
}
