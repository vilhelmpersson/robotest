package se.viper.robotest.robot.controller;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Test;

import se.viper.robotest.robot.Robot;
import se.viper.robotest.robot.controller.AdvancedRobotController.ControllerLanguage;

public class AdvancedRobotControllerTest {

	@Test
	public void testValidCommands() {
		AdvancedRobotController myController = new AdvancedRobotController();
		TestRobot myRobot = new TestRobot();
		myController.setControllerLanguage(ControllerLanguage.ENG);
		myController.move("FLRFLRF", myRobot);
		assertEquals("SLRSLRS", myRobot.commands);
		myRobot.commands = "";
		myController.setControllerLanguage(ControllerLanguage.SWE);
		myController.move("GVHGVHG", myRobot);
		assertEquals("SLRSLRS", myRobot.commands);
	}

	private class TestRobot implements Robot {
		public String commands = "";

		@Override
		public boolean turnRight() {
			commands += "R";
			return true;
		}

		@Override
		public boolean turnLeft() {
			commands += "L";
			return true;
		}

		@Override
		public boolean step() {
			commands += "S";
			return true;
		}

		@Override
		public Direction getDirection() {
			return null;
		}

		@Override
		public Point getPosition() {
			return null;
		}
	}

}
