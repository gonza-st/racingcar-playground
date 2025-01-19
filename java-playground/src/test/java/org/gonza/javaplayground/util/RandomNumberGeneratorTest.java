package org.gonza.javaplayground.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomNumberGeneratorTest {
	@Test
	@DisplayName("사이즈를 3으로 정의하면 3자리이다")
	void size() {
		List<Integer> randomNumbers = RandomNumberGenerator.generate(3, 1, 9);
		assertThat(randomNumbers.size()).isEqualTo(3);
	}

	@Test
	@DisplayName("1에서 9 사이의 숫자가 생성된다")
	void range() {
		List<Integer> randomNumbers = RandomNumberGenerator.generate(3, 1, 9);
		randomNumbers.forEach(number -> {
			assertThat(number).isGreaterThan(0);
			assertThat(number).isLessThan(10);
		});
	}
}