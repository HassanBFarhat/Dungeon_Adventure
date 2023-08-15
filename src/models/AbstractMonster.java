package models;

import java.io.Serial;
import java.io.Serializable;
import java.util.Random;

/**
 *  Subclass of the AbstractDungeonCharacter class that is in association with the
 *  monsters of this game.
 *
 *  @author Hassan Bassam Farhat
 *  @author Avinash Bavisetty
 *  @version Summer 2023
 */
public abstract class AbstractMonster
        extends AbstractDungeonCharacter implements Serializable {

    @Serial
    private static final long serialVersionUID = 1618814556113403060L;

    // constants
    /** . */
    private static final String NEW_LINE = "\n";


    // instance fields
    /** Holds the monsters chance to heal after health depleted a certain level. */
    private double myMonsterChanceToHeal;
    /** The minimum points that a monster can heal. */
    private int myMinimumHealPoints;
    /** The maximum points that a monster can heal. */
    private int myMaximumHealPoints;


    // constructor

    /**
     *  Calls on the super() of its parent class to set up a monster as a dungeon character.
     *
     * @param theName the name of the chosen monster.
     * @param theHealthPoints the health points of the chosen monster.
     * @param theHitPoints the hit points of the chosen monster.
     * @param theAttackSpeed the attack speed of the chosen monster.
     * @param theChanceHit the monsters chance to hit.
     * @param theMaxDamage the max damage the chosen monster can do.
     * @param theMinDamage the min damage the chosen monster can do.
     */
    public AbstractMonster(final String theName, final int theHealthPoints,
                           final int theHitPoints, final int theAttackSpeed,
                           final double theChanceHit, final int theMaxDamage,
                           final int theMinDamage) {
        super(theName, theHealthPoints, theHitPoints, theMinDamage,
                theMaxDamage, theAttackSpeed, theChanceHit);
    }

    protected AbstractMonster() {
    }


    // methods

    /** Gets the monsters image path for battle scenes. Is overridden in monster subclasses. */
    public String getMonsterBattleImgFilePath() {
        return "No Main file found";
    }

    /**
     *  Allows the monsters to pick a range of heal points between the min and max range that
     *  it will heal itself when called on.
     *
     * @return An integer being the points the monster will get healed with.
     */
    public int heal() {
        final Random random = new Random();
        int randomHeal = 0;
        final int randomChanceToHeal = (int) (Math.random() * 100);
        if (randomChanceToHeal >= (1 - getMonsterChanceToHeal())) {
            randomHeal = random.nextInt(
                    getMaximumHealPoints() - getMinimumHealPoints() + 1)
                    + getMinimumHealPoints();
        }
        return randomHeal;
    }

    /**
     *  Sets the chosen monsters chance to heal itself.
     *
     *  @param theChance the double representation of a hero's chance to heal itself.
     */
    public void setMonsterChanceToHeal(final double theChance) {
        myMonsterChanceToHeal = theChance;
    }

    /** Returns the chosen monsters chance to heal self. */
    public double getMonsterChanceToHeal() {
        return myMonsterChanceToHeal;
    }

    /**
     *  Sets the chosen monsters minimum heal range points.
     *
     *  @param theMinHealPoints the int representation of a monsters minimum healing points.
     */
    public void setMinimumHealPoints(final int theMinHealPoints) {
        myMinimumHealPoints = theMinHealPoints;
    }

    /** Returns the chosen monsters minimum healing points. */
    public int getMinimumHealPoints() {
        return myMinimumHealPoints;
    }

    /**
     *  Sets the chosen monsters maximum heal range points.
     *
     *  @param theMaxHealPoints the int representation of a monsters maximum healing points.
     */
    public void setMaximumHealPoints(final int theMaxHealPoints) {
        myMaximumHealPoints = theMaxHealPoints;
    }

    /** Returns the chosen monsters maximum healing points. */
    public int getMaximumHealPoints() {
        return myMaximumHealPoints;
    }

    /**
     *  Returns a string representation of the chosen monster, its stats, chance to
     *  heal, minimum heal points, and maximum heal points.
     */
    @Override
    public String toString() {
        return super.toString() + "Monster's Chance to Heal: " + myMonsterChanceToHeal
                + NEW_LINE + "Monster's Minimum Heal Points: " + myMinimumHealPoints
                + NEW_LINE + "Monster's Maximum Heal Points: " + myMaximumHealPoints
                + NEW_LINE;
    }

}
