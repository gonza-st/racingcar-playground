package org.gonza.javaplayground.car;

import java.util.List;

public class RaceResult {
	private final List<Car> carList;

	public RaceResult(List<Car> carList) {
		this.carList = carList;
	}

	public int getHighestPosition() {
		return this.carList.stream()
				.map(Car::getPosition)
				.sorted()
				.toList()
				.getLast();
	}

	public List<Car> getHighestCar() {
		int highestPosition = getHighestPosition();

		return this.carList.stream()
				.filter(car -> car.getPosition() == highestPosition)
				.toList();
	}
}
