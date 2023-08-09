package views;

import models.*;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.*;

public class MainFrame extends JFrame {

    // constants

    /** . */
    private static final String MAIN_MENU_PANEL = "controller.Main";
    /** . */
    private static final String NEW_GAME_PANEL = "NewGame";
    /** . */
    private static final String OPTIONS_PANEL = "Option";
    /** . */
    private static final String GAME_INFO_PANEL = "GameInfo";
    /** . */
    private static final String GAME_HELP_PANEL = "GameHelp";
    /** . */
    private static final String GAME_PLAY_PANEL = "GamePlay";
    /** . */
    private static final String BATTLE_PANEL = "BattleField";
    private static final int FRAME_WIDTH = 1280;
    /** . */
    private static final int FRAME_HEIGHT = 720;

    // instance fields

    /** . */
    private JPanel myCardPanel;
    /** . */
    private MainMenuPanel myMainMenuPanel;
    /** . */
    private CharacterSelectionPanel myCharacterSelectionPanel;
    /** . */
    private OptionsPanel myOptionsPanel;
    /** . */
    private GameInformationPanel myGameInformationPanel;
    /** . */
    private GameHelpPanel myGameHelpPanel;
    /** . */
    private GamePlayPanel myGamePlayPanel;
    /** . */
    private BattlePanel myBattlePanel;
    /** . */
    private Adventurer myAdventurer;
    /** . */
    private Dungeon myDungeon;
    /** . */
    private int myCurrentRoomRow;
    /** . */
    private int myCurrentRoomColumn;
    /** . */
    private Room myCurrentRoom;

    // constructor

    public MainFrame() {
        instantiateInstanceDataFields();
        setUpFramePanels();
        setUpMainFrame();
        setUpPanelButtons();
        createMainGameMaze();
    }


    // methods

    /** . */
    private void instantiateInstanceDataFields() {
        myCardPanel = new JPanel(new CardLayout());
        myMainMenuPanel = new MainMenuPanel();
        myCharacterSelectionPanel = new CharacterSelectionPanel();
        myOptionsPanel = new OptionsPanel();
        myGameInformationPanel = new GameInformationPanel();
        myGameHelpPanel = new GameHelpPanel();
        myGamePlayPanel = new GamePlayPanel();
        myBattlePanel = new BattlePanel();
        myDungeon = new Dungeon();
        myCurrentRoomRow = 0;
        myCurrentRoomColumn = 0;
        myCurrentRoom = new Room();
    }

    /** . */
    private void createMainGameMaze() {
        myDungeon.randomlyGenerateRooms();
    }


    /** . */
    private void setUpFramePanels() {
        myCardPanel.add(myMainMenuPanel, MAIN_MENU_PANEL);
        myCardPanel.add(myCharacterSelectionPanel, NEW_GAME_PANEL);
        myCardPanel.add(myOptionsPanel, OPTIONS_PANEL);
        myCardPanel.add(myGameInformationPanel, GAME_INFO_PANEL);
        myCardPanel.add(myGameHelpPanel, GAME_HELP_PANEL);
        myCardPanel.add(myGamePlayPanel, GAME_PLAY_PANEL);
        myCardPanel.add(myBattlePanel, BATTLE_PANEL);
    }

    /** . */
    private void setUpMainFrame() {
        this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        this.setTitle("Dungeon Adventure");
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        final int centerX = (screenSize.width - this.getWidth()) / 2;
        final int centerY = (screenSize.height - this.getHeight()) / 2;
        // Set the frame to the center of the monitor
        this.setLocation(centerX, centerY);

        this.add(myCardPanel);
        this.pack();
        this.setVisible(true);
    }

    /** . */
    private void setUpPanelButtons() {
        myMainMenuPanel.getStartNewGameBtn().addActionListener(
                theAction -> changeScreen(NEW_GAME_PANEL));

        myMainMenuPanel.getLoadGameBtn().addActionListener(
                theAction -> System.out.println("LOADING"));

        myMainMenuPanel.getOptionsBtn().addActionListener(
                theAction -> changeScreen(OPTIONS_PANEL));

        myMainMenuPanel.getExitBtn().addActionListener(
                theAction -> System.exit(0));

        myCharacterSelectionPanel.getMyBackBtn().addActionListener(
                theAction -> changeScreen(MAIN_MENU_PANEL));

        myCharacterSelectionPanel.getMyStartGameBtnBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent theEvent) {
                if (myCharacterSelectionPanel.getCharactersName().isEmpty()) {
                    JOptionPane.showMessageDialog(myMainMenuPanel, "CANNOT START WITHOUT PUTTING A NAME!");
                } else {
                    if (myCharacterSelectionPanel.getHeroOptionFromBox().equals("Warrior")) {
                        myAdventurer = new Warrior();
                    } else if (myCharacterSelectionPanel.getHeroOptionFromBox().equals("Priestess")) {
                        myAdventurer = new Priestess();
                    } else if (myCharacterSelectionPanel.getHeroOptionFromBox().equals("Thief")) {
                        myAdventurer = new Thief();
                    }

                    for (int j = 0; j < myDungeon.getMazeSize(); j++) {
                        if (myDungeon.getMyMazeRoom()[0][j].hasEntrance()) {
                            myCurrentRoomRow = 0;
                            myCurrentRoomColumn = j;

                            myCurrentRoom = myDungeon.getMyMazeRoom()[myCurrentRoomRow][myCurrentRoomColumn];
                        }
                    }

                    checkToSeeIfDoorsArePassable(myCurrentRoomRow, myCurrentRoomColumn);

                    /*
                        We also need to implement when this btn is pressed, we need to use myDungeon.getMaze()
                        and check the first row to see where the entrance is; afterwards, we must place our
                        Adventurer at that location to start. ADD HERE.

                        Also want to check here the types of doors available for the user in the current
                        cell of the matrix.
                     */

                    myGamePlayPanel.setHeroMainImgFilePath(myAdventurer.getAdventurerMainImgFilePath());
                    myGamePlayPanel.addingPlayerChosenAdventurerImgToPanel();
                    changeScreen(GAME_PLAY_PANEL);
//                    changeScreen(BATTLE_PANEL);

                }
            }
        });

        myOptionsPanel.getMyBackBtn().addActionListener(
                theAction -> changeScreen(MAIN_MENU_PANEL));

        myOptionsPanel.getMyGeneralInfoBtn().addActionListener(
                theAction -> changeScreen(GAME_INFO_PANEL));

        myOptionsPanel.getMyGameHelpBtn().addActionListener(
                theAction -> changeScreen(GAME_HELP_PANEL));

        myGameInformationPanel.getMyBackBtn().addActionListener(
                theAction -> changeScreen(OPTIONS_PANEL));

        myGameHelpPanel.getMyBackBtn().addActionListener(
                theAction -> changeScreen(OPTIONS_PANEL));

        myGamePlayPanel.getMyNorthBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent theEvent) {
                myCurrentRoomRow -= 1;
                myCurrentRoom = myDungeon.getMyMazeRoom()[myCurrentRoomRow][myCurrentRoomColumn];
                checkToSeeIfDoorsArePassable(myCurrentRoomRow, myCurrentRoomColumn);
                checkRoomForGroundItemsAndPit();
                checkRoomForMonster();
            }
        });

        myGamePlayPanel.getMySouthBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent theEvent) {
                myCurrentRoomRow += 1;
                myCurrentRoom = myDungeon.getMyMazeRoom()[myCurrentRoomRow][myCurrentRoomColumn];
                checkToSeeIfDoorsArePassable(myCurrentRoomRow, myCurrentRoomColumn);
                checkRoomForGroundItemsAndPit();
                checkRoomForMonster();
            }
        });

        myGamePlayPanel.getMyEastBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent theEvent) {
                myCurrentRoomColumn += 1;
                myCurrentRoom = myDungeon.getMyMazeRoom()[myCurrentRoomRow][myCurrentRoomColumn];
                checkToSeeIfDoorsArePassable(myCurrentRoomRow, myCurrentRoomColumn);
                checkRoomForGroundItemsAndPit();
                checkRoomForMonster();
            }
        });

        myGamePlayPanel.getMyWestBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent theEvent) {
                myCurrentRoomColumn -= 1;
                myCurrentRoom = myDungeon.getMyMazeRoom()[myCurrentRoomRow][myCurrentRoomColumn];
                checkToSeeIfDoorsArePassable(myCurrentRoomRow, myCurrentRoomColumn);
                checkRoomForGroundItemsAndPit();
                checkRoomForMonster();
            }
        });

        myGamePlayPanel.getMyInventoryBtn().addActionListener(
                theAction -> System.out.println("Inventory check"));

        myGamePlayPanel.getMySaveGameBtn().addActionListener(
                theAction -> System.out.println("SAVING"));


        myBattlePanel.getMyAttackBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent theEvent) {
                System.out.println("You attacked the monster");
                final Monster roomMonster = myCurrentRoom.getRoomMonster();
                roomMonster.setCharacterHealthPoints(roomMonster.getCharacterHealthPoints() - myAdventurer.attack());
                checkIfMonsterHealthIsZero();
                checkIfAdventurerHealthIsZero();
            }
        });

        myBattlePanel.getMySpecialAttackBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent theEvent) {
                System.out.println("You used Special Attack");
                final Monster roomMonster = myCurrentRoom.getRoomMonster();
                roomMonster.setCharacterHealthPoints(roomMonster.getCharacterHealthPoints() - myAdventurer.specialAttack());
                checkIfMonsterHealthIsZero();
                checkIfAdventurerHealthIsZero();
            }
        });

        myBattlePanel.getMyHealBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent theEvent) {
                final Random random = new Random();
                final int randomHealAmount = random.nextInt(15 - 5 + 1) + 5;
                if (myAdventurer.getMyHealingPotions() > 0) {
                    myAdventurer.setCharacterHealthPoints(myAdventurer.getCharacterHealthPoints() + randomHealAmount);
                } else {
                    System.out.println("No potions to use for healing.");
                }
            }
        });

        myBattlePanel.getMyBlockBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent theEvent) {
                final double randomChanceToBlock = (int) (Math.random() * 100) / 100.0;
                if (randomChanceToBlock >= (1 - myAdventurer.getChanceToHit())) {
                    System.out.println("Block Successful! No Damage Taken.");
                } else {
                    System.out.println("Block Failed. Monster Attacked.");
                    // insert monster attacking here
                    final int monsterAttackAmount = myCurrentRoom.getRoomMonster().attack();
                    myAdventurer.setCharacterHealthPoints(myAdventurer.getCharacterHealthPoints() - monsterAttackAmount);
                    checkIfMonsterHealthIsZero();
                    checkIfAdventurerHealthIsZero();
                }
            }
        });

    }

    /** . */
    private void changeScreen(final String theScreen) {
        ((CardLayout) myCardPanel.getLayout()).show(myCardPanel, theScreen);
    }


    /** . */
    private void checkToSeeIfDoorsArePassable(final int theCurrRow, final int theCurrColumn) {
        final Room currentRoom = myDungeon.getMyMazeRoom()[theCurrRow][theCurrColumn];

        if (currentRoom.getDoorNorth().equals(DoorDirections.NO_DOOR_DIRECTION)) {
            myGamePlayPanel.getMyNorthBtn().setEnabled(false);
        } else {
            myGamePlayPanel.getMyNorthBtn().setEnabled(true);
        }
        if (currentRoom.getDoorSouth().equals(DoorDirections.NO_DOOR_DIRECTION)) {
            myGamePlayPanel.getMySouthBtn().setEnabled(false);
        } else {
            myGamePlayPanel.getMySouthBtn().setEnabled(true);
        }
        if (currentRoom.getDoorEast().equals(DoorDirections.NO_DOOR_DIRECTION)) {
            myGamePlayPanel.getMyEastBtn().setEnabled(false);
        } else {
            myGamePlayPanel.getMyEastBtn().setEnabled(true);
        }
        if (currentRoom.getDoorWest().equals(DoorDirections.NO_DOOR_DIRECTION)) {
            myGamePlayPanel.getMyWestBtn().setEnabled(false);
        } else {
            myGamePlayPanel.getMyWestBtn().setEnabled(true);
        }
    }



    /** . */
    private void checkRoomForGroundItemsAndPit() {
        if (myCurrentRoom.hasHealingPotion()) {
            myAdventurer.setMyHealingPotions(1);
        }
        if (myCurrentRoom.hasPillar()) {
            myAdventurer.addPillarToMyPillarsArray(myCurrentRoom.getOOPillar());
        }
        // Add check for vision potion too once/if implemented
        if (myCurrentRoom.hasPit()) {
            int randomDamage = (int) (Math.random() * 20);
            // can put JOptionPane here letting user quickly know that they took fall damage.
            myAdventurer.setCharacterHealthPoints(myAdventurer.getCharacterHealthPoints() - randomDamage);
            // Need to update health bars on GamePlayPanel to show appropriate health.
        }
    }

    /** . */
    private void checkRoomForMonster() {
        if (myCurrentRoom.hasRoomMonster()) {
            myBattlePanel.setCurrentRoomMonster(myCurrentRoom.getRoomMonster());
            myBattlePanel.setAdventurer(myAdventurer);
            // need to fix the health bars accordingly for this match.
            myBattlePanel.addBothCharactersToBattlePanel();
            changeScreen(BATTLE_PANEL);
        }
    }

    private void checkIfMonsterHealthIsZero() {
        if (myCurrentRoom.getRoomMonster().getCharacterHealthPoints() <= 0) {
            System.out.println("You beat the monster");
            myCurrentRoom.setRoomMonster(null);
            myBattlePanel.getMyMonsterImgLabel().setVisible(false);
            changeScreen(GAME_PLAY_PANEL);
        }
    }

    private void checkIfAdventurerHealthIsZero() {
        if (myAdventurer.getCharacterHealthPoints() <= 0) {
            System.out.println("You Died");
            // Put a quick JOptionpane here before death panel
//            changeScreen(LOSING_PANEL);
//            changeScreen(MAIN_MENU_PANEL);
        }
    }


}
