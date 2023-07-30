package views;

import javax.swing.*;

public class GamePlayPanel extends JPanel {

    // constants



    // instance fields

    /** . */
    private JPanel myMiniMap;
    /** . */
    private JPanel myCharacterAndMovementOptions;
    /** . */
    private JLabel myHeroJPGLabel;
    /** . */
    private JButton myNorthBtn;
    /** . */
    private JButton mySouthBtn;
    /** . */
    private JButton myEastBtn;
    /** . */
    private JButton myWestBtn;
    /** . */
    private JProgressBar myCharactersHealth;
    /** . */
    private JButton myInventoryBtn;
    /** . */
    private JButton mySaveGameBtn;


    // constructor

    /** . */
    public GamePlayPanel() {
        instantiateInstanceDataFields();
    }


    // methods

    /** . */
    private void instantiateInstanceDataFields() {
        final ImageIcon heroImg = new ImageIcon("src/imgs/MainMenuBG_Image.jpg");
        myMiniMap = new JPanel();
        myCharacterAndMovementOptions = new JPanel();
        myHeroJPGLabel = new JLabel(heroImg);
        myNorthBtn = new JButton("Move North");
        mySouthBtn = new JButton("Move South");
        myEastBtn = new JButton("Move East");
        myWestBtn = new JButton("Move West");
        myCharactersHealth = new JProgressBar();
        myInventoryBtn = new JButton("Inventory");
        mySaveGameBtn = new JButton("Save Game");
    }

    private void addComponentsToCharacterAndMovementPanel() {

    }

}
