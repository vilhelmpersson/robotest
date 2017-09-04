package se.viper.robotest;

import java.util.Scanner;

import se.viper.robotest.robot.BasicRobot;
import se.viper.robotest.robot.Robot;
import se.viper.robotest.robot.controller.AdvancedRobotController;
import se.viper.robotest.robot.controller.AdvancedRobotController.ControllerLanguage;
import se.viper.robotest.robot.display.Display;
import se.viper.robotest.robot.display.StandardDisplay;
import se.viper.robotest.room.CircularRoom;
import se.viper.robotest.room.RectangularRoom;
import se.viper.robotest.room.Room;
import se.viper.robotest.room.UniversalRoom;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("Welcome to Robo tester");
			ControllerLanguage language = selectLanguage(scanner);
			AdvancedRobotController robotController = new AdvancedRobotController();
			robotController.setControllerLanguage(language);

			Room room = selectRoom(scanner);
			Robot robot = new BasicRobot(room);
			Display display = new StandardDisplay();

			printRobotLocation(robot, display);
			boolean quit = false;
			while (!quit) {
				System.out.println(
						String.format("Please command your robot using sequence of %s", language.getRobotCommand()));
				String command = scanner.nextLine();
				if ("QUIT".equals(command)) {
					quit = true;
				} else {
					robotController.move(command, robot);
					printRobotLocation(robot, display);
				}

			}
			System.out.println("Bye bye. Welcome back.");
		}
	}

	private static ControllerLanguage selectLanguage(Scanner scanner) {
		int langSelection = 0;
		do {
			System.out.println("Select language:");
			System.out.println(String.format(" 1 - English    (%s)", ControllerLanguage.ENG.getRobotCommand()));
			System.out.println(String.format(" 2 - Swedish    (%s)", ControllerLanguage.SWE.getRobotCommand()));
			langSelection = getUserInput(scanner, "Select [1-2]:");
		} while (langSelection < 1 || langSelection > 2);
		if (langSelection == 1) {
			return ControllerLanguage.ENG;
		} else if (langSelection == 2) {
			return ControllerLanguage.SWE;
		}
		return ControllerLanguage.ENG;
	}

	private static int getUserInput(Scanner scanner, String description) {
		return getUserInput(scanner, description, null);
	}

	private static int getUserInput(Scanner scanner, String description, Integer defaultValue) {
		boolean validInput = false;
		int number = 0;

		do {
			System.out.print(description);
			try {
				String tmpInput = scanner.nextLine();
				if ("".equals(tmpInput) && defaultValue != null) {
					number = defaultValue;
				} else {
					number = Integer.parseInt(tmpInput);
				}
				validInput = true;
			} catch (NumberFormatException e) {
				System.out.print("Invalid number!");
			}
		} while (!validInput);
		return number;
	}

	private static Room selectRoom(Scanner scanner) {
		int roomSelection = 0;
		while (roomSelection < 1 || roomSelection > 3) {
			System.out.println("Select room type:");
			System.out.println(" 1 - Circular");
			System.out.println(" 2 - Rectangular");
			System.out.println(" 3 - Universal");
			roomSelection = getUserInput(scanner, "Select [1-3]:");
		}
		if (roomSelection == 1) {
			int radius = getUserInput(scanner, "Enter radius:");
			int centerX = getUserInput(scanner, "Enter center X (0):", 0);
			int centerY = getUserInput(scanner, "Enter center Y (0):", 0);
			int startX = getUserInput(scanner, String.format("Enter start X (%d):", centerX), centerX);
			int startY = getUserInput(scanner, String.format("Enter start Y (%d):", centerY), centerY);
			return new CircularRoom(radius, centerX, centerY, startX, startY);
		} else if (roomSelection == 2) {
			int width = getUserInput(scanner, "Enter width:");
			int height = getUserInput(scanner, "Enter height:");
			int upperLeftX = getUserInput(scanner, "Enter upper left X (0):", 0);
			int upperLeftY = getUserInput(scanner, "Enter upper left Y (0):", 0);
			int startX = getUserInput(scanner, String.format("Enter start X (%d):", upperLeftX), upperLeftX);
			int startY = getUserInput(scanner, String.format("Enter start Y (%d):", upperLeftY), upperLeftY);
			return new RectangularRoom(width, height, upperLeftX, upperLeftY, startX, startY);
		} else if (roomSelection == 3) {
			int startX = getUserInput(scanner, "Enter start X (0):", 0);
			int startY = getUserInput(scanner, "Enter start Y (0):", 0);
			return new UniversalRoom(startX, startY);
		}
		return null;
	}

	private static void printRobotLocation(Robot robot, Display display) {
		System.out.println(String.format("Robot current location: %s", display.show(robot)));
	}
}
