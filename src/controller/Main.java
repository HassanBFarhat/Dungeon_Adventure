package controller;

import models.*;
import views.MainFrame;

import java.sql.SQLOutput;

public final class Main {

    private Main() {
        // Utility class shouldn't have public or default constructor.
    }

    public static void main(final String[] theArgs) {

//        new MainFrame();

        final Dungeon d = new Dungeon();
        d.randomlyGenerateRooms();

        System.out.println(d.getMyMazeRoom()[4][4]);
        System.out.println();
        System.out.println(d.getMyMazeRoom()[4][4].getRoomMonster());
        System.out.println(d.getMyMazeRoom()[4][4].getRoomMonster().getCharacterHealthPoints());
        System.out.println(d.getMyMazeRoom()[4][4].getRoomMonster().getCharacterHitPoints());
        System.out.println(d.getMyMazeRoom()[4][4].getHealingPotion());


//        MonsterFactory mf = new MonsterFactory();
//        System.out.println(mf.getMonsterList().toString());
//        final int randomMonsterIndex = (int) (Math.random() * 3);

//        System.out.println(randomMonsterIndex);





    }

}
