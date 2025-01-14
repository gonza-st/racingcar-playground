package org.gonza.javaplayground.core;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NameTest {

    @Test
    @DisplayName("이름을 생성할 수 있다.")
    void createNameSuccessTest() throws Exception {

        Nickname nickname = new Nickname("이름");

        assertThat(nickname.getName()).isEqualTo("이름");
    }

    @Test
    @DisplayName("이름은 5자를 넘길 수 없다.")
    void createNameFailTest_overedMaxLength() throws Exception {
        assertThatThrownBy(() -> new Nickname("h ongkim"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 5자 이하여야 합니다.");
    }

    @Test
    @DisplayName("이름은 비어있을 수 없다.")
    void createNameFailTest_emptyName() throws Exception {
        assertThatThrownBy(() -> new Nickname(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 필수입니다.");
    }

}
