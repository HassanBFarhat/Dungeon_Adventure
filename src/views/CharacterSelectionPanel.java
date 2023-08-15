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

/**
 * @author Avinash Bavisetty
 * @author Hassan Bassam Farhat
 * @version Summer 2023
 */
public class CharacterSelectionPanel extends JPanel {

    // constants

    /** Font Style. */
    private static final String LABEL_FONT_STYLE = "Freestyle Script";

    /** Label font size. */
    private static final int LABEL_FONT_SIZE = 30;

    /** Label Heigth. */
    private static final int LABEL_HEIGHT = 30;

    /** width of name for character. */
    private static final int NAME_CHARACTER_LABEL_WIDTH = 150;

    /** width for select character. */
    private static final int SELECT_CHARACTER_LABEL_WIDTH = 160;

    /** choose difficulty label width. */
    private static final int CHOOSE_DIFFICULTY_LABEL_WIDTH = 170;

    /** character name x coordinate. */
    private static final int NAME_CHARACTER_LABEL_X_AXIS = 50;

    /** character name x coordinate. */
    private static final int SELECT_CHARACTER_LABEL_X_AXIS = 50;

    /** choose difficulty x axis. */
    private static final int CHOOSE_DIFFICULTY_LABEL_X_AXIS = 50;

    /** character name label and text box Y coordinate. */
    private static final int NAME_CHARACTER_LABEL_AND_TEXT_BOX_Y_AXIS = 50;

    /** select character label and combo box y coordinate. */
    private static final int SELECT_CHARACTER_LABEL_AND_COMBO_BOX_Y_AXIS = 105;

    /** choose difficult label and combo box y coordinate. */
    private static final int CHOOSE_DIFFICULTY_LABEL_AND_COMBO_BOX_Y_AXIS = 155;

    /** combo box and text box x coordinate. */
    private static final int COMBO_BOX_AND_TEXT_BOX_X_AXIS = 230;

    /** combo box and text box width. */
    private static final int COMBO_BOX_AND_TEXT_BOX_WIDTH = 150;

    /** combo box and text box height. */
    private static final int COMBO_BOX_AND_TEXT_BOX_HEIGHT = 25;

    /** transparent color. */
    private static final Color GRAY_TRANSPARENT_COLOR = new Color(128, 128, 128, 80);

    /** transparent panel x coordinate. */
    private static final int TRANSPARENT_PANEL_X_AXIS = 440;

    /** transparent panel y coordinate. */
    private static final int TRANSPARENT_PANEL_Y_AXIS = 200;

    /** transparent panel width. */
    private static final int TRANSPARENT_PANEL_WIDTH = 410;

    /** transparent panel height. */
    private static final int TRANSPARENT_PANEL_HEIGHT = 300;

    /** back button x coordinate. */
    private static final int BACK_BUTTON_X_AXIS = 50;

    /** start game button x coordinate. */
    private static final int START_GAME_BUTTON_X_AXIS = 210;

    /** all buttons y coordinate. */
    private static final int ALL_BUTTONS_Y_AXIS = 230;

    /** all buttons width. */
    private static final int ALL_BUTTONS_WIDTH = 155;

    /** all buttons height. */
    private static final int ALL_BUTTONS_HEIGHT = 30;

    /** back adn start button and character text size. */
    private static final int BACK_AND_START_BTN_AND_CHARACTER_TEXT = 25;

    /** hero and difficulty text size. */
    private static final int HERO_AND_DIFFICULTY_TEXT_SIZE = 24;

    /** character y coordinate. */
    private static final int CHARACTER_Y_AXIS = 60;

    /** hero dropdown y coordinate. */
    private static final int HERO_DROPDOWN_Y_AXIS = 110;

    /** difficulty dropdown y coordinate. */
    private static final int DIFFICULTY_DROPDOWN_Y_AXIS = 160;

    // instance fields

    /** select character label. */
    private JLabel mySelectCharacterLabel;

    /** options for hero dropdown box. */
    private JComboBox myHeroOptionsDropDownBox;

    /** character name label. */
    private JLabel myNameYourCharacterLabel;

    /** character name text box. */
    private JTextField myNameYourCharacterTextBox;

    /** choose difficulty heading. */
    private JLabel myChooseDifficultyLabel;

    /** difficulty options dropdown box. */
    private JComboBox myDifficultyOptionsDropDownBox;

    /** Transparent panel that holds components. */
    private JPanel myTransparentComponentHoldingPanel;

    /** label for new game. */
    private JLabel myNewGameBGLabel;

    /** button that allows you to go back. */
    private JButton myBackBtn;

    /** button that allows you to start the game. */
    private JButton myStartGameBtn;


    // constructor

    /** sets up the CharacterSelectiopnPanel as well as the components required for the character selection in the
     * game to work . */
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

    /** gets back button that allows the player to go back in the menu. */
    public JButton getMyBackBtn() {
        return myBackBtn;
    }

    /** gets my start game button that allows the player to start a game. */
    public JButton getMyStartGameBtnBtn() {
        return myStartGameBtn;
    }

    /** gets the character name. */
    public String getCharactersName() {
        return myNameYourCharacterTextBox.getText();
    }

    /** sets the character name text box to allow the player to enter a name for the character. */
    public void setMyNameYourCharacterTextBox(final String theName) {
        myNameYourCharacterTextBox.setText(theName);
    }

    /** hero option box allows the player to select a hero to play as. */
    public String getHeroOptionFromBox() {
        return (String) myHeroOptionsDropDownBox.getSelectedItem();
    }

    /** Allows the player to select game difficulty. */
    public String getGameDifficultyFromBox() {
        return (String) myDifficultyOptionsDropDownBox.getSelectedItem();
    }


    // private methods

    /** instiantiates data fields in teh character selection panel. */
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

    /** sets the panel layout and adds background image on top of it. */
    private void setUpThisPanelsLayoutAndAddBGImg() {
        this.setLayout(new OverlayLayout(this));
        this.add(myNewGameBGLabel);
    }

    /** Sets up the label style and the bounds for this. */
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

    /** Adds dropdown box along with text boxes to teh panel. */
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

    /** sets up the bounds for all the buttons. */
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

    /** sets transparency style for the panels and adds the required components to the
     * character selection panel */
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

    /** sets up background panel style and adds transparent panel to it. */
    private void setUpBGPanelStyleAndAddTransparentPanelToIt() {
        myNewGameBGLabel.setLayout(null);
        myNewGameBGLabel.add(myTransparentComponentHoldingPanel);
    }

}
