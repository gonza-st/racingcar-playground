package org.gonza.javaplayground;

import org.gonza.javaplayground.game.Game;
import org.gonza.javaplayground.game.GamePrinter;
import org.gonza.javaplayground.game.car.CarNameReader;
import org.gonza.javaplayground.game.car.CarService;
import org.gonza.javaplayground.game.car.CarSpec;
import org.gonza.javaplayground.game.count.RacingCountReader;
import org.gonza.javaplayground.game.count.RacingCountService;
import org.gonza.javaplayground.game.record.GameRecord;
import org.gonza.javaplayground.io.CarNameReaderImpl;
import org.gonza.javaplayground.io.GamePrinterImpl;
import org.gonza.javaplayground.io.RacingCountReaderImpl;
import org.gonza.javaplayground.io.handler.IOHandler;

import java.io.PrintStream;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		IOHandler ioHandler = createIOHandler();
		CarService carService = createCarService(ioHandler);
		RacingCountService racingCountService = createRacingCountService(ioHandler);
		GamePrinter gamePrinter = createGamePrinter(ioHandler);
		GameRecord gameRecord = new GameRecord();

		Game game = new Game(carService, racingCountService, gamePrinter);

		game.race();

	}

	private static GamePrinter createGamePrinter(IOHandler ioHandler) {
		GamePrinter gamePrinter = new GamePrinterImpl(ioHandler);
		return gamePrinter;
	}

	private static RacingCountService createRacingCountService(IOHandler ioHandler) {
		RacingCountReader racingCountReader = new RacingCountReaderImpl(ioHandler);
		RacingCountService service = new RacingCountService(racingCountReader);
		return service;
	}

	private static CarService createCarService(IOHandler ioHandler) {
		final Integer MAX_NAME_LENGTH = 5;
		final Integer MAX_DISTANCE = 5;


		CarNameReader carNameReader = new CarNameReaderImpl(ioHandler);
		CarSpec carSpec = new CarSpec(MAX_NAME_LENGTH, MAX_DISTANCE);
		CarService carService = new CarService(carNameReader, carSpec);

		return carService;
	}

	private static IOHandler createIOHandler() {
		Scanner scanner = new Scanner(System.in);
		PrintStream out = System.out;

		IOHandler ioHandler = new IOHandler(scanner, out);
		return ioHandler;
	}
}
