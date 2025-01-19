package org.gonza.javaplayground;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.gonza.javaplayground.car.Car;
import org.gonza.javaplayground.car.RaceResult;
import org.gonza.javaplayground.car.Racing;
import org.gonza.javaplayground.util.NumberConverter;
import org.gonza.javaplayground.util.RandomNumberGenerator;
import org.gonza.javaplayground.util.StringConverter;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JavaPlaygroundApplication {
	public static final long TIME_DELAY = 1000L;
	private static final Integer START_NUMBER = 1;
	private static final Integer END_NUMBER = 9;

	public static void main(String[] args) throws InterruptedException {
		Racing racing = getRacing();
		int playCount = getPlayCount();
		List<RaceResult> resultList = getRaceResults(playCount, racing);
		reportWinner(resultList);
	}

	private static List<RaceResult> getRaceResults(int playCount, Racing racing) throws InterruptedException {
		List<RaceResult> resultList = new ArrayList<>();
		for (int i = 0; i < playCount; i++) {
			List<Integer> numbers = RandomNumberGenerator.generate(racing.countPlayers(), START_NUMBER, END_NUMBER);
			RaceResult result = racing.race(numbers);
			resultList.add(result);
			raceReport(result.report());
			Thread.sleep(TIME_DELAY / playCount);
		}
		return resultList;
	}

	private static void raceReport(String report) {
		System.out.println(report + "\n");
	}

	private static void reportWinner(List<RaceResult> resultList) {
		List<String> highestCarNames = resultList.getLast()
			.getHighestCar()
			.stream()
			.map(Car::getName)
			.toList();
		String joinCarNames = String.join(",", highestCarNames);
		System.out.println(joinCarNames + "가 최종 우승했습니다.");
	}

	private static int getPlayCount() {
		System.out.println("시도할 회수는 몇회인가요?");
		Scanner scannerCount = new Scanner(System.in);
		return NumberConverter.convertBy(scannerCount.nextLine());
	}

	private static Racing getRacing() {
		System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
		Scanner scannerNames = new Scanner(System.in);
		List<String> players = StringConverter.splitByComma(scannerNames.nextLine());
		return new Racing(players);
	}
}
