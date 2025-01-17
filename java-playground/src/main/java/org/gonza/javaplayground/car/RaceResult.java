package org.gonza.javaplayground.car;

import java.util.List;
import java.util.stream.Collectors;

public class RaceResult {
	private final List<Car> carList;

	public RaceResult(List<Car> carList) {
		this.carList = carList;
	}

	private int getHighestPosition() {
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

	public String report() {
		return carList.stream()
				.map(Car::report)
				.collect(Collectors.joining("\n"));
	}
}
