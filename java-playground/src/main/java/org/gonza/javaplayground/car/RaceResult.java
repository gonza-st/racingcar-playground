package org.gonza.javaplayground.car;

import java.util.List;
import java.util.stream.Stream;

public class RaceResult {
	private final List<String> carNameList;
	private final int position;

	public RaceResult(List<Car> carList) {
		this.carNameList = carList.stream().map(Car::getName).toList();
		this.position = carList.getFirst().getPosition();
	}

	public int highestPosition() {
		return position;
	}
}
