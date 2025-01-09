package org.gonza.javaplayground.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberGeneratorTest {

    @Test
    @DisplayName("랜덤 숫자를 생성할 수 있다.")
    void generateRandomNumberTest() throws Exception {

        int randomNumber = NumberGenerator.generateRandomNumber();

        assertThat(randomNumber).isNotNull();
    }

}
