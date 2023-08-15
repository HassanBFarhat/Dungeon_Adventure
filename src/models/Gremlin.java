package models;

import java.io.Serial;
import java.io.Serializable;

/**
 *  A child class of the parent AbstractMonster, which holds the specific representation
 *  of a Gremlin.
 *
 *  @author Hassan Bassam Farhat
 *  @author Avinash Bavisetty
 *  @version Summer 2023
 */
public class Gremlin extends AbstractMonster implements Serializable {

    @Serial
    private static final long serialVersionUID = -5687175985038661820L;

    // instance fields
    /** Holds the image file path of the Gremlin. */
    private static final String GREMLIN_IMG_BATTLE_FILE_PATH = "src/imgs/Gremlin1.png";


    // constructor

    /**
     *  Calls on the super() of its parent class to set up the gremlin as a monster character.
     *
     * @param theName the name of the gremlin.
     * @param theHealth the health points of the gremlin.
     * @param theHit the hit points of the gremlin.
     * @param theAttack the attack speed of the gremlin.
     * @param theChance the gremlin's chance to hit.
     * @param theMaxDam the max damage the gremlin can do.
     * @param theMinDam the min damage the gremlin can do.
     */
    public Gremlin(final String theName, final int theHealth, final int theHit,
                   final int theAttack, final double theChance, final int theMaxDam,
                   final int theMinDam) {
        super(theName, theHealth, theHit, theAttack, theChance, theMaxDam, theMinDam);
    }


    // methods

    /** Returns the gremlin's specific file path. */
    @Override
    public String getMonsterBattleImgFilePath() {
        return GREMLIN_IMG_BATTLE_FILE_PATH;
    }

    /** Returns generic name for gremlin to denote which monster it is. */
    @Override
    public String toString() {
        return "Gremlin";
    }

}
