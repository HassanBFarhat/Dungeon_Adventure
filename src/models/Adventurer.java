package models;

import java.awt.*;
import java.util.ArrayList;

public class Adventurer extends Hero {

    // Attributes specific to models.Adventurer class
    private int myHealingPotions;
    private int myVisionPotions;
    private ArrayList<RoomItems> myPillars;

    // Constructor for models.Adventurer class
    protected Adventurer(final String theCharacterName, final int theCharacterHealthPoints,
                         final int theCharacterHitPoints, final int theMinimumDamageRange,
                         final int theMaximumDamageRange, final int theAttackSpeed,
                         final double theChanceToHit) {
        super(theCharacterName, theCharacterHealthPoints, theCharacterHitPoints, theAttackSpeed, theChanceToHit, theMaximumDamageRange, theMinimumDamageRange);
        myPillars = new ArrayList<>();
    }


    public String getAdventurerMainImgFilePath() {
        return "No Main file found";
    }

    public String getAdventurerBattleImgFilePath() {
        return "No Battle file found";
    }


    public void setMyHealingPotions(int healingPotions) {
        this.myHealingPotions += healingPotions;
        if (this.myHealingPotions < 0) {
            this.myHealingPotions = 0;  // Ensure it doesn't go negative
        }
    }

    public int getMyHealingPotions() {
        return myHealingPotions;
    }

    public void setMyVisionPotions(int visionPotions) {
        this.myVisionPotions += visionPotions;
        if (this.myVisionPotions < 0) {
            this.myVisionPotions = 0;  // Ensure it doesn't go negative
        }
    }

    public int getMyVisionPotions() {
        return myVisionPotions;
    }

    public void addPillarToMyPillarsArray(RoomItems thePillar) {
        myPillars.add(thePillar);
    }

    public ArrayList<RoomItems> getMyPillars() {
        return myPillars;
    }


    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        return sb.toString();
    }

}

