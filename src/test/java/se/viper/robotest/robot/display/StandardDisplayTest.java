package se.viper.robotest.robot.display;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Test;

import se.viper.robotest.robot.Robot;
import se.viper.robotest.robot.Robot.Direction;

public class StandardDisplayTest {

	@Test
	public void testDisplay() {
		StandardDisplay myDisplay = new StandardDisplay();
		TestRobot myRobot = new TestRobot();
		assertEquals("0 0 N", myDisplay.show(myRobot));
		myRobot.position.x = 42;
		myRobot.position.y = 4711;
		myRobot.direction = Direction.EAST;
		assertEquals("42 4711 Ö", myDisplay.show(myRobot));
		myRobot.direction = Direction.SOUTH;
		assertEquals("42 4711 S", myDisplay.show(myRobot));
		myRobot.direction = Direction.WEST;
		assertEquals("42 4711 V", myDisplay.show(myRobot));
	}

	private class TestRobot implements Robot {
		//Public variables so they easy can be modified from the test case
		public Direction direction = Direction.NORTH;
		public Point position = new Point(0, 0);

		@Override
		public boolean turnRight() {
			return false;
		}

		@Override
		public boolean turnLeft() {
			return false;
		}

		@Override
		public boolean step() {
			return false;
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
}
