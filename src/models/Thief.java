package models;
class Thief extends Hero {
    private static final int HEALTH_POINTS = 75;
    private static final int HIT_POINTS = 75;
    private static final int ATTACK_SPEED = 6;
    private static final double CHANCE_TO_HIT = 0.8;
    private static final double CHANCE_TO_BLOCK = 0.4;
    private static final int MAX_DAMAGE = 40;
    private static final int MIN_DAMAGE = 20;

    // Constants specific to the models.Thief class
    private static final double CHANCE_SURPRISE_ATTACK = 0.4;
    private static final double CHANCE_CAUGHT = 0.2;
    // Remaining 40% is a normal attack, so no need for an explicit constant.

    // Constructor
    public Thief(String name) {
        super(name, HEALTH_POINTS, HIT_POINTS, ATTACK_SPEED, CHANCE_TO_HIT, MAX_DAMAGE, MIN_DAMAGE, CHANCE_TO_BLOCK);
        setChanceToBlock(CHANCE_TO_BLOCK);

    }
    @Override
    public int specialAttack() {
        double chance = Math.random();
        if (chance <= CHANCE_SURPRISE_ATTACK) {
            int totalDamage = 0;
            for (int i = 0; i < (1 + getHeroSpecialSkill()); i++) { // 1 is the base number of attacks, myHeroSpecialSkill adds more
                totalDamage += attack();
            }
            return totalDamage;
        } else if (chance <= CHANCE_SURPRISE_ATTACK + CHANCE_CAUGHT) {
            return 0;
        } else {
            return standardAttack();
        }
    }
}
