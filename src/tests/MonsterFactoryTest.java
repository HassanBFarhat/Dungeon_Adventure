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


    @BeforeAll
    static void setUp() throws Exception {
        ds = new SQLiteDataSource();
        ds.setUrl("jdbc:sqlite:dungeon_characters.sqlite");
        MonsterFactory monsterFactory = new MonsterFactory(ds);


        // Create the table and insert test data
        try (Connection conn = ds.getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.execute("DROP TABLE IF EXISTS monsters");
            stmt.execute("CREATE TABLE monsters (monster_name TEXT, monster_health_points INTEGER, monster_hit_points INTEGER, monster_min_damage INTEGER, monster_max_damage INTEGER, monster_attack_speed INTEGER, monster_chance_to_hit REAL, monster_chance_to_heal REAL, monster_min_heal_points INTEGER, monster_max_heal_points INTEGER)");
            stmt.execute("INSERT INTO monsters VALUES ('Ogre', 100, 10, 1, 5, 2, 0.8, 0.3, 2, 4)");
            stmt.execute("INSERT INTO monsters VALUES ('Gremlin', 80, 8, 2, 4, 3, 0.7, 0.4, 1, 3)");
            stmt.execute("INSERT INTO monsters VALUES ('Skeleton', 60, 6, 3, 6, 4, 0.6, 0.5, 2, 5)");
        }
    }
    private void setDataSource(MonsterFactory factory, SQLiteDataSource ds) throws Exception {
        Field myDsField = MonsterFactory.class.getDeclaredField("myDs");
        myDsField.setAccessible(true);
        myDsField.set(factory, ds);
    }

    @Test
    void testCreateMonster() throws Exception {
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
