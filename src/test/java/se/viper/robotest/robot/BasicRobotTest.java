package se.viper.robotest.robot;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import se.viper.robotest.robot.Robot.Direction;

public class BasicRobotTest {
	@Test
	public void turnRight() {
		BasicRobot myRobot = new BasicRobot();
		myRobot.turnRight();
		assertEquals(Direction.EAST, myRobot.getDirection());
		myRobot.turnRight();
		assertEquals(Direction.SOUTH, myRobot.getDirection());
		myRobot.turnRight();
		assertEquals(Direction.WEST, myRobot.getDirection());
		myRobot.turnRight();
		assertEquals(Direction.NORTH, myRobot.getDirection());
		myRobot.turnRight();
		assertEquals(Direction.EAST, myRobot.getDirection());
	}

	@Test
	public void turnLeft() {
		BasicRobot myRobot = new BasicRobot();
		myRobot.turnLeft();
		assertEquals(Direction.WEST, myRobot.getDirection());
		myRobot.turnLeft();
		assertEquals(Direction.SOUTH, myRobot.getDirection());
		myRobot.turnLeft();
		assertEquals(Direction.EAST, myRobot.getDirection());
		myRobot.turnLeft();
		assertEquals(Direction.NORTH, myRobot.getDirection());
		myRobot.turnLeft();
		assertEquals(Direction.WEST, myRobot.getDirection());
	}

	@Test
	public void moveNorth() {
		BasicRobot myRobot = new BasicRobot();
		assertEquals(Direction.NORTH, myRobot.getDirection());
		myRobot.step();
		assertEquals(0, myRobot.getPosition().x);
		assertEquals(1, myRobot.getPosition().y);
		myRobot.step();
		assertEquals(0, myRobot.getPosition().x);
		assertEquals(2, myRobot.getPosition().y);
	}

	@Test
	public void moveEast() {
		BasicRobot myRobot = new BasicRobot();
		myRobot.turnRight();
		assertEquals(Direction.EAST, myRobot.getDirection());
		myRobot.step();
		assertEquals(1, myRobot.getPosition().x);
		assertEquals(0, myRobot.getPosition().y);
		myRobot.step();
		assertEquals(2, myRobot.getPosition().x);
		assertEquals(0, myRobot.getPosition().y);
	}

	@Test
	public void moveSouth() {
		BasicRobot myRobot = new BasicRobot();
		myRobot.turnRight();
		myRobot.turnRight();
		assertEquals(Direction.SOUTH, myRobot.getDirection());
		myRobot.step();
		assertEquals(0, myRobot.getPosition().x);
		assertEquals(-1, myRobot.getPosition().y);
		myRobot.step();
		assertEquals(0, myRobot.getPosition().x);
		assertEquals(-2, myRobot.getPosition().y);
	}

	@Test
	public void moveWest() {
		BasicRobot myRobot = new BasicRobot();
		myRobot.turnLeft();
		assertEquals(Direction.WEST, myRobot.getDirection());
		myRobot.step();
		assertEquals(-1, myRobot.getPosition().x);
		assertEquals(0, myRobot.getPosition().y);
		myRobot.step();
		assertEquals(-2, myRobot.getPosition().x);
		assertEquals(0, myRobot.getPosition().y);
	}
}
