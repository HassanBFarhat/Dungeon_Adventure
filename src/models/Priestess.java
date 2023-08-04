package models;
class Priestess extends Hero {
    private static final int HEALTH_POINTS = 75;
    private static final int HIT_POINTS = 75;
    private static final int ATTACK_SPEED = 5;
    private static final double CHANCE_TO_HIT = 0.7;
    private static final double CHANCE_TO_BLOCK = 0.3;
    private static final int MAX_DAMAGE = 45;
    private static final int MIN_DAMAGE = 25;

    // Constant for the heal range for models.Priestess. Adjust these values as per the range you desire.
    private static final int MIN_HEAL = 10;
    private static final int MAX_HEAL = 30;

    // Constructor
    public Priestess(String name) {
        // Calling the superclass constructor with the specified statistics
        super(name, HEALTH_POINTS, HIT_POINTS, ATTACK_SPEED, CHANCE_TO_HIT, MAX_DAMAGE, MIN_DAMAGE, CHANCE_TO_BLOCK);
        setChanceToBlock(CHANCE_TO_BLOCK);
    }

    // Special skill: heal
    @Override
    public int specialAttack() {
        double chance = Math.random();
        int modifiedMinHeal = MIN_HEAL + getHeroSpecialSkill();
        int healAmount = (int)(chance * (MAX_HEAL - modifiedMinHeal + 1)) + modifiedMinHeal;
        int newHealth = getCharacterHealthPoints() + healAmount;
        setCharacterHealthPoints(Math.min(newHealth, HEALTH_POINTS));
        return healAmount;
    }
}
