package views;

import models.*;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Random;
import javax.swing.*;

/**
 * @author Avinash Bavisetty
 * @author Hassan Bassam Farhat
 * @version Summer 2023
 */

public class MainFrame extends JFrame implements Serializable {

    @Serial
    private static final long serialVersionUID = -9118850470601436365L;

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
    private static final String GAME_OVER_PANEL = "GameOver";
    /** . */
    private static final String WINNING_PANEL = "Winner";
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
    /** . */
    private int myMonsterInitialHealth;
    /** . */
    private GameOverPanel myGameOverPanel;
    /** . */
    private WinningPanel myWinningPanel;
    /** . */
    private ImageIcon myTitleIcon;
    /** . */
    private String fileName = "serialized_game_data.ser";

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
        myTitleIcon = new ImageIcon("src/imgs/DungeonDoorProjectIcon.png");

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
        myMonsterInitialHealth = 0;
        myGameOverPanel = new GameOverPanel();
        myWinningPanel = new WinningPanel();
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
        myCardPanel.add(myGameOverPanel, GAME_OVER_PANEL);
        myCardPanel.add(myWinningPanel, WINNING_PANEL);
    }

    /** . */
    private void setUpMainFrame() {
        this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        this.setTitle("Dungeon Adventure");
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setIconImage(myTitleIcon.getImage());

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

        myMainMenuPanel.getLoadGameBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent theEvent) {
                //Deserialization
                try {
                    // Reading Object from file
                    final FileInputStream file = new FileInputStream(fileName);
                    final ObjectInputStream in = new ObjectInputStream(file);
                    // Method for deserialization of object.
                    myAdventurer = (Adventurer) in.readObject();
                    myDungeon = (Dungeon) in.readObject();
                    myGamePlayPanel = (GamePlayPanel) in.readObject();
                    myBattlePanel = (BattlePanel) in.readObject();
//                    myCurrentRoom = (Room) in.readObject();
                    in.close();
                    file.close();
                    System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
                    System.out.println(myAdventurer.toString());
                    System.out.println(myDungeon.toString());
                    System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
//                    System.out.println(myCurrentRoom.toString());
                } catch (final Exception e) {
                    e.printStackTrace();
                    System.exit(0);
                }
                changeScreen(GAME_PLAY_PANEL);
            }
        });


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
                    myGamePlayPanel.updateMiniMap(myCurrentRoomRow, myCurrentRoomColumn);

                    myGamePlayPanel.setHeroMainImgFilePath(myAdventurer.getAdventurerMainImgFilePath());
                    myGamePlayPanel.addingPlayerChosenAdventurerImgToPanel();
                    myGamePlayPanel.setMyAdventurer(myAdventurer);
                    myBattlePanel.initializeHeroBattleHealthBarMaxMin(myAdventurer);
                    changeScreen(GAME_PLAY_PANEL);
                    myGamePlayPanel.setUpHealthBarWithAdventurerHealthStats(myAdventurer);

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
                myGamePlayPanel.updateMiniMap(myCurrentRoomRow, myCurrentRoomColumn);
                checkToSeeIfDoorsArePassable(myCurrentRoomRow, myCurrentRoomColumn);
                checkRoomForGroundItemsAndPit();
                checkRoomForMonster();
                checkIfAdventurerHealthIsZero();
                checkIfHeroIsAbleToExit();
            }
        });

        myGamePlayPanel.getMySouthBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent theEvent) {
                myCurrentRoomRow += 1;
                myCurrentRoom = myDungeon.getMyMazeRoom()[myCurrentRoomRow][myCurrentRoomColumn];
                myGamePlayPanel.updateMiniMap(myCurrentRoomRow, myCurrentRoomColumn);
                checkToSeeIfDoorsArePassable(myCurrentRoomRow, myCurrentRoomColumn);
                checkRoomForGroundItemsAndPit();
                checkRoomForMonster();
                checkIfAdventurerHealthIsZero();
                checkIfHeroIsAbleToExit();
            }
        });

        myGamePlayPanel.getMyEastBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent theEvent) {
                myCurrentRoomColumn += 1;
                myCurrentRoom = myDungeon.getMyMazeRoom()[myCurrentRoomRow][myCurrentRoomColumn];
                myGamePlayPanel.updateMiniMap(myCurrentRoomRow, myCurrentRoomColumn);
                checkToSeeIfDoorsArePassable(myCurrentRoomRow, myCurrentRoomColumn);
                checkRoomForGroundItemsAndPit();
                checkRoomForMonster();
                checkIfAdventurerHealthIsZero();
                checkIfHeroIsAbleToExit();
            }
        });

        myGamePlayPanel.getMyWestBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent theEvent) {
                myCurrentRoomColumn -= 1;
                myCurrentRoom = myDungeon.getMyMazeRoom()[myCurrentRoomRow][myCurrentRoomColumn];
                myGamePlayPanel.updateMiniMap(myCurrentRoomRow, myCurrentRoomColumn);
                checkToSeeIfDoorsArePassable(myCurrentRoomRow, myCurrentRoomColumn);
                checkRoomForGroundItemsAndPit();
                checkRoomForMonster();
                checkIfAdventurerHealthIsZero();
                checkIfHeroIsAbleToExit();
            }
        });

        myGamePlayPanel.getMyInventoryBtn().addActionListener(
                theAction -> JOptionPane.showMessageDialog(this, "Health Potions " + myAdventurer.getMyHealingPotions() + "\nPillars Collected: " + myAdventurer.getMyPillars().toString()));

        myGamePlayPanel.getMySaveGameBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent theEvent) {
                // Serialization
                try {
                    // Saving Object in a File
                    final FileOutputStream file = new FileOutputStream(fileName);
                    final ObjectOutputStream out = new ObjectOutputStream(file);
                    // Method for Serialization of Object
                    out.writeObject(myAdventurer);
                    out.writeObject(myDungeon);
                    out.writeObject(myGamePlayPanel);
                    out.writeObject(myBattlePanel);
//                    out.writeObject(myCurrentRoom);
                    out.close();
                    file.close();
                    System.out.println("############################################################################################");
                    System.out.println(myAdventurer.toString());
                    System.out.println(myDungeon.toString());
                    System.out.println("############################################################################################");
//                    System.out.println(myCurrentRoom.toString());
                } catch (final Exception e) {
                    e.printStackTrace();
                    System.exit(0);
                }

                myAdventurer = null;
                myDungeon = null;
//                myCurrentRoom = null;
                changeScreen(MAIN_MENU_PANEL);
            }
        });


        myBattlePanel.getMyAttackBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent theEvent) {
                System.out.println("You attacked the monster");
                final AbstractMonster roomMonster = myCurrentRoom.getRoomMonster();
                System.out.println("BEFORE" + roomMonster.getCharacterHealthPoints());
                roomMonster.setCharacterHealthPoints(roomMonster.getCharacterHealthPoints() - myAdventurer.attack());
                System.out.println(roomMonster.getCharacterHealthPoints());
                myBattlePanel.updateHealthBarForMonster(roomMonster.getCharacterHealthPoints());
                checkIfMonsterHealthIsZero();
                checkIfAdventurerHealthIsZero();
                monsterAttacksHero(myCurrentRoom.getRoomMonster());
            }
        });

        myBattlePanel.getMySpecialAttackBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent theEvent) {
                System.out.println("You used Special Attack");
                final AbstractMonster roomMonster = myCurrentRoom.getRoomMonster();
                if (myAdventurer.getCharacterName().equals("Warrior")) {
                    roomMonster.setCharacterHealthPoints(roomMonster.getCharacterHealthPoints() - myAdventurer.specialAttack());
                } else if (myAdventurer.getCharacterName().equals("Priestess")) {
                    myAdventurer.setCharacterHealthPoints(myAdventurer.getCharacterHealthPoints() + myAdventurer.specialAttack());
                    myBattlePanel.updateHealthBarsForHero(myAdventurer.getCharacterHealthPoints());
                } else if (myAdventurer.getCharacterName().equals("Thief")) {
                    roomMonster.setCharacterHealthPoints(roomMonster.getCharacterHealthPoints() - myAdventurer.specialAttack());
                }
                myBattlePanel.updateHealthBarForMonster(roomMonster.getCharacterHealthPoints());
                checkIfMonsterHealthIsZero();
                checkIfAdventurerHealthIsZero();
                monsterAttacksHero(myCurrentRoom.getRoomMonster());
            }
        });

        myBattlePanel.getMyHealBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent theEvent) {
                final Random random = new Random();
                final int randomHealAmount = random.nextInt(15 - 5 + 1) + 5;
                if (myAdventurer.getMyHealingPotions() > 0) {
                    myAdventurer.setCharacterHealthPoints(myAdventurer.getCharacterHealthPoints() + randomHealAmount);
                    myBattlePanel.updateHealthBarsForHero(myAdventurer.getCharacterHealthPoints());
                    myAdventurer.setMyHealingPotions(-1);
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
                    myBattlePanel.updateHealthBarsForHero(myAdventurer.getCharacterHealthPoints());
                    checkIfMonsterHealthIsZero();
                    checkIfAdventurerHealthIsZero();
                }
            }
        });


        myGameOverPanel.getPlayAgainBtn().addActionListener(
                theAction -> changeScreen(NEW_GAME_PANEL));
                // also make sure that dungeon.generatemaze() is ran to generate a new maze, clear out old inventory too.
                // pretty much re-instantiate the objects here to start over

        myGameOverPanel.getMyMainMenuBtn().addActionListener(
                theAction -> changeScreen(MAIN_MENU_PANEL));

        myWinningPanel.getMyMainMenuBtn().addActionListener(
                theAction -> changeScreen(MAIN_MENU_PANEL));

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
            myCurrentRoom.setHealingPotion(null);
        }
        if (myCurrentRoom.hasPillar()) {
            myAdventurer.addPillarToMyPillarsArray(myCurrentRoom.getOOPillar());
            myCurrentRoom.setOOPillar(null);
        }
        // Add check for vision potion too once/if implemented
        if (myCurrentRoom.hasPit()) {
            int randomDamage = (int) (Math.random() * 20);
            JOptionPane.showMessageDialog(myGamePlayPanel, "You fell into a pit and took damage!");
            // can put JOptionPane here letting user quickly know that they took fall damage.
            myAdventurer.setCharacterHealthPoints(myAdventurer.getCharacterHealthPoints() - randomDamage);
            myGamePlayPanel.updateAdventurerHealthBar(myAdventurer);
            // Need to update health bars on GamePlayPanel to show appropriate health.
        }
    }

    /** . */
    private void checkRoomForMonster() {
        if (myCurrentRoom.hasRoomMonster()) {
            myMonsterInitialHealth = myCurrentRoom.getRoomMonster().getCharacterHealthPoints();
            myBattlePanel.setCurrentRoomMonster(myCurrentRoom.getRoomMonster());
            myBattlePanel.setAdventurer(myAdventurer);
            // need to fix the health bars accordingly for this match.
            myBattlePanel.addBothCharactersToBattlePanel();
            myBattlePanel.setUpHealthBarsForHeroAndMonster(myAdventurer, myCurrentRoom.getRoomMonster());
            changeScreen(BATTLE_PANEL);
        }
    }

    private void checkIfMonsterHealthIsZero() {
        if (myCurrentRoom.getRoomMonster().getCharacterHealthPoints() <= 0) {
            System.out.println("You beat the monster");
            myCurrentRoom.getRoomMonster().setCharacterHealthPoints(myMonsterInitialHealth);
            myCurrentRoom.setRoomMonster(null);
            myBattlePanel.getMyMonsterImgLabel().setVisible(false);
            myGamePlayPanel.updateAdventurerHealthBar(myAdventurer);
            changeScreen(GAME_PLAY_PANEL);
        }
    }

    private void checkIfAdventurerHealthIsZero() {
        if (myAdventurer.getCharacterHealthPoints() <= 0) {
            System.out.println("You Died");
            // Put a quick JOptionpane here before death panel
            JOptionPane.showMessageDialog(myBattlePanel, "You have Died a painful death!");
            changeScreen(GAME_OVER_PANEL);
        }
    }


    private void checkIfHeroIsAbleToExit() {
        if (myAdventurer.getMyPillars().size() == 4 && myCurrentRoom.hasExit()) {
            int usersChoice = JOptionPane.showConfirmDialog(myGamePlayPanel, "You've found the Exit! \nYou've also collected all the Pillars. \nWould you like to exit?", null, JOptionPane.YES_NO_OPTION);
            if (usersChoice == 0) {
                changeScreen(WINNING_PANEL);
            }
        } else if (myCurrentRoom.hasExit()) {
            JOptionPane.showMessageDialog(myGamePlayPanel, "Sorry, you cannot exit the dungeon until all pillars are found. \nBut hey, now you know where the exit is!");
        }
    }


//    private void saveGame() {
//        try {
//            myAdventurer.saveToFile("src/models/savefile.ser", myAdventurer);
//
//            if(myCurrentRoom.hasRoomMonster()) {
//                myCurrentRoom.getRoomMonster().saveToFile("src/models/monster_savefile.ser");
//            }
//            myDungeon.saveToFile("src/models/savefile.ser");
//
//        } catch (IOException e) {
//            e.printStackTrace();
//            JOptionPane.showMessageDialog(this, "game could not be saved.");
//        }
//    }
//
//    private void loadGame() {
//        try {
//            myAdventurer = Adventurer.loadFile("src/models/savefile.ser");
//            if(myCurrentRoom.hasRoomMonster()) {
//                AbstractMonster loadedMonster = AbstractMonster.loadFile("ssrc/models/savefile.ser");
//                myCurrentRoom.setRoomMonster(loadedMonster);
//            }
//            myDungeon = Dungeon.loadFile("src/models/savefile.ser");
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            JOptionPane.showMessageDialog(this, "game was unable to load.");
//        }
//    }


    private void monsterAttacksHero(final AbstractMonster theMonster) {
        if (theMonster != null) {
            JOptionPane.showMessageDialog(myBattlePanel, "Monsters Turn To Attack");
            final int monsterAttackAmount = myCurrentRoom.getRoomMonster().attack();
            myAdventurer.setCharacterHealthPoints(myAdventurer.getCharacterHealthPoints() - monsterAttackAmount);
            myBattlePanel.updateHealthBarsForHero(myAdventurer.getCharacterHealthPoints());
            checkIfMonsterHealthIsZero();
            checkIfAdventurerHealthIsZero();
        }
    }



}
