package models;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author Avinash Bavisetty
 * @author Hassan Bassam Farhat
 * @version Summer 2023
 */
public abstract class AbstractHero extends AbstractDungeonCharacter implements Serializable {

    @Serial
    private static final long serialVersionUID = 4675854409591872348L;

    // constants
    /** . */
    private static final String NEW_LINE = "\n";


    // instance fields
    /** . */
    private double myChanceToBlock;
    /** . */
    private String myHeroSpecialSkill;


    // Constructor

    public AbstractHero(final String theName, final int theHealthPoints,
                        final int theHitPoints, final int theAttackSpeed,
                        final double theChanceHit, final int theMaxDamage,
                        final int theMinDamage) {
        super(theName, theHealthPoints, theHitPoints, theMinDamage,
                theMaxDamage, theAttackSpeed, theChanceHit);
    }


    // method

    /** . */
    public int specialAttack() {
        return 0;
    }

    /** . */
    public double getChanceToBlock() {
        return myChanceToBlock;
    }

    /** . */
    public void setChanceToBlock(final double theChanceToBlock) {
        this.myChanceToBlock = theChanceToBlock;
    }

    /** . */
    protected void setHeroSpecialSkill(final String theHeroSpecialSkill) {
        this.myHeroSpecialSkill = theHeroSpecialSkill;
    }

    /** . */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(super.toString());
        sb.append("Hero's Chance to Block: " + getChanceToBlock() + NEW_LINE);
        sb.append("Hero's Special Skill: " + myHeroSpecialSkill + NEW_LINE);
        return sb.toString();
    }

}




