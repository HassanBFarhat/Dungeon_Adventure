package models;

import java.io.Serial;
import java.io.Serializable;

/**
 *
 * @author Hassan Bassam Farhat
 * @version Summer 2023
 */
public class Room implements Serializable {

    @Serial
    private static final long serialVersionUID = -8845860585432504096L;

    // constants
    /** . */
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
    private RoomItems myVisionPotion;
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

    /** . */
    public final void setEntrance(final RoomItems theEntrance) {
        myEntrance = theEntrance;
    }

    /** . */
    public final RoomItems getEntrance() {
        return myEntrance;
    }

    /** . */
    public final boolean hasEntrance() {
        return getEntrance() != null;
    }

    /** . */
    public final void setExit(final RoomItems theExit) {
        myExit = theExit;
    }

    /** . */
    public final RoomItems getExit() {
        return myExit;
    }

    /** . */
    public final boolean hasExit() {
        return getExit() != null;
    }

    /** . */
    public final void setDoorNorth(final DoorDirections theNorthDoor) {
        myDoorNorth = theNorthDoor;
    }

    /** . */
    public final DoorDirections getDoorNorth() {
        return myDoorNorth;
    }

    /** . */
    public final void setDoorSouth(final DoorDirections theSouthDoor) {
        myDoorSouth = theSouthDoor;
    }

    /** . */
    public final DoorDirections getDoorSouth() {
        return myDoorSouth;
    }

    /** . */
    public final void setDoorEast(final DoorDirections theEastDoor) {
        myDoorEast = theEastDoor;
    }

    /** . */
    public final DoorDirections getDoorEast() {
        return myDoorEast;
    }

    /** . */
    public final void setDoorWest(final DoorDirections theWestDoor) {
        myDoorWest = theWestDoor;
    }

    /** . */
    public final DoorDirections getDoorWest() {
        return myDoorWest;
    }

    /** . */
    public final void setOOPillar(final RoomItems theOOPillar) {
        myOOPillar = theOOPillar;
    }

    /** . */
    public final RoomItems getOOPillar() {
        return myOOPillar;
    }

    /** . */
    public final boolean hasPillar() {
        return getOOPillar() != null;
    }

    /** . */
    public final void setHealingPotion(final RoomItems theHealingPotion) {
        myHealingPotion = theHealingPotion;
    }

    /** . */
    public final RoomItems getHealingPotion() {
        return myHealingPotion;
    }

    /** . */
    public final boolean hasHealingPotion() {
        return getHealingPotion() != null;
    }

//    /** . */
//    public final void setVisionPotion(final RoomItems theVisionPotion) {
//        myVisionPotion = theVisionPotion;
//    }
//
//    /** . */
//    public final RoomItems getVisionPotion() {
//        return myVisionPotion;
//    }
//
//    /** . */
//    public final boolean hasVisionPotion() {
//        return getVisionPotion() != null;
//    }

    /** . */
    public final void setPit(final RoomItems thePit) {
        myPit = thePit;
    }

    /** . */
    public final RoomItems getPit() {
        return myPit;
    }

    /** . */
    public final boolean hasPit() {
        return getPit() != null;
    }

    /** . */
    public final void setRoomMonster(final AbstractMonster theMonster) {
        myRoomMonster = theMonster;
    }

    /** . */
    public final AbstractMonster getRoomMonster() {
        return myRoomMonster;
    }

    /** . */
    public final boolean hasRoomMonster() {
        return getRoomMonster() != null;
    }

    /** . */
    public void setMyRowPosition(final int theRowPosition) {
        myRowPostion = theRowPosition;
    }

    /** . */
    public int getMyRowPosition() {
        return myRowPostion;
    }

    /** . */
    public void setMyColumnPosition(final int theColumnPosition) {
        myColumnPostion = theColumnPosition;
    }

    /** . */
    public int getMyColumnPosition() {
        return myColumnPostion;
    }

    /** . */
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
