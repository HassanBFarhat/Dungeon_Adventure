package models;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Hassan Bassam Farhat
 * @author Avinash Bavisetty
 * @version Summer 2023
 */
public class Adventurer extends AbstractHero implements Serializable {

    @Serial
    private static final long serialVersionUID = 1322284771007316582L;

    // instance fields

    /** . */
    private int myHealingPotions;
//    /** . */
//    private int myVisionPotions;
    /** . */
    private final ArrayList<RoomItems> myPillars;


    // constructor

    protected Adventurer(final String theCharacterName, final int theCharacterHealthPoints,
                         final int theCharacterHitPoints, final int theMinimumDamageRange,
                         final int theMaximumDamageRange, final int theAttackSpeed,
                         final double theChanceToHit) {
        super(theCharacterName, theCharacterHealthPoints, theCharacterHitPoints,
                theAttackSpeed, theChanceToHit, theMaximumDamageRange, theMinimumDamageRange);
        myPillars = new ArrayList<>();
    }


    // methods

    /** . */
    public String getAdventurerMainImgFilePath() {
        return "No Main file found";
    }

    /** . */
    public String getAdventurerBattleImgFilePath() {
        return "No Battle file found";
    }

    /** . */
    public void setMyHealingPotions(final int theHealingPotions) {
        this.myHealingPotions += theHealingPotions;
        if (this.myHealingPotions < 0) {
            this.myHealingPotions = 0;
        }
    }

    /** . */
    public int getMyHealingPotions() {
        return myHealingPotions;
    }

    /** . */
    public void addPillarToMyPillarsArray(final RoomItems thePillar) {
        myPillars.add(thePillar);
    }

    /** . */
    public ArrayList<RoomItems> getMyPillars() {
        return myPillars;
    }

    /** . */
    public void saveToFile(final String theFilename, final Adventurer theAdventurer)
            throws IOException {
        try (ObjectOutputStream oos =
                     new ObjectOutputStream(new FileOutputStream(theFilename))) {
            oos.writeObject(theAdventurer);
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }

    /** . */
    public static Adventurer loadFile(final String theFilename) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(theFilename))) {
            return (Adventurer) in.readObject();
        } catch (final IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    /** . */
    public String toString() {
        return super.toString();
    }


//    public void setMyVisionPotions(final int theVisionPotions) {
//        this.myVisionPotions += theVisionPotions;
//        if (this.myVisionPotions < 0) {
//            this.myVisionPotions = 0;
//        }
//    }
//
//    public int getMyVisionPotions() {
//        return myVisionPotions;
//    }

}
