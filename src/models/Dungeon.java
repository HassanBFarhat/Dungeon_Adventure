package models;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Dungeon {
//    private static final int MAZE_SIZE = (int) Math.random();
    private static final int MAZE_SIZE = 5;


    private Room[][] myMazeRoom;
    private String myAdventureLocation;

    public Dungeon() {
//        myMazeRoom = new models.Room[][];
        myAdventureLocation = "0.0";
        randomlyGenerateRooms();
//        checkIfEntranceToExitIsValid();
//        placeRandomContentInRoom();
//        placeRandomMonsterInRoom();
    }

    //TODO: Needs to implement MonsterFactory to then add randomized monster to the room.
    public void randomlyGenerateRooms() {

        Room currentRoom = new Room();
        List<RoomItems> pillarList = generateArrayOfPillars();
        // MonsterFactory mF = new MonsterFactory();
        // List<Monster> monsterList = mF.getArrayOfMonsters();
        boolean entrancePlaced = false;
        boolean exitPlaced = false;
        boolean abstractPillar = false;
        boolean inheritancePillar = false;
        boolean encapsulationPillar = false;
        boolean polymorphismPillar = false;

        for (int i = 0; i < MAZE_SIZE; i++) {
            for (int j = 0; j < MAZE_SIZE; j++) {

                if (i == 0 && !entrancePlaced) {
                    // randomly decide to place entrance somewhere on first row
                    final int randomEntranceNumber = (int) (Math.random() * 70);
                    if (randomEntranceNumber > 20) {
                        currentRoom.setEntrance(RoomItems.ENTRANCE);
                    }
                    entrancePlaced = true;
                } else if (i == MAZE_SIZE - 1 && !exitPlaced) {
                    // randomly decide to place exit somewhere on last row
                    final int randomExitNumber = (int) (Math.random() * 70);
                    if (randomExitNumber > 20) {
                        currentRoom.setExit(RoomItems.EXIT);
                    }
                    exitPlaced = true;
                } else {
                    // Randomly place items and doors in rooms.
                    generateAndPutItemsAndDoorsInCurrentRoom(currentRoom, pillarList, i, j);
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
                    myMazeRoom[i][j] = currentRoom;
                    currentRoom = new Room();
                }
            }
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
                                                          final int theCurrentRow,
                                                          final int theCurrentColumn) {

        final int randomNumberForPotion = (int) (Math.random() * 100);
        final int randomNumberForPit = (int) (Math.random() * 100);
        final int randomNumberForPillar = (int) (Math.random() * 100);

        if (randomNumberForPotion <= 15) {
            theRoom.setHealingPotion(RoomItems.HEALING_POTION);
        }
        if (randomNumberForPit <= 10) {
            theRoom.setPit(RoomItems.PIT);
        }
        if (randomNumberForPillar <= 40) {
            final int randomPillarIndex = (int) (Math.random() * thePillarList.size());
            theRoom.setOOPillar(thePillarList.get(randomPillarIndex));
            thePillarList.remove(randomPillarIndex);
        }


        //
        //  if statement to place a random monster in the room goes here
        //  implement similar to the thePillarList, but don't remove the monster
        //  when finished adding to the room.
        //
        //



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

    }





    //TODO: CAN DELETE THIS METHOD. NO USE.
//    public boolean checkIfEntranceToExitIsValid() {
//
//        boolean[][] roomsvisited = new boolean[MAZE_SIZE][MAZE_SIZE];
//
//        return direction(0, 0, roomsvisited);
//    }

//    private boolean direction(int row, int col, boolean[][] roomsvisited) {
//
//        // Mark the current location as visited
//        roomsvisited[row][col] = true;
//
//        // If this location is out of bounds or has already been visited, it's not a valid path
//        if (row < 0 || row >= MAZE_SIZE || col < 0 || col >= MAZE_SIZE || roomsvisited[row][col]) {
//            return false;
//        }
//
//        // If this location is the exit, we've found a path!
//        if (row == MAZE_SIZE - 1 && col == MAZE_SIZE - 1) {
//            return true;
//        }
//
//        // Explore each direction from this location
//
//        // North
//        if (myMazeRoom[row][col].getDoorNorth() && direction(row - 1, col, roomsvisited)) {
//            return true;
//        }
//
//        // East
//        if (myMazeRoom[row][col].getDoorEast() && direction(row, col + 1, roomsvisited)) {
//            return true;
//        }
//
//        // South
//        if (myMazeRoom[row][col].getDoorSouth() && direction(row + 1, col, roomsvisited)) {
//            return true;
//        }
//
//        // West
//        return myMazeRoom[row][col].getDoorWest() && direction(row, col - 1, roomsvisited);
//    }
    //TODO: CAN DELETE
//    public void placeRandomContentInRoom() {
//
//        Random room = new Random();
//
//        for (int i = 0; i < MAZE_SIZE; i++ ) {
//            for (int j = 0; j < MAZE_SIZE; j++) {
//                myMazeRoom[i][j].setOOPillar(room.nextBoolean());
//                myMazeRoom[i][j].setPit(room.nextBoolean());
//                myMazeRoom[i][j].setVisionPotion(room.nextBoolean());
//            }
//        }
//
//    }
    //TODO: CAN DELETE
    //THIS NEEDS TO BE COMPLETEDDDDDDD!!!!!!!!
//    public DungeonCharacter placeRandomMonsterInRoom() {
//        Random random = new Random();
//
//        DungeonCharacter monster = null;
//
//        return monster;
//    }
//
////    public models.DungeonCharacter placeRandomMonsterInRoom() {
////        Random newRandom = new Random();
////        int random;
////    }

    public void setMazeRoom(Room[][] mazeRoom) {
        myMazeRoom = mazeRoom;
    }

    public Room[][] getMyMazeRoom() {
        return myMazeRoom;
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