package models;

import java.io.Serial;
import java.io.Serializable;

/**
 *
 * @author Hassan Bassam Farhat
 * @author Avinash Bavisetty
 * @version Summer 2023
 */
public class Ogre extends AbstractMonster implements Serializable {

    @Serial
    private static final long serialVersionUID = -3135985768945417554L;

    // instance fields
    /** . */
    private static final String OGRE_IMG_BATTLE_FILE_PATH = "src/imgs/Ogre1.png";


    // constructor

    protected Ogre() {
    }

    public Ogre(final String theName, final int theHealth, final int theHit,
                final int theAttack, final double theChance, final int theMaxDam,
                final int theMinDam) {
        super(theName, theHealth, theHit, theAttack, theChance, theMaxDam, theMinDam);
    }


    // methods

    /** . */
    @Override
    public String getMonsterBattleImgFilePath() {
        return OGRE_IMG_BATTLE_FILE_PATH;
    }

    /** . */
    @Override
    public String toString() {
        return "Ogre";
    }

}
