package org.gonza.javaplayground.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

class StringConverterTest {
	@Test
	void 콤마를_기준으로_구분할_수_있다() {
		List<String> actual = StringConverter.splitByComma("test,test1,test2");

		assertEquals(3, actual.size());
		assertEquals("test", actual.get(0));
		assertEquals("test1", actual.get(1));
		assertEquals("test2", actual.get(2));
	}

	@Test
	void 콤마가_아니라면_구분되지_않는다() {
		String notComma = "/./.';';[;p[;;'./";
		List<String> actual = StringConverter.splitByComma(notComma);

		assertEquals(1, actual.size());
		assertEquals(notComma, actual.getFirst());
	}
}