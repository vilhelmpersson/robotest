package se.viper.robotest.room;

import java.awt.Rectangle;
import java.awt.Point;

public class RectangularRoom implements Room {

	final Point startPosition;
	final Rectangle rectangle;

	public RectangularRoom(int width, int height) {
		this(width, height, 0, 0);
	}

	public RectangularRoom(int width, int height, int bottomLeftX, int bottomLeftY) {
		this(width, height, bottomLeftX, bottomLeftY, bottomLeftX, bottomLeftY);
	}

	public RectangularRoom(int width, int height, int bottomLeftX, int bottomLeftY, int startX, int startY) {
		rectangle = new Rectangle(bottomLeftX, bottomLeftY, width, height);
		startPosition = new Point(startX, startY);
		//TODO: Validate start position and thow exception
	}

	@Override
	public Point getStartPosition() {
		return (Point) startPosition.clone();
	}

	@Override
	public boolean contains(Point point) {
		return rectangle.contains(point);
	}

}
