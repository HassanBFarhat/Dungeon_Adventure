package models;

import java.io.Serial;
import java.io.Serializable;

/**
 *  A child class of the parent AbstractHero, which holds the specific representation
 *  of a Thief.
 *
 *  @author Hassan Bassam Farhat
 *  @author Avinash Bavisetty
 *  @version Summer 2023
 */
public class Thief extends Adventurer implements Serializable {

    @Serial
    private static final long serialVersionUID = 8850439520184187280L;

    // constants
    /** Holds the constant for the "Thief" character name. */
    private static final String THIEF_NAME = "Thief";
    /** Holds the thief's file path to the sprites image. */
    private static final String THIEF_FILE_PATH = "src/imgs/Thief.png";
    /** Specific health points related to thief's criteria. */
    private static final int HEALTH_POINTS = 75;
    /** Specific hit points related to thief's criteria. */
    private static final int HIT_POINTS = 75;
    /** Specific attack speed related to thief's criteria. */
    private static final int ATTACK_SPEED = 6;
    /** Specific chance to hit monster related to thief's criteria. */
    private static final double CHANCE_TO_HIT = 0.8;
    /** Specific chance to block a monsters attack related to thief's criteria. */
    private static final double CHANCE_TO_BLOCK = 0.4;
    /** Specific max damage a thief can do on a monster. */
    private static final int MAX_DAMAGE = 40;
    /** Specific min damage a thief can do on a monster. */
    private static final int MIN_DAMAGE = 20;
    /** Specific chance a thief will be able to perform a surprise attack on monster. */
    private static final double SURPRISE_ATTACK_ODDS = 0.6;
    /** Specific chance the surprise attack fails and thief is caught. */
    private static final double CHANCE_CAUGHT = 0.2;


    // constructor

    /**
     *  Calls on the super() of its parent class to set up the thief as a hero character.
     */
    public Thief() {
        super(THIEF_NAME, HEALTH_POINTS, HIT_POINTS, MIN_DAMAGE, MAX_DAMAGE,
                ATTACK_SPEED, CHANCE_TO_HIT);
        setChanceToBlock(CHANCE_TO_BLOCK);
        setHeroSpecialSkill("Surprise Attack");
    }


    // methods

    /** Returns the thief's specific file path. */
    @Override
    public String getAdventurerMainImgFilePath() {
        return THIEF_FILE_PATH;
    }

    /**
     *  Allows the thief to try and do a surprise attack. If successful, the thief has an
     *  opportunity to attack twice if the chance for a surprise attack is successful.
     *  Otherwise, the thief will only attack once. If the thief tries and is unsuccessful,
     *  he's caught and turn moves over to monster.
     *
     * @return An integer being the points the thief will do on the monster.
     */
    @Override
    public int specialAttack() {
        final double chanceForSurpriseAttackOdds = (int) (Math.random() * 100) / 100.0;
        int totalDamage = 0;
        if (chanceForSurpriseAttackOdds >= (1 - CHANCE_CAUGHT)) {
            return totalDamage;
        } else if (chanceForSurpriseAttackOdds >= (1 - SURPRISE_ATTACK_ODDS)) {
            totalDamage += this.attack();
            totalDamage += this.attack();
        } else {
            totalDamage += this.attack();
        }
        return totalDamage;
    }

}
