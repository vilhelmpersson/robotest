package se.viper.robotest.room;

import static org.junit.Assert.*;

import org.junit.Test;

public class UniversalRoomTest {

	@Test
	public void testDefaultEntry() {
		UniversalRoom room = new UniversalRoom();
		assertEquals(0, room.getStartPosition().x);
		assertEquals(0, room.getStartPosition().y);
	}

	@Test
	public void testSpecificEntry() {
		UniversalRoom room = new UniversalRoom(42, 4711);
		assertEquals(42, room.getStartPosition().x);
		assertEquals(4711, room.getStartPosition().y);
	}

	@Test
	public void testEntryUnmodified() {
		UniversalRoom room = new UniversalRoom(42, 4711);
		room.getStartPosition().translate(17, 17);
		assertEquals(4711, room.getStartPosition().y);
	}
}
