package controller;

import models.*;
import views.MainFrame;

import java.sql.SQLOutput;

public final class Main {

    private Main() {
        // Utility class shouldn't have public or default constructor.
    }

    public static void main(final String[] theArgs) {

        new MainFrame();

//        final Dungeon d = new Dungeon();
//        d.randomlyGenerateRooms();

//        MonsterFactory mf = new MonsterFactory();
//        System.out.println(mf.getMonsterList().toString());
//        final int randomMonsterIndex = (int) (Math.random() * 3);

//        System.out.println(randomMonsterIndex);


    }

}
