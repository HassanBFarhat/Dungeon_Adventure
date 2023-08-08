package models;
public class Priestess extends Adventurer {
    private static final String PRIESTESS_NAME = "Priestess";
    private static final String PRIESTESS_IMG_MAIN_FILE_PATH = "src/imgs/Priestess_Main.png";
    private static final String PRIESTESS_IMG_BATTLE_FILE_PATH = "src/imgs/Priestess_Battle.png";
    private static final int HEALTH_POINTS = 75;
    private static final int HIT_POINTS = 75;
    private static final int ATTACK_SPEED = 5;
    private static final double CHANCE_TO_HIT = 0.7;
    private static final double CHANCE_TO_BLOCK = 0.3;
    private static final int MAX_DAMAGE = 45;
    private static final int MIN_DAMAGE = 25;
    private static final int MIN_HEAL = 10;
    private static final int MAX_HEAL = 30;

    // Constructor
    public Priestess() {
        super(PRIESTESS_NAME, HEALTH_POINTS, HIT_POINTS, MIN_DAMAGE, MAX_DAMAGE, ATTACK_SPEED, CHANCE_TO_HIT);
        setChanceToBlock(CHANCE_TO_BLOCK);
        setHeroSpecialSkill("Heal");
    }

    @Override
    public String getAdventurerMainImgFilePath() {
        return PRIESTESS_IMG_MAIN_FILE_PATH;
    }

    @Override
    public String getAdventurerBattleImgFilePath() {
        return PRIESTESS_IMG_BATTLE_FILE_PATH;
    }


    // Special skill: heal
    @Override
    public void specialAttack() {
        double chanceForHeal = (int) (Math.random() * 100) / 100.0;
        if (chanceForHeal >= 0.6) {
            this.setCharacterHealthPoints(this.getCharacterHealthPoints() + MAX_HEAL);
        } else {
            this.setCharacterHealthPoints(this.getCharacterHealthPoints() + MIN_HEAL);
        }
    }
}
