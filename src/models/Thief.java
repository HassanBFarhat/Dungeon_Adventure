package models;

import java.io.Serial;
import java.io.Serializable;

public class Thief extends Adventurer implements Serializable {


    private static final String THIEF_NAME = "Thief";
    private static final String THIEF_IMG_MAIN_FILE_PATH = "src/imgs/Thief_Main.png";
    private static final String THIEF_IMG_BATTLE_FILE_PATH = "src/imgs/Thief_Battle.png";
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

    @Serial
    private static final long serialVersionUID = 8850439520184187280L;


    // Constructor

    public Thief() {
        super(THIEF_NAME, HEALTH_POINTS, HIT_POINTS, MIN_DAMAGE, MAX_DAMAGE, ATTACK_SPEED, CHANCE_TO_HIT);
        setChanceToBlock(CHANCE_TO_BLOCK);
        setHeroSpecialSkill("Surprise Attack");
    }

    @Override
    public String getAdventurerMainImgFilePath() {
        return THIEF_IMG_MAIN_FILE_PATH;
    }

    @Override
    public String getAdventurerBattleImgFilePath() {
        return THIEF_IMG_BATTLE_FILE_PATH;
    }




    @Override
    public int specialAttack() {
        final double chanceForSurpriseAttackOdds = (int) (Math.random() * 100) / 100.0;
        if (chanceForSurpriseAttackOdds >= (1 - CHANCE_CAUGHT)) {
            System.out.println("Thief Caught. No attack.");
        } else if (chanceForSurpriseAttackOdds >= (1 - SURPRISE_ATTACK_ODDS)) {
            System.out.println("Thief Attacks Twice!");
            this.standardAttack();
            this.standardAttack();
        } else {
            System.out.println("Special Attack attempt not successful, resorting to normal attack");
            this.standardAttack();
        }
        return 0;
    }
}
