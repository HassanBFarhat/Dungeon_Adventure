package models;

import java.io.Serial;
import java.io.Serializable;

/**
 *  A child class of the parent AbstractMonster, which holds the specific representation
 *  of an Ogre.
 *
 *  @author Hassan Bassam Farhat
 *  @author Avinash Bavisetty
 *  @version Summer 2023
 */
public class Ogre extends AbstractMonster implements Serializable {

    @Serial
    private static final long serialVersionUID = -3135985768945417554L;

    // instance fields
    /** Holds the image file path of the Ogre. */
    private static final String OGRE_IMG_BATTLE_FILE_PATH = "src/imgs/Ogre1.png";


    // constructor

    /**
     *  Calls on the super() of its parent class to set up the ogre as a monster character.
     *
     * @param theName the name of the ogre.
     * @param theHealth the health points of the ogre.
     * @param theHit the hit points of the ogre.
     * @param theAttack the attack speed of the ogre.
     * @param theChance the ogre's chance to hit.
     * @param theMaxDam the max damage the ogre can do.
     * @param theMinDam the min damage the ogre can do.
     */
    public Ogre(final String theName, final int theHealth, final int theHit,
                final int theAttack, final double theChance, final int theMaxDam,
                final int theMinDam) {
        super(theName, theHealth, theHit, theAttack, theChance, theMaxDam, theMinDam);
    }


    // methods

    /** Returns the ogre's specific file path. */
    @Override
    public String getMonsterBattleImgFilePath() {
        return OGRE_IMG_BATTLE_FILE_PATH;
    }

    /** Returns generic name for ogre to denote which monster it is. */
    @Override
    public String toString() {
        return "Ogre";
    }

}
