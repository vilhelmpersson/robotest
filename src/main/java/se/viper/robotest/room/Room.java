package se.viper.robotest.room;

import java.awt.Point;

public interface Room {
	Point getStartPosition();

	boolean contains(Point point);
}
