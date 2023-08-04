package models;

public class Adventurer extends DungeonCharacter {

    // Attributes specific to models.Adventurer class
    private String myName;
    private int myHitPoints;
    private int myHealingPotions;
    private int myVisionPotions;
    private char[] myPillars;

    // Constructor for models.Adventurer class
    protected Adventurer(final String theCharacterName, final int theCharacterHealthPoints,
                         final int theCharacterHitPoints, final int theMinimumDamageRange,
                         final int theMaximumDamageRange, final int theAttackSpeed,
                         final double theChanceToHit, int theVisionPotions, char[] thePillars) {
        super(theCharacterName, theCharacterHealthPoints, theCharacterHitPoints, theMinimumDamageRange, theMaximumDamageRange, theAttackSpeed, theChanceToHit);
        // Initialization for models.Adventurer-specific attributes can be added here, if needed
        this.myName = theCharacterName;
        this.myHitPoints = theCharacterHitPoints;
        this.myHealingPotions = theCharacterHealthPoints;
        this.myVisionPotions = theVisionPotions;
        this.myPillars = thePillars;
    }

    // Getter and Setter methods for models.Adventurer-specific attributes

    public void setMyName(String name) {
        this.myName = name;
    }

    public String getMyName() {
        return myName;
    }

    public void setMyHitPoints(int hitPoints) {
        this.myHitPoints = hitPoints;
    }

    public int getMyHitPoints() {
        return myHitPoints;
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

    public void setMyPillars(char[] pillars) {
        this.myPillars = pillars;
    }

    public char[] getMyPillars() {
        return myPillars;
    }

    public String toString() {
        final StringBuilder sb = new StringBuilder();

        // Use the superclass's toString() for shared attributes
        sb.append(super.toString());
        return sb.toString();
    }
}

