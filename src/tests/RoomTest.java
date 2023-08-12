package tests;

import models.Room;
import models.RoomItems;
import models.AbstractMonster;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Avinash Bavisetty
 * @author Hassan Bassam Farhat
 * @version Summer 2023
 */

public class RoomTest {

    private Room room;

    // Dummy monster class for testing purposes
    private static class DummyMonster extends AbstractMonster {}

    @BeforeEach
    public void setUp() {
        room = new Room();
    }

    @Test
    public void testEntrance() {
        room.setEntrance(RoomItems.ENTRANCE);
        assertEquals(RoomItems.ENTRANCE, room.getEntrance());
        assertTrue(room.hasEntrance());
    }

    @Test
    public void testExit() {
        room.setExit(RoomItems.EXIT);
        assertEquals(RoomItems.EXIT, room.getExit());
        assertTrue(room.hasExit());
    }

    @Test
    public void testOOPillar() {
        room.setOOPillar(RoomItems.INHERITANCE_PILLAR);
        assertEquals(RoomItems.INHERITANCE_PILLAR, room.getOOPillar());
        assertTrue(room.hasPillar());
    }

    @Test
    public void testHealingPotion() {
        room.setHealingPotion(RoomItems.HEALING_POTION);
        assertEquals(RoomItems.HEALING_POTION, room.getHealingPotion());
        assertTrue(room.hasHealingPotion());
    }

    @Test
    public void testPit() {
        room.setPit(RoomItems.PIT);
        assertEquals(RoomItems.PIT, room.getPit());
        assertTrue(room.hasPit());
    }

    @Test
    public void testRoomMonster() {
        AbstractMonster monster = new DummyMonster();
        room.setRoomMonster(monster);
        assertEquals(monster, room.getRoomMonster());
        assertTrue(room.hasRoomMonster());
    }

    @Test
    public void testRowAndColumnPosition() {
        room.setMyRowPosition(6);
        assertEquals(6, room.getMyRowPosition());

        room.setMyColumnPosition(5);
        assertEquals(5, room.getMyColumnPosition());
    }

    @Test
    public void testToString() {
        // You can define a test similar to what's in the Room's toString method,
        // comparing expected vs actual. But this is often less valuable than testing functionality.
        String strRepresentation = room.toString();
        assertNotNull(strRepresentation);
        assertTrue(strRepresentation.contains("This room stats:"));
    }
}

