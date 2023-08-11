package models;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hassan Bassam Farhat
 * @author Avinash Bavisetty
 * @version Summer 2023
 */
public class Dungeon implements Serializable {

    @Serial
    private static final long serialVersionUID = -8905573779050064748L;

    // constants
    /** . */
    private static final int MAZE_SIZE = 5;
    /** . */
    private static final int MAX_PILLAR_COUNT = 4;
    /** . */
    private static final int ENTRANCE_AND_EXIT_THRESHOLD = 20;
    /** . */
    private static final int POTION_PLACEMENT_POSSIBILITY = 90;
    /** . */
    private static final int PIT_PLACEMENT_POSSIBILITY = 90;
    /** . */
    private static final int PILLAR_PLACEMENT_POSSIBILITY = 15;
    /** . */
    private static final int MONSTER_PLACEMENT_POSSIBILITY = 85;

    // instance fields
    /** . */
    private final Room[][] myMazeRoom;


    // constructor

    public Dungeon() {
        myMazeRoom = new Room[MAZE_SIZE][MAZE_SIZE];
    }


    // methods

    /** . */
    public void randomlyGenerateRooms() {
        Room currentRoom = new Room();
        final List<RoomItems> pillarList = generateArrayOfPillars();
        final MonsterFactory mF = new MonsterFactory();
        final List<AbstractMonster> monsterList = mF.getMyMonsterList();
        boolean entrancePlaced = false;
        boolean exitPlaced = false;
        boolean abstractPillar = false;
        boolean inheritancePillar = false;
        boolean encapsulationPillar = false;
        boolean polymorphismPillar = false;

        for (int row = 0; row < MAZE_SIZE; row++) {
            for (int col = 0; col < MAZE_SIZE; col++) {
                System.out.print("THIS IS ROOM: Maze[" + row + "][" + col + "]");
                currentRoom.setMyRowPosition(row);
                currentRoom.setMyColumnPosition(col);
                if (row == 0 && !entrancePlaced) {
                    // randomly decide to place entrance somewhere on first row
                    final int randomEntranceNumber = (int) (Math.random() * 70);
                    if (randomEntranceNumber > ENTRANCE_AND_EXIT_THRESHOLD) {
                        currentRoom.setEntrance(RoomItems.ENTRANCE);
                        entrancePlaced = true;
                    }
                    generateAndPutItemsAndDoorsInCurrentRoom(currentRoom, pillarList,
                                                             monsterList, row, col);
                } else if (row == MAZE_SIZE - 1 && !exitPlaced) {
                    // randomly decide to place exit somewhere on last row
                    final int randomExitNumber = (int) (Math.random() * 70);
                    if (randomExitNumber > ENTRANCE_AND_EXIT_THRESHOLD) {
                        currentRoom.setExit(RoomItems.EXIT);
                        exitPlaced = true;
                    }
                    generateAndPutItemsAndDoorsInCurrentRoom(currentRoom, pillarList,
                                                             monsterList, row, col);
                } else {
                    // Randomly place items and doors in rooms.
                    generateAndPutItemsAndDoorsInCurrentRoom(currentRoom, pillarList,
                                                             monsterList, row, col);
                    // checks to see if one of the pillars was placed into a room
                    if (!abstractPillar || !inheritancePillar
                            || !encapsulationPillar || !polymorphismPillar) {
                        if (currentRoom.getOOPillar() == RoomItems.ABSTRACTION_PILLAR) {
                            abstractPillar = true;
                        } else if (currentRoom.getOOPillar() == RoomItems.INHERITANCE_PILLAR) {
                            inheritancePillar = true;
                        } else if (currentRoom.getOOPillar()
                                == RoomItems.ENCAPSULATION_PILLAR) {
                            encapsulationPillar = true;
                        } else {
                            polymorphismPillar = true;
                        }
                    }
                }
                myMazeRoom[row][col] = currentRoom;
                System.out.println(currentRoom.toString());
                currentRoom = new Room();
            }
        }
        if (!checkIfMazeIsValid(myMazeRoom)) {
            randomlyGenerateRooms();
        }
    }

    /** . */
    private List<RoomItems> generateArrayOfPillars() {
        final List<RoomItems> arr = new ArrayList<>();
        arr.add(RoomItems.ABSTRACTION_PILLAR);
        arr.add(RoomItems.ENCAPSULATION_PILLAR);
        arr.add(RoomItems.INHERITANCE_PILLAR);
        arr.add(RoomItems.POLYMORPHISM_PILLAR);
        return arr;
    }

    /** . */
    private void generateAndPutItemsAndDoorsInCurrentRoom(final Room theRoom,
                                                          final List<RoomItems> thePillarList,
                                                          final List<AbstractMonster>
                                                                  theMonsterList,
                                                          final int theCurrentRow,
                                                          final int theCurrentColumn) {
        // Firstly, set up the doors within the matrix
        setRoomDoors(theRoom, theCurrentRow, theCurrentColumn);
        // Secondly, check if entrance or exit has been placed
        if (theRoom.hasEntrance() || theRoom.hasExit()) {
            return;
        }
        // Thirdly, randomize items, and monsters within the current room of matrix
        setRandomItemsAndMonstersInRoom(theRoom, thePillarList, theMonsterList);
    }

    /** . */
    private void setRoomDoors(final Room theRoom,
                              final int theCurrentRow,
                              final int theCurrentColumn) {
        // FIRST, SET ROOM DOORS
        // figures out what doors go within which room in the matrix
        if (theCurrentRow == 0 && theCurrentColumn > 0 && theCurrentColumn < MAZE_SIZE - 1) {
            theRoom.setDoorNorth(DoorDirections.NO_DOOR_DIRECTION);
            theRoom.setDoorSouth(DoorDirections.SOUTH);
            theRoom.setDoorEast(DoorDirections.EAST);
            theRoom.setDoorWest(DoorDirections.WEST);
        } else if (theCurrentRow == MAZE_SIZE - 1 && theCurrentColumn > 0
                && theCurrentColumn < MAZE_SIZE - 1) {
            theRoom.setDoorNorth(DoorDirections.NORTH);
            theRoom.setDoorSouth(DoorDirections.NO_DOOR_DIRECTION);
            theRoom.setDoorEast(DoorDirections.EAST);
            theRoom.setDoorWest(DoorDirections.WEST);
        } else if (theCurrentRow > 0 && theCurrentRow < MAZE_SIZE - 1
                && theCurrentColumn == 0) {
            theRoom.setDoorNorth(DoorDirections.NORTH);
            theRoom.setDoorSouth(DoorDirections.SOUTH);
            theRoom.setDoorEast(DoorDirections.EAST);
            theRoom.setDoorWest(DoorDirections.NO_DOOR_DIRECTION);
        } else if (theCurrentRow > 0 && theCurrentRow < MAZE_SIZE - 1
                && theCurrentColumn == MAZE_SIZE - 1) {
            theRoom.setDoorNorth(DoorDirections.NORTH);
            theRoom.setDoorSouth(DoorDirections.SOUTH);
            theRoom.setDoorEast(DoorDirections.NO_DOOR_DIRECTION);
            theRoom.setDoorWest(DoorDirections.WEST);
        } else if (theCurrentRow == 0 && theCurrentColumn == MAZE_SIZE - 1) {
            theRoom.setDoorNorth(DoorDirections.NO_DOOR_DIRECTION);
            theRoom.setDoorSouth(DoorDirections.SOUTH);
            theRoom.setDoorEast(DoorDirections.NO_DOOR_DIRECTION);
            theRoom.setDoorWest(DoorDirections.WEST);
        } else if (theCurrentRow == MAZE_SIZE - 1 && theCurrentColumn == 0) {
            theRoom.setDoorNorth(DoorDirections.NORTH);
            theRoom.setDoorSouth(DoorDirections.NO_DOOR_DIRECTION);
            theRoom.setDoorEast(DoorDirections.EAST);
            theRoom.setDoorWest(DoorDirections.NO_DOOR_DIRECTION);
        } else if (theCurrentRow == MAZE_SIZE - 1 && theCurrentColumn == MAZE_SIZE - 1) {
            theRoom.setDoorNorth(DoorDirections.NORTH);
            theRoom.setDoorSouth(DoorDirections.NO_DOOR_DIRECTION);
            theRoom.setDoorEast(DoorDirections.NO_DOOR_DIRECTION);
            theRoom.setDoorWest(DoorDirections.WEST);
        } else if (theCurrentRow == 0 && theCurrentColumn == 0) {
            theRoom.setDoorNorth(DoorDirections.NO_DOOR_DIRECTION);
            theRoom.setDoorSouth(DoorDirections.SOUTH);
            theRoom.setDoorEast(DoorDirections.EAST);
            theRoom.setDoorWest(DoorDirections.NO_DOOR_DIRECTION);
        } else {
            theRoom.setDoorNorth(DoorDirections.NORTH);
            theRoom.setDoorSouth(DoorDirections.SOUTH);
            theRoom.setDoorEast(DoorDirections.EAST);
            theRoom.setDoorWest(DoorDirections.WEST);
        }
    }

    /** . */
    private void setRandomItemsAndMonstersInRoom(final Room theRoom,
                                                 final List<RoomItems> thePillarList,
                                                 final List<AbstractMonster> theMonsterList) {
        final int randomNumberForPotion = (int) (Math.random() * 100);
        final int randomNumberForPit = (int) (Math.random() * 100);
        final int randomNumberForPillar = (int) (Math.random() * 100);
        final int randomNumberForMonster = (int) (Math.random() * 100);

        // THIRD, PLACE RANDOM ITEMS OTHERWISE.
        if (randomNumberForPotion >= POTION_PLACEMENT_POSSIBILITY) {
            theRoom.setHealingPotion(RoomItems.HEALING_POTION);
        }
        if (randomNumberForPit >= PIT_PLACEMENT_POSSIBILITY) {
            theRoom.setPit(RoomItems.PIT);
        }
        if (randomNumberForPillar <= PILLAR_PLACEMENT_POSSIBILITY
                && thePillarList.size() != 0) {
            final int randomPillarIndex = (int) (Math.random() * thePillarList.size());
            theRoom.setOOPillar(thePillarList.get(randomPillarIndex));
            thePillarList.remove(randomPillarIndex);
        }
        if (randomNumberForMonster >= MONSTER_PLACEMENT_POSSIBILITY) {
            final int randomMonsterIndex = (int) (Math.random() * 3);
            theRoom.setRoomMonster(theMonsterList.get(randomMonsterIndex));
        }
    }


    /** . */
    private boolean checkIfMazeIsValid(final Room[][] theMaze) {
        boolean value = false;
        boolean entrance = false;
        boolean exit = false;
        int pillarCount = 0;
        for (Room[] rooms : theMaze) {
            for (int j = 0; j < theMaze.length; j++) {
                if (rooms[j].hasEntrance()) {
                    entrance = true;
                }
                if (rooms[j].hasExit()) {
                    exit = true;
                }
                if (rooms[j].hasPillar()) {
                    pillarCount++;
                }
            }
        }
        if (entrance && exit && pillarCount == MAX_PILLAR_COUNT) {
            value = true;
        }
        return value;
    }

    /** . */
    public Room[][] getMyMazeRoom() {
        return myMazeRoom;
    }

    /** . */
    public int getMazeSize() {
        return MAZE_SIZE;
    }

    /** . */
    public void saveToFile(final String theFilename) throws IOException {
        try (ObjectOutputStream oos
                     = new ObjectOutputStream(new FileOutputStream(theFilename))) {
            oos.writeObject(this);
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }

    /** . */
    public static Dungeon loadFile(final String theFilename) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(theFilename))) {
            return (Dungeon) in.readObject();
        } catch (final IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    /** . */
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < MAZE_SIZE; i++) {
            for (int j = 0; j < MAZE_SIZE; j++) {
                sb.append(myMazeRoom[i][j].toString());
                sb.append("\n");
            }
        }
        return sb.toString();
    }

}
