package views;

import java.awt.Color;
import java.awt.Font;
import java.io.Serial;
import java.io.Serializable;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.OverlayLayout;
import models.AbstractMonster;
import models.Adventurer;

/**
 *
 * @author Hassan Bassam Farhat
 * @version Summer 2023
 */
public class BattlePanel extends JPanel implements Serializable {

    @Serial
    private static final long serialVersionUID = -4498408607411363508L;

    // constants

    /** . */
    private static final int ACTION_CONSOLE_WIDTH = 800;
    /** . */
    private static final int ACTION_CONSOLE_HEIGHT = 120;
    /** . */
    private static final int ACTION_CONSOLE_X_COORDINATE = 50;
    /** . */
    private static final int ACTION_CONSOLE_Y_COORDINATE = 530;
    /** . */
    private static final int HERO_AND_MONSTER_WIDTH = 300;
    /** . */
    private static final int HERO_AND_MONSTER_HEIGHT = 326;
    /** . */
    private static final int HERO_X_COORDINATE = 150;
    /** . */
    private static final int HERO_Y_COORDINATE = 200;
    /** . */
    private static final int MONSTER_X_COORDINATE = 730;
    /** . */
    private static final int MONSTER_Y_COORDINATE = 25;
    /** . */
    private static final int HERO_AND_MONSTER_HEALTH_BAR_WIDTH = 250;
    /** . */
    private static final int HERO_AND_MONSTER_HEALTH_BAR_HEIGHT = 26;
    /** . */
    private static final int HERO_HEALTH_BAR_X_COORDINATE = 400;
    /** . */
    private static final int HERO_HEALTH_BAR_Y_COORDINATE = 350;
    /** . */
    private static final int MONSTER_HEALTH_BAR_X_COORDINATE = 490;
    /** . */
    private static final int MONSTER_HEALTH_BAR_Y_COORDINATE = 180;
    /** . */
    private static final int ALL_BUTTONS_WIDTH = 170;
    /** . */
    private static final int ALL_BUTTONS_HEIGHT = 50;
    /** . */
    private static final int ATTACK_AND_HEAL_BUTTON_X_COORDINATE = 880;
    /** . */
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
    private JButton myBlockBtn;
    /** . */
    private JTextArea myGameActionConsole;
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
        final ImageIcon heroImg = new ImageIcon(myAdventurer.getAdventurerBattleImgFilePath());
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
    public JButton getMyBlockBtn() {
        return myBlockBtn;
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
        myHeroHealthBar.setMaximum(theAdventurer.getCharacterHealthPoints());
    }

    /** . */
    public void updateHealthBarForMonster(final int theNewMonsterStats) {
        myMonstersHealthBar.setValue(theNewMonsterStats);
        System.out.println(myMonstersHealthBar.getValue());
    }

    /** . */
    public void updateHealthBarsForHero(final int theNewHeroStats) {
        myHeroHealthBar.setValue(theNewHeroStats);
    }

    /** . */
    public JLabel getMyMonsterImgLabel() {
        return myMonsterImgLabel;
    }


    // private methods

    /** . */
    private void instantiateInstanceDataFields() {
        final ImageIcon battleBGImg = new ImageIcon("src/imgs/BattleFieldImg1.png");
        myBattleBGImgLabel = new JLabel(battleBGImg);
        myAttackBtn = new JButton("Attack");
        mySpecialAttackBtn = new JButton("Special Attack");
        myHealBtn = new JButton("Heal");
        myBlockBtn = new JButton("Block");
        myMonstersHealthBar = new JProgressBar();
        myHeroHealthBar = new JProgressBar();
        myGameActionConsole = new JTextArea();
    }

    /** . */
    private void setUpThisPanelsLayoutAndAddBGImg() {
        this.setLayout(new OverlayLayout(this));
        this.add(myBattleBGImgLabel);
    }

    /** . */
    private void setUpBorderAndBoundsForActionConsole() {
        myGameActionConsole.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        myGameActionConsole.setBounds(ACTION_CONSOLE_X_COORDINATE,
                                      ACTION_CONSOLE_Y_COORDINATE,
                                      ACTION_CONSOLE_WIDTH,
                                      ACTION_CONSOLE_HEIGHT);
        myGameActionConsole.setEditable(false);
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
                            ALL_BUTTONS_WIDTH,
                            ALL_BUTTONS_HEIGHT);
        myHealBtn.setFont(new Font(FONT_CHOICE, Font.BOLD, BUTTON_TEXT_SIZE));
        myBlockBtn.setBounds(SPECIAL_ATTACK_AND_BLOCK_BUTTON_X_COORDINATE,
                             HEAL_AND_BLOCK_BUTTON_Y_COORDINATE,
                             ALL_BUTTONS_WIDTH,
                             ALL_BUTTONS_HEIGHT);
        myBlockBtn.setFont(new Font(FONT_CHOICE, Font.BOLD, BUTTON_TEXT_SIZE));

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
        myBattleBGImgLabel.add(myBlockBtn);
        myBattleBGImgLabel.add(myGameActionConsole);
        myBattleBGImgLabel.add(myHeroHealthBar);
        myBattleBGImgLabel.add(myMonstersHealthBar);
    }

}
