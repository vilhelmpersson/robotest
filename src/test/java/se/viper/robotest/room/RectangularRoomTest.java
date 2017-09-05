package se.viper.robotest.room;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Test;

public class RectangularRoomTest {

	@Test
	public void testDefaultContains() {
		RectangularRoom room = new RectangularRoom(5, 5);
		assertTrue(room.contains(new Point(0, 0)));
		assertTrue(room.contains(new Point(2, 2)));
		assertTrue(room.contains(new Point(2, 3)));
		assertTrue(room.contains(new Point(4, 4)));
		assertTrue(room.contains(new Point(0, 4)));
		assertTrue(room.contains(new Point(4, 0)));

		assertFalse(room.contains(new Point(-1, -1)));
		assertFalse(room.contains(new Point(42, 42)));
		assertFalse(room.contains(new Point(6, 2)));
		assertFalse(room.contains(new Point(2, -1)));
	}

	@Test
	public void testSpecificContains() {
		RectangularRoom room = new RectangularRoom(10, 10, -5, -5);
		assertTrue(room.contains(new Point(0, 0)));
		assertTrue(room.contains(new Point(2, 2)));
		assertTrue(room.contains(new Point(2, 3)));
		assertTrue(room.contains(new Point(4, 4)));
		assertTrue(room.contains(new Point(0, 4)));
		assertTrue(room.contains(new Point(4, 0)));

		assertTrue(room.contains(new Point(-2, -2)));
		assertTrue(room.contains(new Point(-2, -3)));
		assertTrue(room.contains(new Point(-5, -5)));
		assertTrue(room.contains(new Point(0, -5)));
		assertTrue(room.contains(new Point(-5, 0)));

		assertTrue(room.contains(new Point(4, -4)));

		assertFalse(room.contains(new Point(-10, -10)));
		assertFalse(room.contains(new Point(42, 42)));
		assertFalse(room.contains(new Point(6, 2)));
		assertFalse(room.contains(new Point(2, -10)));
	}

	@Test
	public void testDefaultEntry() {
		RectangularRoom room = new RectangularRoom(5, 5);
		assertEquals(0, room.getStartPosition().x);
		assertEquals(0, room.getStartPosition().y);
	}

	@Test
	public void testSpecificEntry() {
		RectangularRoom room = new RectangularRoom(10000, 10000, 0, 0, 42, 4711);
		assertEquals(42, room.getStartPosition().x);
		assertEquals(4711, room.getStartPosition().y);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testInvalidEntry() {
		new RectangularRoom(100, 100, 0, 0, 42, 4711);
	}

}
