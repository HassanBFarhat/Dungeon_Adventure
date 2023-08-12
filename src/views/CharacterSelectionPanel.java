package views;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.OverlayLayout;

public class CharacterSelectionPanel extends JPanel {

    // constants

    /** . */
    private static final String LABEL_FONT_STYLE = "Freestyle Script";
    /** . */
    private static final int LABEL_FONT_SIZE = 30;
    /** . */
    private static final int LABEL_HEIGHT = 30;
    /** . */
    private static final int NAME_CHARACTER_LABEL_WIDTH = 150;
    /** . */
    private static final int SELECT_CHARACTER_LABEL_WIDTH = 160;
    /** . */
    private static final int CHOOSE_DIFFICULTY_LABEL_WIDTH = 170;
    /** . */
    private static final int NAME_CHARACTER_LABEL_X_AXIS = 50;
    /** . */
    private static final int SELECT_CHARACTER_LABEL_X_AXIS = 50;
    /** . */
    private static final int CHOOSE_DIFFICULTY_LABEL_X_AXIS = 50;
    /** . */
    private static final int NAME_CHARACTER_LABEL_AND_TEXT_BOX_Y_AXIS = 50;
    /** . */
    private static final int SELECT_CHARACTER_LABEL_AND_COMBO_BOX_Y_AXIS = 105;
    /** . */
    private static final int CHOOSE_DIFFICULTY_LABEL_AND_COMBO_BOX_Y_AXIS = 155;
    /** . */
    private static final int COMBO_BOX_AND_TEXT_BOX_X_AXIS = 230;
    /** . */
    private static final int COMBO_BOX_AND_TEXT_BOX_WIDTH = 150;
    /** . */
    private static final int COMBO_BOX_AND_TEXT_BOX_HEIGHT = 25;
    /** . */
    private static final Color GRAY_TRANSPARENT_COLOR = new Color(128, 128, 128, 80);
    /** . */
    private static final int TRANSPARENT_PANEL_X_AXIS = 440;
    /** . */
    private static final int TRANSPARENT_PANEL_Y_AXIS = 200;
    /** . */
    private static final int TRANSPARENT_PANEL_WIDTH = 410;
    /** . */
    private static final int TRANSPARENT_PANEL_HEIGHT = 300;
    /** . */
    private static final int BACK_BUTTON_X_AXIS = 50;
    /** . */
    private static final int START_GAME_BUTTON_X_AXIS = 210;
    /** . */
    private static final int ALL_BUTTONS_Y_AXIS = 230;
    /** . */
    private static final int ALL_BUTTONS_WIDTH = 155;
    /** . */
    private static final int ALL_BUTTONS_HEIGHT = 30;
    /** . */
    private static final int BACK_AND_START_BTN_AND_CHARACTER_TEXT = 25;
    /** . */
    private static final int HERO_AND_DIFFICULTY_TEXT_SIZE = 24;
    /** . */
    private static final int CHARACTER_Y_AXIS = 60;
    /** . */
    private static final int HERO_DROPDOWN_Y_AXIS = 110;
    /** . */
    private static final int DIFFICULTY_DROPDOWN_Y_AXIS = 160;

    // instance fields

    /** . */
    private JLabel mySelectCharacterLabel;
    /** . */
    private JComboBox myHeroOptionsDropDownBox;
    /** . */
    private JLabel myNameYourCharacterLabel;
    /** . */
    private JTextField myNameYourCharacterTextBox;
    /** . */
    private JLabel myChooseDifficultyLabel;
    /** . */
    private JComboBox myDifficultyOptionsDropDownBox;
    /** . */
    private JPanel myTransparentComponentHoldingPanel;
    /** . */
    private JLabel myNewGameBGLabel;
    /** . */
    private JButton myBackBtn;
    /** . */
    private JButton myStartGameBtn;


    // constructor

    public CharacterSelectionPanel() {
        instantiateInstanceDataFields();
        setUpThisPanelsLayoutAndAddBGImg();
        setUpAllLabelsStyleAndBounds();
        addAllDropDownBoxAndTextBoxToTransparentPanel();
        setUpAllButtonsBounds();
        setUpTransparentPanelStyleAndAddAllComponentsToIt();
        setUpBGPanelStyleAndAddTransparentPanelToIt();
    }


    // methods

    /** . */
    public JButton getMyBackBtn() {
        return myBackBtn;
    }

    /** . */
    public JButton getMyStartGameBtnBtn() {
        return myStartGameBtn;
    }

    /** . */
    public String getCharactersName() {
        return myNameYourCharacterTextBox.getText();
    }

    /** . */
    public String getHeroOptionFromBox() {
        return (String) myHeroOptionsDropDownBox.getSelectedItem();
    }

    /** . */
    public String getGameDifficultyFromBox() {
        return (String) myDifficultyOptionsDropDownBox.getSelectedItem();
    }


    // private methods

    /** . */
    private void instantiateInstanceDataFields() {
        mySelectCharacterLabel = new JLabel("Choose your Hero: ");
        final String[] heroChoices = {"Warrior", "Priestess", "Thief"};
        myHeroOptionsDropDownBox = new JComboBox(heroChoices);
        myNameYourCharacterLabel = new JLabel("Name your Hero: ");
        myNameYourCharacterTextBox = new JTextField();
        myChooseDifficultyLabel = new JLabel("Choose Difficulty: ");
        final String[] difficultyChoices = {"Easy", "Medium", "Hard"};
        myDifficultyOptionsDropDownBox = new JComboBox(difficultyChoices);
        myTransparentComponentHoldingPanel = new JPanel();
        final ImageIcon bgImg = new ImageIcon("src/imgs/MainMenuBG_Image.jpg");
        myNewGameBGLabel = new JLabel(bgImg);
        myBackBtn = new JButton("Back");
        myStartGameBtn = new JButton("Begin Adventure");
    }

    /** . */
    private void setUpThisPanelsLayoutAndAddBGImg() {
        this.setLayout(new OverlayLayout(this));
        this.add(myNewGameBGLabel);
    }

    /** . */
    private void setUpAllLabelsStyleAndBounds() {
        myNameYourCharacterLabel.setFont(
                new Font(LABEL_FONT_STYLE, Font.BOLD, LABEL_FONT_SIZE));
        myNameYourCharacterLabel.setForeground(Color.WHITE);
        myNameYourCharacterLabel.setBounds(NAME_CHARACTER_LABEL_X_AXIS,
                                           NAME_CHARACTER_LABEL_AND_TEXT_BOX_Y_AXIS,
                                           NAME_CHARACTER_LABEL_WIDTH, LABEL_HEIGHT);

        mySelectCharacterLabel.setFont(
                new Font(LABEL_FONT_STYLE, Font.BOLD, LABEL_FONT_SIZE));
        mySelectCharacterLabel.setForeground(Color.WHITE);
        mySelectCharacterLabel.setBounds(SELECT_CHARACTER_LABEL_X_AXIS,
                                         SELECT_CHARACTER_LABEL_AND_COMBO_BOX_Y_AXIS,
                                         SELECT_CHARACTER_LABEL_WIDTH, LABEL_HEIGHT);

        myChooseDifficultyLabel.setFont(
                new Font(LABEL_FONT_STYLE, Font.BOLD, LABEL_FONT_SIZE));
        myChooseDifficultyLabel.setForeground(Color.WHITE);
        myChooseDifficultyLabel.setBounds(CHOOSE_DIFFICULTY_LABEL_X_AXIS,
                                          CHOOSE_DIFFICULTY_LABEL_AND_COMBO_BOX_Y_AXIS,
                                          CHOOSE_DIFFICULTY_LABEL_WIDTH, LABEL_HEIGHT);
    }

    /** . */
    private void addAllDropDownBoxAndTextBoxToTransparentPanel() {
        myNameYourCharacterTextBox.setBounds(COMBO_BOX_AND_TEXT_BOX_X_AXIS,
                                             CHARACTER_Y_AXIS,
                                             COMBO_BOX_AND_TEXT_BOX_WIDTH,
                                             COMBO_BOX_AND_TEXT_BOX_HEIGHT);
        myNameYourCharacterTextBox.setFont(
                new Font(LABEL_FONT_STYLE, Font.BOLD, BACK_AND_START_BTN_AND_CHARACTER_TEXT));
        myHeroOptionsDropDownBox.setBounds(COMBO_BOX_AND_TEXT_BOX_X_AXIS,
                                           HERO_DROPDOWN_Y_AXIS,
                                           COMBO_BOX_AND_TEXT_BOX_WIDTH,
                                           COMBO_BOX_AND_TEXT_BOX_HEIGHT);
        myHeroOptionsDropDownBox.setFont(
                new Font(LABEL_FONT_STYLE, Font.BOLD, HERO_AND_DIFFICULTY_TEXT_SIZE));
        myDifficultyOptionsDropDownBox.setBounds(COMBO_BOX_AND_TEXT_BOX_X_AXIS,
                                                 DIFFICULTY_DROPDOWN_Y_AXIS,
                                                 COMBO_BOX_AND_TEXT_BOX_WIDTH,
                                                 COMBO_BOX_AND_TEXT_BOX_HEIGHT);
        myDifficultyOptionsDropDownBox.setFont(
                new Font(LABEL_FONT_STYLE, Font.BOLD, HERO_AND_DIFFICULTY_TEXT_SIZE));
    }

    /** . */
    private void setUpAllButtonsBounds() {
        myBackBtn.setBounds(BACK_BUTTON_X_AXIS, ALL_BUTTONS_Y_AXIS,
                            ALL_BUTTONS_WIDTH, ALL_BUTTONS_HEIGHT);
        myBackBtn.setFont(
                new Font(LABEL_FONT_STYLE, Font.BOLD, BACK_AND_START_BTN_AND_CHARACTER_TEXT));
        myStartGameBtn.setBounds(START_GAME_BUTTON_X_AXIS, ALL_BUTTONS_Y_AXIS,
                                 ALL_BUTTONS_WIDTH, ALL_BUTTONS_HEIGHT);
        myStartGameBtn.setFont(
                new Font(LABEL_FONT_STYLE, Font.BOLD, BACK_AND_START_BTN_AND_CHARACTER_TEXT));
    }

    /** . */
    private void setUpTransparentPanelStyleAndAddAllComponentsToIt() {
        myTransparentComponentHoldingPanel.setLayout(null);
        myTransparentComponentHoldingPanel.setBackground(GRAY_TRANSPARENT_COLOR);
        myTransparentComponentHoldingPanel.setBounds(TRANSPARENT_PANEL_X_AXIS,
                                                     TRANSPARENT_PANEL_Y_AXIS,
                                                     TRANSPARENT_PANEL_WIDTH,
                                                     TRANSPARENT_PANEL_HEIGHT);
        myTransparentComponentHoldingPanel.add(myNameYourCharacterLabel);
        myTransparentComponentHoldingPanel.add(myNameYourCharacterTextBox);
        myTransparentComponentHoldingPanel.add(mySelectCharacterLabel);
        myTransparentComponentHoldingPanel.add(myHeroOptionsDropDownBox);
        myTransparentComponentHoldingPanel.add(myChooseDifficultyLabel);
        myTransparentComponentHoldingPanel.add(myDifficultyOptionsDropDownBox);
        myTransparentComponentHoldingPanel.add(myBackBtn);
        myTransparentComponentHoldingPanel.add(myStartGameBtn);
    }

    /** . */
    private void setUpBGPanelStyleAndAddTransparentPanelToIt() {
        myNewGameBGLabel.setLayout(null);
        myNewGameBGLabel.add(myTransparentComponentHoldingPanel);
    }

}
