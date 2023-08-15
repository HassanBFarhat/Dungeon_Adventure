package models;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *  The Adventurer.java is the actual object representation of the hero a player has chosen.
 *
 *  @author Hassan Bassam Farhat
 *  @author Avinash Bavisetty
 *  @version Summer 2023
 */
public class Adventurer extends AbstractHero implements Serializable {

    @Serial
    private static final long serialVersionUID = 1322284771007316582L;

    // instance fields

    /** Holds the value of how many potions the player has in their inventory. */
    private int myHealingPotions;
    /** Holds all the pillar keys collected within the players inventory. */
    private final ArrayList<RoomItems> myPillars;


    // constructor

    /**
     *  Calls on the super() of its parent class to set up a monster as a dungeon character.
     *
     * @param theCharacterName the name of the players chosen hero.
     * @param theCharacterHealthPoints the health points of the players chosen hero.
     * @param theCharacterHitPoints the hit points of the players chosen hero.
     * @param theMinimumDamageRange the min damage to the players chosen hero.
     * @param theMaximumDamageRange the max damage to the players chosen hero.
     * @param theAttackSpeed the attack speed of the players chosen hero.
     * @param theChanceToHit the player's chosen hero's chance to hit monster.
     */
    public Adventurer(final String theCharacterName, final int theCharacterHealthPoints,
                      final int theCharacterHitPoints, final int theMinimumDamageRange,
                      final int theMaximumDamageRange, final int theAttackSpeed,
                      final double theChanceToHit) {
        super(theCharacterName, theCharacterHealthPoints, theCharacterHitPoints,
                theAttackSpeed, theChanceToHit, theMaximumDamageRange, theMinimumDamageRange);
        myPillars = new ArrayList<>();
    }


    // methods

    /** Returns the player's chosen hero's main image file path. */
    public String getAdventurerMainImgFilePath() {
        return "No Main file found";
    }

    /** Returns the player's chosen hero's battle image file path. */
    public String getAdventurerBattleImgFilePath() {
        return "No Battle file found";
    }

    /**
     *  Sets the amount of healing potions the player has picked up traversing the dungeon.
     *
     *  @param theHealingPotions the int number of healing potions picked up for inventory.
     */
    public void setMyHealingPotions(final int theHealingPotions) {
        this.myHealingPotions += theHealingPotions;
        if (this.myHealingPotions < 0) {
            this.myHealingPotions = 0;
        }
    }

    /** Returns the player's chosen hero's amount of healing potions. */
    public int getMyHealingPotions() {
        return myHealingPotions;
    }

    /**
     *  Sets the player's pillar collection with the specified pillar when player traverses
     *  the dungeon and picks up a pillar.
     *
     *  @param thePillar the pillar in the room picked up by the player.
     */
    public void addPillarToMyPillarsArray(final RoomItems thePillar) {
        myPillars.add(thePillar);
    }

    /** Returns the player's chosen hero's collected OO Pillar keys. */
    public ArrayList<RoomItems> getMyPillars() {
        return myPillars;
    }

    /**
     *  Returns a string representation of the player's chosen hero, its stats, chance to
     *  block and special skill.
     */
    public String toString() {
        return super.toString();
    }
}
