package views;

import models.Adventurer;
import models.DoorDirections;

import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.OverlayLayout;

public class GamePlayPanel extends JPanel {

    // constants

    /** . */
    private static final int MINIMUM_HEALTH_SIZE = 0;
    /** . */
//    private static final int MAXIMUM_HEALTH_SIZE = 100;
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
    private static final int SAVE_AND_INVENTORY_BUTTON_WIDTH = 100;
    /** . */
    private static final int SAVE_AND_INVENTORY_BUTTON_HEIGHT = 40;
    /** . */
    private static final int SAVE_BUTTON_X_COORDINATE = 145;
    /** . */
    private static final int INVENTORY_X_COORDINATE = 1035;
    /** . */
    private static final int SAVE_AND_INVENTORY_Y_COORDINATE = 620;

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
    /** . */
    private String myHeroMainImgPath;
    /** . */
    private Adventurer myAdventurer;
    private int[][] dungeon;
    private int myRow;
    private int myCol;
    // constructor

    /** . */
    public GamePlayPanel() {
        instantiateInstanceDataFields();
        setUpThisPanelsLayoutAndAddBGImg();
        setCharacterButtonsPreferredSize();
        addButtonsAndHeroImageToCharacterAndMovementPanel();
        setUpHeroHealthBar();

        // Set up the mini map (which now includes dungeon initialization and starting position)
        setUpMiniMapAndItsBounds();

        setUpSaveAndInventoryButtonBounds();
        addAllTheComponentsToGameBGLabel();

//        setUpHealthBarWithAdventurerHealthStats();
    }

    // methods
    public void addingPlayerChosenAdventurerImgToPanel() {
        final ImageIcon heroImg = new ImageIcon(getMainImgPath());
        myHeroJPGLabel = new JLabel(heroImg);
        myCharacterAndMovementOptions.add(myHeroJPGLabel, BorderLayout.CENTER);
    }

    public void setHeroMainImgFilePath(final String theMainImgFilePath) {
//        System.out.println(theMainImgFilePath);
        myHeroMainImgPath = theMainImgFilePath;
//        System.out.println(myHeroMainImgPath);
    }

    public String getMainImgPath() {
//        System.out.println(myHeroMainImgPath);
        return myHeroMainImgPath;
    }

    /** . */
    private void instantiateInstanceDataFields() {
//        final ImageIcon heroImg = new ImageIcon(getMainImgPath());
        final ImageIcon gamePlayBGImg = new ImageIcon("src/imgs/MainGameImg1.jpg");
        myMiniMap = new JPanel();
        myCharacterAndMovementOptions = new JPanel();
//        myHeroJPGLabel = new JLabel(heroImg);
        myGameBGLabel = new JLabel(gamePlayBGImg);
        myNorthBtn = new JButton("Move North");
        mySouthBtn = new JButton("Move South");
        myEastBtn = new JButton("Move East");
        myWestBtn = new JButton("Move West");
        myCharactersHealth = new JProgressBar();
        myInventoryBtn = new JButton("Inventory");
        mySaveGameBtn = new JButton("Save Game");


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
        mySouthBtn.setPreferredSize(new Dimension(CHARACTER_MOVEMENT_BTN_WIDTH,
                                    CHARACTER_MOVEMENT_BTN_HEIGHT));
        myEastBtn.setPreferredSize(new Dimension(CHARACTER_MOVEMENT_BTN_WIDTH,
                                    CHARACTER_MOVEMENT_BTN_HEIGHT));
        myWestBtn.setPreferredSize(new Dimension(CHARACTER_MOVEMENT_BTN_WIDTH,
                                    CHARACTER_MOVEMENT_BTN_HEIGHT));
    }

    /** . */
    private void addButtonsAndHeroImageToCharacterAndMovementPanel() {
        myCharacterAndMovementOptions.setLayout(new BorderLayout());

        // Set up action listeners for the movement buttons
        myNorthBtn.addActionListener(e -> moveNorth());
        mySouthBtn.addActionListener(e -> moveSouth());
        myEastBtn.addActionListener(e -> moveEast());
        myWestBtn.addActionListener(e -> moveWest());
//        myCharacterAndMovementOptions.add(myHeroJPGLabel, BorderLayout.CENTER);
        myCharacterAndMovementOptions.add(myNorthBtn, BorderLayout.NORTH);
        myCharacterAndMovementOptions.add(mySouthBtn, BorderLayout.SOUTH);
        myCharacterAndMovementOptions.add(myEastBtn, BorderLayout.EAST);
        myCharacterAndMovementOptions.add(myWestBtn, BorderLayout.WEST);
        myCharacterAndMovementOptions.setBounds(CHARACTER_PANEL_AND_HEALTH_BAR_X_COORDINATE,
                                                CHARACTER_PANEL_Y_COORDINATE,
                                                CHARACTER_PANEL_AND_HEALTH_BAR_WIDTH,
                                                CHARACTER_PANEL_HEIGHT);

    }

    public JButton getMyNorthBtn() {
        return myNorthBtn;
    }

    public JButton getMySouthBtn() {
        return mySouthBtn;
    }

    public JButton getMyEastBtn() {
        return myEastBtn;
    }

    public JButton getMyWestBtn() {
        return myWestBtn;
    }

    public JButton getMyInventoryBtn() {
        return myInventoryBtn;
    }

    public JButton getMySaveGameBtn() {
        return mySaveGameBtn;
    }


    /** . */
    private void setUpHeroHealthBar() {
        System.out.println("Trying to set up main health bar");
//        myCharactersHealth.setValue(myAdventurer.getCharacterHealthPoints());
        myCharactersHealth.setBounds(CHARACTER_PANEL_AND_HEALTH_BAR_X_COORDINATE,
                                     HEALTH_BAR_Y_COORDINATE,
                                     CHARACTER_PANEL_AND_HEALTH_BAR_WIDTH,
                                     HEALTH_BAR_HEIGHT);
        myCharactersHealth.setForeground(Color.RED);
        myCharactersHealth.setBackground(Color.GRAY);
        myCharactersHealth.setString("Health");
        myCharactersHealth.setStringPainted(true);
    }

    /** . */
    private void setUpMiniMapAndItsBounds() {
        // Initialize dungeon and set starting position
        dungeon = new int[5][5];
        myRow = 0;
        myCol = 0;
        dungeon[myRow][myCol] = 2;  // Assuming 2 represents the player's starting position

        myMiniMap.setBounds(MINI_MAP_X_COORDINATE, MINI_MAP_Y_COORDINATE,
                MINI_MAP_WIDTH, MINI_MAP_HEIGHT);
        myMiniMap.setBackground(Color.PINK);
        myMiniMap.setLayout(new GridLayout(dungeon.length, dungeon[0].length));

        for(int i = 0; i < dungeon.length; i++) {
            for(int j = 0; j < dungeon[i].length; j++) {
                JPanel cell = new JPanel();
                if(dungeon[i][j] == 2) {  // If it's the starting position
                    cell.setBackground(Color.RED); // Representing player's starting & current position
                } else {
                    cell.setBackground(Color.BLUE); // Default color or representation
                }
                myMiniMap.add(cell);
            }
        }
    }

    /** . */
    private void setUpSaveAndInventoryButtonBounds() {
        mySaveGameBtn.setBounds(SAVE_BUTTON_X_COORDINATE,
                                SAVE_AND_INVENTORY_Y_COORDINATE,
                                SAVE_AND_INVENTORY_BUTTON_WIDTH,
                                SAVE_AND_INVENTORY_BUTTON_HEIGHT);
        myInventoryBtn.setBounds(INVENTORY_X_COORDINATE,
                                 SAVE_AND_INVENTORY_Y_COORDINATE,
                                 SAVE_AND_INVENTORY_BUTTON_WIDTH,
                                 SAVE_AND_INVENTORY_BUTTON_HEIGHT);
    }

    /** . */
    private void addAllTheComponentsToGameBGLabel() {
        myGameBGLabel.add(myCharacterAndMovementOptions);
        myGameBGLabel.add(myCharactersHealth);
        myGameBGLabel.add(myMiniMap);
        myGameBGLabel.add(myInventoryBtn);
        myGameBGLabel.add(mySaveGameBtn);
    }

    public void setMyAdventurer(final Adventurer theAdventurer) {
        myAdventurer = theAdventurer;
        setUpHealthBarWithAdventurerHealthStats();
    }

    public void setUpHealthBarWithAdventurerHealthStats() {
        myCharactersHealth.setValue(myAdventurer.getCharacterHealthPoints());
    }
    public void moveAdventurer(int rowChange, int colChange) {
        // Ensure the move doesn't exceed dungeon boundaries
        if (myRow + rowChange >= 0 && myRow + rowChange < dungeon.length &&
                myCol + colChange >= 0 && myCol + colChange < dungeon[0].length) {

            // Mark the current cell as visited
            dungeon[myRow][myCol] = 1;

            // Adjust the adventurer's position
            myRow += rowChange;
            myCol += colChange;

            // Mark the new cell as current
            dungeon[myRow][myCol] = 2;

            // Update the visual mini-map
            updateMap();
        }
    }
    public void moveNorth() {
        moveAdventurer(-1, 0);
    }

    public void moveSouth() {
        moveAdventurer(1, 0);
    }

    public void moveEast() {
        moveAdventurer(0, 1);
    }

    public void moveWest() {
        moveAdventurer(0, -1);
    }

    public void updateMap() {
        // Remove old labels
        myMiniMap.removeAll();

        for (int row = 0; row < dungeon.length; row++) {
            for (int col = 0; col < dungeon[0].length; col++) {
                // Create a new label for the cell
                JLabel cellLabel = new JLabel();
                cellLabel.setOpaque(true);
                cellLabel.setPreferredSize(new Dimension(20, 20));

                // Set the label's color based on the dungeon cell's value
                switch (dungeon[row][col]) {
                    case 0:
                        cellLabel.setBackground(Color.BLUE);  // Unvisited room
                        break;
                    case 1:
                        cellLabel.setBackground(Color.GRAY);   // Visited room
                        break;
                    case 2:
                        cellLabel.setBackground(Color.RED);     // Current room
                        break;
                }

                // minimap panel
                myMiniMap.add(cellLabel);
            }
        }

        // minimap is updated
        myMiniMap.revalidate();
        myMiniMap.repaint();
    }
}
