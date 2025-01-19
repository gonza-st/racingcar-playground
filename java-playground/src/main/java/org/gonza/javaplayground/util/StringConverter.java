package org.gonza.javaplayground.util;

import java.util.List;

public class StringConverter {
	public static List<String> splitByComma(String string) {
		return List.of(string.split(","));
	}
}
