package views;

import javax.swing.*;
import java.awt.*;
import java.nio.channels.OverlappingFileLockException;

public class CharacterSelectionPanel extends JPanel {

    /** . */
    private String[] myHeroChoices = {"Warrior", "Priestess", "Thief"};

    /** . */
    private JComboBox myHeroOptions = new JComboBox(myHeroChoices);

    private JLabel myLab = new JLabel("Test Label");

    /** . */
    final ImageIcon myMainMenuBGImg = new ImageIcon("src/imgs/MainMenuBG_Image.jpg");

    /** . */
    final JLabel myNewGameBGLabel = new JLabel(myMainMenuBGImg);

    /** . */
    final JPanel myTransHoldingPanel = new JPanel();

    public CharacterSelectionPanel() {
        this.setLayout(new OverlayLayout(this));
        this.add(myNewGameBGLabel);

        myNewGameBGLabel.setLayout(null);


        myTransHoldingPanel.setLayout(null);
        myTransHoldingPanel.setBackground(new Color(128,128,128, 80));

        myTransHoldingPanel.setPreferredSize(new Dimension(200, 100));
        myTransHoldingPanel.setBounds(440,200,410,300);

        myHeroOptions.setBounds(250,50,150,20);

        myTransHoldingPanel.add(myHeroOptions);
        myNewGameBGLabel.add(myTransHoldingPanel);


    }





}
