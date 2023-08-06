package models;

import org.sqlite.SQLiteDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MonsterFactory {

    // constants

    /** . */
    private static SQLiteDataSource ds = null;

    // instance fields

    private final List<Monster> monsterList;

    // constructor

    public MonsterFactory() {
        // try for connection to DB
        try {
            ds = new SQLiteDataSource();
            ds.setUrl("jdbc:sqlite:dungeon_characters.sqlite");
        } catch ( Exception e ) {
            e.printStackTrace();
            System.exit(0);
        }

        monsterList = new ArrayList<>();
        monsterList.add(createMonster("Ogre"));
        monsterList.add(createMonster("Gremlin"));
        monsterList.add(createMonster("Skeleton"));
    }


    // methods

    public Monster createMonster(String monsterType) {
        Monster monster = null;

        String query = "SELECT * FROM monsters WHERE monster_name = '" + monsterType + "'";


        // querying DB for content
        try (Connection conn = ds.getConnection();
             Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next()) {
                String monsterName = rs.getString("monster_name");
                int monsterHealth = rs.getInt("monster_health_points");
                int monsterHitPoints = rs.getInt("monster_hit_points");
                int monsterMinDamage = rs.getInt("monster_min_damage");
                int monsterMaxDamage = rs.getInt("monster_max_damage");
                int monsterAttackSpeed = rs.getInt("monster_attack_speed");
                double monsterChanceToHit = rs.getDouble("monster_chance_to_hit");
                double monsterChanceToHeal = rs.getDouble("monster_chance_to_heal");
                int monsterMinHealPoints = rs.getInt("monster_min_heal_points");
                int monsterMaxHealPoints = rs.getInt("monster_max_heal_points");

                switch (monsterType) {
                    case "Ogre":
                        monster = new Ogre(monsterName, monsterHealth, monsterHitPoints, monsterAttackSpeed, monsterChanceToHit, monsterMaxDamage, monsterMinDamage);
                        monster.setMonsterChanceToHeal(monsterChanceToHeal);
                        monster.setMinimumHealPoints(monsterMinHealPoints);
                        monster.setMaximumHealPoints(monsterMaxHealPoints);

                    case "Gremlin":
                        monster = new Gremlin(monsterName, monsterHealth, monsterHitPoints, monsterAttackSpeed, monsterChanceToHit, monsterMaxDamage, monsterMinDamage);
                        monster.setMonsterChanceToHeal(monsterChanceToHeal);
                        monster.setMinimumHealPoints(monsterMinHealPoints);
                        monster.setMaximumHealPoints(monsterMaxHealPoints);

                    case "Skeleton":
                        monster = new Skeleton(monsterName, monsterHealth, monsterHitPoints, monsterAttackSpeed, monsterChanceToHit, monsterMaxDamage, monsterMinDamage);
                        monster.setMonsterChanceToHeal(monsterChanceToHeal);
                        monster.setMinimumHealPoints(monsterMinHealPoints);
                        monster.setMaximumHealPoints(monsterMaxHealPoints);
                }
            }
        }
        catch (final SQLException e) {
            e.printStackTrace();
            System.exit(0);
            throw new RuntimeException(e);
        }

        return monster;
    }

    public List<Monster> getMonsterList() {
        return monsterList;
    }

//    private

}
