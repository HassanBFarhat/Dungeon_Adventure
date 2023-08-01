package views;

import javax.swing.*;
import java.awt.*;

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
    private JLabel myGameBGLabel;
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
        setUpThisPanelsLayoutAndAddBGImg();

        myNorthBtn.setPreferredSize(new Dimension(100, 100));
        mySouthBtn.setPreferredSize(new Dimension(100, 100));
        myEastBtn.setPreferredSize(new Dimension(100, 100));
        myWestBtn.setPreferredSize(new Dimension(100, 100));

        myCharacterAndMovementOptions.setLayout(new BorderLayout());
        myCharacterAndMovementOptions.add(myHeroJPGLabel, BorderLayout.CENTER);
        myCharacterAndMovementOptions.add(myNorthBtn, BorderLayout.NORTH);
        myCharacterAndMovementOptions.add(mySouthBtn, BorderLayout.SOUTH);
        myCharacterAndMovementOptions.add(myEastBtn, BorderLayout.EAST);
        myCharacterAndMovementOptions.add(myWestBtn, BorderLayout.WEST);
        myCharacterAndMovementOptions.setBounds(390,110,500,500);


        myCharactersHealth.setValue(100);
        myCharactersHealth.setBounds(390, 620, 500, 40);
        myCharactersHealth.setForeground(Color.RED);
        myCharactersHealth.setBackground(Color.GRAY);
        myCharactersHealth.setString("Health");
        myCharactersHealth.setStringPainted(true);


        myMiniMap.setBounds(30,25,200,200);
        myMiniMap.setBackground(Color.PINK);

        mySaveGameBtn.setBounds(145, 620, 100,40);
        myInventoryBtn.setBounds(1035, 620, 100,40);

        myGameBGLabel.add(myCharacterAndMovementOptions);
        myGameBGLabel.add(myCharactersHealth);
        myGameBGLabel.add(myMiniMap);
        myGameBGLabel.add(myInventoryBtn);
        myGameBGLabel.add(mySaveGameBtn);


    }


    // methods

    /** . */
    private void instantiateInstanceDataFields() {
        final ImageIcon heroImg = new ImageIcon("src/imgs/TEST_HERO_SPRITE2.jpg");
        final ImageIcon gamePlayBGImg = new ImageIcon("src/imgs/MainGameImg1.jpg");
        myMiniMap = new JPanel();
        myCharacterAndMovementOptions = new JPanel();
        myHeroJPGLabel = new JLabel(heroImg);
        myGameBGLabel = new JLabel(gamePlayBGImg);
        myNorthBtn = new JButton("Move North");
        mySouthBtn = new JButton("Move South");
        myEastBtn = new JButton("Move East");
        myWestBtn = new JButton("Move West");
        myCharactersHealth = new JProgressBar(0, 100);
        myInventoryBtn = new JButton("Inventory");
        mySaveGameBtn = new JButton("Save Game");
    }

    /** . */
    private void setUpThisPanelsLayoutAndAddBGImg() {
        this.setLayout(new OverlayLayout(this));
        this.add(myGameBGLabel);
    }

    private void addComponentsToCharacterAndMovementPanel() {

    }

}
