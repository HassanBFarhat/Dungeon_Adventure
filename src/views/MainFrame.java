package views;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serial;
import java.io.Serializable;
import java.util.Random;
import javax.sound.sampled.FloatControl;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import models.*;

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
    /** . */
    private static final String WARRIOR = "Warrior";
    /** . */
    private static final String PRIESTESS = "Priestess";
    /** . */
    private static final String THIEF = "Thief";
    /** . */
    private static final int FRAME_WIDTH = 1280;
    /** . */
    private static final int FRAME_HEIGHT = 720;
    /** . */
    private static final int MAX_ARRAY_SIZE = 4;


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
    private Music myMusic;
    /** . */
    private ImageIcon myTitleIcon;
    /** . */
    private Action upAction;
    /** . */
    private Action downAction;
    /** . */
    private Action leftAction;
    /** . */
    private Action rightAction;
    /** . */
    private final String myFileName = "serialized_game_data.ser";


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
        myMusic = new Music();
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
        this.setLocation(centerX, centerY);
        this.add(myCardPanel);
        this.pack();
        this.setVisible(true);
    }

    /** . */
    private void setUpPanelButtons() {
        setUpMainMenuPanelBtnActionListeners();
        setUpCharacterSelectionPanelActionListeners();
        setUpOptionsGameInfoAndGameHelpActionListeners();
        setUpGamePlayPanelBtnsActionListeners();
        setUpKeyMovementActions();
        bindMovementBtnsToKeyStrokes();
        setUpBattlePanelBtnActionListeners();
        setUpGameOverAndWinningPanelsActionListeners();
        setUpMusicControlsActionListeners();



    }

    /** . */
    private void setUpMainMenuPanelBtnActionListeners() {
        myMainMenuPanel.getStartNewGameBtn().addActionListener(
                theAction -> changeScreen(NEW_GAME_PANEL));

        myMainMenuPanel.getLoadGameBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent theEvent) {
                //Deserialization
                try {
                    // Reading Object from file
                    final FileInputStream file = new FileInputStream(myFileName);
                    final ObjectInputStream in = new ObjectInputStream(file);
                    // Method for deserialization of object.
                    myAdventurer = (Adventurer) in.readObject();
                    myDungeon = (Dungeon) in.readObject();
                    in.close();
                    file.close();
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
    }

    /** . */
    private void setUpCharacterSelectionPanelActionListeners() {
        myCharacterSelectionPanel.getMyBackBtn().addActionListener(
                theAction -> changeScreen(MAIN_MENU_PANEL));

        myCharacterSelectionPanel.getMyStartGameBtnBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent theEvent) {
                if (myCharacterSelectionPanel.getCharactersName().isEmpty()) {
                    JOptionPane.showMessageDialog(myMainMenuPanel,
                            "CANNOT START WITHOUT PUTTING A NAME!");
                } else {
                    instantiateUsersHeroAndSetEntranceCoordinates();
                    checkToSeeIfDoorsArePassable(myCurrentRoomRow, myCurrentRoomColumn);
                    initializeGamePlayPanelAndBattlePanel();
                    changeScreen(GAME_PLAY_PANEL);
                    myGamePlayPanel.setUpHealthBarWithAdventurerHealthStats(myAdventurer);
                }
            }
        });
    }

    /** . */
    private void instantiateUsersHeroAndSetEntranceCoordinates() {
        if (myCharacterSelectionPanel.getHeroOptionFromBox().equals(WARRIOR)) {
            myAdventurer = new Warrior();
        } else if (myCharacterSelectionPanel.getHeroOptionFromBox().equals(PRIESTESS)) {
            myAdventurer = new Priestess();
        } else if (myCharacterSelectionPanel.getHeroOptionFromBox().equals(THIEF)) {
            myAdventurer = new Thief();
        }
        for (int j = 0; j < myDungeon.getMazeSize(); j++) {
            if (myDungeon.getMyMazeRoom()[0][j].hasEntrance()) {
                myCurrentRoomRow = 0;
                myCurrentRoomColumn = j;
                myCurrentRoom = myDungeon.getMyMazeRoom()
                        [myCurrentRoomRow][myCurrentRoomColumn];
            }
        }
    }

    /** . */
    private void initializeGamePlayPanelAndBattlePanel() {
        myGamePlayPanel.updateMiniMap(myCurrentRoomRow, myCurrentRoomColumn);
        myGamePlayPanel.setHeroMainImgFilePath(
                myAdventurer.getAdventurerMainImgFilePath());
        myGamePlayPanel.addingPlayerChosenAdventurerImgToPanel();
        myGamePlayPanel.setMyAdventurer(myAdventurer);
        myBattlePanel.initializeHeroBattleHealthBarMaxMin(myAdventurer);
    }

    /** . */
    private void setUpOptionsGameInfoAndGameHelpActionListeners() {
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
    }


    /** . */
    private void setUpKeyMovementActions() {
        upAction = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                myCurrentRoomRow -= 1;
                myCurrentRoom = myDungeon.getMyMazeRoom()
                        [myCurrentRoomRow][myCurrentRoomColumn];
                myGamePlayPanel.updateMiniMap(myCurrentRoomRow, myCurrentRoomColumn);
                checkToSeeIfDoorsArePassable(myCurrentRoomRow, myCurrentRoomColumn);
                checkRoomForGroundItemsAndPit();
                checkRoomForMonster();
                checkIfAdventurerHealthIsZero();
                checkIfHeroIsAbleToExit();
            }
        };

        downAction = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                myCurrentRoomRow += 1;
                myCurrentRoom = myDungeon.getMyMazeRoom()
                        [myCurrentRoomRow][myCurrentRoomColumn];
                myGamePlayPanel.updateMiniMap(myCurrentRoomRow, myCurrentRoomColumn);
                checkToSeeIfDoorsArePassable(myCurrentRoomRow, myCurrentRoomColumn);
                checkRoomForGroundItemsAndPit();
                checkRoomForMonster();
                checkIfAdventurerHealthIsZero();
                checkIfHeroIsAbleToExit();
            }
        };

        leftAction = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                myCurrentRoomColumn -= 1;
                myCurrentRoom = myDungeon.getMyMazeRoom()
                        [myCurrentRoomRow][myCurrentRoomColumn];
                myGamePlayPanel.updateMiniMap(myCurrentRoomRow, myCurrentRoomColumn);
                checkToSeeIfDoorsArePassable(myCurrentRoomRow, myCurrentRoomColumn);
                checkRoomForGroundItemsAndPit();
                checkRoomForMonster();
                checkIfAdventurerHealthIsZero();
                checkIfHeroIsAbleToExit();
            }
        };

        rightAction = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                myCurrentRoomColumn += 1;
                myCurrentRoom = myDungeon.getMyMazeRoom()
                        [myCurrentRoomRow][myCurrentRoomColumn];
                myGamePlayPanel.updateMiniMap(myCurrentRoomRow, myCurrentRoomColumn);
                checkToSeeIfDoorsArePassable(myCurrentRoomRow, myCurrentRoomColumn);
                checkRoomForGroundItemsAndPit();
                checkRoomForMonster();
                checkIfAdventurerHealthIsZero();
                checkIfHeroIsAbleToExit();
            }
        };
    }



    /** . */
    private void setUpGamePlayPanelBtnsActionListeners() {
        myGamePlayPanel.getMyNorthBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                myCurrentRoomRow -= 1;
                myCurrentRoom = myDungeon.getMyMazeRoom()
                        [myCurrentRoomRow][myCurrentRoomColumn];
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
            public void actionPerformed(ActionEvent e) {
                myCurrentRoomRow += 1;
                myCurrentRoom = myDungeon.getMyMazeRoom()
                        [myCurrentRoomRow][myCurrentRoomColumn];
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
            public void actionPerformed(ActionEvent e) {
                myCurrentRoomColumn += 1;
                myCurrentRoom = myDungeon.getMyMazeRoom()
                        [myCurrentRoomRow][myCurrentRoomColumn];
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
            public void actionPerformed(ActionEvent e) {
                myCurrentRoomColumn -= 1;
                myCurrentRoom = myDungeon.getMyMazeRoom()
                        [myCurrentRoomRow][myCurrentRoomColumn];
                myGamePlayPanel.updateMiniMap(myCurrentRoomRow, myCurrentRoomColumn);
                checkToSeeIfDoorsArePassable(myCurrentRoomRow, myCurrentRoomColumn);
                checkRoomForGroundItemsAndPit();
                checkRoomForMonster();
                checkIfAdventurerHealthIsZero();
                checkIfHeroIsAbleToExit();
            }
        });

        myGamePlayPanel.getMyInventoryBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent theEvent) {
                final String inventoryStats = "Health Potions: "
                        + myAdventurer.getMyHealingPotions() + "\nPillars Collected: "
                        + myAdventurer.getMyPillars().toString();
                JOptionPane.showMessageDialog(myGamePlayPanel, inventoryStats);
            }
        });

        myGamePlayPanel.getMySaveGameBtn().addActionListener(theEvent -> {
            // Serialization
            try {
                // Saving Object in a File
                final FileOutputStream file = new FileOutputStream(myFileName);
                final ObjectOutputStream out = new ObjectOutputStream(file);
                // Method for Serialization of Object
                out.writeObject(myAdventurer);
                out.writeObject(myDungeon);
                out.writeObject(myGamePlayPanel);
                out.writeObject(myBattlePanel);
                out.close();
                file.close();
            } catch (final Exception e) {
                e.printStackTrace();
                System.exit(0);
            }
            myAdventurer = null;
            myDungeon = null;
            changeScreen(MAIN_MENU_PANEL);
        });
    }

    /** . */
    private void bindMovementBtnsToKeyStrokes() {
        myGamePlayPanel.getMyNorthBtn().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("W"), "w clicked");
        myGamePlayPanel.getMyNorthBtn().getActionMap().put("w clicked", upAction);
        myGamePlayPanel.getMyNorthBtn().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("UP"), "up arrow clicked");
        myGamePlayPanel.getMyNorthBtn().getActionMap().put("up arrow clicked", upAction);

        myGamePlayPanel.getMySouthBtn().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("S"), "s clicked");
        myGamePlayPanel.getMySouthBtn().getActionMap().put("s clicked", downAction);
        myGamePlayPanel.getMySouthBtn().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("DOWN"), "down arrow clicked");
        myGamePlayPanel.getMySouthBtn().getActionMap().put("down arrow clicked", downAction);
//
        myGamePlayPanel.getMyEastBtn().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("D"), "d clicked");
        myGamePlayPanel.getMyEastBtn().getActionMap().put("d clicked", rightAction);
        myGamePlayPanel.getMyEastBtn().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("RIGHT"), "right arrow clicked");
        myGamePlayPanel.getMyEastBtn().getActionMap().put("right arrow clicked", rightAction);
//
        myGamePlayPanel.getMyWestBtn().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("A"), "a clicked");
        myGamePlayPanel.getMyWestBtn().getActionMap().put("a clicked", leftAction);
        myGamePlayPanel.getMyWestBtn().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("LEFT"), "left arrow clicked");
        myGamePlayPanel.getMyWestBtn().getActionMap().put("left arrow clicked", leftAction);
    }

    /** . */
    private void setUpBattlePanelBtnActionListeners() {
        myBattlePanel.getMyAttackBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent theEvent) {
                myBattlePanel.getMyGameActionText().append("You attacked the monster\n");
                final int monsterDamageTaken = myAdventurer.attack();
                final AbstractMonster roomMonster = myCurrentRoom.getRoomMonster();
                roomMonster.setCharacterHealthPoints(
                        roomMonster.getCharacterHealthPoints() - monsterDamageTaken);
                myBattlePanel.getMyGameActionText().append("Monster Took " + monsterDamageTaken + " Damage\n");
                myBattlePanel.updateHealthBarForMonster(
                        roomMonster.getCharacterHealthPoints());
                checkIfMonsterHealthIsZero();

                if (roomMonster.getCharacterHealthPoints() <= 20) {
                    final int randomChanceToHealSelf = (int) (Math.random() * 100);
                    final int randomPointsHealed = roomMonster.heal();
                    if (randomChanceToHealSelf >= 80) {
                        myBattlePanel.getMyGameActionText().append("Wait... Monster Healed Itself!\n");
                        roomMonster.setCharacterHealthPoints(
                                roomMonster.getCharacterHealthPoints() + randomPointsHealed);
                        myBattlePanel.getMyGameActionText().append("Monster Healed " + randomPointsHealed + " Health Points\n");

                    }
                    myBattlePanel.updateHealthBarForMonster(
                            roomMonster.getCharacterHealthPoints());
                }

                checkIfAdventurerHealthIsZero();
                monsterAttacksHero(myCurrentRoom.getRoomMonster());
            }
        });

        myBattlePanel.getMySpecialAttackBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent theEvent) {
                myBattlePanel.getMyGameActionText().append("You used Special Attack\n");

                final AbstractMonster roomMonster = myCurrentRoom.getRoomMonster();
                final int specialDamage = myAdventurer.specialAttack();
                if (myAdventurer.getCharacterName().equals(WARRIOR)) {
                    roomMonster.setCharacterHealthPoints(
                            roomMonster.getCharacterHealthPoints() - specialDamage);
                    myBattlePanel.getMyGameActionText().append("You dealt " + specialDamage + " damage to the monster\n");
                } else if (myAdventurer.getCharacterName().equals(PRIESTESS)) {
                    myAdventurer.setCharacterHealthPoints(
                            myAdventurer.getCharacterHealthPoints() + specialDamage);
                    myBattlePanel.getMyGameActionText().append("You Healed Yourself " + specialDamage + " points\n");
                    myBattlePanel.updateHealthBarsForHero(
                            myAdventurer.getCharacterHealthPoints());
                } else if (myAdventurer.getCharacterName().equals(THIEF)) {
                    roomMonster.setCharacterHealthPoints(
                            roomMonster.getCharacterHealthPoints() - specialDamage);
                    myBattlePanel.getMyGameActionText().append("You dealt " + specialDamage + " damage to the monster.\n");
                }
                myBattlePanel.updateHealthBarForMonster(
                        roomMonster.getCharacterHealthPoints());
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
                    myBattlePanel.getMyGameActionText().append("You used Heal to gain " + randomHealAmount + " health points.\n");
                    myAdventurer.setCharacterHealthPoints(
                            myAdventurer.getCharacterHealthPoints() + randomHealAmount);
                    myBattlePanel.updateHealthBarsForHero(
                            myAdventurer.getCharacterHealthPoints());
                    myAdventurer.setMyHealingPotions(-1);
                    myBattlePanel.getMyGameActionText().append("You have " + myAdventurer.getMyHealingPotions() + " Healing Potions Left.\n");
                } else {
                    myBattlePanel.getMyGameActionText().append("No potions left to use for healing.\n");

                }
            }
        });

    }

    /** . */
    private void setUpGameOverAndWinningPanelsActionListeners() {
        myGameOverPanel.getPlayAgainBtn().addActionListener(
                theAction -> {
                    startingNewGameSameWindow();
                    changeScreen(NEW_GAME_PANEL);
                });
        myGameOverPanel.getMyMainMenuBtn().addActionListener(
                theAction -> {
                    changeScreen(MAIN_MENU_PANEL);
                    startingNewGameSameWindow();
                });

        myWinningPanel.getMyMainMenuBtn().addActionListener(
                theAction -> {
                    changeScreen(MAIN_MENU_PANEL);
                    startingNewGameSameWindow();
                });
    }

    /** . */
    private void setUpMusicControlsActionListeners() {
        myOptionsPanel.getMyAudioOnOffBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent theE) {
                if (myOptionsPanel.getMyAudioOnOffBtn().isSelected()) {
                    myMusic.stopAudio();
                } else {
                    myMusic.playAudio();
                }
            }
        });

        myOptionsPanel.getMyAudioSlider().addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(final ChangeEvent theE) {
                if (myMusic.getMyAudioClip() != null) {
                    final float volume = (float)
                            myOptionsPanel.getMyAudioSlider().getValue() / 100.0f;
                    final FloatControl gainControl = (FloatControl) myMusic.getMyAudioClip().getControl(FloatControl.Type.MASTER_GAIN);
                    gainControl.setValue(20f * (float) Math.log10(volume));
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
        myGamePlayPanel.getMyNorthBtn().setEnabled(
                !currentRoom.getDoorNorth().equals(DoorDirections.NO_DOOR_DIRECTION));
        myGamePlayPanel.getMySouthBtn().setEnabled(
                !currentRoom.getDoorSouth().equals(DoorDirections.NO_DOOR_DIRECTION));
        myGamePlayPanel.getMyEastBtn().setEnabled(
                !currentRoom.getDoorEast().equals(DoorDirections.NO_DOOR_DIRECTION));
        myGamePlayPanel.getMyWestBtn().setEnabled(
                !currentRoom.getDoorWest().equals(DoorDirections.NO_DOOR_DIRECTION));
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
        if (myCurrentRoom.hasPit()) {
            final int randomDamage = (int) (Math.random() * 20);
            JOptionPane.showMessageDialog(
                    myGamePlayPanel, "You fell into a pit and took damage!");
            myAdventurer.setCharacterHealthPoints(
                    myAdventurer.getCharacterHealthPoints() - randomDamage);
            myGamePlayPanel.updateAdventurerHealthBar(myAdventurer);
        }
    }

    /** . */
    private void checkRoomForMonster() {
        if (myCurrentRoom.hasRoomMonster()) {
            myMonsterInitialHealth = myCurrentRoom.getRoomMonster().getCharacterHealthPoints();
            myBattlePanel.setCurrentRoomMonster(myCurrentRoom.getRoomMonster());
            myBattlePanel.setAdventurer(myAdventurer);
            myBattlePanel.addBothCharactersToBattlePanel();
            myBattlePanel.setUpHealthBarsForHeroAndMonster(myAdventurer,
                                                           myCurrentRoom.getRoomMonster());
            changeScreen(BATTLE_PANEL);
        }
    }

    /** . */
    private void checkIfMonsterHealthIsZero() {
        if (myCurrentRoom.getRoomMonster().getCharacterHealthPoints() <= 0) {
            JOptionPane.showMessageDialog(myBattlePanel, "You beat the monster!");
            myCurrentRoom.getRoomMonster().setCharacterHealthPoints(myMonsterInitialHealth);
            myCurrentRoom.setRoomMonster(null);
            myBattlePanel.getMyMonsterImgLabel().setVisible(false);
            myGamePlayPanel.updateAdventurerHealthBar(myAdventurer);
            myBattlePanel.getMyGameActionText().setText("");
            changeScreen(GAME_PLAY_PANEL);
        }
    }

    /** . */
    private void checkIfAdventurerHealthIsZero() {
        if (myAdventurer.getCharacterHealthPoints() <= 0) {
            JOptionPane.showMessageDialog(myBattlePanel, "You have Died a painful death!");
            startingNewGameSameWindow();
            changeScreen(GAME_OVER_PANEL);
        }
    }

    /** . */
    private void checkIfHeroIsAbleToExit() {
        if (myAdventurer.getMyPillars().size() == MAX_ARRAY_SIZE && myCurrentRoom.hasExit()) {
            final String ableToLeave = """
                    You've found the Exit!\s
                    You've also collected all the Pillars...\s
                    Would you like to exit the Dungeon?
                    """;
            final int usersChoice = JOptionPane.showConfirmDialog(myGamePlayPanel,
                                                                  ableToLeave,
                                                              null, JOptionPane.YES_NO_OPTION);
            if (usersChoice == 0) {
                changeScreen(WINNING_PANEL);
            }
        } else if (myCurrentRoom.hasExit()) {
            final String cannotLeave = """
                    Sorry, you cannot exit the dungeon just yet.\s
                    You haven't found all the pillars yet...\s
                    Once you have all the pillars then you may leave.\s
                    But hey, now you know where the exit is!
                    """;
            JOptionPane.showMessageDialog(myGamePlayPanel, cannotLeave);
        }
    }

    /** . */
    private void monsterAttacksHero(final AbstractMonster theMonster) {
        if (theMonster != null) {
            myBattlePanel.getMyGameActionText().append("Monsters Turn To Attack\n");

            final double randomChanceToBlock = (int) (Math.random() * 100) / 100.0;
            if (randomChanceToBlock >= (1 - myAdventurer.getChanceToHit())) {
                myBattlePanel.getMyGameActionText().append("You Blocked the Monsters Attack Successfully! No Damage Taken.\n");

            } else {
                myBattlePanel.getMyGameActionText().append("You failed to Block the Monsters Attack.\n");

                final int monsterAttackAmount = myCurrentRoom.getRoomMonster().attack();
                myAdventurer.setCharacterHealthPoints(
                        myAdventurer.getCharacterHealthPoints() - monsterAttackAmount);
                myBattlePanel.getMyGameActionText().append("You took " + monsterAttackAmount + " Points of Damage\n");
                myBattlePanel.updateHealthBarsForHero(
                        myAdventurer.getCharacterHealthPoints());
                checkIfMonsterHealthIsZero();
                checkIfAdventurerHealthIsZero();
            }
        }
    }

    /** . */
    private void startingNewGameSameWindow() {
        myDungeon.randomlyGenerateRooms();
        myCharacterSelectionPanel.setMyNameYourCharacterTextBox(null);
        myGamePlayPanel.getMyAdventurerImgLabel().setVisible(false);
        myBattlePanel.getMyMonsterImgLabel().setVisible(false);
        myBattlePanel.getMyAdventurerImgLabel().setVisible(false);
        myBattlePanel.getMyGameActionText().setText("");
        myBattlePanel.setVisible(false);
        myAdventurer = null;
    }

}
