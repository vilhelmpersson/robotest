package se.viper.robotest.room;

import java.awt.Point;

public class CircularRoom implements Room {

	final Point startPosition;
	final Point origo;
	final int radius;

	public CircularRoom(int radius) {
		this(radius, 0, 0);
	}

	public CircularRoom(int radius, int origoX, int origoY) {
		this(radius, origoX, origoY, origoX, origoY);
	}

	public CircularRoom(int radius, int origoX, int origoY, int startX, int startY) {
		this.radius = radius;
		origo = new Point(origoX, origoY);
		startPosition = new Point(startX, startY);
		// TODO: Validate start position and throw exception
	}

	@Override
	public Point getStartPosition() {
		return (Point) startPosition.clone();
	}

	@Override
	public boolean contains(Point point) {
		// TODO Check circular contains
		return true;
	}

}
