package models;

import java.util.Random;

public class Dungeon {
    private static final int MAZE_SIZE = (int) Math.random();


    private Room[][] myMazeRoom;
    private String myAdventureLocation;

    public Dungeon() {
//        myMazeRoom = new models.Room[][];
        myAdventureLocation = "0.0";
        randomlyGenerateRooms();
        checkIfEntranceToExitIsValid();
        placeRandomContentInRoom();
        placeRandomMonsterInRoom();
    }

    //METHOD STILL NEEDS A BIT OF WORK
    public void randomlyGenerateRooms() {
        Random randomroom = new Random();

        for (int i = 0; i < MAZE_SIZE; i++) {
            for (int j = 0; j < MAZE_SIZE; j++) {

                //values from boolean variables below are temp
                boolean North = false;
                boolean South = false;
                boolean East = false;
                boolean West = false;

                // myMazeRoom[i][j] = new models.Room(North, South, East, West);

            }
        }

    }

    public boolean checkIfEntranceToExitIsValid() {

        boolean[][] roomsvisited = new boolean[MAZE_SIZE][MAZE_SIZE];

        return direction(0, 0, roomsvisited);
    }

    private boolean direction(int row, int col, boolean[][] roomsvisited) {

        // Mark the current location as visited
        roomsvisited[row][col] = true;

        // If this location is out of bounds or has already been visited, it's not a valid path
        if (row < 0 || row >= MAZE_SIZE || col < 0 || col >= MAZE_SIZE || roomsvisited[row][col]) {
            return false;
        }

        // If this location is the exit, we've found a path!
        if (row == MAZE_SIZE - 1 && col == MAZE_SIZE - 1) {
            return true;
        }

        // Explore each direction from this location

        // North
        if (myMazeRoom[row][col].getDoorNorth() && direction(row - 1, col, roomsvisited)) {
            return true;
        }

        // East
        if (myMazeRoom[row][col].getDoorEast() && direction(row, col + 1, roomsvisited)) {
            return true;
        }

        // South
        if (myMazeRoom[row][col].getDoorSouth() && direction(row + 1, col, roomsvisited)) {
            return true;
        }

        // West
        return myMazeRoom[row][col].getDoorWest() && direction(row, col - 1, roomsvisited);
    }

    public void placeRandomContentInRoom() {

        Random room = new Random();

        for (int i = 0; i < MAZE_SIZE; i++ ) {
            for (int j = 0; j < MAZE_SIZE; j++) {
                myMazeRoom[i][j].setOOPillar(room.nextBoolean());
                myMazeRoom[i][j].setPit(room.nextBoolean());
                myMazeRoom[i][j].setVisionPotion(room.nextBoolean());
            }
        }

    }

    //THIS NEEDS TO BE COMPLETEDDDDDDD!!!!!!!!
    public DungeonCharacter placeRandomMonsterInRoom() {
        Random random = new Random();

        DungeonCharacter monster = null;

        return monster;
    }

//    public models.DungeonCharacter placeRandomMonsterInRoom() {
//        Random newRandom = new Random();
//        int random;
//    }

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