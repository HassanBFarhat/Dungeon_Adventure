package models;

class Gremlin extends Monster {

    private static final int HEALTH_POINTS = 70;
    private static final int HIT_POINTS = 70;
    private static final int ATTACK_SPEED = 5;
    private static final double CHANCE_TO_HIT = 0.8;
    private static final int MAX_DAMAGE = 30;
    private static final int MIN_DAMAGE = 15;
    private static final double MONSTER_CHANCE_TO_HEAL = 0.4;
    private static final int MIN_HEAL_POINTS = 20;
    private static final int MAX_HEAL_POINTS = 40;
    private static final int MAX_DAMAGE_RANGE = 50;
    private static final int MIN_DAMAGE_RANGE = 30;

    public Gremlin(String name) {

        super(name, HEALTH_POINTS, HIT_POINTS, ATTACK_SPEED, CHANCE_TO_HIT, MAX_DAMAGE, MIN_DAMAGE);

        setMonsterChanceToHeal(MONSTER_CHANCE_TO_HEAL);

        setMinimumHealPoints(MIN_HEAL_POINTS);
        setMaximumHealPoints(MAX_HEAL_POINTS);

        setMaximumDamageRange(MAX_DAMAGE_RANGE);
        setMinimumDamageRange(MIN_DAMAGE_RANGE);
    }

    public int attack() {
        return super.attack();
    }
}