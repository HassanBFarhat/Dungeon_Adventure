package views;

import javax.swing.*;
import java.awt.*;

public class CharacterSelectionPanel extends JPanel {


    /** . */
    private String[] myHeroChoices = {"Warrior", "Priestess", "Thief"};

    /** . */
    private JComboBox myHeroOptions = new JComboBox(myHeroChoices);

    /** . */
    private String[] myDifficultyChoices = {"Easy", "Medium", "Hard"};

    /** . */
    private JComboBox myDifficultyOptions = new JComboBox(myDifficultyChoices);


    /** . */
    final ImageIcon myMainMenuBGImg = new ImageIcon("src/imgs/MainMenuBG_Image.jpg");

    /** . */
    final JLabel myNewGameBGLabel = new JLabel(myMainMenuBGImg);

    /** . */
    final JPanel myTransparentHoldingPanel = new JPanel();


    /** . */
    final JButton myBackBtn = new JButton("Back");

    /** . */
    final JButton myStartGameBtn = new JButton("Begin your Adventure");

    /** . */
    final JLabel myCharacterSelectionText = new JLabel("Choose your Hero: ");

    /** . */
    final JLabel myCharacterNameText = new JLabel("Name of your Hero: ");

    /** . */
    final JTextField myCharacterNameTextBox = new JTextField();

    /** . */
    final JLabel myChooseDifficultyText = new JLabel("Choose the Difficulty: ");

    public CharacterSelectionPanel() {
        this.setLayout(new OverlayLayout(this));
        this.add(myNewGameBGLabel);

        myNewGameBGLabel.setLayout(null);


        myTransparentHoldingPanel.setLayout(null);
        myTransparentHoldingPanel.setBackground(new Color(128,128,128, 80));
        myTransparentHoldingPanel.setBounds(440,200,410,300);

        myCharacterNameText.setFont(new Font("Arial", Font.BOLD, 15));
        myCharacterNameText.setForeground(Color.WHITE);
        myCharacterNameText.setBounds(49, 50, 150, 20);
        myCharacterNameTextBox.setBounds(210, 50, 150, 20);

        myCharacterSelectionText.setFont(new Font("Arial", Font.BOLD, 15));
        myCharacterSelectionText.setForeground(Color.WHITE);
        myCharacterSelectionText.setBounds(50, 100, 150, 20);
        myHeroOptions.setBounds(210,100,150,20);

        myChooseDifficultyText.setFont(new Font("Arial", Font.BOLD, 15));
        myChooseDifficultyText.setForeground(Color.WHITE);
        myChooseDifficultyText.setBounds(43, 150, 160, 20);
        myDifficultyOptions.setBounds(210, 150, 150, 20);

        myBackBtn.setBounds(50, 230, 155, 20);
        myStartGameBtn.setBounds(210, 230, 155, 20);

        myTransparentHoldingPanel.add(myCharacterNameText);
        myTransparentHoldingPanel.add(myCharacterNameTextBox);
        myTransparentHoldingPanel.add(myCharacterSelectionText);
        myTransparentHoldingPanel.add(myHeroOptions);
        myTransparentHoldingPanel.add(myChooseDifficultyText);
        myTransparentHoldingPanel.add(myDifficultyOptions);
        myTransparentHoldingPanel.add(myBackBtn);
        myTransparentHoldingPanel.add(myStartGameBtn);

        myNewGameBGLabel.add(myTransparentHoldingPanel);


    }





}
