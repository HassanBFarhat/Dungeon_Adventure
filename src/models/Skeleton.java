package models;

import java.io.Serial;
import java.io.Serializable;

/**
 *
 * @author Hassan Bassam Farhat
 * @version Summer 2023
 */
public class Skeleton extends AbstractMonster implements Serializable {

    @Serial
    private static final long serialVersionUID = -5448755600554862879L;

    // instance fields
    /** . */
    private static final String SKELETON_IMG_BATTLE_FILE_PATH = "src/imgs/Skeleton1.png";


    // constructor

    public Skeleton(final String theName, final int theHealth, final int theHit,
                    final int theAttack, final double theChance, final int theMaxDam,
                    final int theMinDam) {
        super(theName, theHealth, theHit, theAttack, theChance, theMaxDam, theMinDam);
    }


    // methods

    /** . */
    @Override
    public String getMonsterBattleImgFilePath() {
        return SKELETON_IMG_BATTLE_FILE_PATH;
    }

    /** . */
    @Override
    public String toString() {
        return "Skeleton";
    }

}
