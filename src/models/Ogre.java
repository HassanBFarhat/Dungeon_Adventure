package models;

import java.io.Serial;
import java.io.Serializable;

public class Ogre extends Monster implements Serializable {



    private static final String OGRE_IMG_BATTLE_FILE_PATH = "src/imgs/Ogre1.png";
    @Serial
    private static final long serialVersionUID = -3135985768945417554L;

//    private static final int HEALTH_POINTS = 200;
//    private static final int HIT_POINTS = 200;
//    private static final int ATTACK_SPEED = 2;
//    private static final double CHANCE_TO_HIT = 0.6;
//    private static final int MAX_DAMAGE = 60;
//    private static final int MIN_DAMAGE = 30;
//    private static final double MONSTER_CHANCE_TO_HEAL = 0.1;
//    private static final int MIN_HEAL_POINTS = 30;
//    private static final int MAX_HEAL_POINTS = 60;
//    private static final int MAX_DAMAGE_RANGE = 60;
//    private static final int MIN_DAMAGE_RANGE = 30;




    public Ogre(String theName, int theHealth, int theHit, int theAttack, double theChance, int theMaxDam, int theMinDam) {
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
        return OGRE_IMG_BATTLE_FILE_PATH;
    }


    @Override
    public String toString() {
        return "Ogre";
    }




}
