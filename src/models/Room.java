package models;

import java.io.Serial;
import java.io.Serializable;

/**
 *  Represents a room object that holds many data such as N,S,E,W doors, items such as healing
 *  potions, pillar or pits, an entrance and exit, and even a monster. This will be a room
 *  representation of what's in the dungeon.
 *
 *  @author Hassan Bassam Farhat
 *  @author Avinash Bavisetty
 *  @version Summer 2023
 */
public class Room implements Serializable {

    @Serial
    private static final long serialVersionUID = -8845860585432504096L;

    // constants
    /** Holds the escape sequence for newline. */
    private static final String NEW_LINE = "\n";


    // instance fields
    /** . */
    private RoomItems myEntrance;
    /** . */
    private RoomItems myExit;
    /** . */
    private DoorDirections myDoorNorth;
    /** . */
    private DoorDirections myDoorEast;
    /** . */
    private DoorDirections myDoorSouth;
    /** . */
    private DoorDirections myDoorWest;
    /** . */
    private RoomItems myOOPillar;
    /** . */
    private RoomItems myHealingPotion;
    /** . */
    private RoomItems myPit;
    /** . */
    private AbstractMonster myRoomMonster;
    /** . */
    private int myRowPostion;
    /** . */
    private int myColumnPostion;


    // constructors

    public Room() {
        // default constructor
    }


    // methods

    /**
     *  Sets the entrance in this room to the enum value, if this room has it.
     *
     *  @param theEntrance the RoomItem enum for ENTRANCE.
     */
    public final void setEntrance(final RoomItems theEntrance) {
        myEntrance = theEntrance;
    }

    /** Returns the enum ENTRANCE, if room contains the entrance. */
    public final RoomItems getEntrance() {
        return myEntrance;
    }

    /** Returns boolean true if myEntrance has the ENTRANCE enum, false otherwise. */
    public final boolean hasEntrance() {
        return getEntrance() != null;
    }

    /**
     *  Sets the exit in this room to the enum value, if this room has it.
     *
     *  @param theExit the RoomItem enum for EXIT.
     */
    public final void setExit(final RoomItems theExit) {
        myExit = theExit;
    }

    /** Returns the enum EXIT, if room contains the exit. */
    public final RoomItems getExit() {
        return myExit;
    }

    /** Returns boolean true if myExit has the EXIT enum, false otherwise. */
    public final boolean hasExit() {
        return getExit() != null;
    }

    /**
     *  Sets the north door of the room with the enum value if this room has it.
     *
     *  @param theNorthDoor the DoorDirection enum for NORTH.
     */
    public final void setDoorNorth(final DoorDirections theNorthDoor) {
        myDoorNorth = theNorthDoor;
    }

    /** Returns the enum NORTH, if room contains the north door. */
    public final DoorDirections getDoorNorth() {
        return myDoorNorth;
    }

    /**
     *  Sets the south door of the room with the enum value if this room has it.
     *
     *  @param theSouthDoor the DoorDirection enum for SOUTH.
     */
    public final void setDoorSouth(final DoorDirections theSouthDoor) {
        myDoorSouth = theSouthDoor;
    }

    /** Returns the enum SOUTH, if room contains the south door. */
    public final DoorDirections getDoorSouth() {
        return myDoorSouth;
    }

    /**
     *  Sets the east door of the room with the enum value if this room has it.
     *
     *  @param theEastDoor the DoorDirection enum for EAST.
     */
    public final void setDoorEast(final DoorDirections theEastDoor) {
        myDoorEast = theEastDoor;
    }

    /** Returns the enum EAST, if room contains the east door. */
    public final DoorDirections getDoorEast() {
        return myDoorEast;
    }

    /**
     *  Sets the west door of the room with the enum value if this room has it.
     *
     *  @param theWestDoor the DoorDirection enum for WEST.
     */
    public final void setDoorWest(final DoorDirections theWestDoor) {
        myDoorWest = theWestDoor;
    }

    /** Returns the enum WEST, if room contains the west door. */
    public final DoorDirections getDoorWest() {
        return myDoorWest;
    }

    /**
     *  Sets the OO Pillar in this room to the enum value, if this room has it.
     *
     *  @param theOOPillar the RoomItem enum for either ABSTRACTION, ENCAPSULATION,
     *                     INHERITANCE, POLYMORPHISM PILLAR's.
     */
    public final void setOOPillar(final RoomItems theOOPillar) {
        myOOPillar = theOOPillar;
    }

    /** Returns the specified enum OO PILLAR, if room contains an OO Pillar. */
    public final RoomItems getOOPillar() {
        return myOOPillar;
    }

    /** Returns boolean true if myOOPillar has one of the PILLAR enums, false otherwise. */
    public final boolean hasPillar() {
        return getOOPillar() != null;
    }

    /**
     *  Sets the healing potion in this room to the enum value, if this room has it.
     *
     *  @param theHealingPotion the RoomItem enum for HEALING_POTION.
     */
    public final void setHealingPotion(final RoomItems theHealingPotion) {
        myHealingPotion = theHealingPotion;
    }

    /** Returns the enum HEALING_POTION, if room contains a healing potion. */
    public final RoomItems getHealingPotion() {
        return myHealingPotion;
    }

    /**
     *  Returns boolean true if myHealingPotion has the HEALING_POTION enum,
     *  false otherwise.
     */
    public final boolean hasHealingPotion() {
        return getHealingPotion() != null;
    }

    /**
     *  Sets the pit in this room to the enum value, if this room has it.
     *
     *  @param thePit the RoomItem enum for PIT.
     */
    public final void setPit(final RoomItems thePit) {
        myPit = thePit;
    }

    /** Returns the enum PIT, if room contains a pit. */
    public final RoomItems getPit() {
        return myPit;
    }

    /** Returns boolean true if myPit has the PIT enum, false otherwise. */
    public final boolean hasPit() {
        return getPit() != null;
    }

    /**
     *  Sets the room monster to the monster picked from the factory.
     *
     *  @param theMonster the monster from the AbstractMonster class.
     */
    public final void setRoomMonster(final AbstractMonster theMonster) {
        myRoomMonster = theMonster;
    }

    /** Returns the specified monster, if room contains a monster. */
    public final AbstractMonster getRoomMonster() {
        return myRoomMonster;
    }

    /** Returns boolean true if myRoomMonster has a monster, false otherwise. */
    public final boolean hasRoomMonster() {
        return getRoomMonster() != null;
    }

    /**
     *  Sets the room's row position given when inside a 2D-Dungeon matrix.
     *
     *  @param theRowPosition the int value representing the row this room is on.
     */
    public void setMyRowPosition(final int theRowPosition) {
        myRowPostion = theRowPosition;
    }

    /** Returns the row position of this room in a matrix. */
    public int getMyRowPosition() {
        return myRowPostion;
    }

    /**
     *  Sets the room's column position given when inside a 2D-Dungeon matrix.
     *
     *  @param theColumnPosition the int value representing the column this room is on.
     */
    public void setMyColumnPosition(final int theColumnPosition) {
        myColumnPostion = theColumnPosition;
    }

    /** Returns the column position of this room in a matrix. */
    public int getMyColumnPosition() {
        return myColumnPostion;
    }

    /**
     *  Returns a string representation of a given room object and the data
     *  items its holding.
     */
    @Override
    public final String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("This room stats:" + NEW_LINE);
        sb.append("***********************************" + NEW_LINE);
        sb.append("Has an Entrance: " + getEntrance() + NEW_LINE);
        sb.append("Has an Exit: " + getExit() + NEW_LINE);
        sb.append("Row Position: " + getMyRowPosition() + NEW_LINE);
        sb.append("Column Position: " + getMyColumnPosition() + NEW_LINE);
        sb.append("Has an North Door: " + getDoorNorth() + NEW_LINE);
        sb.append("Has an South Door: " + getDoorSouth() + NEW_LINE);
        sb.append("Has an East Door: " + getDoorEast() + NEW_LINE);
        sb.append("Has an West Door: " + getDoorWest() + NEW_LINE);
        sb.append("Has an OO Pillar in Room: " + getOOPillar() + NEW_LINE);
        sb.append("Has a Healing Potion in Room: " + getHealingPotion() + NEW_LINE);
//        sb.append("Has a Vision Potion in Room: " + getVisionPotion() + NEW_LINE);
        sb.append("Has a Pit in Room: " + getPit() + NEW_LINE);
        sb.append("Has a Monster in Room: " + getRoomMonster() + NEW_LINE);
        return sb.toString();
    }

}
