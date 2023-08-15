//**MonsterFactoryTest**//
package tests;

import models.*;
import org.junit.jupiter.api.*;
import org.sqlite.SQLiteDataSource;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.*;

class MonsterFactoryTest {
    private static SQLiteDataSource ds;


    private void setDataSource(MonsterFactory factory, SQLiteDataSource ds) throws Exception {
        Field myDsField = MonsterFactory.class.getDeclaredField("myDs");
        myDsField.setAccessible(true);
        myDsField.set(factory, ds);
    }

    @Test
    void testCreateMonster() throws Exception {
        ds = new SQLiteDataSource();
        ds.setUrl("jdbc:sqlite:dungeon_characters.sqlite");
        MonsterFactory factory = new MonsterFactory(ds);
        setDataSource(factory, ds);
        factory.setMyDs(ds); // You may need to change the access modifier of myDs or use reflection

        AbstractMonster ogre = factory.createMonster("Ogre");
        assertEquals("src/imgs/Ogre1.png", ogre.getMonsterBattleImgFilePath());

        AbstractMonster gremlin = factory.createMonster("Gremlin");
        assertEquals("src/imgs/Gremlin1.png", gremlin.getMonsterBattleImgFilePath());

        AbstractMonster skeleton = factory.createMonster("Skeleton");
        assertEquals("src/imgs/Skeleton1.png", skeleton.getMonsterBattleImgFilePath());

        AbstractMonster noMonster = factory.createMonster("NoMonster");
        assertNull(noMonster);
    }

    @Test
    void testGetMyMonsterList() throws Exception {
        MonsterFactory factory = new MonsterFactory(ds);
        setDataSource(factory, ds);
        factory.setMyDs(ds); // You may need to change the access modifier of myDs or use reflection

        assertEquals(3, factory.getMyMonsterList().size());
    }
}
