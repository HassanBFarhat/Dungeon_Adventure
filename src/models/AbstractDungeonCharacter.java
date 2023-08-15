package models;

import java.io.Serial;
import java.io.Serializable;
import java.util.Random;

/**
 *  This class holds all character models behaviors and methods of hero's/monsters
 *  found throughout the game.
 *
 *  @author Hassan Bassam Farhat
 *  @author Avinash Bavisetty
 *  @version Summer 2023
 */
public abstract class AbstractDungeonCharacter implements Serializable {

    @Serial
    private static final long serialVersionUID = 3275576433211800933L;


    // constants
    /** Holds the escape character for new line. */
    private static final String NEW_LINE = "\n";

    // instance fields
    /** The dungeon characters name. */
    private String myCharacterName;
    /** The dungeon characters health points. */
    private int myCharacterHealthPoints;
    /** The dungeon characters hit points. */
    private int myCharacterHitPoints;
    /** The dungeon characters minimum damage range. */
    private int myMinimumDamageRange;
    /** The dungeon characters maximum damage range. */
    private int myMaximumDamageRange;
    /** The dungeon characters attack speed. */
    private int myAttackSpeed;
    /** The dungeon characters chance to hit. */
    private double myChanceToHit;


    // constructor

    /**
     *  Specified parameterized constructor for the hero/monster subclasses to call on
     *  in order to instantiate a dungeon character.
     */
    public AbstractDungeonCharacter(final String theCharacterName,
                                    final int theCharacterHealthPoints,
                                    final int theCharacterHitPoints,
                                    final int theMinimumDamageRange,
                                    final int theMaximumDamageRange, final int theAttackSpeed,
                                    final double theChanceToHit) {
        setCharacterName(theCharacterName);
        setCharacterHealthPoints(theCharacterHealthPoints);
        setCharacterHitPoints(theCharacterHitPoints);
        setMinimumDamageRange(theMinimumDamageRange);
        setMaximumDamageRange(theMaximumDamageRange);
        setAttackSpeed(theAttackSpeed);
        setChanceToHit(theChanceToHit);
    }

    protected AbstractDungeonCharacter() {

    }


    // methods

    /**
     *  Generic attack method that all dungeon characters utilize when needing to attack
     *  enemy.
     */
    public int attack() {
        final Random random = new Random();
        int randomDamage = 0;
        final int randomChanceToAttack = (int) (Math.random() * 100);
        if (randomChanceToAttack >= (1 - getChanceToHit())) {
            randomDamage = random.nextInt(
                    getMaximumDamageRange() - getMinimumDamageRange() + 1)
                    + getMinimumDamageRange();
        }
        return randomDamage;
    }

    /**
     *  Sets the dungeon characters myCharactersName instance field to the parameter
     *  theName.
     *
     * @param theName the passed String value for the dungeon characters name.
     */
    public final void setCharacterName(final String theName) {
        myCharacterName = theName;
    }

    /** Returns the instance of myCharacterName to whomever called upon it. */
    public final String getCharacterName() {
        return myCharacterName;
    }

    /**
     *  Sets the dungeon characters myCharacterHealthPoints instance field to the
     *  parameter theHealthPoints which will always be a positive number greater than
     *  0.
     *
     * @param theHealthPoints the passed int value for the dungeon characters health points.
     */
    public final void setCharacterHealthPoints(final int theHealthPoints) {
        myCharacterHealthPoints = Math.max(theHealthPoints, 0);
    }

    /** Returns the instance of myCharacterHealthPoints to whomever called upon it. */
    public final int getCharacterHealthPoints() {
        return myCharacterHealthPoints;
    }

    /**
     *  Sets the dungeon characters myCharacterHitPoints instance field to the
     *  parameter theHitPoints.
     *
     *  @param theHitPoints the passed int value for the dungeon characters hit points.
     */
    public final void setCharacterHitPoints(final int theHitPoints) {
        myCharacterHitPoints = theHitPoints;
    }

    /** Returns the instance of myCharacterHitPoints to whomever called upon it. */
    public final int getCharacterHitPoints() {
        return myCharacterHitPoints;
    }

    /**
     *  Sets the dungeon characters myMinimumDamageRange instance field to the
     *  parameter theMinimumDamageRange.
     *
     *  @param theMinimumDamageRange the passed int value for the dungeon characters
     *                               minimum points damage.
     */
    public final void setMinimumDamageRange(final int theMinimumDamageRange) {
        myMinimumDamageRange = theMinimumDamageRange;
    }

    /** Returns the instance of myMinimumDamageRange to whomever called upon it. */
    public final int getMinimumDamageRange() {
        return myMinimumDamageRange;
    }

    /**
     *  Sets the dungeon characters myMaximumDamageRange instance field to the
     *  parameter theMaximumDamageRange.
     *
     *  @param theMaximumDamageRange the passed int value for the dungeon characters
     *                               maximum points of damage.
     */
    public final void setMaximumDamageRange(final int theMaximumDamageRange) {
        myMaximumDamageRange = theMaximumDamageRange;
    }

    /** Returns the instance of myMaximumDamageRange to whomever called upon it. */
    public final int getMaximumDamageRange() {
        return myMaximumDamageRange;
    }

    /**
     *  Sets the dungeon characters myAttackSpeed instance field to the parameter
     *  theAttackSpeed.
     *
     *  @param theAttackSpeed the passed int value for the dungeon characters attack speed.
     */
    public final void setAttackSpeed(final int theAttackSpeed) {
        myAttackSpeed = theAttackSpeed;
    }

    /** Returns the instance of myAttackSpeed to whomever called upon it. */
    public final int getAttackSpeed() {
        return myAttackSpeed;
    }

    /**
     *  Sets the dungeon characters myChanceToHit instance field to the parameter
     *  theChanceToHit.
     *
     *  @param theChanceToHit the passed double value for the dungeon characters chance to
     *                        hit monster.
     */
    public final void setChanceToHit(final double theChanceToHit) {
        myChanceToHit = theChanceToHit;
    }

    /** Returns the instance of myChanceToHit to whomever called upon it. */
    public final double getChanceToHit() {
        return myChanceToHit;
    }

    /** Returns a string representation of the abstract dungeon character and its data. */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("This DungeonCharacter's name is " + getCharacterName() + "." + NEW_LINE);
        sb.append("These are " + getCharacterName() + "'s stats:" + NEW_LINE);
        sb.append("***********************************************" + NEW_LINE);
        sb.append("Health: " + getCharacterHealthPoints() + NEW_LINE);
        sb.append("Hit Points: " + getCharacterHitPoints() + NEW_LINE);
        sb.append("Minimum Damage Range: " + getMinimumDamageRange() + NEW_LINE);
        sb.append("Maximum Damage Range: " + getMaximumDamageRange() + NEW_LINE);
        sb.append("Attack Speed: " + getAttackSpeed() + NEW_LINE);
        sb.append("Chance to Hit: " + getChanceToHit() + NEW_LINE);
        return sb.toString();
    }

}
