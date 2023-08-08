package models;
public class Warrior extends Adventurer {
    private static final String WARRIOR_NAME = "Warrior";
    private static final String WARRIOR_IMG_MAIN_FILE_PATH = "src/imgs/Warrior_Main.png";
    private static final String WARRIOR_IMG_BATTLE_FILE_PATH = "src/imgs/Warrior_Battle.png";
    private static final int HEALTH_POINTS = 125;
    private static final int HIT_POINTS = 125;
    private static final int ATTACK_SPEED = 4;
    private static final double CHANCE_TO_HIT = 0.8;
    private static final double CHANCE_TO_BLOCK = 0.2;
    private static final int MAX_DAMAGE = 60;
    private static final int MIN_DAMAGE = 35;

    private static final double CRUSHING_BLOW_CHANCE = 0.4;
    private static final int CRUSHING_BLOW_MIN_DAMAGE = 75;
    private static final int CRUSHING_BLOW_MAX_DAMAGE = 175;

    public Warrior() {
        super(WARRIOR_NAME, HEALTH_POINTS, HIT_POINTS, MIN_DAMAGE, MAX_DAMAGE, ATTACK_SPEED, CHANCE_TO_HIT);
        setChanceToBlock(CHANCE_TO_BLOCK);
        setHeroSpecialSkill("Crushing Blow");
    }

    @Override
    public String getAdventurerMainImgFilePath() {
        return WARRIOR_IMG_MAIN_FILE_PATH;
    }

    @Override
    public String getAdventurerBattleImgFilePath() {
        return WARRIOR_IMG_BATTLE_FILE_PATH;
    }




    @Override
    public void specialAttack() {
        double chanceForCrushingBlow = (int) (Math.random() * 100) / 100.0;
        if (chanceForCrushingBlow >= (1 - CRUSHING_BLOW_CHANCE)) {
            double chanceForMaxCrush = (int) (Math.random() * 100) / 100.0;
            if (chanceForMaxCrush >= 0.8) {
                System.out.println("MAX crushing active");
                //do max crush to monsters health
            } else {
                System.out.println("MIN crushing active");
                //do min crush to monsters health
            }
        } else {
            System.out.println("Chance for crushing blow failed, normal attack commence.");
            this.standardAttack();
        }
    }

}
