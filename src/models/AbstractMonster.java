package models;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serial;
import java.io.Serializable;
import java.util.Random;

/**
 *
 * @author Hassan Bassam Farhat
 * @author Avinash Bavisetty
 * @version Summer 2023
 */
public abstract class AbstractMonster
        extends AbstractDungeonCharacter implements Serializable {

    @Serial
    private static final long serialVersionUID = 1618814556113403060L;

    // constants
    /** . */
    private static final String NEW_LINE = "\n";


    // instance fields
    /** . */
    private double myMonsterChanceToHeal;
    /** . */
    private int myMinimumHealPoints;
    /** . */
    private int myMaximumHealPoints;


    // constructor

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

    /** . */
    public String getMonsterBattleImgFilePath() {
        return "No Main file found";
    }

    /** . */
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

    /** . */
    public void setMonsterChanceToHeal(final double theChance) {
        myMonsterChanceToHeal = theChance;
    }

    /** . */
    public double getMonsterChanceToHeal() {
        return myMonsterChanceToHeal;
    }

    /** . */
    public void setMinimumHealPoints(final int theMinHealPoints) {
        myMinimumHealPoints = theMinHealPoints;
    }

    /** . */
    public int getMinimumHealPoints() {
        return myMinimumHealPoints;
    }

    /** . */
    public void setMaximumHealPoints(final int theMaxHealPoints) {
        myMaximumHealPoints = theMaxHealPoints;
    }

    /** . */
    public int getMaximumHealPoints() {
        return myMaximumHealPoints;
    }

    /** . */
    public void saveToFile(final String theFilename) throws IOException {
        try (ObjectOutputStream oos
                     = new ObjectOutputStream(new FileOutputStream(theFilename))) {
            oos.writeObject(this);
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }

    /** . */
    public static AbstractMonster loadFile(final String theFilename) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(theFilename))) {
            return (AbstractMonster) in.readObject();
        } catch (final IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    /** . */
    @Override
    public String toString() {
        return super.toString() + "Monster's Chance to Heal: " + myMonsterChanceToHeal
                + NEW_LINE + "Monster's Minimum Heal Points: " + myMinimumHealPoints
                + NEW_LINE + "Monster's Maximum Heal Points: " + myMaximumHealPoints
                + NEW_LINE;
    }

}
