package models;

import java.io.Serial;
import java.io.Serializable;

/**
 *  A child class of the parent AbstractMonster, which holds the specific representation
 *  of a Skeleton.
 *
 *  @author Hassan Bassam Farhat
 *  @author Avinash Bavisetty
 *  @version Summer 2023
 */
public class Skeleton extends AbstractMonster implements Serializable {

    @Serial
    private static final long serialVersionUID = -5448755600554862879L;

    // instance fields
    /** Holds the image file path of the Skeleton. */
    private static final String SKELETON_IMG_BATTLE_FILE_PATH = "src/imgs/Skeleton1.png";


    // constructor

    /**
     *  Calls on the super() of its parent class to set up the skeleton as a monster character.
     *
     * @param theName the name of the skeleton.
     * @param theHealth the health points of the skeleton.
     * @param theHit the hit points of the skeleton.
     * @param theAttack the attack speed of the skeleton.
     * @param theChance the skeleton's chance to hit.
     * @param theMaxDam the max damage the skeleton can do.
     * @param theMinDam the min damage the skeleton can do.
     */
    public Skeleton(final String theName, final int theHealth, final int theHit,
                    final int theAttack, final double theChance, final int theMaxDam,
                    final int theMinDam) {
        super(theName, theHealth, theHit, theAttack, theChance, theMaxDam, theMinDam);
    }


    // methods

    /** Returns the skeleton's specific file path. */
    @Override
    public String getMonsterBattleImgFilePath() {
        return SKELETON_IMG_BATTLE_FILE_PATH;
    }

    /** Returns generic name for skeleton to denote which monster it is. */
    @Override
    public String toString() {
        return "Skeleton";
    }

}
