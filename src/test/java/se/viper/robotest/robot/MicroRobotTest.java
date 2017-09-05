package se.viper.robotest.robot;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import se.viper.robotest.robot.Robot.Direction;
import se.viper.robotest.room.RectangularRoom;
import se.viper.robotest.room.UniversalRoom;

public class MicroRobotTest {
	@Test
	public void turnRight() {
		MicroRobot myRobot = new MicroRobot(new UniversalRoom());
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
		MicroRobot myRobot = new MicroRobot(new UniversalRoom());
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
		MicroRobot myRobot = new MicroRobot(new UniversalRoom());
		assertEquals(Direction.NORTH, myRobot.getDirection());
		myRobot.step();
		assertEquals(0, myRobot.getPosition().x);
		assertEquals(-1, myRobot.getPosition().y);
		myRobot.step();
		assertEquals(0, myRobot.getPosition().x);
		assertEquals(-2, myRobot.getPosition().y);
	}

	@Test
	public void moveEast() {
		MicroRobot myRobot = new MicroRobot(new UniversalRoom());
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
		MicroRobot myRobot = new MicroRobot(new UniversalRoom());
		myRobot.turnRight();
		myRobot.turnRight();
		assertEquals(Direction.SOUTH, myRobot.getDirection());
		myRobot.step();
		assertEquals(0, myRobot.getPosition().x);
		assertEquals(1, myRobot.getPosition().y);
		myRobot.step();
		assertEquals(0, myRobot.getPosition().x);
		assertEquals(2, myRobot.getPosition().y);
	}

	@Test
	public void moveWest() {
		MicroRobot myRobot = new MicroRobot(new UniversalRoom());
		myRobot.turnLeft();
		assertEquals(Direction.WEST, myRobot.getDirection());
		myRobot.step();
		assertEquals(-1, myRobot.getPosition().x);
		assertEquals(0, myRobot.getPosition().y);
		myRobot.step();
		assertEquals(-2, myRobot.getPosition().x);
		assertEquals(0, myRobot.getPosition().y);
	}

	@Test
	public void roomBoundaries() {
		MicroRobot myRobot = new MicroRobot(new RectangularRoom(5, 5));
		myRobot.turnRight();
		myRobot.turnRight();
		myRobot.step();
		assertEquals(0, myRobot.getPosition().x);
		assertEquals(1, myRobot.getPosition().y);
		myRobot.step();
		myRobot.step();
		myRobot.step();
		assertEquals(0, myRobot.getPosition().x);
		assertEquals(4, myRobot.getPosition().y);
		myRobot.step();
		assertEquals(0, myRobot.getPosition().x);
		assertEquals(4, myRobot.getPosition().y);
		myRobot.turnLeft();
		myRobot.step();
		assertEquals(1, myRobot.getPosition().x);
		assertEquals(4, myRobot.getPosition().y);
	}

	@Test
	public void roomStartPosition() {
		MicroRobot myRobot = new MicroRobot(new UniversalRoom(1, 2));
		assertEquals(1, myRobot.getPosition().x);
		assertEquals(2, myRobot.getPosition().y);
	}
}
