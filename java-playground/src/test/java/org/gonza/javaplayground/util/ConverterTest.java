package org.gonza.javaplayground.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

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

    @Test
    @DisplayName("입력이 비어있으면 예외를 터트린다.")
    void separatedByCommasFailTest() throws Exception {

        // given
        String emptyInput = "";
        String nullInput = null;
        String onlySpacesInput = "   ";

        // when & then
        assertAll(
                () -> assertThatThrownBy(() -> Converter.separatedByCommas(emptyInput))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("입력값이 비어있습니다."),

                () -> assertThatThrownBy(() -> Converter.separatedByCommas(nullInput))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("입력값이 비어있습니다."),

                () -> assertThatThrownBy(() -> Converter.separatedByCommas(onlySpacesInput))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("입력값이 비어있습니다.")
        );

    }

    @Test
    @DisplayName("쉼표가 없는 입력은 예외를 터트린다.")
    void noCommaInputTest() {
        // given
        String inputWithoutComma = "leehongseob";

        // when & then
        assertThatThrownBy(() -> Converter.separatedByCommas(inputWithoutComma))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("구분자는 ,(콤마)를 입력해주세요.");
    }
    
    @Test
    @DisplayName("연속된 쉼표는 빈 문자열을 포함한 리스트를 반환한다.")
    void consecutiveCommasTest() {
        // given
        String inputWithConsecutiveCommas = "lee,,hong,,,seob";

        // when
        List<String> result = Converter.separatedByCommas(inputWithConsecutiveCommas);

        // then
        assertThat(result).containsExactly("lee", "", "hong", "", "", "seob");
    }

}
