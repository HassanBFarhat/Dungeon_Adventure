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
    /** character movement button width. */
    private static final int CHARACTER_MOVEMENT_BTN_WIDTH = 100;
    /** character movement button height. */
    private static final int CHARACTER_MOVEMENT_BTN_HEIGHT = 100;
    /** character panel and health bar width. */
    private static final int CHARACTER_PANEL_AND_HEALTH_BAR_WIDTH = 500;
    /** character panel height. */
    private static final int CHARACTER_PANEL_HEIGHT = 500;
    /** character panel and health bar x coordinate. */
    private static final int CHARACTER_PANEL_AND_HEALTH_BAR_X_COORDINATE = 390;
    /** character panel y coordinate. */
    private static final int CHARACTER_PANEL_Y_COORDINATE = 110;
    /** health bar y coordinate. */
    private static final int HEALTH_BAR_Y_COORDINATE = 620;
    /** health bar height. */
    private static final int HEALTH_BAR_HEIGHT = 40;
    /** mini map width. */
    private static final int MINI_MAP_WIDTH = 200;
    /** mini map height. */
    private static final int MINI_MAP_HEIGHT = 200;
    /** mini map x coordinate. */
    private static final int MINI_MAP_X_COORDINATE = 30;
    /** mini map y coordinate. */
    private static final int MINI_MAP_Y_COORDINATE = 25;
    /** save and inventory button width. */
    private static final int SAVE_AND_INVENTORY_BUTTON_WIDTH = 150;
    /** save and inventory button height. */
    private static final int SAVE_AND_INVENTORY_BUTTON_HEIGHT = 40;
    /** save button x coordinate. */
    private static final int SAVE_BUTTON_X_COORDINATE = 145;
    /** inventory x coordinate. */
    private static final int INVENTORY_X_COORDINATE = 985;
    /** save and inventory y coorindate. */
    private static final int SAVE_AND_INVENTORY_Y_COORDINATE = 620;
    /** mini map matrix size. */
    private static final int MINI_MAP_MATRIX_SIZE = 5;
    /** Font Style. */
    private static final String FONT_LABEL = "Freestyle Script";
    /** Font size. */
    private static final int FONT_SIZE = 45;
    /** Health bar save inventory font size. */
    private static final int HEALTH_BAR_SAVE_INVENTORY_FONT_SIZE = 30;



    // instance fields

    /** mini map. */
    private JPanel myMiniMap;
    /** character movement options. */
    private JPanel myCharacterAndMovementOptions;
    /** game label. */
    private JLabel myGameBGLabel;
    /** north button. */
    private JButton myNorthBtn;
    /** south button. */
    private JButton mySouthBtn;
    /** east button. */
    private JButton myEastBtn;
    /** west button. */
    private JButton myWestBtn;
    /** character's health. */
    private JProgressBar myCharactersHealth;
    /** inventory button. */
    private JButton myInventoryBtn;
    /** save game button. */
    private JButton mySaveGameBtn;
    /** hero main image path. */
    private String myHeroMainImgPath;
    /** hero image label. */
    private JLabel myHeroImgLabel;
    /** dungeon. */
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

    /** sets hero main image file path. */
    public void setHeroMainImgFilePath(final String theMainImgFilePath) {
        myHeroMainImgPath = theMainImgFilePath;
    }

    /** gets main image path of hero. */
    public String getMainImgPath() {
        return myHeroMainImgPath;
    }

    /** gets north button. */
    public JButton getMyNorthBtn() {
        return myNorthBtn;
    }

    /** gets south button. */
    public JButton getMySouthBtn() {
        return mySouthBtn;
    }

    /** gets East button. */
    public JButton getMyEastBtn() {
        return myEastBtn;
    }

    /** gets West button. */
    public JButton getMyWestBtn() {
        return myWestBtn;
    }

    /** gets inventory button. */
    public JButton getMyInventoryBtn() {
        return myInventoryBtn;
    }

    /** gets save game button. */
    public JButton getMySaveGameBtn() {
        return mySaveGameBtn;
    }

    /** updates mini map depending on the location of the player in the dungeon. */
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

    /** sets adventurer. */
    public void setMyAdventurer(final Adventurer theAdventurer) {
        setUpHealthBarWithAdventurerHealthStats(theAdventurer);
    }

    /** sets up health bar with adventurer health stats. */
    public void setUpHealthBarWithAdventurerHealthStats(final Adventurer theAdventurer) {
        myCharactersHealth.setMaximum(0);
        myCharactersHealth.setMaximum(theAdventurer.getCharacterHitPoints());
        myCharactersHealth.setValue(theAdventurer.getCharacterHealthPoints());
    }

    /** updates adventurer health bar whenever a course of action takes place. */
    public void updateAdventurerHealthBar(final Adventurer theAdventurer) {
        myCharactersHealth.setValue(theAdventurer.getCharacterHealthPoints());
    }

    /** gest adventurer image label. */
    public JLabel getMyAdventurerImgLabel() {
        return myHeroImgLabel;
    }


    // private methods

    /** instantiating data fields for GamePlayPanel that provides gameplay options and control. */
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

    /** sets the panel layout and adds background image. */
    private void setUpThisPanelsLayoutAndAddBGImg() {
        this.setLayout(new OverlayLayout(this));
        this.add(myGameBGLabel);
    }

    /** sets the character buttons preferrerd size. */
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

    /** adds buttons and hero iamge to character and movement panel. */
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

    /** sets the hero health bar up. */
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

    /** sets up save and inventory button bounds in the panel. */
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

    /** adds all the components to game. */
    private void addAllTheComponentsToGameBGLabel() {
        myGameBGLabel.add(myCharacterAndMovementOptions);
        myGameBGLabel.add(myCharactersHealth);
        myGameBGLabel.add(myMiniMap);
        myGameBGLabel.add(myInventoryBtn);
        myGameBGLabel.add(mySaveGameBtn);
    }

}
