package controller;

import views.MainFrame;

/**
 *  controller.DungeonAdventure class under the controller package used as entry way
 *  into the program.
 *
 *  @author Hassan Bassam Farhat
 *  @version Summer 2023
 */
public final class DungeonAdventure {

    private DungeonAdventure() {
        // Utility class shouldn't have public or default constructor.
    }

    /**
     *  Runs the MainFrame for the Dungeon Adventure game.
     *
     *  @param theArgs the command line arguments.
     */
    public static void main(final String[] theArgs) {
        new MainFrame();
    }

}
