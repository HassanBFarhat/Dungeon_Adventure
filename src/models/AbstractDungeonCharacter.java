package models;

import java.util.Random;

/**
 *
 * @author Hassan Bassam Farhat
 * @author Avinash Bavisetty
 * @version Summer 2023
 */
public abstract class AbstractDungeonCharacter {

    // constants
    /** . */
    private static final String NEW_LINE = "\n";

    // instance fields
    /** . */
    private String myCharacterName;
    /** . */
    private int myCharacterHealthPoints;
    /** . */
    private int myCharacterHitPoints;
    /** . */
    private int myMinimumDamageRange;
    /** . */
    private int myMaximumDamageRange;
    /** . */
    private int myAttackSpeed;
    /** . */
    private double myChanceToHit;


    // constructor

    /** . */
    AbstractDungeonCharacter(final String theCharacterName, final int theCharacterHealthPoints,
                             final int theCharacterHitPoints, final int theMinimumDamageRange,
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

    /** . */
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

    /** . */
    public final void setCharacterName(final String theName) {
        myCharacterName = theName;
    }

    /** . */
    public final String getCharacterName() {
        return myCharacterName;
    }

    /** . */
    public final void setCharacterHealthPoints(final int theHealthPoints) {
        myCharacterHealthPoints = Math.max(theHealthPoints, 0);
    }

    /** . */
    public final int getCharacterHealthPoints() {
        return myCharacterHealthPoints;
    }

    /** . */
    public final void setCharacterHitPoints(final int theHitPoints) {
        myCharacterHitPoints = theHitPoints;
    }

    /** . */
    public final int getCharacterHitPoints() {
        return myCharacterHitPoints;
    }

    /** . */
    public final void setMinimumDamageRange(final int theMinimumDamageRange) {
        myMinimumDamageRange = theMinimumDamageRange;
    }

    /** . */
    public final int getMinimumDamageRange() {
        return myMinimumDamageRange;
    }

    /** . */
    public final void setMaximumDamageRange(final int theMaximumDamageRange) {
        myMaximumDamageRange = theMaximumDamageRange;
    }

    /** . */
    public final int getMaximumDamageRange() {
        return myMaximumDamageRange;
    }

    /** . */
    public final void setAttackSpeed(final int theAttackSpeed) {
        myAttackSpeed = theAttackSpeed;
    }

    /** . */
    public final int getAttackSpeed() {
        return myAttackSpeed;
    }

    /** . */
    public final void setChanceToHit(final double theChangeToHit) {
        myChanceToHit = theChangeToHit;
    }

    /** . */
    public final double getChanceToHit() {
        return myChanceToHit;
    }

    /** . */
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
