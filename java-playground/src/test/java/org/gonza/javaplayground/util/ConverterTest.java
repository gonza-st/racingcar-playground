package org.gonza.javaplayground.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ConverterTest {

    @Test
    @DisplayName("쉼표로 구분을 할 수 있다.")
    void separatedByCommasTest() throws Exception {

        // 이름을 쉼표로 구분하여 받는다.
        // 쉼표로 구분한 것을 배열로 만들어서 사용한다.
        String inputData = "lee,hong,seob";
        List<String> separatedInputList = Converter.separatedByCommas(inputData);


        assertThat(separatedInputList.get(0)).isEqualTo("lee");
        assertThat(separatedInputList.get(1)).isEqualTo("hong");
        assertThat(separatedInputList.get(2)).isEqualTo("seob");
    }

    @DisplayName("쉼표로 구분되지 않을 경우 예외가 터진다.")
    @ParameterizedTest
    @ValueSource(strings = {"|", ".", "-", "a", "%"})
    void separatedByCommasFailTest_invalidSeparator(String invalidData) throws Exception {

        String invalidInputData = "lee" + invalidData + "hong" + invalidData + "seob";

        assertThatThrownBy(() -> Converter.separatedByCommas(invalidInputData))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("구분자가 올바르지 않습니다.");
    }

}
