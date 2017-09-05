package se.viper.robotest.robot;

import java.awt.Point;

import se.viper.robotest.room.Room;

public class MicroRobot implements Robot {

	private int positionX;
	private int positionY;
	//
	private boolean directionNE = true;
	private boolean directionWN = true;
	private Point tmpPoint = new Point();
	private final Room room;

	public MicroRobot(Room room) {
		this.room = room;
		this.positionX = room.getStartPosition().x;
		this.positionY = room.getStartPosition().y;
	}

	@Override
	public boolean turnRight() {
		if (directionNE) {
			if (directionWN)
				directionWN = false;
			else
				directionNE = false;
		} else {
			if (directionWN)
				directionNE = true;
			else
				directionWN = true;
		}
		return true;
	}

	@Override
	public boolean turnLeft() {
		if (directionNE) {
			if (directionWN)
				directionNE = false;
			else
				directionWN = true;
		} else {
			if (directionWN)
				directionWN = false;
			else
				directionNE = true;
		}
		return true;
	}

	@Override
	public boolean step() {
		if (directionNE) {
			if (directionWN)
				--positionY;
			else
				++positionX;
		} else {
			if (directionWN)
				--positionX;
			else
				++positionY;
		}

		tmpPoint.move(positionX, positionY);
		if (!room.contains(tmpPoint)) {
			// Normally we are inside the room, so revert position if hitting wall
			if (directionNE) {
				if (directionWN)
					++positionY;
				else
					--positionX;
			} else {
				if (directionWN)
					++positionX;
				else
					--positionY;
			}
			return false;
		} else {
			return true;
		}
	}

	@Override
	public Direction getDirection() {
		if (directionNE) {
			if (directionWN)
				return Direction.NORTH;
			else
				return Direction.EAST;
		} else {
			if (directionWN)
				return Direction.WEST;
			else
				return Direction.SOUTH;
		}
	}

	@Override
	public Point getPosition() {
		return new Point(positionX, positionY);
	}

}
