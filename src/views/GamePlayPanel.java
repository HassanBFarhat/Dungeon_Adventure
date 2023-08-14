package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.OverlayLayout;
import models.Adventurer;

/**
 * @author Avinash Bavisetty
 * @author Hassan Bassam Farhat
 * @version Summer 2023
 */

/**
 *
 * @author Hassan Bassam Farhat
 * @version Summer 2023
 */
public class GamePlayPanel extends JPanel {

    // constants
    /** . */
    private static final int CHARACTER_MOVEMENT_BTN_WIDTH = 100;
    /** . */
    private static final int CHARACTER_MOVEMENT_BTN_HEIGHT = 100;
    /** . */
    private static final int CHARACTER_PANEL_AND_HEALTH_BAR_WIDTH = 500;
    /** . */
    private static final int CHARACTER_PANEL_HEIGHT = 500;
    /** . */
    private static final int CHARACTER_PANEL_AND_HEALTH_BAR_X_COORDINATE = 390;
    /** . */
    private static final int CHARACTER_PANEL_Y_COORDINATE = 110;
    /** . */
    private static final int HEALTH_BAR_Y_COORDINATE = 620;
    /** . */
    private static final int HEALTH_BAR_HEIGHT = 40;
    /** . */
    private static final int MINI_MAP_WIDTH = 200;
    /** . */
    private static final int MINI_MAP_HEIGHT = 200;
    /** . */
    private static final int MINI_MAP_X_COORDINATE = 30;
    /** . */
    private static final int MINI_MAP_Y_COORDINATE = 25;
    /** . */
    private static final int SAVE_AND_INVENTORY_BUTTON_WIDTH = 150;
    /** . */
    private static final int SAVE_AND_INVENTORY_BUTTON_HEIGHT = 40;
    /** . */
    private static final int SAVE_BUTTON_X_COORDINATE = 145;
    /** . */
    private static final int INVENTORY_X_COORDINATE = 985;
    /** . */
    private static final int SAVE_AND_INVENTORY_Y_COORDINATE = 620;
    /** . */
    private static final int MINI_MAP_MATRIX_SIZE = 5;
    /** . */
    private static final String FONT_LABEL = "Freestyle Script";
    /** . */
    private static final int FONT_SIZE = 45;
    /** . */
    private static final int HEALTH_BAR_SAVE_INVENTORY_FONT_SIZE = 30;



    // instance fields

    /** . */
    private JPanel myMiniMap;
    /** . */
    private JPanel myCharacterAndMovementOptions;
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
    /** . */
    private String myHeroMainImgPath;
    /** . */
    private JLabel myHeroImgLabel;
    /** . */
    private int[][] myDungeon;


    // constructor

    public GamePlayPanel() {
        instantiateInstanceDataFields();
        setUpThisPanelsLayoutAndAddBGImg();
        setCharacterButtonsPreferredSize();
        addButtonsAndHeroImageToCharacterAndMovementPanel();
        setUpHeroHealthBar();
        setUpSaveAndInventoryButtonBounds();
        addAllTheComponentsToGameBGLabel();
    }

    // methods

    /** . */
    public void addingPlayerChosenAdventurerImgToPanel() {
        final ImageIcon heroImg = new ImageIcon(getMainImgPath());
        final JLabel heroJPGLabel = new JLabel(heroImg);
        myHeroImgLabel = heroJPGLabel;
        myCharacterAndMovementOptions.add(heroJPGLabel, BorderLayout.CENTER);
    }

    /** . */
    public void setHeroMainImgFilePath(final String theMainImgFilePath) {
        myHeroMainImgPath = theMainImgFilePath;
    }

    /** . */
    public String getMainImgPath() {
        return myHeroMainImgPath;
    }

    /** . */
    public JButton getMyNorthBtn() {
        return myNorthBtn;
    }

    /** . */
    public JButton getMySouthBtn() {
        return mySouthBtn;
    }

    /** . */
    public JButton getMyEastBtn() {
        return myEastBtn;
    }

    /** . */
    public JButton getMyWestBtn() {
        return myWestBtn;
    }

    /** . */
    public JButton getMyInventoryBtn() {
        return myInventoryBtn;
    }

    /** . */
    public JButton getMySaveGameBtn() {
        return mySaveGameBtn;
    }

    /** . */
    public void updateMiniMap(final int theCurrentRow, final int theCurrentColumn) {
        myMiniMap.removeAll();
        myDungeon[theCurrentRow][theCurrentColumn] = 2;
        myMiniMap.setBounds(MINI_MAP_X_COORDINATE, MINI_MAP_Y_COORDINATE,
                MINI_MAP_WIDTH, MINI_MAP_HEIGHT);
        myMiniMap.setBackground(Color.PINK);
        myMiniMap.setLayout(new GridLayout(myDungeon.length, myDungeon[0].length));
        for (int i = 0; i < myDungeon.length; i++) {
            for (int j = 0; j < myDungeon[i].length; j++) {
                final JPanel cell = new JPanel();
                if (myDungeon[i][j] == 2) {
                    cell.setBackground(Color.RED);
                    myDungeon[i][j] = 0;
                } else {
                    cell.setBackground(Color.BLUE);
                }
                myMiniMap.add(cell);
            }
        }
        myMiniMap.revalidate();
        myMiniMap.repaint();
    }

    /** . */
    public void setMyAdventurer(final Adventurer theAdventurer) {
        setUpHealthBarWithAdventurerHealthStats(theAdventurer);
    }

    /** . */
    public void setUpHealthBarWithAdventurerHealthStats(final Adventurer theAdventurer) {
        myCharactersHealth.setMaximum(0);
        myCharactersHealth.setMaximum(theAdventurer.getCharacterHitPoints());
        myCharactersHealth.setValue(theAdventurer.getCharacterHealthPoints());
    }

    /** . */
    public void updateAdventurerHealthBar(final Adventurer theAdventurer) {
        myCharactersHealth.setValue(theAdventurer.getCharacterHealthPoints());
    }

    /** . */
    public JLabel getMyAdventurerImgLabel() {
        return myHeroImgLabel;
    }


    // private methods

    /** . */
    private void instantiateInstanceDataFields() {
        final ImageIcon gamePlayBGImg = new ImageIcon("src/imgs/MainGameImg1.jpg");
        myMiniMap = new JPanel();
        myCharacterAndMovementOptions = new JPanel();
        myGameBGLabel = new JLabel(gamePlayBGImg);
        myNorthBtn = new JButton("North");
        mySouthBtn = new JButton("South");
        myEastBtn = new JButton("East");
        myWestBtn = new JButton("West");
        myCharactersHealth = new JProgressBar();
        myInventoryBtn = new JButton("Inventory");
        mySaveGameBtn = new JButton("Save Game");
        myDungeon = new int[MINI_MAP_MATRIX_SIZE][MINI_MAP_MATRIX_SIZE];
    }

    /** . */
    private void setUpThisPanelsLayoutAndAddBGImg() {
        this.setLayout(new OverlayLayout(this));
        this.add(myGameBGLabel);
    }

    /** . */
    private void setCharacterButtonsPreferredSize() {
        myNorthBtn.setPreferredSize(new Dimension(CHARACTER_MOVEMENT_BTN_WIDTH,
                                                  CHARACTER_MOVEMENT_BTN_HEIGHT));
        myNorthBtn.setFont(new Font(FONT_LABEL, Font.BOLD, FONT_SIZE));
        mySouthBtn.setPreferredSize(new Dimension(CHARACTER_MOVEMENT_BTN_WIDTH,
                                                  CHARACTER_MOVEMENT_BTN_HEIGHT));
        mySouthBtn.setFont(new Font(FONT_LABEL, Font.BOLD, FONT_SIZE));
        myEastBtn.setPreferredSize(new Dimension(CHARACTER_MOVEMENT_BTN_WIDTH,
                                                 CHARACTER_MOVEMENT_BTN_HEIGHT));
        myEastBtn.setFont(new Font(FONT_LABEL, Font.BOLD, FONT_SIZE));
        myWestBtn.setPreferredSize(new Dimension(CHARACTER_MOVEMENT_BTN_WIDTH,
                                                 CHARACTER_MOVEMENT_BTN_HEIGHT));
        myWestBtn.setFont(new Font(FONT_LABEL, Font.BOLD, FONT_SIZE));
    }

    /** . */
    private void addButtonsAndHeroImageToCharacterAndMovementPanel() {
        myCharacterAndMovementOptions.setLayout(new BorderLayout());
        myCharacterAndMovementOptions.add(myNorthBtn, BorderLayout.NORTH);
        myCharacterAndMovementOptions.add(mySouthBtn, BorderLayout.SOUTH);
        myCharacterAndMovementOptions.add(myEastBtn, BorderLayout.EAST);
        myCharacterAndMovementOptions.add(myWestBtn, BorderLayout.WEST);
        myCharacterAndMovementOptions.setBounds(CHARACTER_PANEL_AND_HEALTH_BAR_X_COORDINATE,
                                                CHARACTER_PANEL_Y_COORDINATE,
                                                CHARACTER_PANEL_AND_HEALTH_BAR_WIDTH,
                                                CHARACTER_PANEL_HEIGHT);
    }

    /** . */
    private void setUpHeroHealthBar() {
        System.out.println("Trying to set up main health bar");
        myCharactersHealth.setBounds(CHARACTER_PANEL_AND_HEALTH_BAR_X_COORDINATE,
                                     HEALTH_BAR_Y_COORDINATE,
                                     CHARACTER_PANEL_AND_HEALTH_BAR_WIDTH,
                                     HEALTH_BAR_HEIGHT);
        myCharactersHealth.setFont(
                new Font(FONT_LABEL, Font.BOLD, HEALTH_BAR_SAVE_INVENTORY_FONT_SIZE));
        myCharactersHealth.setForeground(Color.RED);
        myCharactersHealth.setBackground(Color.GRAY);
        myCharactersHealth.setString("Health");
        myCharactersHealth.setStringPainted(true);
    }

    /** . */
    private void setUpSaveAndInventoryButtonBounds() {
        mySaveGameBtn.setBounds(SAVE_BUTTON_X_COORDINATE,
                                SAVE_AND_INVENTORY_Y_COORDINATE,
                                SAVE_AND_INVENTORY_BUTTON_WIDTH,
                                SAVE_AND_INVENTORY_BUTTON_HEIGHT);
        mySaveGameBtn.setFont(
                new Font(FONT_LABEL, Font.BOLD, HEALTH_BAR_SAVE_INVENTORY_FONT_SIZE));
        myInventoryBtn.setBounds(INVENTORY_X_COORDINATE,
                                 SAVE_AND_INVENTORY_Y_COORDINATE,
                                 SAVE_AND_INVENTORY_BUTTON_WIDTH,
                                 SAVE_AND_INVENTORY_BUTTON_HEIGHT);
        myInventoryBtn.setFont(
                new Font(FONT_LABEL, Font.BOLD, HEALTH_BAR_SAVE_INVENTORY_FONT_SIZE));
    }

    /** . */
    private void addAllTheComponentsToGameBGLabel() {
        myGameBGLabel.add(myCharacterAndMovementOptions);
        myGameBGLabel.add(myCharactersHealth);
        myGameBGLabel.add(myMiniMap);
        myGameBGLabel.add(myInventoryBtn);
        myGameBGLabel.add(mySaveGameBtn);
    }

}
