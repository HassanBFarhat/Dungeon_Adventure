package models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.sqlite.SQLiteDataSource;

/**
 *  Produces a list of monsters by accessing SQLite DB and creating a List to pick
 *  and choose which ones to use for the game.
 *
 *  @author Hassan Bassam Farhat
 *  @author Avinash Bavisetty
 *  @version Summer 2023
 */
public class MonsterFactory {

    // constants
    /** . */
    private static final String OGRE = "Ogre";
    /** . */
    private static final String GREMLIN = "Gremlin";
    /** . */
    private static final String SKELETON = "Skeleton";


    // instance fields
    /** The data source for when accessing the SQLite DB. */
    private static SQLiteDataSource myDs;
    /** The list of monsters produced from the factory. */
    private List<AbstractMonster> myMonsterList;

    // constructor

    /** Empty default constructor. */
    public MonsterFactory() {
        this(null);
    }

    /**
     *  Specified constructor used to connect to DB and obtain monster information.
     *
     *  @param theDs the Data Source that connects us to the DB.
     */
    public MonsterFactory(final SQLiteDataSource theDs) {
        if (theDs == null) {
            try {
                myDs = new SQLiteDataSource();
                myDs.setUrl("jdbc:sqlite:dungeon_characters.sqlite");
            } catch (final Exception e) {
                e.printStackTrace();
                System.exit(0);
            }
        } else {
            myDs = theDs;
        }
        instantiateMonsterListAndAddMonstersToIt();
    }


    // methods

    /**
     *  Creates a specific monster by accessing the SQLite DB and retrieving and storing
     *  the data within a creation of AbstractMonster local variable instance.
     *
     *  @param theMonsterType the String representation of the monster we want to create.
     */
    public AbstractMonster createMonster(final String theMonsterType) {
        AbstractMonster monster = null;
        final String query
                = "SELECT * FROM monsters WHERE monster_name = '" + theMonsterType + "'";

        // querying DB for content
        try (Connection conn = myDs.getConnection();
             Statement stmt = conn.createStatement()) {
            final ResultSet rs = stmt.executeQuery(query);
            if (rs.next()) {
                final String monsterName = rs.getString("monster_name");
                final int monsterHealth = rs.getInt("monster_health_points");
                final int monsterHitPoints = rs.getInt("monster_hit_points");
                final int monsterMinDamage = rs.getInt("monster_min_damage");
                final int monsterMaxDamage = rs.getInt("monster_max_damage");
                final int monsterAttackSpeed = rs.getInt("monster_attack_speed");
                final double monsterChanceToHit = rs.getDouble("monster_chance_to_hit");
                final double monsterChanceToHeal = rs.getDouble("monster_chance_to_heal");
                final int monsterMinHealPoints = rs.getInt("monster_min_heal_points");
                final int monsterMaxHealPoints = rs.getInt("monster_max_heal_points");

                switch (theMonsterType) {
                    case OGRE -> {
                        monster = new Ogre(monsterName, monsterHealth, monsterHitPoints,
                                monsterAttackSpeed, monsterChanceToHit, monsterMaxDamage,
                                monsterMinDamage);
                        monster.setMonsterChanceToHeal(monsterChanceToHeal);
                        monster.setMinimumHealPoints(monsterMinHealPoints);
                        monster.setMaximumHealPoints(monsterMaxHealPoints);
                    }
                    case GREMLIN -> {
                        monster = new Gremlin(monsterName, monsterHealth, monsterHitPoints,
                                monsterAttackSpeed, monsterChanceToHit, monsterMaxDamage,
                                monsterMinDamage);
                        monster.setMonsterChanceToHeal(monsterChanceToHeal);
                        monster.setMinimumHealPoints(monsterMinHealPoints);
                        monster.setMaximumHealPoints(monsterMaxHealPoints);
                    }
                    case SKELETON -> {
                        monster = new Skeleton(monsterName, monsterHealth, monsterHitPoints,
                                monsterAttackSpeed, monsterChanceToHit, monsterMaxDamage,
                                monsterMinDamage);
                        monster.setMonsterChanceToHeal(monsterChanceToHeal);
                        monster.setMinimumHealPoints(monsterMinHealPoints);
                        monster.setMaximumHealPoints(monsterMaxHealPoints);
                    }
                    default -> {
                        System.out.println("No monsters are being created.");
                    }
                }
            }
        } catch (final SQLException e) {
            e.printStackTrace();
            System.exit(0);
            throw new RuntimeException(e);
        }
        return monster;
    }

    /** . */
    public void setMyDs(final SQLiteDataSource theDs) {
        // Package-private setter method for testing
        myDs = theDs;
    }

    /** Returns the list of all created monsters from the factory. */
    public List<AbstractMonster> getMyMonsterList() {
        return myMonsterList;
    }


    // private methods

    private void instantiateMonsterListAndAddMonstersToIt() {
        myMonsterList = new ArrayList<>();
        myMonsterList.add(createMonster(OGRE));
        myMonsterList.add(createMonster(GREMLIN));
        myMonsterList.add(createMonster(SKELETON));
    }

}