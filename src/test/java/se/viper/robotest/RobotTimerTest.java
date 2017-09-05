package se.viper.robotest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import se.viper.robotest.robot.BasicRobot;
import se.viper.robotest.robot.MicroRobot;
import se.viper.robotest.robot.Robot;
import se.viper.robotest.robot.display.StandardDisplay;
import se.viper.robotest.room.RectangularRoom;

public class RobotTimerTest {

	private RectangularRoom myRoom = new RectangularRoom(50, 50, 0, 0, 10, 10);

	@Test
	public void testBasicRobot() {
		BasicRobot basicRobot = new BasicRobot(myRoom);
		testTimer(basicRobot);
	}

	@Test
	public void testMicroRobot() {
		MicroRobot basicRobot = new MicroRobot(myRoom);
		testTimer(basicRobot);
	}

	@Test
	public void testBasicRobot2() {
		BasicRobot basicRobot = new BasicRobot(myRoom);
		testTimer(basicRobot);
	}

	@Test
	public void testMicroRobot2() {
		MicroRobot basicRobot = new MicroRobot(myRoom);
		testTimer(basicRobot);
	}

	@Test
	public void testMicroRobot3() {
		MicroRobot basicRobot = new MicroRobot(myRoom);
		testTimer(basicRobot);
	}

	@Test
	public void testBasicRobot3() {
		BasicRobot basicRobot = new BasicRobot(myRoom);
		testTimer(basicRobot);
	}

	private void testTimer(Robot robot) {
		long repeat = 5000000;
		StandardDisplay myDisplay = new StandardDisplay();
		//long startTime = System.nanoTime();
		for (long i = 0; i < repeat; ++i) {
			runPathRectangle3(robot);
		}
		//long estimatedTime = System.nanoTime() - startTime;
		//System.out.println(String.format("The test using %s %d times took %d nanos", robot.getClass().getName(),
		//		repeat, estimatedTime));
		assertEquals("10 10 N", myDisplay.show(robot));
	}

	// Run path that will return the robot to the same position
	private void runPathRectangle3(Robot robot) {
		robot.step();
		robot.step();
		robot.step();
		robot.turnRight();
		robot.step();
		robot.step();
		robot.step();
		robot.turnRight();
		robot.step();
		robot.step();
		robot.step();
		robot.turnRight();
		robot.step();
		robot.step();
		robot.step();
		robot.turnRight();
	}
}
