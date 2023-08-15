package views;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.OverlayLayout;

/**
 *  This panel is responsible for letting a player know that the game is over, and they lost,
 *  either from dying from a monster, or losing all their health from a pit.
 *
 *  @author Avinash Bavisetty
 *  @author Hassan Bassam Farhat
 *  @version Summer 2023
 */
public class GameOverPanel extends JPanel {

    // constants

    /** Font Style. */
    private static final String LABEL_FONT_STYLE = "Freestyle Script";
    /** Font size. */
    private static final int LABEL_FONT_SIZE = 30;
    /** button width. */
    private static final int BUTTON_WIDTH = 120;
    /** button height. */
    private static final int BUTTON_HEIGHT = 40;
    /** panel x coordinate. */
    private static final int PANEL_X_AXIS = 440;
    /** panel y coordinate. */
    private static final int PANEL_Y_AXIS = 250;
    /** panel width. */
    private static final int PANEL_WIDTH = 410;
    /** panel height. */
    private static final int PANEL_HEIGHT = 300;
    /** main menu and yes button y coordinate. */
    private static final int MAIN_MENU_AND_YES_BTN_Y_AXIS = 200;
    /** yes button x coordinate. */
    private static final int YES_BTN_X_AXIS = 80;
    /** main menu button x coordinate. */
    private static final int MAIN_MENU_BTN_X_AXIS = 230;
    /** button font size. */
    private static final int BTN_FONT_SIZE = 29;
    /** text bounds box x coordinate. */
    private static final int TEXT_BOUNDS_BOX_X_AXIS = 20;
    /** text bounds box y coordinate. */
    private static final int TEXT_BOUNDS_BOX_Y_AXIS = 75;
    /** text bounds box width. */
    private static final int TEXT_BOUNDS_BOX_WIDTH = 380;
    /** text bounds box height. */
    private static final int TEXT_BOUNDS_BOX_HEIGHT = 100;

    // instance fields

    /** panel that asks the user if they want to play the game again. */
    private JPanel myAskUserToPlayAgainPanel;
    /** button taht allows the user to play the game again. */
    private JButton myYesPlayAgainButton;
    /** button that takes the user back to the main menu. */
    private JButton myMainMenuButton;
    /** text to play again button. */
    private JTextArea myTextToPlayAgainButton;
    /** game over background label. */
    private JLabel myGameOverBGLabel;

    // constructors

    /**
     *  Sets up the GameOverPanel as well as the components required for teh components
     *  that need to be displayed.
     */
    public GameOverPanel() {
        this.setLayout(new OverlayLayout(this));
        instantiateInstanceDataFields();
        addBackgroundImage();
        setTheSizeOfTheButtonsAndBoundsOnThisPanel();
        setUpTextAskingUserToPlayAgain();
        setUpPlayAgainPanelAndAddAllComponentsToIt();
        setUpBGPanelStyleAndAddPanelToIt();
    }


    // methods

    /** gets play again button. */
    public JButton getPlayAgainBtn() {
        return myYesPlayAgainButton;
    }

    /** gets main menu button. */
    public JButton getMyMainMenuBtn() {
        return myMainMenuButton;
    }


    // private methods

    /** instantiating data fields for GameOverPanel that provides info regarding winning. */
    private void instantiateInstanceDataFields() {
        final ImageIcon gameOverBGImg = new ImageIcon("src/imgs/GameOverScreen.jpg");
        final String gameInfoText = """
                Unfortunately, the Hero has perished.\s
                Would you like to play again?""";
        myAskUserToPlayAgainPanel = new JPanel();
        myYesPlayAgainButton = new JButton("Yes");
        myMainMenuButton = new JButton("Main Menu");
        myTextToPlayAgainButton = new JTextArea(gameInfoText);
        myGameOverBGLabel = new JLabel(gameOverBGImg);
    }

    /** addd background image. */
    private void addBackgroundImage() {
        this.add(myGameOverBGLabel);
    }

    /** sets the size of the buttons and bounds on this panel. */
    private void setTheSizeOfTheButtonsAndBoundsOnThisPanel() {
        myYesPlayAgainButton.setBounds(YES_BTN_X_AXIS, MAIN_MENU_AND_YES_BTN_Y_AXIS,
                                        BUTTON_WIDTH, BUTTON_HEIGHT);
        myYesPlayAgainButton.setFont(new Font(LABEL_FONT_STYLE, Font.BOLD, BTN_FONT_SIZE));
        myMainMenuButton.setBounds(MAIN_MENU_BTN_X_AXIS, MAIN_MENU_AND_YES_BTN_Y_AXIS,
                                    BUTTON_WIDTH, BUTTON_HEIGHT);
        myMainMenuButton.setFont(new Font(LABEL_FONT_STYLE, Font.BOLD, BTN_FONT_SIZE));
    }

    /** ests up text that asks user if they want to play the game again. */
    private void setUpTextAskingUserToPlayAgain() {
        myTextToPlayAgainButton.setBounds(TEXT_BOUNDS_BOX_X_AXIS, TEXT_BOUNDS_BOX_Y_AXIS,
                                          TEXT_BOUNDS_BOX_WIDTH, TEXT_BOUNDS_BOX_HEIGHT);
        myTextToPlayAgainButton.setBackground(Color.GRAY);
        myTextToPlayAgainButton.setBorder(BorderFactory.createEmptyBorder());
        myTextToPlayAgainButton.setForeground(Color.WHITE);
        myTextToPlayAgainButton.setFont(
                new Font(LABEL_FONT_STYLE, Font.BOLD, LABEL_FONT_SIZE));
        myTextToPlayAgainButton.setEditable(false);
    }

    /** sets up panel and adds all suitable components to this panel. */
    private void setUpPlayAgainPanelAndAddAllComponentsToIt() {
        myAskUserToPlayAgainPanel.setLayout(null);
        myAskUserToPlayAgainPanel.setBackground(Color.GRAY);
        myAskUserToPlayAgainPanel.setBounds(PANEL_X_AXIS, PANEL_Y_AXIS,
                                            PANEL_WIDTH, PANEL_HEIGHT);
        myAskUserToPlayAgainPanel.add(myYesPlayAgainButton);
        myAskUserToPlayAgainPanel.add(myMainMenuButton);
        myAskUserToPlayAgainPanel.add(myTextToPlayAgainButton);
    }

    /** set background panel style and add panel to this. */
    private void setUpBGPanelStyleAndAddPanelToIt() {
        myGameOverBGLabel.setLayout(null);
        myGameOverBGLabel.add(myAskUserToPlayAgainPanel);
    }

}
