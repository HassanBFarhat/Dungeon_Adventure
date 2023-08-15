package models;

import java.io.Serial;
import java.io.Serializable;
import java.util.Random;

/**
 *  A child class of the parent AbstractHero, which holds the specific representation
 *  of a Priestess.
 *
 *  @author Hassan Bassam Farhat
 *  @author Avinash Bavisetty
 *  @version Summer 2023
 */
public class Priestess extends Adventurer implements Serializable {

    @Serial
    private static final long serialVersionUID = -4337052340195714754L;

    // constants
    /** . */
    private static final String PRIESTESS_NAME = "Priestess";
    /** . */
    private static final String PRIESTESS_FILE_PATH = "src/imgs/Priestess.png";
    /** . */
    private static final int HEALTH_POINTS = 75;
    /** . */
    private static final int HIT_POINTS = 75;
    /** . */
    private static final int ATTACK_SPEED = 5;
    /** . */
    private static final double CHANCE_TO_HIT = 0.7;
    /** . */
    private static final double CHANCE_TO_BLOCK = 0.3;
    /** . */
    private static final int MAX_DAMAGE = 45;
    /** . */
    private static final int MIN_DAMAGE = 25;
    /** . */
    private static final int MIN_HEAL = 10;
    /** . */
    private static final int MAX_HEAL = 30;


    // constructor

    /**
     *  Calls on the super() of its parent class to set up the priestess as a hero character.
     */
    public Priestess() {
        super(PRIESTESS_NAME, HEALTH_POINTS, HIT_POINTS, MIN_DAMAGE, MAX_DAMAGE,
                ATTACK_SPEED, CHANCE_TO_HIT);
        setChanceToBlock(CHANCE_TO_BLOCK);
        setHeroSpecialSkill("Heal");
    }


    // methods

    /** Returns the priestess's specific file path. */
    @Override
    public String getAdventurerMainImgFilePath() {
        return PRIESTESS_FILE_PATH;
    }

    /**
     *  Allows the priestess to pick a range of healing points between the min and max
     *  range that it will heal herself during a battle with a monster.
     *
     * @return An integer being the points the priestess will heal herself with.
     */
    @Override
    public int specialAttack() {
        final Random random = new Random();
        return random.nextInt(MAX_HEAL - MIN_HEAL + 1) + MIN_HEAL;
    }

}
