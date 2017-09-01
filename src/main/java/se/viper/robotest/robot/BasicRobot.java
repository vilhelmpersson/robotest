package se.viper.robotest.robot;

import java.awt.Point;

public class BasicRobot implements Robot {

	private Direction direction = Direction.NORTH;
	private Point position = new Point(0, 0);

	@Override
	public boolean turnRight() {
		switch (direction) {
		case EAST:
			direction = Direction.SOUTH;
			break;
		case NORTH:
			direction = Direction.EAST;
			break;
		case SOUTH:
			direction = Direction.WEST;
			break;
		case WEST:
			direction = Direction.NORTH;
			break;
		}
		return true;
	}

	@Override
	public boolean turnLeft() {
		switch (direction) {
		case EAST:
			direction = Direction.NORTH;
			break;
		case NORTH:
			direction = Direction.WEST;
			break;
		case SOUTH:
			direction = Direction.EAST;
			break;
		case WEST:
			direction = Direction.SOUTH;
			break;
		}
		return true;
	}

	@Override
	public boolean step() {
		switch (direction) {
		case EAST:
			position.translate(1, 0);
			break;
		case NORTH:
			position.translate(0, 1);
			break;
		case SOUTH:
			position.translate(0, -1);
			break;
		case WEST:
			position.translate(-1, 0);
			break;
		}
		return true;
	}

	@Override
	public Direction getDirection() {
		return direction;
	}

	@Override
	public Point getPosition() {
		return position;
	}

}
