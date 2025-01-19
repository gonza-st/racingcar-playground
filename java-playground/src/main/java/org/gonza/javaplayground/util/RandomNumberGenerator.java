package org.gonza.javaplayground.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RandomNumberGenerator {
	public static List<Integer> generate(int size, int start, int end) {
		Set<Integer> set = new HashSet<>();

		while (set.size() < size) {
			double d = Math.random() * end + start;
			set.add((int)d);
		}

		return new ArrayList<>(set);
	}
}
