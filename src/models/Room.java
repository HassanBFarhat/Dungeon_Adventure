package models;

public class Room {

    // constants

    /** . */
    private static final String NEW_LINE = "\n";

    // instance fields

    /** . */
    private boolean myEntrance;

    /** . */
    private boolean myExit;

    /** . */
    private boolean myDoorNorth;

    /** . */
    private boolean myDoorEast;

    /** . */
    private boolean myDoorSouth;

    /** . */
    private boolean myDoorWest;

    /** . */
    private boolean myOOPillar;

    /** . */
    private boolean myHealingPotion;

    /** . */
    private boolean myVisionPotion;

    /** . */
    private boolean myPit;

    // constructor

    /** . */
    Room(final boolean theEntrance, final boolean theExit, final boolean theDoorNorth,
         final boolean theDoorEast, final boolean theDoorSouth, final boolean theDoorWest,
         final boolean theOOPillar, final boolean theHealingPotion,
         final boolean theVisionPotion, final boolean thePit) {

        setEntrance(theEntrance);
        setExit(theExit);
        setDoorNorth(theDoorNorth);
        setDoorEast(theDoorEast);
        setDoorSouth(theDoorSouth);
        setDoorWest(theDoorWest);
        setOOPillar(theOOPillar);
        setHealingPotion(theHealingPotion);
        setVisionPotion(theVisionPotion);
        setPit(thePit);
    }

    // methods

    /** . */
    public final void setEntrance(final boolean theEntrance) {
        myEntrance = theEntrance;
    }

    /** . */
    public final boolean getEntrance() {
        return myEntrance;
    }

    /** . */
    public final void setExit(final boolean theExit) {
        myExit = theExit;
    }

    /** . */
    public final boolean getExit() {
        return myExit;
    }

    /** . */
    public final void setDoorNorth(final boolean theNorthDoor) {
        myDoorNorth = theNorthDoor;
    }

    /** . */
    public final boolean getDoorNorth() {
        return myDoorNorth;
    }

    /** . */
    public final void setDoorSouth(final boolean theSouthDoor) {
        myDoorSouth = theSouthDoor;
    }

    /** . */
    public final boolean getDoorSouth() {
        return myDoorSouth;
    }

    /** . */
    public final void setDoorEast(final boolean theEastDoor) {
        myDoorEast = theEastDoor;
    }

    /** . */
    public final boolean getDoorEast() {
        return myDoorEast;
    }

    /** . */
    public final void setDoorWest(final boolean theWestDoor) {
        myDoorWest = theWestDoor;
    }

    /** . */
    public final boolean getDoorWest() {
        return myDoorWest;
    }

    //TODO: May change DT to "char" not "bool"
    /** . */
    public final void setOOPillar(final boolean theOOPillar) {
        myOOPillar = theOOPillar;
    }

    /** . */
    public final boolean getOOPillar() {
        return myOOPillar;
    }

    /** . */
    public final void setHealingPotion(final boolean theHealingPotion) {
        myHealingPotion = theHealingPotion;
    }

    /** . */
    public final boolean getHealingPotion() {
        return myHealingPotion;
    }

    /** . */
    public final void setVisionPotion(final boolean theVisionPotion) {
        myVisionPotion = theVisionPotion;
    }

    /** . */
    public final boolean getVisionPotion() {
        return myVisionPotion;
    }

    /** . */
    public final void setPit(final boolean thePit) {
        myPit = thePit;
    }

    /** . */
    public final boolean getPit() {
        return myPit;
    }

    /** . */
    @Override
    public final String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("This room stats:" + NEW_LINE);
        sb.append("***********************************" + NEW_LINE);
        sb.append("Has an Entrance: " + getEntrance() + NEW_LINE);
        sb.append("Has an Exit: " + getExit() + NEW_LINE);
        sb.append("Has an North Door: " + getDoorNorth() + NEW_LINE);
        sb.append("Has an South Door: " + getDoorSouth() + NEW_LINE);
        sb.append("Has an East Door: " + getDoorEast() + NEW_LINE);
        sb.append("Has an West Door: " + getDoorWest() + NEW_LINE);
        sb.append("Has an OO Pillar in models.Room: " + getOOPillar() + NEW_LINE);
        sb.append("Has a Healing Potion in models.Room: " + getHealingPotion() + NEW_LINE);
        sb.append("Has a Vision Potion in models.Room: " + getVisionPotion() + NEW_LINE);
        sb.append("Has a Pit in models.Room: " + getPit() + NEW_LINE);
        return sb.toString();
    }


}
