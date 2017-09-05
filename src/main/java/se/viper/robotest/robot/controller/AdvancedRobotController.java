package se.viper.robotest.robot.controller;

import java.util.function.IntPredicate;

import se.viper.robotest.robot.Robot;

public class AdvancedRobotController implements RobotController {

	public enum ControllerLanguage {
		SWE('V', 'H', 'G'), ENG('L', 'R', 'F');

		private final char turnLeft;
		private final char turnRight;
		private final char step;

		ControllerLanguage(char turnLeft, char turnRight, char step) {
			this.turnLeft = turnLeft;
			this.turnRight = turnRight;
			this.step = step;
		}

		public String getRobotCommand() {
			return String.format("%s=Turn Right,  %s=Turn Left,  %s=Go forward", turnRight, turnLeft, step);
		}
	}

	private ControllerLanguage controllerLanguage = ControllerLanguage.ENG;

	public AdvancedRobotController() {
	}

	public AdvancedRobotController(ControllerLanguage language) {
		controllerLanguage = language;
	}

	@Override
	public boolean move(String command, Robot robot) {
		IntPredicate validMovesPredicate = c -> (c == controllerLanguage.turnRight || c == controllerLanguage.turnLeft
				|| c == controllerLanguage.step);
		boolean validMoves = command.chars().map(c -> Character.toUpperCase(c)).allMatch(validMovesPredicate);
		if (validMoves) {
			command.chars().map(c -> Character.toUpperCase(c)).forEachOrdered(c -> {
				if (c == controllerLanguage.turnRight)
					robot.turnRight();
				else if (c == controllerLanguage.turnLeft)
					robot.turnLeft();
				else if (c == controllerLanguage.step)
					robot.step();
			});
		}
		return validMoves;
	}

	public ControllerLanguage getControllerLanguage() {
		return controllerLanguage;
	}

	public void setControllerLanguage(ControllerLanguage controllerLanguage) {
		this.controllerLanguage = controllerLanguage;
	}
}
