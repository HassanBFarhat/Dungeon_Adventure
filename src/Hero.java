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

class Warrior extends Hero {

    private static final double CRUSHING_BLOW_CHANCE = 0.4; // 40%
    private static final int CRUSHING_BLOW_MIN_DAMAGE = 75;
    private static final int CRUSHING_BLOW_MAX_DAMAGE = 175;

    public Warrior(String name) {
        super(name, 125, 125, 4, 0.8, 35, 60, 0.2);

        // If there's any Warrior-specific attribute initialization, do it here
    }

    @Override
    public int specialAttack() {
        double chance = Math.random();
        if (chance <= CRUSHING_BLOW_CHANCE) {
            // If the Crushing Blow succeeds
            return (int)(chance * (CRUSHING_BLOW_MAX_DAMAGE - CRUSHING_BLOW_MIN_DAMAGE + 1))
                    + CRUSHING_BLOW_MIN_DAMAGE;
        } else {
            // If the special attack fails, perform a standard attack
            return super.attack();
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append("Warrior's Crushing Blow Chance: " + CRUSHING_BLOW_CHANCE + NEW_LINE);
        sb.append("Warrior's Minimum Crushing Blow Damage: " + CRUSHING_BLOW_MIN_DAMAGE + NEW_LINE);
        sb.append("Warrior's Maximum Crushing Blow Damage: " + CRUSHING_BLOW_MAX_DAMAGE + NEW_LINE);
        return sb.toString();
    }

    // Any other Warrior-specific methods can be added below
}

class Priestess extends Hero {

    // Constant for the heal range for Priestess. Adjust these values as per the range you desire.
    private static final int MIN_HEAL = 10;
    private static final int MAX_HEAL = 30;

    // Constructor
    public Priestess(String name) {
        // Calling the superclass constructor with the specified statistics
        super(name, 75, 75, 5, 0.7, 25, 45, 0.3);
    }

    public int standardAttack() {
        int damage = super.attack();  // Call the attack method from the DungeonCharacter class
        // Add any additional behavior here if necessary
        return damage;
    }

    // Special skill: heal
    @Override
    public int specialAttack() {
        double chance = Math.random();
        int healAmount = (int)(chance * (MAX_HEAL - MIN_HEAL + 1)) + MIN_HEAL;
        int newHealth = getCharacterHealthPoints() + healAmount;

        // Ensure we don't exceed max hit points
        setCharacterHealthPoints(Math.min(newHealth, 75));

        return healAmount; // This can be used to inform the user how much they healed by.
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append("Priestess's Healing Range: " + MIN_HEAL + " - " + MAX_HEAL + NEW_LINE);
        return sb.toString();
    }
}

class Thief extends Hero {

    // Constants specific to the Thief class
    private static final double CHANCE_SURPRISE_ATTACK = 0.4;
    private static final double CHANCE_CAUGHT = 0.2;
    // Remaining 40% is a normal attack, so no need for an explicit constant.

    // Constructor
    public Thief(String name) {
        super(name, 75, 75, 6, 0.8, 40, 20, 0.4);
    }

    @Override
    public int specialAttack() {
        double chance = Math.random();
        if (chance <= CHANCE_SURPRISE_ATTACK) {
            // Successful surprise attack
            int damageFirstAttack = attack();
            int damageSecondAttack = attack();
            return damageFirstAttack + damageSecondAttack; // total damage from both attacks
        } else if (chance <= CHANCE_SURPRISE_ATTACK + CHANCE_CAUGHT) {
            // Thief was caught, no attack rendered
            return 0;
        } else {
            // Normal attack logic
            return super.attack();
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append("Thief's Chance for Surprise Attack: " + CHANCE_SURPRISE_ATTACK + NEW_LINE);
        sb.append("Thief's Chance of Getting Caught: " + CHANCE_CAUGHT + NEW_LINE);
        return sb.toString();
    }
}

