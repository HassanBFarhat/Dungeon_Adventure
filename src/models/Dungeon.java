package models;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hassan Bassam Farhat
 * @version Summer 2023
 */
public class Dungeon implements Serializable {

    //    private static final int MAZE_SIZE = (int) Math.random();
    private static final int MAZE_SIZE = 5;

    @Serial
    private static final long serialVersionUID = -8905573779050064748L;

    public void saveToFile(String filename) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Dungeon loadFile(String filename) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
            return (Dungeon) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
    private Room[][] myMazeRoom;
    private String myAdventureLocation;

    public Dungeon() {
        myMazeRoom = new Room[MAZE_SIZE][MAZE_SIZE];
        myAdventureLocation = "0.0";
        ////// UNDO THIS randomlyGenerateRooms();
//        checkIfEntranceToExitIsValid();
//        placeRandomContentInRoom();
//        placeRandomMonsterInRoom();
    }

    public void randomlyGenerateRooms() {

        Room currentRoom = new Room();
        List<RoomItems> pillarList = generateArrayOfPillars();
        MonsterFactory mF = new MonsterFactory();
        List<AbstractMonster> monsterList = mF.getMyMonsterList();
        boolean entrancePlaced = false;
        boolean exitPlaced = false;
        boolean abstractPillar = false;
        boolean inheritancePillar = false;
        boolean encapsulationPillar = false;
        boolean polymorphismPillar = false;

        for (int i = 0; i < MAZE_SIZE; i++) {
            for (int j = 0; j < MAZE_SIZE; j++) {
                System.out.print("THIS IS ROOM: Maze[" + i + "][" + j + "]");
                currentRoom.setMyRowPosition(i);
                currentRoom.setMyColumnPosition(j);
                if (i == 0 && !entrancePlaced) {
                    // randomly decide to place entrance somewhere on first row
                    final int randomEntranceNumber = (int) (Math.random() * 70);
                    if (randomEntranceNumber > 20) {
                        currentRoom.setEntrance(RoomItems.ENTRANCE);
                        entrancePlaced = true;
                    }
                    generateAndPutItemsAndDoorsInCurrentRoom(currentRoom, pillarList, monsterList, i, j);
                } else if (i == MAZE_SIZE - 1 && !exitPlaced) {
                    // randomly decide to place exit somewhere on last row
                    final int randomExitNumber = (int) (Math.random() * 70);
                    if (randomExitNumber > 20) {
                        currentRoom.setExit(RoomItems.EXIT);
                        exitPlaced = true;
                    }
                    generateAndPutItemsAndDoorsInCurrentRoom(currentRoom, pillarList, monsterList, i, j);
                } else {
                    // Randomly place items and doors in rooms.
                    generateAndPutItemsAndDoorsInCurrentRoom(currentRoom, pillarList, monsterList, i, j);
                    // checks to see if one of the pillars was placed into a room
                    if (!abstractPillar || !inheritancePillar || !encapsulationPillar || !polymorphismPillar) {
                        if (currentRoom.getOOPillar() == RoomItems.ABSTRACTION_PILLAR) {
                            abstractPillar = true;
                        } else if (currentRoom.getOOPillar() == RoomItems.INHERITANCE_PILLAR) {
                            inheritancePillar = true;
                        } else if (currentRoom.getOOPillar() == RoomItems.ENCAPSULATION_PILLAR) {
                            encapsulationPillar = true;
                        } else {
                            polymorphismPillar = true;
                        }
                    }
                }
                myMazeRoom[i][j] = currentRoom;
                System.out.println(currentRoom.toString());
                currentRoom = new Room();
            }
        }
        if (checkIfMazeIsValid(myMazeRoom)) {
            System.out.println("**************************MAZE IS GOOD**************************");
            return;
        } else {
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!MAZE IS NOT GOOD, REMAKING MAZE!!!!!!!!!!!!!!!!!!!!!!!!\n");
            randomlyGenerateRooms();
        }
    }

    private List<RoomItems> generateArrayOfPillars() {
        final List<RoomItems> arr = new ArrayList<>();
        arr.add(RoomItems.ABSTRACTION_PILLAR);
        arr.add(RoomItems.ENCAPSULATION_PILLAR);
        arr.add(RoomItems.INHERITANCE_PILLAR);
        arr.add(RoomItems.POLYMORPHISM_PILLAR);
        return arr;
    }

    private void generateAndPutItemsAndDoorsInCurrentRoom(final Room theRoom,
                                                          final List<RoomItems> thePillarList,
                                                          final List<AbstractMonster> theMonsterList,
                                                          final int theCurrentRow,
                                                          final int theCurrentColumn) {

        final int randomNumberForPotion = (int) (Math.random() * 100);
        final int randomNumberForPit = (int) (Math.random() * 100);
        final int randomNumberForPillar = (int) (Math.random() * 100);
        final int randomNumberForMonster = (int) (Math.random() * 100);

        // FIRST, SET ROOM DOORS
        // figures out what doors go within which room in the matrix
        if (theCurrentRow == 0 && theCurrentColumn > 0 && theCurrentColumn < MAZE_SIZE - 1) {
            theRoom.setDoorNorth(DoorDirections.NO_DOOR_DIRECTION);
            theRoom.setDoorSouth(DoorDirections.SOUTH);
            theRoom.setDoorEast(DoorDirections.EAST);
            theRoom.setDoorWest(DoorDirections.WEST);
        } else if (theCurrentRow == MAZE_SIZE - 1 && theCurrentColumn > 0 && theCurrentColumn < MAZE_SIZE - 1) {
            theRoom.setDoorNorth(DoorDirections.NORTH);
            theRoom.setDoorSouth(DoorDirections.NO_DOOR_DIRECTION);
            theRoom.setDoorEast(DoorDirections.EAST);
            theRoom.setDoorWest(DoorDirections.WEST);
        } else if (theCurrentRow > 0 && theCurrentRow < MAZE_SIZE - 1 && theCurrentColumn == 0) {
            theRoom.setDoorNorth(DoorDirections.NORTH);
            theRoom.setDoorSouth(DoorDirections.SOUTH);
            theRoom.setDoorEast(DoorDirections.EAST);
            theRoom.setDoorWest(DoorDirections.NO_DOOR_DIRECTION);
        } else if (theCurrentRow > 0 && theCurrentRow < MAZE_SIZE - 1 && theCurrentColumn == MAZE_SIZE - 1) {
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


        // SECOND, CHECK TO SEE IF ENTRANCE OR EXIT IS PLACED
        if (theRoom.hasEntrance() || theRoom.hasExit()) {
            return;
        }

        // THIRD, PLACE RANDOM ITEMS OTHERWISE.
        if (randomNumberForPotion <= 90) {
            theRoom.setHealingPotion(RoomItems.HEALING_POTION);
        }
        if (randomNumberForPit <= 10) {
            theRoom.setPit(RoomItems.PIT);
        }
        if (randomNumberForPillar <= 15 && thePillarList.size() != 0) {
            final int randomPillarIndex = (int) (Math.random() * thePillarList.size());
            theRoom.setOOPillar(thePillarList.get(randomPillarIndex));
            thePillarList.remove(randomPillarIndex);
        }
        //TODO:COME BACK AND FIX THIS FOR MONSTER GENERATION IN THE DUNGEON.
        if (randomNumberForMonster <= 90) {
            final int randomMonsterIndex = (int) (Math.random() * 3);
            theRoom.setRoomMonster(theMonsterList.get(randomMonsterIndex));
        }
        //
        //  if statement to place a random monster in the room goes here
        //  implement similar to the thePillarList, but don't remove the monster
        //  when finished adding to the room.
        //
        //

    }

    private boolean checkIfMazeIsValid(final Room[][] theMaze) {
        boolean value = false;
        boolean entrance = false;
        boolean exit = false;
        int pillarCount = 0;

        for (int i = 0; i < theMaze.length; i++) {
            for (int j = 0; j < theMaze.length; j++) {
                if (theMaze[i][j].hasEntrance()) {
                    entrance = true;
                }
                if (theMaze[i][j].hasExit()) {
                    exit = true;
                }
                if (theMaze[i][j].hasPillar()) {
                    pillarCount++;
                }
            }
        }

        if (entrance && exit && pillarCount == 4) {
            value = true;
        }

        return value;
    }


    public void setMazeRoom(Room[][] mazeRoom) {
        myMazeRoom = mazeRoom;
    }

    public Room[][] getMyMazeRoom() {
        return myMazeRoom;
    }

    public int getMazeSize() {
        return MAZE_SIZE;
    }


    public void setMyAdventureLocation(String myAdventureLocation) {
        this.myAdventureLocation = myAdventureLocation;
    }

    public String getMyAdventureLocation() {
        return myAdventureLocation;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < MAZE_SIZE; i++) {
            for (int j = 0; j < MAZE_SIZE; j++)
            sb.append(myMazeRoom[i][j].toString());
            sb.append("\n");
        }

        return sb.toString();
    }
}