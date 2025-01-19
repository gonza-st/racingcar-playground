package org.gonza.javaplayground.util;

import java.util.Arrays;
import java.util.List;

public class Converter {

    public static final String COMMAS = ",";

    public Converter() {
        throw new IllegalStateException("유틸리티 클래스는 인스턴스화 할 수 없습니다.");
    }

    public static List<String> separatedByCommas(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("입력값이 비어있습니다.");
        }
        if (!input.contains(COMMAS)) {
            throw new IllegalArgumentException("구분자는 ,(콤마)를 입력해주세요.");
        }
        return Arrays.asList(input.split(COMMAS));
    }
}
