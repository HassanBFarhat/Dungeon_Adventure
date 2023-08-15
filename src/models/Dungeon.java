package models;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *  Creates the 2D-Dungeon array itself with randomizing the items that goes within each
 *  room of the dungeon.
 *
 *  @author Hassan Bassam Farhat
 *  @author Avinash Bavisetty
 *  @version Summer 2023
 */
public class Dungeon implements Serializable {

    @Serial
    private static final long serialVersionUID = -8905573779050064748L;

    // constants
    /** Sets the constant for n x n size matrix of n = 5. */
    private static final int MAZE_SIZE = 5;
    /** Maximum pillars the dungeon can hold. */
    private static final int MAX_PILLAR_COUNT = 4;
    /** Threshold value to randomly place the entrance and exit throughout the dungeon. */
    private static final int ENTRANCE_AND_EXIT_THRESHOLD = 20;
    /** Chance to place a potion down (10%). */
    private static final int POTION_PLACEMENT_POSSIBILITY = 90;
    /** Chance to place a pit down (10%). */
    private static final int PIT_PLACEMENT_POSSIBILITY = 90;
    /** Chance to place one of the pillars in the dungeons room. */
    private static final int PILLAR_PLACEMENT_POSSIBILITY = 15;
    /** Chance to place one of the monsters in the dungeons room. */
    private static final int MONSTER_PLACEMENT_POSSIBILITY = 85;

    // instance fields
    /** Holds the n x n matrix of our 2D-Dungeon. */
    private final Room[][] myMazeRoom;


    // constructor

    /**
     *  Sets up the dungeon matrix to be of set specified size within this class.
     */
    public Dungeon() {
        myMazeRoom = new Room[MAZE_SIZE][MAZE_SIZE];
    }


    // methods

    /**
     *  Will randomly generate all rooms necessary for all cells of the dungeon matrix.
     *  This will continue to execute till all the cells within the maze are filled with
     *  a room.
     */
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
                currentRoom = new Room();
            }
        }
        if (!checkIfMazeIsValid(myMazeRoom)) {
            randomlyGenerateRooms();
        }
    }

    /** Returns the 2D-matrix of the generated Dungeon. */
    public Room[][] getMyMazeRoom() {
        return myMazeRoom;
    }

    /** Returns 'n' the (n x n) size of the matrix. */
    public int getMazeSize() {
        return MAZE_SIZE;
    }

    /**
     *  Returns a string representation of each room of the 2D-matrix and the room items
     *  within each cell.
     */
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


    // private methods

    /**
     *  Creates an array list that holds enum values for our OO Pillars. We will use this
     *  to remove a pillar and place in a room, and repeat till all pillars are placed in
     *  a room.
     */
    private List<RoomItems> generateArrayOfPillars() {
        final List<RoomItems> arr = new ArrayList<>();
        arr.add(RoomItems.ABSTRACTION_PILLAR);
        arr.add(RoomItems.ENCAPSULATION_PILLAR);
        arr.add(RoomItems.INHERITANCE_PILLAR);
        arr.add(RoomItems.POLYMORPHISM_PILLAR);
        return arr;
    }

    /**
     *  Generate the randomized items and place within the rooms, while also setting up
     *  the proper door associated with each cell of the matrix.
     */
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

    /** The logic for setting up each cell's proper door associations within the matrix. */
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

    /** The logic for randomizing the items that will go within each room of each cell. */
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


    /**
     *  This logic makes sure that the maze generated is proper for the player to access,
     *  and is able to beat the game by collecting all required OO keys.
     */
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

}
