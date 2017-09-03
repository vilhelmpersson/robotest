package se.viper.robotest.robot.display;

import java.awt.Point;

import se.viper.robotest.robot.Robot;
import se.viper.robotest.robot.Robot.Direction;

public class StandardDisplay implements Display {

	@Override
	public String show(Robot robot) {
		Point position = robot.getPosition();
		return String.format("%d %d %s", position.x, position.y, translateRobotDirection(robot.getDirection()));
	}

	private String translateRobotDirection(Direction direction) {
		switch (direction) {
		case EAST:
			return "Ö";
		case NORTH:
			return "N";
		case SOUTH:
			return "S";
		case WEST:
			return "V";
		default:
			return "?";
		}
	}
}
