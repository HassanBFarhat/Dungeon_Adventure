package views;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serial;
import java.io.Serializable;
import java.util.Random;
import javax.sound.sampled.FloatControl;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import models.AbstractMonster;
import models.Adventurer;
import models.DoorDirections;
import models.Dungeon;
import models.Music;
import models.Priestess;
import models.Room;
import models.Thief;
import models.Warrior;

/**
 *  This is the entry point for having all necessary models and panels instantiated and
 *  accessed to link up main game components.
 *
 *  @author Avinash Bavisetty
 *  @author Hassan Bassam Farhat
 *  @version Summer 2023
 */
public class MainFrame extends JFrame implements Serializable {

    @Serial
    private static final long serialVersionUID = -9118850470601436365L;

    // constants
    /** main menu panel. */
    private static final String MAIN_MENU_PANEL = "controller.Main";
    /** new game panel. */
    private static final String NEW_GAME_PANEL = "NewGame";
    /** options panel. */
    private static final String OPTIONS_PANEL = "Option";
    /** game info panel. */
    private static final String GAME_INFO_PANEL = "GameInfo";
    /** game help panel. */
    private static final String GAME_HELP_PANEL = "GameHelp";
    /** game play panel. */
    private static final String GAME_PLAY_PANEL = "GamePlay";
    /** game over panel. */
    private static final String GAME_OVER_PANEL = "GameOver";
    /** winning panel. */
    private static final String WINNING_PANEL = "Winner";
    /** battle panel. */
    private static final String BATTLE_PANEL = "BattleField";
    /** warrior . */
    private static final String WARRIOR = "Warrior";
    /** priestess. */
    private static final String PRIESTESS = "Priestess";
    /** thief. */
    private static final String THIEF = "Thief";
    /** w key clicked. */
    private static final String W_PUSHED = "w clicked";
    /** up arrow key clicked. */
    private static final String UP_PUSHED = "up arrow clicked";
    /** a key pushed. */
    private static final String A_PUSHED = "a clicked";
    /** left arrow pushed. */
    private static final String LEFT_PUSHED = "left arrow clicked";
    /** s pushed. */
    private static final String S_PUSHED = "s clicked";
    /** down arrow pushed. */
    private static final String DOWN_PUSHED = "down arrow clicked";
    /** d key pushed. */
    private static final String D_PUSHED = "d clicked";
    /** right pushed. */
    private static final String RIGHT_PUSHED = "right arrow clicked";
    /** frame width. */
    private static final int FRAME_WIDTH = 1280;
    /** frame height. */
    private static final int FRAME_HEIGHT = 720;
    /** max array size. */
    private static final int MAX_ARRAY_SIZE = 4;
    /** monster min health to try to heal. */
    private static final int MONSTERS_MIN_HEALTH_TO_TRY_HEAL = 20;
    /** monster's chance when it comes to trying to heal. */
    private static final int MONSTERS_CHANCE_TO_TRY_HEAL = 80;
    /** you dealt. */
    private static final String YOU_DEALT = "You dealt ";
    /** damage to monster. */
    private static final String DAMAGE_TO_THE_MONSTER = " damage to the monster\n";
    /** gain constant. */
    private static final float GAIN_CONSTANT = 20f;

    // instance fields

    /** card panel. */
    private JPanel myCardPanel;
    /** main menu panel. */
    private MainMenuPanel myMainMenuPanel;
    /** myCharacterSelectionPanel. */
    private CharacterSelectionPanel myCharacterSelectionPanel;
    /** myOptionsPanel. */
    private OptionsPanel myOptionsPanel;
    /** myGameInformationPanel. */
    private GameInformationPanel myGameInformationPanel;
    /** myGameHelpPanel. */
    private GameHelpPanel myGameHelpPanel;
    /** myGamePlayPanel. */
    private GamePlayPanel myGamePlayPanel;
    /** myBattlePanel. */
    private BattlePanel myBattlePanel;
    /** myAdventurer. */
    private Adventurer myAdventurer;
    /** dungeon. */
    private Dungeon myDungeon;
    /** current room row. */
    private int myCurrentRoomRow;
    /** current room column. */
    private int myCurrentRoomColumn;
    /** current room. */
    private Room myCurrentRoom;
    /** monster's initial health. */
    private int myMonsterInitialHealth;
    /** GameOverPanel. */
    private GameOverPanel myGameOverPanel;
    /** WinningPanel. */
    private WinningPanel myWinningPanel;
    /** Music. */
    private Music myMusic;
    /** TitleIcon. */
    private ImageIcon myTitleIcon;
    /** myUpAction. */
    private Action myUpAction;
    /** myDownAction. */
    private Action myDownAction;
    /** myLeftAction. */
    private Action myLeftAction;
    /** myRightAction. */
    private Action myRightAction;
    /** myFileChooser. */
    private JFileChooser myFileChooser;


    // constructor

    /**
     *  Sets up the main JFrame as well as the components required to make the game
     *  run in same window.
     */
    public MainFrame() {
        instantiateInstanceDataFields();
        setUpFramePanels();
        setUpMainFrame();
        setUpPanelButtons();
        createMainGameMaze();
    }


    // methods

    /** Instantiates all instance fields within this class. */
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
        myFileChooser = new JFileChooser();
    }

    /** Creates the randomly generated the 2D-dungeon within the myDungeon instantiation. */
    private void createMainGameMaze() {
        myDungeon.randomlyGenerateRooms();
    }

    /**
     *  Sets up the myCardPanel with all possible panels we want to switch to during
     *  certain scenarios.
     */
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

    /** Sets up the main JFrame size, location, title, etc.... */
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

    /** Sets up all the panel buttons within each of the panels and their actions. */
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

    /** Sets up all the main menu buttons and their associated actions. */
    private void setUpMainMenuPanelBtnActionListeners() {
        myMainMenuPanel.getStartNewGameBtn().addActionListener(
                theAction -> changeScreen(NEW_GAME_PANEL));

        myMainMenuPanel.getLoadGameBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent theEvent) {
                final int returnValue = myFileChooser.showOpenDialog(myMainMenuPanel);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    final File selectedFile = myFileChooser.getSelectedFile();
                    try (ObjectInputStream inputStream = new ObjectInputStream(
                            new FileInputStream(selectedFile))) {
                        myDungeon = (Dungeon) inputStream.readObject();
                        myAdventurer = (Adventurer) inputStream.readObject();
                        myCurrentRoomRow = (int) inputStream.readObject();
                        myCurrentRoomColumn = (int) inputStream.readObject();
                    } catch (final IOException | ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }
                initializeGamePlayPanelAndBattlePanel();
                myGamePlayPanel.setUpHealthBarWithAdventurerHealthStats(myAdventurer);
                myGamePlayPanel.updateAdventurerHealthBar(myAdventurer);
                myGamePlayPanel.updateMiniMap(myCurrentRoomRow, myCurrentRoomColumn);
                changeScreen(GAME_PLAY_PANEL);
            }
        });

        myMainMenuPanel.getOptionsBtn().addActionListener(
                theAction -> changeScreen(OPTIONS_PANEL));

        myMainMenuPanel.getExitBtn().addActionListener(
                theAction -> System.exit(0));
    }

    /** Sets up all the character selection panel buttons and their associated actions. */
    private void setUpCharacterSelectionPanelActionListeners() {
        myCharacterSelectionPanel.getMyBackBtn().addActionListener(
                theAction -> changeScreen(MAIN_MENU_PANEL));

        myCharacterSelectionPanel.getMyStartGameBtnBtn().addActionListener(theEvent -> {
            if (myCharacterSelectionPanel.getCharactersName().isEmpty()) {
                JOptionPane.showMessageDialog(myMainMenuPanel,
                        "Please enter a name. The game cannot start without a name!");
            } else {
                instantiateUsersHeroAndSetEntranceCoordinates();
                checkToSeeIfDoorsArePassable(myCurrentRoomRow, myCurrentRoomColumn);
                initializeGamePlayPanelAndBattlePanel();
                changeScreen(GAME_PLAY_PANEL);
                myGamePlayPanel.setUpHealthBarWithAdventurerHealthStats(myAdventurer);
            }
        });
    }

    /**
     *  This instantiates the users specified hero choice as well as the coordinates of
     *  where the player will start based off the Entrance in the 2D-dungeon.
     */
    private void instantiateUsersHeroAndSetEntranceCoordinates() {
        if (myCharacterSelectionPanel.getHeroOptionFromBox().equals(WARRIOR)) {
            myAdventurer = new Warrior();
        } else if (myCharacterSelectionPanel.getHeroOptionFromBox().equals(PRIESTESS)) {
            myAdventurer = new Priestess();
        } else if (myCharacterSelectionPanel.getHeroOptionFromBox().equals(THIEF)) {
            myAdventurer = new Thief();
        }
        System.out.println(myAdventurer.toString());
        for (int j = 0; j < myDungeon.getMazeSize(); j++) {
            if (myDungeon.getMyMazeRoom()[0][j].hasEntrance()) {
                myCurrentRoomRow = 0;
                myCurrentRoomColumn = j;
                myCurrentRoom = myDungeon.getMyMazeRoom()
                        [myCurrentRoomRow][myCurrentRoomColumn];
            }
        }
    }

    /**
     *  This initializes the main games panel to show minimap correct location to start and
     *  hero chosen by the user for both main game and battle game purposes.
     */
    private void initializeGamePlayPanelAndBattlePanel() {
        myGamePlayPanel.updateMiniMap(myCurrentRoomRow, myCurrentRoomColumn);
        myGamePlayPanel.setHeroMainImgFilePath(
                myAdventurer.getAdventurerMainImgFilePath());
        myGamePlayPanel.addingPlayerChosenAdventurerImgToPanel();
        myGamePlayPanel.setMyAdventurer(myAdventurer);
        myBattlePanel.initializeHeroBattleHealthBarMaxMin(myAdventurer);
    }

    /** Sets up all the option panels buttons and their associated actions. */
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

    /**
     *  Sets up the movement logic for WASD and Arrow Key movement of the player throughout
     *  the 2D-dungeon matrix.
     */
    private void setUpKeyMovementActions() {
        myUpAction = new AbstractAction() {
            @Override
            public void actionPerformed(final ActionEvent theE) {
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

        myDownAction = new AbstractAction() {
            @Override
            public void actionPerformed(final ActionEvent theE) {
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

        myLeftAction = new AbstractAction() {
            @Override
            public void actionPerformed(final ActionEvent theE) {
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

        myRightAction = new AbstractAction() {
            @Override
            public void actionPerformed(final ActionEvent theE) {
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

    /**
     *  Sets up the onscreen button logic for N,S,E,W movement of the player throughout
     *  the 2D-dungeon matrix.
     */
    private void setUpGamePlayPanelBtnsActionListeners() {
        myGamePlayPanel.getMyNorthBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent theE) {
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
            public void actionPerformed(final ActionEvent theE) {
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
            public void actionPerformed(final ActionEvent theE) {
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
            public void actionPerformed(final ActionEvent theE) {
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
            final int returnValue = myFileChooser.showSaveDialog(this);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                final File selectedFile = myFileChooser.getSelectedFile();
                System.out.println(myAdventurer.toString());
                try (ObjectOutputStream outputStream =
                             new ObjectOutputStream(new FileOutputStream(selectedFile))) {
                    outputStream.writeObject(myDungeon);
                    outputStream.writeObject(myAdventurer);
                    outputStream.writeObject(myCurrentRoomRow);
                    outputStream.writeObject(myCurrentRoomColumn);
                } catch (final IOException e) {
                    e.printStackTrace();
                }
            }
            changeScreen(MAIN_MENU_PANEL);
            startingNewGameSameWindow();
        });
    }

    /**
     *  Binds the keybinds for WASD and Arrow keys to the onscreen movement buttons for
     *  alternative way to move the hero throughout the game.
     */
    private void bindMovementBtnsToKeyStrokes() {
        myGamePlayPanel.getMyNorthBtn(
                ).getInputMap(
                JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("W"), W_PUSHED);
        myGamePlayPanel.getMyNorthBtn().getActionMap().put(W_PUSHED, myUpAction);
        myGamePlayPanel.getMyNorthBtn(
                ).getInputMap(
                JComponent.WHEN_IN_FOCUSED_WINDOW).put(
                        KeyStroke.getKeyStroke("UP"), UP_PUSHED);
        myGamePlayPanel.getMyNorthBtn().getActionMap().put(UP_PUSHED, myUpAction);

        myGamePlayPanel.getMySouthBtn(
                ).getInputMap(
                JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("S"), S_PUSHED);
        myGamePlayPanel.getMySouthBtn().getActionMap().put(S_PUSHED, myDownAction);
        myGamePlayPanel.getMySouthBtn(
                ).getInputMap(
                JComponent.WHEN_IN_FOCUSED_WINDOW).put(
                        KeyStroke.getKeyStroke("DOWN"), DOWN_PUSHED);
        myGamePlayPanel.getMySouthBtn().getActionMap().put(DOWN_PUSHED, myDownAction);

        myGamePlayPanel.getMyEastBtn(
                ).getInputMap(
                JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("D"), D_PUSHED);
        myGamePlayPanel.getMyEastBtn().getActionMap().put(D_PUSHED, myRightAction);
        myGamePlayPanel.getMyEastBtn(
                ).getInputMap(
                JComponent.WHEN_IN_FOCUSED_WINDOW).put(
                        KeyStroke.getKeyStroke("RIGHT"), RIGHT_PUSHED);
        myGamePlayPanel.getMyEastBtn().getActionMap().put(RIGHT_PUSHED, myRightAction);

        myGamePlayPanel.getMyWestBtn(
                ).getInputMap(
                JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("A"), A_PUSHED);
        myGamePlayPanel.getMyWestBtn().getActionMap().put(A_PUSHED, myLeftAction);
        myGamePlayPanel.getMyWestBtn(
                ).getInputMap(
                JComponent.WHEN_IN_FOCUSED_WINDOW).put(
                        KeyStroke.getKeyStroke("LEFT"), LEFT_PUSHED);
        myGamePlayPanel.getMyWestBtn().getActionMap().put(LEFT_PUSHED, myLeftAction);
    }

    /**
     *  Sets up the onscreen button logic for Attack, Special Attack, and Heal buttons
     *  for the player to utilize when battling a monster within the 2D-dungeon maze.
     */
    private void setUpBattlePanelBtnActionListeners() {
        myBattlePanel.getMyAttackBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent theEvent) {
                myBattlePanel.getMyGameActionText().append("You attacked the monster\n");
                final int monsterDamageTaken = myAdventurer.attack();
                final AbstractMonster roomMonster = myCurrentRoom.getRoomMonster();
                roomMonster.setCharacterHealthPoints(
                        roomMonster.getCharacterHealthPoints() - monsterDamageTaken);
                myBattlePanel.getMyGameActionText().append(
                        "Monster Took " + monsterDamageTaken + " Damage\n");
                myBattlePanel.updateHealthBarForMonster(
                        roomMonster.getCharacterHealthPoints());
                checkIfMonsterHealthIsZero();

                if (roomMonster.getCharacterHealthPoints()
                        <= MONSTERS_MIN_HEALTH_TO_TRY_HEAL) {
                    final int randomChanceToHealSelf = (int) (Math.random() * 100);
                    final int randomPointsHealed = roomMonster.heal();
                    if (randomChanceToHealSelf >= MONSTERS_CHANCE_TO_TRY_HEAL) {
                        myBattlePanel.getMyGameActionText().append(
                                "Wait... Monster Healed Itself!\n");
                        roomMonster.setCharacterHealthPoints(
                                roomMonster.getCharacterHealthPoints() + randomPointsHealed);
                        myBattlePanel.getMyGameActionText().append(
                                "Monster Healed " + randomPointsHealed + " Health Points\n");
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
                    myBattlePanel.getMyGameActionText().append(
                            YOU_DEALT + specialDamage + DAMAGE_TO_THE_MONSTER);
                } else if (myAdventurer.getCharacterName().equals(PRIESTESS)) {
                    myAdventurer.setCharacterHealthPoints(
                            myAdventurer.getCharacterHealthPoints() + specialDamage);
                    myBattlePanel.getMyGameActionText().append(
                            "You Healed Yourself " + specialDamage + " points\n");
                    myBattlePanel.updateHealthBarsForHero(
                            myAdventurer.getCharacterHealthPoints());
                } else if (myAdventurer.getCharacterName().equals(THIEF)) {
                    roomMonster.setCharacterHealthPoints(
                            roomMonster.getCharacterHealthPoints() - specialDamage);
                    myBattlePanel.getMyGameActionText().append(
                            YOU_DEALT + specialDamage + DAMAGE_TO_THE_MONSTER);
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
                    myBattlePanel.getMyGameActionText().append(
                            "You used Heal to gain " + randomHealAmount + " health points.\n");
                    myAdventurer.setCharacterHealthPoints(
                            myAdventurer.getCharacterHealthPoints() + randomHealAmount);
                    myBattlePanel.updateHealthBarsForHero(
                            myAdventurer.getCharacterHealthPoints());
                    myAdventurer.setMyHealingPotions(-1);
                    myBattlePanel.getMyGameActionText().append(
                            "You have " + myAdventurer.getMyHealingPotions()
                                    + " Healing Potions Left.\n");
                } else {
                    myBattlePanel.getMyGameActionText().append(
                            "No potions left to use for healing.\n");

                }
            }
        });

    }

    /** Sets up the onscreen buttons for the Winning and Losing panels of the game. */
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

    /**
     *  Sets up the music controls, the slider and toggle button, to change the
     *  music volume or on and off.
     */
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
                    final FloatControl gainControl =
                            (FloatControl) myMusic.getMyAudioClip().getControl(
                                    FloatControl.Type.MASTER_GAIN);
                    gainControl.setValue(GAIN_CONSTANT * (float) Math.log10(volume));
                }
            }
        });
    }

    /**
     *  Changes the current panel to another panel after proper execution has occurred.
     *
     *  @param theScreen the String value of the panel we want to switch too.
     */
    private void changeScreen(final String theScreen) {
        ((CardLayout) myCardPanel.getLayout()).show(myCardPanel, theScreen);
    }

    /**
     *  Will check the current room to see which doors are available. Rooms without certain
     *  doors will be greyed out preventing the user from going out of bounds of the dungeon.
     *
     * @param theCurrRow the current row position in the 2D-Dungeon
     * @param theCurrColumn the current column position in the 2D-dungeon
     */
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

    /**
     *  Will check the room for certain ground items (healing potion or Pillar), player will
     *  automatically pick up when walking in the room. Further, if the room has pit,
     *  the player will take damage.
     */
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

    /**
     *  Checks the room to see if a monster is in there. If so, the battle will commence and
     *  the panel will change
     */
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

    /**
     *  Checks to see if the monsters health is zero. If so, the player beat the monster
     *  and player returns back to main game panel.
     */
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

    /**
     *  Checks to see if the players health is zero. If so, player is dead and player is
     *  sent to the game over panel.
     */
    private void checkIfAdventurerHealthIsZero() {
        if (myAdventurer.getCharacterHealthPoints() <= 0) {
            JOptionPane.showMessageDialog(myBattlePanel, "You have Died a painful death!");
            startingNewGameSameWindow();
            changeScreen(GAME_OVER_PANEL);
        }
    }

    /**
     *  When the player has found the exit, a prompt will tell a player they've either
     *  found the exit and need to find all the keys to be able to escape, or if all
     *  keys found, will ask them if they want to continue exploring or exit now.
     */
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

    /**
     *  The logic in which the monster attacks the hero after the hero attacks. The hero
     *  has a random chance at blocking the monsters hit, however if not successful, the
     *  player will take damage.
     */
    private void monsterAttacksHero(final AbstractMonster theMonster) {
        if (theMonster != null) {
            myBattlePanel.getMyGameActionText().append("Monsters Turn To Attack\n");

            final double randomChanceToBlock = (int) (Math.random() * 100) / 100.0;
            if (randomChanceToBlock >= (1 - myAdventurer.getChanceToHit())) {
                myBattlePanel.getMyGameActionText().append(
                        "You Blocked the Monsters Attack Successfully! No Damage Taken.\n");

            } else {
                myBattlePanel.getMyGameActionText().append(
                        "You failed to Block the Monsters Attack.\n");

                final int monsterAttackAmount = myCurrentRoom.getRoomMonster().attack();
                myAdventurer.setCharacterHealthPoints(
                        myAdventurer.getCharacterHealthPoints() - monsterAttackAmount);
                myBattlePanel.getMyGameActionText().append(
                        "You took " + monsterAttackAmount + " Points of Damage\n");
                myBattlePanel.updateHealthBarsForHero(
                        myAdventurer.getCharacterHealthPoints());
                checkIfMonsterHealthIsZero();
                checkIfAdventurerHealthIsZero();
            }
        }
    }

    /**
     *  When the player wins/loses after returning to the main screen or wanting to play
     *  again, a new dungeon is generated and old character sprites are cleared in the event
     *  the player wants to choose another character to try.
     */
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
