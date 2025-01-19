package org.gonza.javaplayground.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class NumberConverterTest {

	@Test
	void 숫자로_변환한다() {
		Integer number = NumberConverter.convertBy("1");

		assertEquals(1, number);
	}

	@Test
	void 숫자가_아니면_예외가_발생한다() {
		assertThrows(IllegalArgumentException.class, () -> NumberConverter.convertBy("dsa"));
	}
}