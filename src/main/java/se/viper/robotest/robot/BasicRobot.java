package se.viper.robotest.robot;

import java.awt.Point;

import se.viper.robotest.room.Room;

public class BasicRobot implements Robot {

	private Direction direction = Direction.NORTH;
	private Point position = new Point(0, 0);
	private final Room room;

	public BasicRobot(Room room) {
		this.room = room;
		this.position.setLocation(room.getStartPosition());
	}

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
		Point newPosition = position.getLocation();
		switch (direction) {
		case EAST:
			newPosition.translate(1, 0);
			break;
		case NORTH:
			newPosition.translate(0, 1);
			break;
		case SOUTH:
			newPosition.translate(0, -1);
			break;
		case WEST:
			newPosition.translate(-1, 0);
			break;
		}
		if (room.contains(newPosition)) {
			position.setLocation(newPosition);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Direction getDirection() {
		return direction;
	}

	@Override
	public Point getPosition() {
		return position.getLocation();
	}

}
