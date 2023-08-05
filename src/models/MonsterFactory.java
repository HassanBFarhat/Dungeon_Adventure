package models;

import org.sqlite.SQLiteDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MonsterFactory {

    // constants

    /** . */
    private static SQLiteDataSource ds = null;

    // instance fields

    private List<Monster> monsterList;

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

        String query = "SELECT * FROM monsters WHERE monster_name = ";

        if (monsterType.equals("Ogre")) {
            query += "'Ogre'";
            // querying DB for content
            try (Connection conn = ds.getConnection();
                 Statement stmt = conn.createStatement();) {
                ResultSet rs = stmt.executeQuery(query);
                String monsterName = null;
                int monsterHealth = 0;
                int monsterHitPoints = 0;
                int monsterMinDamage = 0;
                int monsterMaxDamage = 0;
                int monsterAttackSpeed = 0;
                double monsterChanceToHit = 0.0;
                double monsterChanceToHeal = 0.0;
                int monsterMinHealPoints = 0;
                int monsterMaxHealPoints = 0;
                while (rs.next()) {
                    monsterName = rs.getString("monster_name");
                    monsterHealth = rs.getInt("monster_health_points");
                    monsterHitPoints = rs.getInt("monster_hit_points");
                    monsterMinDamage = rs.getInt("monster_min_damage");
                    monsterMaxDamage = rs.getInt("monster_max_damage");
                    monsterAttackSpeed = rs.getInt("monster_attack_speed");
                    monsterChanceToHit = rs.getDouble("monster_chance_to_hit");
                    monsterChanceToHeal = rs.getDouble("monster_chance_to_heal");
                    monsterMinHealPoints = rs.getInt("monster_min_heal_points");
                    monsterMaxHealPoints = rs.getInt("monster_max_heal_points");
                }
                monster = new Ogre(monsterName, monsterHealth, monsterHitPoints, monsterAttackSpeed, monsterChanceToHit, monsterMaxDamage, monsterMinDamage);
                monster.setMonsterChanceToHeal(monsterChanceToHeal);
                monster.setMinimumHealPoints(monsterMinHealPoints);
                monster.setMaximumHealPoints(monsterMaxHealPoints);

            } catch (final Exception e) {
                e.printStackTrace();
                System.exit(0);
            }
        } else if (monsterType.equals("Gremlin")) {
            query += "'Gremlin'";
            // querying DB for content
            try (Connection conn = ds.getConnection();
                 Statement stmt = conn.createStatement();) {
                ResultSet rs = stmt.executeQuery(query);
                String monsterName = null;
                int monsterHealth = 0;
                int monsterHitPoints = 0;
                int monsterMinDamage = 0;
                int monsterMaxDamage = 0;
                int monsterAttackSpeed = 0;
                double monsterChanceToHit = 0.0;
                double monsterChanceToHeal = 0.0;
                int monsterMinHealPoints = 0;
                int monsterMaxHealPoints = 0;
                while (rs.next()) {
                    monsterName = rs.getString("monster_name");
                    monsterHealth = rs.getInt("monster_health_points");
                    monsterHitPoints = rs.getInt("monster_hit_points");
                    monsterMinDamage = rs.getInt("monster_min_damage");
                    monsterMaxDamage = rs.getInt("monster_max_damage");
                    monsterAttackSpeed = rs.getInt("monster_attack_speed");
                    monsterChanceToHit = rs.getDouble("monster_chance_to_hit");
                    monsterChanceToHeal = rs.getDouble("monster_chance_to_heal");
                    monsterMinHealPoints = rs.getInt("monster_min_heal_points");
                    monsterMaxHealPoints = rs.getInt("monster_max_heal_points");
                }
                monster = new Ogre(monsterName, monsterHealth, monsterHitPoints, monsterAttackSpeed, monsterChanceToHit, monsterMaxDamage, monsterMinDamage);
                monster.setMonsterChanceToHeal(monsterChanceToHeal);
                monster.setMinimumHealPoints(monsterMinHealPoints);
                monster.setMaximumHealPoints(monsterMaxHealPoints);

            } catch (final Exception e) {
                e.printStackTrace();
                System.exit(0);
            }
        } else if (monsterType.equals("Skeleton")) {
            query += "'Skeleton'";
            // querying DB for content
            try (Connection conn = ds.getConnection();
                 Statement stmt = conn.createStatement();) {
                ResultSet rs = stmt.executeQuery(query);
                String monsterName = null;
                int monsterHealth = 0;
                int monsterHitPoints = 0;
                int monsterMinDamage = 0;
                int monsterMaxDamage = 0;
                int monsterAttackSpeed = 0;
                double monsterChanceToHit = 0.0;
                double monsterChanceToHeal = 0.0;
                int monsterMinHealPoints = 0;
                int monsterMaxHealPoints = 0;
                while (rs.next()) {
                    monsterName = rs.getString("monster_name");
                    monsterHealth = rs.getInt("monster_health_points");
                    monsterHitPoints = rs.getInt("monster_hit_points");
                    monsterMinDamage = rs.getInt("monster_min_damage");
                    monsterMaxDamage = rs.getInt("monster_max_damage");
                    monsterAttackSpeed = rs.getInt("monster_attack_speed");
                    monsterChanceToHit = rs.getDouble("monster_chance_to_hit");
                    monsterChanceToHeal = rs.getDouble("monster_chance_to_heal");
                    monsterMinHealPoints = rs.getInt("monster_min_heal_points");
                    monsterMaxHealPoints = rs.getInt("monster_max_heal_points");
                }
                monster = new Ogre(monsterName, monsterHealth, monsterHitPoints, monsterAttackSpeed, monsterChanceToHit, monsterMaxDamage, monsterMinDamage);
                monster.setMonsterChanceToHeal(monsterChanceToHeal);
                monster.setMinimumHealPoints(monsterMinHealPoints);
                monster.setMaximumHealPoints(monsterMaxHealPoints);

            } catch (final Exception e) {
                e.printStackTrace();
                System.exit(0);
            }
        }
        return monster;
    }

    public List<Monster> getMonsterList() {
        return monsterList;
    }

//    private

}
