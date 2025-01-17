package org.gonza.javaplayground.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

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

}
