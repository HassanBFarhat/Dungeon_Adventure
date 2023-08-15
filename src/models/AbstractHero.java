package models;

import java.io.Serial;
import java.io.Serializable;

/**
 *  Subclass of the AbstractDungeonCharacter class that is in association with the
 *  hero's of this game.
 *
 *  @author Avinash Bavisetty
 *  @author Hassan Bassam Farhat
 *  @version Summer 2023
 */
public abstract class AbstractHero extends AbstractDungeonCharacter implements Serializable {

    @Serial
    private static final long serialVersionUID = 4675854409591872348L;

    // constants
    /** Escape sequence constant for newline. */
    private static final String NEW_LINE = "\n";


    // instance fields
    /** Holds the hero's change to block a monsters attack. */
    private double myChanceToBlock;
    /** Holds the string representing the specific hero's special move. */
    private String myHeroSpecialSkill;


    // Constructor

    /**
     *  Calls on the super() of its parent class to set up a hero as a dungeon character.
     *
     * @param theName the name of the chosen hero.
     * @param theHealthPoints the health points of the chosen hero.
     * @param theHitPoints the hit points of the chosen hero.
     * @param theAttackSpeed the attack speed of the chosen hero.
     * @param theChanceHit the hero's chance to hit.
     * @param theMaxDamage the max damage the chosen hero can do.
     * @param theMinDamage the min damage the chosen hero can do.
     */
    public AbstractHero(final String theName, final int theHealthPoints,
                        final int theHitPoints, final int theAttackSpeed,
                        final double theChanceHit, final int theMaxDamage,
                        final int theMinDamage) {
        super(theName, theHealthPoints, theHitPoints, theMinDamage,
                theMaxDamage, theAttackSpeed, theChanceHit);
    }


    // method

    /**
     *  Default hero special attack that will be overridden and specified by each hero
     *  accordingly.
     */
    public int specialAttack() {
        return 0;
    }

    /** Returns the chosen hero's chance to block a monsters hit. */
    public double getChanceToBlock() {
        return myChanceToBlock;
    }

    /**
     *  Sets the chosen hero's chance to block a monsters hit.
     *
     *  @param theChanceToBlock the double representation of a hero's chance to block an
     *                          attack.
     */
    public void setChanceToBlock(final double theChanceToBlock) {
        this.myChanceToBlock = theChanceToBlock;
    }

    /**
     *  Sets the string representation of each hero's special skill.
     *
     *  @param theHeroSpecialSkill the String form of a chosen hero's special skill.
     */
    protected void setHeroSpecialSkill(final String theHeroSpecialSkill) {
        this.myHeroSpecialSkill = theHeroSpecialSkill;
    }

    /**
     *  Returns a string representation of the chosen hero, its stats, chance to
     *  block and special skill.
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(super.toString());
        sb.append("Hero's Chance to Block: " + getChanceToBlock() + NEW_LINE);
        sb.append("Hero's Special Skill: " + myHeroSpecialSkill + NEW_LINE);
        return sb.toString();
    }

}
