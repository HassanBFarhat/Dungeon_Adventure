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
    /** . */
    private static final String WARRIOR_NAME = "Warrior";
    /** . */
    private static final String WARRIOR_FILE_PATH = "src/imgs/Warrior.png";
    /** . */
    private static final int HEALTH_POINTS = 125;
    /** . */
    private static final int HIT_POINTS = 125;
    /** . */
    private static final int ATTACK_SPEED = 4;
    /** . */
    private static final double CHANCE_TO_HIT = 0.8;
    /** . */
    private static final double CHANCE_TO_BLOCK = 0.2;
    /** . */
    private static final int MAX_DAMAGE = 60;
    /** . */
    private static final int MIN_DAMAGE = 35;
    /** . */
    private static final double CRUSHING_BLOW_CHANCE = 0.4;
    /** . */
    private static final int CRUSHING_BLOW_MIN_DAMAGE = 75;
    /** . */
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
