package se.viper.robotest.room;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Test;

public class CircularRoomTest {

	@Test
	public void testDefaultContains() {
		CircularRoom room = new CircularRoom(5);
		assertTrue(room.contains(new Point(0,0)));
		assertTrue(room.contains(new Point(2,2)));
		assertTrue(room.contains(new Point(2,3)));
		assertTrue(room.contains(new Point(-2,-2)));
		assertTrue(room.contains(new Point(-2,-3)));
		
		assertTrue(room.contains(new Point(0,5)));
		assertTrue(room.contains(new Point(5,0)));
		assertTrue(room.contains(new Point(0,-5)));
		assertTrue(room.contains(new Point(-5,0)));
		
		assertFalse(room.contains(new Point(5,5)));
		assertFalse(room.contains(new Point(-5,5)));
		assertFalse(room.contains(new Point(5,-5)));
		assertFalse(room.contains(new Point(-5,-5)));
		assertFalse(room.contains(new Point(42,42)));
		assertFalse(room.contains(new Point(6,2)));
	}

	@Test
	public void testSpecificContains() {
		CircularRoom room = new CircularRoom(5, 10, 10);
		assertTrue(room.contains(new Point(10,10)));
		assertTrue(room.contains(new Point(12,12)));
		assertTrue(room.contains(new Point(12,13)));
		assertTrue(room.contains(new Point(14,14)));
		assertTrue(room.contains(new Point(10,14)));
		assertTrue(room.contains(new Point(14,10)));
		
		assertTrue(room.contains(new Point(8,8)));
		assertTrue(room.contains(new Point(8,7)));
		assertTrue(room.contains(new Point(5,5)));
		assertTrue(room.contains(new Point(10,5)));
		assertTrue(room.contains(new Point(5,10)));
		
		assertTrue(room.contains(new Point(14,6)));
		
		assertFalse(room.contains(new Point(-10,-10)));
		assertFalse(room.contains(new Point(42,42)));
		assertFalse(room.contains(new Point(16,12)));
		assertFalse(room.contains(new Point(12,0)));
	}
	
	@Test
	public void testDefaultEntry() {
		CircularRoom room = new CircularRoom(5);
		assertEquals(0, room.getStartPosition().x);
		assertEquals(0, room.getStartPosition().y);
	}

	@Test
	public void testSpecificEntry() {
		CircularRoom room = new CircularRoom(10000, 0, 0, 42, 4711);
		assertEquals(42, room.getStartPosition().x);
		assertEquals(4711, room.getStartPosition().y);
	}

}
