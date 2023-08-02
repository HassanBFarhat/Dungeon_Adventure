package views;

import javax.swing.*;
import java.awt.*;

public class BattlePanel extends JPanel {

    // constants



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
    private JTextArea myGameActionConsole;

    // constructor

    /** . */
    public BattlePanel() {
        instantiateInstanceDataFields();
        setUpThisPanelsLayoutAndAddBGImg();

        myGameActionConsole.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        myGameActionConsole.setBounds(95,530,800,120);
        myGameActionConsole.setEditable(false);

        myAttackBtn.setBounds(945, 550, 120,50);
        mySpecialAttackBtn.setBounds(1065, 550, 120,50);
        myHealBtn.setBounds(945, 600, 240,50);



        myHeroImgLabel.setBounds(220,270,200,200);

        myMonsterImgLabel.setBounds(670,25,200,200);

        myHeroHealthBar.setValue(100);
        myHeroHealthBar.setBounds(410, 350, 250, 20);
        myHeroHealthBar.setForeground(Color.RED);
        myHeroHealthBar.setBackground(Color.GRAY);
        myHeroHealthBar.setString("Hero Health");
        myHeroHealthBar.setStringPainted(true);

        myMonstersHealthBar.setValue(100);
        myMonstersHealthBar.setBounds(410, 100, 250, 20);
        myMonstersHealthBar.setForeground(Color.RED);
        myMonstersHealthBar.setBackground(Color.GRAY);
        myMonstersHealthBar.setString("Monster Health");
        myMonstersHealthBar.setStringPainted(true);





        myBattleBGImgLabel.add(myAttackBtn);
        myBattleBGImgLabel.add(mySpecialAttackBtn);
        myBattleBGImgLabel.add(myHealBtn);
        myBattleBGImgLabel.add(myGameActionConsole);
        myBattleBGImgLabel.add(myHeroImgLabel);
        myBattleBGImgLabel.add(myMonsterImgLabel);
        myBattleBGImgLabel.add(myHeroHealthBar);
        myBattleBGImgLabel.add(myMonstersHealthBar);



    }


    // methods

    /** . */
    private void instantiateInstanceDataFields() {
        final ImageIcon monsterImg = new ImageIcon("src/imgs/MONSTER_TEST_SPRITE.jpg");
        final ImageIcon heroImg = new ImageIcon("src/imgs/TEST_HERO_SPRITE3.jpg");
        final ImageIcon battleBGImg = new ImageIcon("src/imgs/BattleFieldImg1.png");
        myMonsterImgLabel = new JLabel(monsterImg);
        myHeroImgLabel = new JLabel(heroImg);
        myBattleBGImgLabel = new JLabel(battleBGImg);
        myAttackBtn = new JButton("Attack");
        mySpecialAttackBtn = new JButton("Special Attack");
        myHealBtn = new JButton("Heal");
        myMonstersHealthBar = new JProgressBar(0, 100);
        myHeroHealthBar = new JProgressBar(0, 100);
        myGameActionConsole = new JTextArea();
    }

    /** . */
    private void setUpThisPanelsLayoutAndAddBGImg() {
        this.setLayout(new OverlayLayout(this));
        this.add(myBattleBGImgLabel);
    }


}
