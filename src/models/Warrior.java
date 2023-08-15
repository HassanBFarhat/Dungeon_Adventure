package models;

import java.io.Serial;
import java.io.Serializable;
import java.util.Random;

/**
 *  A child class of the parent AbstractHero, which holds the specific representation
 *  of a Warrior.
 *
 *  @author Hassan Bassam Farhat
 *  @author Avinash Bavisetty
 *  @version Summer 2023
 */
public class Warrior extends Adventurer implements Serializable {

    @Serial
    private static final long serialVersionUID = 3747422476561415822L;

    // constants
    /** Holds the constant for the "Warrior" character name. */
    private static final String WARRIOR_NAME = "Warrior";
    /** Holds the warrior's file path to the sprites image. */
    private static final String WARRIOR_FILE_PATH = "src/imgs/Warrior.png";
    /** Specific health points related to warrior's criteria. */
    private static final int HEALTH_POINTS = 125;
    /** Specific hit points related to warrior's criteria. */
    private static final int HIT_POINTS = 125;
    /** Specific attack speed related to warrior's criteria. */
    private static final int ATTACK_SPEED = 4;
    /** Specific chance to hit monster related to warrior's criteria. */
    private static final double CHANCE_TO_HIT = 0.8;
    /** Specific chance to block a monsters attack related to warrior's criteria. */
    private static final double CHANCE_TO_BLOCK = 0.2;
    /** Specific max damage a warrior can do on a monster. */
    private static final int MAX_DAMAGE = 60;
    /** Specific min damage a warrior can do on a monster. */
    private static final int MIN_DAMAGE = 35;
    /** Specific chance a warrior will be able to perform a crushing blow on monster. */
    private static final double CRUSHING_BLOW_CHANCE = 0.4;
    /** Specific min damage points related to warrior's special attack criteria. */
    private static final int CRUSHING_BLOW_MIN_DAMAGE = 75;
    /** Specific max damage points related to warrior's special attack criteria. */
    private static final int CRUSHING_BLOW_MAX_DAMAGE = 175;


    // constructor

    /**
     *  Calls on the super() of its parent class to set up the warrior as a hero character.
     */
    public Warrior() {
        super(WARRIOR_NAME, HEALTH_POINTS, HIT_POINTS, MIN_DAMAGE, MAX_DAMAGE,
                ATTACK_SPEED, CHANCE_TO_HIT);
        setChanceToBlock(CHANCE_TO_BLOCK);
        setHeroSpecialSkill("Crushing Blow");
    }


    // methods

    /** Returns the warrior's specific file path. */
    @Override
    public String getAdventurerMainImgFilePath() {
        return WARRIOR_FILE_PATH;
    }

    /**
     *  Allows the warrior to pick a range of crushing blow points between the min and max
     *  range that it will deal damage to the monster currently being fought.
     *
     * @return An integer being the points the warrior will do on the monster.
     */
    @Override
    public int specialAttack() {
        final Random random = new Random();
        final double chanceForCrushingBlow = (int) (Math.random() * 100) / 100.0;
        int randomCrushAmount = 0;
        if (chanceForCrushingBlow >= (1 - CRUSHING_BLOW_CHANCE)) {
            randomCrushAmount =
                    random.nextInt(CRUSHING_BLOW_MAX_DAMAGE - CRUSHING_BLOW_MIN_DAMAGE + 1)
                            + CRUSHING_BLOW_MIN_DAMAGE;
        }
        return randomCrushAmount;
    }

}
