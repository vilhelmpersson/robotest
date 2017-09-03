package se.viper.robotest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import se.viper.robotest.robot.BasicRobot;
import se.viper.robotest.robot.controller.AdvancedRobotController;
import se.viper.robotest.robot.controller.AdvancedRobotController.ControllerLanguage;
import se.viper.robotest.robot.display.StandardDisplay;
import se.viper.robotest.room.CircularRoom;
import se.viper.robotest.room.RectangularRoom;

public class RoboTest {
	@Test
	public void test1() {
		RectangularRoom myRoom = new RectangularRoom(5, 5, 0, 0, 1, 2);
		BasicRobot myRobot = new BasicRobot(myRoom);
		AdvancedRobotController myController = new AdvancedRobotController(ControllerLanguage.SWE);
		StandardDisplay myDisplay = new StandardDisplay();
		myController.move("HGHGGHGHG", myRobot);
		//TODO: Test fail. Rewrite code to have Y axis going downwards.
		assertEquals("1 3 N", myDisplay.show(myRobot));
	}
	
	@Test
	public void test2() {
		CircularRoom myRoom = new CircularRoom(10);
		BasicRobot myRobot = new BasicRobot(myRoom);
		AdvancedRobotController myController = new AdvancedRobotController(ControllerLanguage.ENG);
		StandardDisplay myDisplay = new StandardDisplay();
		myController.move("RRFLFFLRF", myRobot);
		//TODO: Test fail. Rewrite code to have Y axis going downwards.
		assertEquals("3 1 Ö", myDisplay.show(myRobot));
	}
}
