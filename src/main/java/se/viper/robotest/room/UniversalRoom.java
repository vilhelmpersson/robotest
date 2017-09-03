package se.viper.robotest.room;

import java.awt.Point;

public class UniversalRoom implements Room {

	final Point startPosition;

	public UniversalRoom() {
		this(0, 0);
	}

	public UniversalRoom(int startX, int startY) {
		startPosition = new Point(startX, startY);
	}

	@Override
	public Point getStartPosition() {
		return (Point) startPosition.clone();
	}

	@Override
	public boolean contains(Point point) {
		return true;
	}

}
