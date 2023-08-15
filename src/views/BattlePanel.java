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

    /** . */
    private static final int SPECIAL_ATTACK_AND_BLOCK_BUTTON_X_COORDINATE = 1050;
    /** . */
    private static final int HEAL_AND_BLOCK_BUTTON_Y_COORDINATE = 600;
    /** . */
    private static final int BUTTON_TEXT_SIZE = 30;
    /** . */
    private static final int HEALTHBARS_TEXT_SIZE = 23;
    /** . */
    private static final String FONT_CHOICE = "Freestyle Script";


    // instance fields

    /** . */
    private JLabel myMonsterImgLabel;
    /** . */
    private JLabel myHeroImgLabel;
    /** . */
    private JLabel myBattleBGImgLabel;
    /** . */
    private JProgressBar myMonstersHealthBar;
    /** . */
    private JProgressBar myHeroHealthBar;
    /** . */
    private JButton myAttackBtn;
    /** . */
    private JButton mySpecialAttackBtn;
    /** . */
    private JButton myHealBtn;
    /** . */
    private JTextArea myGameActionText;
    /** . */
    private JScrollPane myGameScrollConsole;
    /** . */
    private AbstractMonster myCurrentRoomMonster;
    /** . */
    private Adventurer myAdventurer;


    // constructor

    /** . */
    public BattlePanel() {
        instantiateInstanceDataFields();
        setUpThisPanelsLayoutAndAddBGImg();
        setUpBorderAndBoundsForActionConsole();
        setUpAttackSpecialAttackAndHealButtonBounds();
        setUpHeroAndMonsterHealthBars();
        addAllTheComponentsToBattleBGLabel();
    }


    // methods

    /** . */
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

    /** . */
    public JButton getMyAttackBtn() {
        return myAttackBtn;
    }

    /** . */
    public JButton getMySpecialAttackBtn() {
        return mySpecialAttackBtn;
    }

    /** . */
    public JButton getMyHealBtn() {
        return myHealBtn;
    }

    /** . */
    public JTextArea getMyGameActionText() {
        return myGameActionText;
    }

    /** . */
    public void setCurrentRoomMonster(final AbstractMonster theMonster) {
        myCurrentRoomMonster = theMonster;
    }

    /** . */
    public void setAdventurer(final Adventurer theAdventurer) {
        myAdventurer = theAdventurer;
    }

    /** . */
    public void setUpHealthBarsForHeroAndMonster(final Adventurer theAdventurer,
                                                 final AbstractMonster theMonster) {
        myHeroHealthBar.setValue(theAdventurer.getCharacterHealthPoints());
        myMonstersHealthBar.setValue(theMonster.getCharacterHealthPoints());
    }

    /** . */
    public void initializeHeroBattleHealthBarMaxMin(final Adventurer theAdventurer) {
        myHeroHealthBar.setMaximum(0);
        myHeroHealthBar.setMaximum(theAdventurer.getCharacterHitPoints());
    }

    /** . */
    public void updateHealthBarForMonster(final int theNewMonsterStats) {
        myMonstersHealthBar.setValue(theNewMonsterStats);
    }

    /** . */
    public void updateHealthBarsForHero(final int theNewHeroStats) {
        myHeroHealthBar.setValue(theNewHeroStats);
    }

    /** . */
    public JLabel getMyMonsterImgLabel() {
        return myMonsterImgLabel;
    }

    /** . */
    public JLabel getMyAdventurerImgLabel() {
        return myHeroImgLabel;
    }

    // private methods

    /** . */
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

    /** . */
    private void setUpThisPanelsLayoutAndAddBGImg() {
        this.setLayout(new OverlayLayout(this));
        this.add(myBattleBGImgLabel);
    }

    /** . */
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

    /** . */
    private void setUpHeroAndMonsterBGLabelBounds() {
        myHeroImgLabel.setBounds(HERO_X_COORDINATE, HERO_Y_COORDINATE,
                                 HERO_AND_MONSTER_WIDTH, HERO_AND_MONSTER_HEIGHT);
        myMonsterImgLabel.setBounds(MONSTER_X_COORDINATE, MONSTER_Y_COORDINATE,
                                    HERO_AND_MONSTER_WIDTH, HERO_AND_MONSTER_HEIGHT);
    }

    /** . */
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

    /** . */
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

    /** . */
    private void addAllTheComponentsToBattleBGLabel() {
        myBattleBGImgLabel.add(myAttackBtn);
        myBattleBGImgLabel.add(mySpecialAttackBtn);
        myBattleBGImgLabel.add(myHealBtn);
        myBattleBGImgLabel.add(myGameScrollConsole);
        myBattleBGImgLabel.add(myHeroHealthBar);
        myBattleBGImgLabel.add(myMonstersHealthBar);
    }

}
