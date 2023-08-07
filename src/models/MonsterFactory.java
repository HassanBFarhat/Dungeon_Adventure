package models;

import java.sql.*;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.util.ArrayList;
import java.util.List;

public class MonsterFactory {

    private final DatabaseManager dbManager;
    private final List<Monster> monsterList;
    private final Logger logger;

    public MonsterFactory(DatabaseManager dbManager, Logger logger) {
        this.dbManager = dbManager;
        this.logger = logger;
        monsterList = new ArrayList<>();
        monsterList.add(createMonster("Ogre"));
        monsterList.add(createMonster("Gremlin"));
        monsterList.add(createMonster("Skeleton"));
    }

    public Monster createMonster(String monsterType) {
        Monster monster = null;

        ResultSet rs = this.dbManager.queryMonster(monsterType);

        try {
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
                        break;

                    case "Gremlin":
                        monster = new Gremlin(monsterName, monsterHealth, monsterHitPoints, monsterAttackSpeed, monsterChanceToHit, monsterMaxDamage, monsterMinDamage);
                        monster.setMonsterChanceToHeal(monsterChanceToHeal);
                        monster.setMinimumHealPoints(monsterMinHealPoints);
                        monster.setMaximumHealPoints(monsterMaxHealPoints);
                        break;

                    case "Skeleton":
                        monster = new Skeleton(monsterName, monsterHealth, monsterHitPoints, monsterAttackSpeed, monsterChanceToHit, monsterMaxDamage, monsterMinDamage);
                        monster.setMonsterChanceToHeal(monsterChanceToHeal);
                        monster.setMinimumHealPoints(monsterMinHealPoints);
                        monster.setMaximumHealPoints(monsterMaxHealPoints);
                        break;
                }
            }
        } catch (SQLException e) {
            this.logger.log(Level.SEVERE, "Error parsing the result set", e);
            throw new RuntimeException(e);
        }

        return monster;
    }

    public List<Monster> getMonsterList() {
        return monsterList;
    }
}
