package models;
public class Thief extends Hero {
    private static final String THIEF_NAME = "Thief";
    private static final int HEALTH_POINTS = 75;
    private static final int HIT_POINTS = 75;
    private static final int ATTACK_SPEED = 6;
    private static final double CHANCE_TO_HIT = 0.8;
    private static final double CHANCE_TO_BLOCK = 0.4;
    private static final int MAX_DAMAGE = 40;
    private static final int MIN_DAMAGE = 20;
    private static final double SURPRISE_ATTACK_ODDS = 0.6;
    private static final double CHANCE_SURPRISE_ATTACK = 0.4;
    private static final double CHANCE_CAUGHT = 0.2;


    // Constructor

    public Thief() {
        super(THIEF_NAME, HEALTH_POINTS, HIT_POINTS, ATTACK_SPEED, CHANCE_TO_HIT, MAX_DAMAGE, MIN_DAMAGE);
        setChanceToBlock(CHANCE_TO_BLOCK);
        setHeroSpecialSkill("Surprise Attack");
    }
    @Override
    public void specialAttack() {
        double chanceForSurpriseAttackOdds = (int) (Math.random() * 100) / 100.0;
        if (chanceForSurpriseAttackOdds >= (1 - SURPRISE_ATTACK_ODDS)) {
            double chanceForSuccessfulSurpriseAttack = (int) (Math.random() * 60) / 100.0;
            if (chanceForSuccessfulSurpriseAttack >= (SURPRISE_ATTACK_ODDS - CHANCE_SURPRISE_ATTACK)) {
                System.out.println("Thief Attacks Twice!");
                this.standardAttack();
                this.standardAttack();
            } else {
                System.out.println("Thief got caught, no attacking this round.");
                // no damaging monster
            }
        } else {
            System.out.println("Special Attack attempt not successful, resorting to normal attack");
            this.standardAttack();
        }
    }
}
