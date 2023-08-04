package models;
class Warrior extends Hero {
    private static final int HEALTH_POINTS = 125;
    private static final int HIT_POINTS = 125;
    private static final int ATTACK_SPEED = 4;
    private static final double CHANCE_TO_HIT = 0.8;
    private static final double CHANCE_TO_BLOCK = 0.2;
    private static final int MAX_DAMAGE = 60;
    private static final int MIN_DAMAGE = 35;

    private static final double CRUSHING_BLOW_CHANCE = 0.4; // 40%
    private static final int CRUSHING_BLOW_MIN_DAMAGE = 75;
    private static final int CRUSHING_BLOW_MAX_DAMAGE = 175;

    public Warrior(String name) {
        super(name, HEALTH_POINTS, HIT_POINTS, ATTACK_SPEED, CHANCE_TO_HIT, MAX_DAMAGE, MIN_DAMAGE, CHANCE_TO_BLOCK);
        setChanceToBlock(CHANCE_TO_BLOCK);

        // If there's any models.Warrior-specific attribute initialization, do it here
    }

    @Override
    public int specialAttack() {
        double chance = Math.random();
        if (chance <= CRUSHING_BLOW_CHANCE) {
            int modifiedMinDamage = CRUSHING_BLOW_MIN_DAMAGE + getHeroSpecialSkill();
            // If the Crushing Blow succeeds
            return (int)(chance * (CRUSHING_BLOW_MAX_DAMAGE - modifiedMinDamage + 1)) + modifiedMinDamage;
        } else {
            // If the special attack fails, perform a standard attack
            return standardAttack();
        }
    }
    // Any other models.Warrior-specific methods can be added below
}
