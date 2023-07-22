public abstract class Hero extends DungeonCharacter {

    protected static final String NEW_LINE = "\n";

    // Attributes specific to Hero class
    private double myChanceToBlock;
    // It's not clear yet what type 'myHeroSpecialSkill' should be.
    // Assuming an int for now. Adjust as necessary.
    private int myHeroSpecialSkill;

    // Constructor
    public Hero(String name, int healthPoints, int hitPoints, int attackSpeed, double chanceHit,
                int maxDamage, int minDamage, double chanceToBlock) {
        super(name, healthPoints, hitPoints, maxDamage, minDamage, attackSpeed, chanceHit);

        // Additional initialization for Hero-specific attributes
        this.myChanceToBlock = chanceToBlock;
        // Initialize myHeroSpecialSkill with a default value if needed
        this.myHeroSpecialSkill = 0;
    }

    // Abstract method for subclasses to define their own special attack.
    public abstract int specialAttack();

    public double getChanceToBlock() {
        return myChanceToBlock;
    }

    public void setChanceToBlock(double chanceToBlock) {
        this.myChanceToBlock = chanceToBlock;
    }

    public int getHeroSpecialSkill() {
        return myHeroSpecialSkill;
    }

    public void setHeroSpecialSkill(int heroSpecialSkill) {
        this.myHeroSpecialSkill = heroSpecialSkill;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append("Hero's Chance to Block: " + myChanceToBlock + NEW_LINE);
        sb.append("Hero's Special Skill: " + myHeroSpecialSkill + NEW_LINE);
        return sb.toString();
    }
}

