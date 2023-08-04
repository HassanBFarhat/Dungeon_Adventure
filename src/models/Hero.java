package models;
public abstract class Hero extends DungeonCharacter {
    protected static final String NEW_LINE = "\n";

    // Attributes specific to models.Hero class
    private double myChanceToBlock;
    // It's not clear yet what type 'myHeroSpecialSkill' should be.
    // Assuming an int for now. Adjust as necessary.
    private int myHeroSpecialSkill;


    // Constructor
    public Hero(String name, int healthPoints, int hitPoints, int attackSpeed, double chanceHit,
                int maxDamage, int minDamage, double chanceToBlock) {
        super(name, healthPoints, hitPoints, maxDamage, minDamage, attackSpeed, chanceHit);

        // Additional initialization for models.Hero-specific attributes
        this.myChanceToBlock = chanceToBlock;

    }

    // Abstract method for subclasses to define their own special attack.
    protected abstract int specialAttack();

    // Default attack method with standard attack damage
    public int standardAttack() {
        int damage = super.attack(); // Call the attack method from the models.DungeonCharacter class
        // Add any additional behavior here if necessary
        return damage;
    }

    public double getChanceToBlock() {
        return myChanceToBlock;
    }

    public void setChanceToBlock(double chanceToBlock) {
        this.myChanceToBlock = chanceToBlock;
    }

    protected int getHeroSpecialSkill() {
        return myHeroSpecialSkill;
    }

    protected void setHeroSpecialSkill(int heroSpecialSkill) {
        this.myHeroSpecialSkill = heroSpecialSkill;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append("models.Hero's Chance to Block: " + myChanceToBlock + NEW_LINE);
        sb.append("models.Hero's Special Skill: " + myHeroSpecialSkill + NEW_LINE);
        return sb.toString();
    }
}




