package se.viper.robotest.room;

import java.awt.Rectangle;
import java.awt.Point;

public class RectangularRoom implements Room {

	final Point startPosition;
	final Rectangle rectangle;

	public RectangularRoom(int width, int height) {
		this(width, height, 0, 0);
	}

	public RectangularRoom(int width, int height, int upperLeftX, int upperLeftY) {
		this(width, height, upperLeftX, upperLeftY, upperLeftX, upperLeftY);
	}

	public RectangularRoom(int width, int height, int upperLeftX, int upperLeftY, int startX, int startY) {
		rectangle = new Rectangle(upperLeftX, upperLeftY, width, height);
		startPosition = new Point(startX, startY);
		if (!contains(startPosition))
		{
			throw new IllegalArgumentException("Start position must be inside the room.");
		}
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
