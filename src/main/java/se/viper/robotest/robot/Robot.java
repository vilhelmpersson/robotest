package se.viper.robotest.robot;

import java.awt.Point;

public interface Robot {
	
	enum Direction {
		NORTH,
		EAST,
		SOUTH,
		WEST
	}

	public boolean turnRight();
	public boolean turnLeft();
	public boolean step();
	
	public Direction getDirection();
	public Point getPosition();
}
