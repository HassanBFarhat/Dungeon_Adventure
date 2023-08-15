package views;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;

import models.AbstractMonster;
import models.Adventurer;

/**
 *
 * @author Hassan Bassam Farhat
 * @author Avinash Bavisetty
 * @version Summer 2023
 */
public class BattlePanel extends JPanel {

    // constants

    /** width of the action console. */
    private static final int ACTION_CONSOLE_WIDTH = 800;

    /** Height of the action console .*/
    private static final int ACTION_CONSOLE_HEIGHT = 120;

    /** X coordinate of the Action console. */
    private static final int ACTION_CONSOLE_X_COORDINATE = 50;

    /** Y coordinate of the Action console. */
    private static final int ACTION_CONSOLE_Y_COORDINATE = 530;

    /** Width of the monsters and heroes on screen. */
    private static final int HERO_AND_MONSTER_WIDTH = 300;

    /** Height of the monsters and heroes on screen. */
    private static final int HERO_AND_MONSTER_HEIGHT = 326;

    /** X coordinate of the Hero on screen. */
    private static final int HERO_X_COORDINATE = 150;

    /** Y coordinate of the Hero on screen. */
    private static final int HERO_Y_COORDINATE = 200;

    /** X coordinate of the Monster on screen. */
    private static final int MONSTER_X_COORDINATE = 730;

    /** Y coordinate of the Monster on screen. */
    private static final int MONSTER_Y_COORDINATE = 25;

    /** Width of the Health Bar. */
    private static final int HERO_AND_MONSTER_HEALTH_BAR_WIDTH = 250;

    /** Height of the Health Bar. */
    private static final int HERO_AND_MONSTER_HEALTH_BAR_HEIGHT = 26;

    /** X Coordinate of the Hero Health Bar. */
    private static final int HERO_HEALTH_BAR_X_COORDINATE = 400;

    /** Y Coordinate of the Hero Health Bar. */
    private static final int HERO_HEALTH_BAR_Y_COORDINATE = 350;

    /** X coordinate of Monster Health Bar. */
    private static final int MONSTER_HEALTH_BAR_X_COORDINATE = 490;

    /** Y coordinate of Monster Health Bar. */
    private static final int MONSTER_HEALTH_BAR_Y_COORDINATE = 180;

    /** All the buttons width on the screen. */
    private static final int ALL_BUTTONS_WIDTH = 170;

    /** All the buttons height on the screen. */
    private static final int ALL_BUTTONS_HEIGHT = 50;

    /** Attack and Healh button X coordinate. */
    private static final int ATTACK_AND_HEAL_BUTTON_X_COORDINATE = 880;

    /** Attack and Healh button Y coordinate. */
    private static final int ATTACK_AND_SPECIAL_ATTACK_Y_COORDINATE = 550;

    /** X coordinate of Special Attack and Block Button. */
    private static final int SPECIAL_ATTACK_AND_BLOCK_BUTTON_X_COORDINATE = 1050;

    /** Y coordinate of Special Attack and Block Button. */
    private static final int HEAL_AND_BLOCK_BUTTON_Y_COORDINATE = 600;

    /** Text size of Button. */
    private static final int BUTTON_TEXT_SIZE = 30;

    /** Healthbar text size. */
    private static final int HEALTHBARS_TEXT_SIZE = 23;

    /** Choice of Font. */
    private static final String FONT_CHOICE = "Freestyle Script";


    // instance fields

    /** Monster image. */
    private JLabel myMonsterImgLabel;

    /** Hero Image. */
    private JLabel myHeroImgLabel;

    /** Battle background. */
    private JLabel myBattleBGImgLabel;

    /** Monster's Health Bar. */
    private JProgressBar myMonstersHealthBar;

    /** Hero's Health Bar. */
    private JProgressBar myHeroHealthBar;

    /** Attack Button. */
    private JButton myAttackBtn;

    /** Special Attack Button. */
    private JButton mySpecialAttackBtn;

    /** Health Button. */
    private JButton myHealBtn;

    /** Text for Game Action. */
    private JTextArea myGameActionText;

    /** Game console that you can scroll through. */
    private JScrollPane myGameScrollConsole;

    /** Monster that is in the current room.  */
    private AbstractMonster myCurrentRoomMonster;

    /** Current Adventurer character that has been created. */
    private Adventurer myAdventurer;


    // constructor

    /** sets up the battlepanel as well as the components required for the battle in the
     * game to work . */
    public BattlePanel() {
        instantiateInstanceDataFields();
        setUpThisPanelsLayoutAndAddBGImg();
        setUpBorderAndBoundsForActionConsole();
        setUpAttackSpecialAttackAndHealButtonBounds();
        setUpHeroAndMonsterHealthBars();
        addAllTheComponentsToBattleBGLabel();
    }


    // methods

    /** Adds both monsters and heroes to the battle screen. */
    public void addBothCharactersToBattlePanel() {
        final ImageIcon monsterImg =
                new ImageIcon(myCurrentRoomMonster.getMonsterBattleImgFilePath());
        final ImageIcon heroImg = new ImageIcon(myAdventurer.getAdventurerMainImgFilePath());
        myMonsterImgLabel = new JLabel(monsterImg);
        myHeroImgLabel = new JLabel(heroImg);
        myBattleBGImgLabel.add(myHeroImgLabel);
        myBattleBGImgLabel.add(myMonsterImgLabel);
        setUpHeroAndMonsterBGLabelBounds();
    }

    /** gets the attack button. */
    public JButton getMyAttackBtn() {
        return myAttackBtn;
    }

    /** gets the special attack button. */
    public JButton getMySpecialAttackBtn() {
        return mySpecialAttackBtn;
    }

    /** gest the heal button. */
    public JButton getMyHealBtn() {
        return myHealBtn;
    }

    /** gets the game action text. */
    public JTextArea getMyGameActionText() {
        return myGameActionText;
    }

    /** sets the current monster in the battle. */
    public void setCurrentRoomMonster(final AbstractMonster theMonster) {
        myCurrentRoomMonster = theMonster;
    }

    /** sets the adventurer in the battle screen. */
    public void setAdventurer(final Adventurer theAdventurer) {
        myAdventurer = theAdventurer;
    }

    /** sets up the health bars for the hero and the monster. */
    public void setUpHealthBarsForHeroAndMonster(final Adventurer theAdventurer,
                                                 final AbstractMonster theMonster) {
        myHeroHealthBar.setValue(theAdventurer.getCharacterHealthPoints());
        myMonstersHealthBar.setValue(theMonster.getCharacterHealthPoints());
    }

    /** initializes the minimum and maximum amount of health points available in
     * health bar . */
    public void initializeHeroBattleHealthBarMaxMin(final Adventurer theAdventurer) {
        myHeroHealthBar.setMaximum(0);
        myHeroHealthBar.setMaximum(theAdventurer.getCharacterHitPoints());
    }

    /** Updates Health Bar for Monster whether it be for healing or taking damage. */
    public void updateHealthBarForMonster(final int theNewMonsterStats) {
        myMonstersHealthBar.setValue(theNewMonsterStats);
    }

    /** Updates Health Bar for Hero whether it be for healing or taking damage. */
    public void updateHealthBarsForHero(final int theNewHeroStats) {
        myHeroHealthBar.setValue(theNewHeroStats);
    }

    /** Gets image for Monster. */
    public JLabel getMyMonsterImgLabel() {
        return myMonsterImgLabel;
    }

    /** Gets image for the current Adventurer. */
    public JLabel getMyAdventurerImgLabel() {
        return myHeroImgLabel;
    }

    // private methods

    /** instantiating data fields required for battles in dungeon. */
    private void instantiateInstanceDataFields() {
        final ImageIcon battleBGImg = new ImageIcon("src/imgs/BattleFieldImg1.png");
        myBattleBGImgLabel = new JLabel(battleBGImg);
        myAttackBtn = new JButton("Attack");
        mySpecialAttackBtn = new JButton("Special Attack");
        myHealBtn = new JButton("Heal");
        myMonstersHealthBar = new JProgressBar();
        myHeroHealthBar = new JProgressBar();
        myGameActionText = new JTextArea();
        myGameScrollConsole = new JScrollPane(myGameActionText);
    }

    /** sets the layout in the game and allows for proper implementation of
     * backgrounds in the game. */
    private void setUpThisPanelsLayoutAndAddBGImg() {
        this.setLayout(new OverlayLayout(this));
        this.add(myBattleBGImgLabel);
    }

    /** Sets the height and width of the Action Console as well as where its supposed
     * to be located at. */
    private void setUpBorderAndBoundsForActionConsole() {
        myGameScrollConsole.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        myGameScrollConsole.setBounds(ACTION_CONSOLE_X_COORDINATE,
                                      ACTION_CONSOLE_Y_COORDINATE,
                                      ACTION_CONSOLE_WIDTH,
                                      ACTION_CONSOLE_HEIGHT);
        myGameActionText.setFont(new Font(FONT_CHOICE, Font.BOLD, 25));
        myGameActionText.setLineWrap(true);
        myGameActionText.setEditable(false);
    }

    /** sets the bounds for the hero and Monster backgrounds in the game. */
    private void setUpHeroAndMonsterBGLabelBounds() {
        myHeroImgLabel.setBounds(HERO_X_COORDINATE, HERO_Y_COORDINATE,
                                 HERO_AND_MONSTER_WIDTH, HERO_AND_MONSTER_HEIGHT);
        myMonsterImgLabel.setBounds(MONSTER_X_COORDINATE, MONSTER_Y_COORDINATE,
                                    HERO_AND_MONSTER_WIDTH, HERO_AND_MONSTER_HEIGHT);
    }

    /** Provides Buttons for Special Attack and Heal Button on screen. */
    private void setUpAttackSpecialAttackAndHealButtonBounds() {
        myAttackBtn.setBounds(ATTACK_AND_HEAL_BUTTON_X_COORDINATE,
                              ATTACK_AND_SPECIAL_ATTACK_Y_COORDINATE,
                              ALL_BUTTONS_WIDTH,
                              ALL_BUTTONS_HEIGHT);
        myAttackBtn.setFont(new Font(FONT_CHOICE, Font.BOLD, BUTTON_TEXT_SIZE));
        mySpecialAttackBtn.setBounds(SPECIAL_ATTACK_AND_BLOCK_BUTTON_X_COORDINATE,
                                     ATTACK_AND_SPECIAL_ATTACK_Y_COORDINATE,
                                     ALL_BUTTONS_WIDTH,
                                     ALL_BUTTONS_HEIGHT);
        mySpecialAttackBtn.setFont(new Font(FONT_CHOICE, Font.BOLD, BUTTON_TEXT_SIZE));
        myHealBtn.setBounds(ATTACK_AND_HEAL_BUTTON_X_COORDINATE,
                            HEAL_AND_BLOCK_BUTTON_Y_COORDINATE,
                            340,
                            ALL_BUTTONS_HEIGHT);
        myHealBtn.setFont(new Font(FONT_CHOICE, Font.BOLD, BUTTON_TEXT_SIZE));
    }

    /** Sets the health bars visually for Monster and Hero in the game. */
    private void setUpHeroAndMonsterHealthBars() {
        myHeroHealthBar.setBounds(HERO_HEALTH_BAR_X_COORDINATE,
                                  HERO_HEALTH_BAR_Y_COORDINATE,
                                  HERO_AND_MONSTER_HEALTH_BAR_WIDTH,
                                  HERO_AND_MONSTER_HEALTH_BAR_HEIGHT);
        myHeroHealthBar.setFont(new Font(FONT_CHOICE, Font.BOLD, HEALTHBARS_TEXT_SIZE));
        myHeroHealthBar.setForeground(Color.RED);
        myHeroHealthBar.setBackground(Color.GRAY);
        myHeroHealthBar.setString("Hero Health");
        myHeroHealthBar.setStringPainted(true);

        myMonstersHealthBar.setBounds(MONSTER_HEALTH_BAR_X_COORDINATE,
                                      MONSTER_HEALTH_BAR_Y_COORDINATE,
                                      HERO_AND_MONSTER_HEALTH_BAR_WIDTH,
                                      HERO_AND_MONSTER_HEALTH_BAR_HEIGHT);
        myMonstersHealthBar.setFont(new Font(FONT_CHOICE, Font.BOLD, HEALTHBARS_TEXT_SIZE));
        myMonstersHealthBar.setForeground(Color.RED);
        myMonstersHealthBar.setBackground(Color.GRAY);
        myMonstersHealthBar.setString("Monster Health");
        myMonstersHealthBar.setStringPainted(true);
    }

    /** Adds the required buttons that are available for use during Battle between Hero and Monster. */
    private void addAllTheComponentsToBattleBGLabel() {
        myBattleBGImgLabel.add(myAttackBtn);
        myBattleBGImgLabel.add(mySpecialAttackBtn);
        myBattleBGImgLabel.add(myHealBtn);
        myBattleBGImgLabel.add(myGameScrollConsole);
        myBattleBGImgLabel.add(myHeroHealthBar);
        myBattleBGImgLabel.add(myMonstersHealthBar);
    }

}
