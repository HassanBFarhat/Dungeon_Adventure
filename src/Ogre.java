class Ogre extends Monster {

    private static final int HEALTH_POINTS = 200;
    private static final int HIT_POINTS = 200;
    private static final int ATTACK_SPEED = 2;
    private static final double CHANCE_TO_HIT = 0.6;
    private static final int MAX_DAMAGE = 60;
    private static final int MIN_DAMAGE = 30;
    private static final double MONSTER_CHANCE_TO_HEAL = 0.1;
    private static final int MIN_HEAL_POINTS = 30;
    private static final int MAX_HEAL_POINTS = 60;
    private static final int MAX_DAMAGE_RANGE = 60;
    private static final int MIN_DAMAGE_RANGE = 30;

    public Ogre(String name) {
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
