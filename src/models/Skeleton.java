package models;

import java.io.Serial;
import java.io.Serializable;

public class Skeleton extends Monster implements Serializable {



    private static final String SKELETON_IMG_BATTLE_FILE_PATH = "src/imgs/Skeleton1.png";

    @Serial
    private static final long serialVersionUID = -5448755600554862879L;

//    private static final int HEALTH_POINTS = 100;
//    private static final int HIT_POINTS = 100;
//    private static final int ATTACK_SPEED = 3;
//    private static final double CHANCE_TO_HIT = 0.8;
//    private static final int MAX_DAMAGE = 50;
//    private static final int MIN_DAMAGE = 30;
//    private static final double MONSTER_CHANCE_TO_HEAL = 0.3;
//    private static final int MIN_HEAL_POINTS = 30;
//    private static final int MAX_HEAL_POINTS = 50;
//    private static final int MAX_DAMAGE_RANGE = 30;
//    private static final int MIN_DAMAGE_RANGE = 15;

    public Skeleton(String theName, int theHealth, int theHit, int theAttack, double theChance, int theMaxDam, int theMinDam) {
        super(theName, theHealth, theHit, theAttack, theChance, theMaxDam, theMinDam);

//        setMonsterChanceToHeal(MONSTER_CHANCE_TO_HEAL);
//
//        setMinimumHealPoints(MIN_HEAL_POINTS);
//        setMaximumHealPoints(MAX_HEAL_POINTS);
//
//        setMaximumDamageRange(MAX_DAMAGE_RANGE);
//        setMinimumDamageRange(MIN_DAMAGE_RANGE);
    }

    public int attack() {
        return super.attack();
    }


    @Override
    public String getMonsterBattleImgFilePath() {
        return SKELETON_IMG_BATTLE_FILE_PATH;
    }

    @Override
    public String toString() {
        return "Skeleton";
    }
}