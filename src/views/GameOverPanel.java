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
 *
 * @author Hassan Bassam Farhat
 * @version Summer 2023
 */
public class GameOverPanel extends JPanel {

    // constants

    /** . */
    private static final String LABEL_FONT_STYLE = "Freestyle Script";
    /** . */
    private static final int LABEL_FONT_SIZE = 30;
    /** . */
    private static final int BUTTON_WIDTH = 120;
    /** . */
    private static final int BUTTON_HEIGHT = 40;
    /** . */
    private static final int PANEL_X_AXIS = 440;
    /** . */
    private static final int PANEL_Y_AXIS = 250;
    /** . */
    private static final int PANEL_WIDTH = 410;
    /** . */
    private static final int PANEL_HEIGHT = 300;
    /** . */
    private static final int MAIN_MENU_AND_YES_BTN_Y_AXIS = 200;
    /** . */
    private static final int YES_BTN_X_AXIS = 80;
    /** . */
    private static final int MAIN_MENU_BTN_X_AXIS = 230;
    /** . */
    private static final int BTN_FONT_SIZE = 29;
    /** . */
    private static final int TEXT_BOUNDS_BOX_X_AXIS = 20;
    /** . */
    private static final int TEXT_BOUNDS_BOX_Y_AXIS = 75;
    /** . */
    private static final int TEXT_BOUNDS_BOX_WIDTH = 380;
    /** . */
    private static final int TEXT_BOUNDS_BOX_HEIGHT = 100;

    // instance fields

    /** . */
    private JPanel myAskUserToPlayAgainPanel;
    /** . */
    private JButton myYesPlayAgainButton;
    /** . */
    private JButton myMainMenuButton;
    /** . */
    private JTextArea myTextToPlayAgainButton;
    /** . */
    private JLabel myGameOverBGLabel;

    // constructors

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

    /** . */
    public JButton getPlayAgainBtn() {
        return myYesPlayAgainButton;
    }

    /** . */
    public JButton getMyMainMenuBtn() {
        return myMainMenuButton;
    }


    // private methods

    /** . */
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

    /** . */
    private void addBackgroundImage() {
        this.add(myGameOverBGLabel);
    }

    /** . */
    private void setTheSizeOfTheButtonsAndBoundsOnThisPanel() {
        myYesPlayAgainButton.setBounds(YES_BTN_X_AXIS, MAIN_MENU_AND_YES_BTN_Y_AXIS,
                                        BUTTON_WIDTH, BUTTON_HEIGHT);
        myYesPlayAgainButton.setFont(new Font(LABEL_FONT_STYLE, Font.BOLD, BTN_FONT_SIZE));
        myMainMenuButton.setBounds(MAIN_MENU_BTN_X_AXIS, MAIN_MENU_AND_YES_BTN_Y_AXIS,
                                    BUTTON_WIDTH, BUTTON_HEIGHT);
        myMainMenuButton.setFont(new Font(LABEL_FONT_STYLE, Font.BOLD, BTN_FONT_SIZE));
    }

    /** . */
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

    /** . */
    private void setUpPlayAgainPanelAndAddAllComponentsToIt() {
        myAskUserToPlayAgainPanel.setLayout(null);
        myAskUserToPlayAgainPanel.setBackground(Color.GRAY);
        myAskUserToPlayAgainPanel.setBounds(PANEL_X_AXIS, PANEL_Y_AXIS,
                                            PANEL_WIDTH, PANEL_HEIGHT);
        myAskUserToPlayAgainPanel.add(myYesPlayAgainButton);
        myAskUserToPlayAgainPanel.add(myMainMenuButton);
        myAskUserToPlayAgainPanel.add(myTextToPlayAgainButton);
    }

    /** . */
    private void setUpBGPanelStyleAndAddPanelToIt() {
        myGameOverBGLabel.setLayout(null);
        myGameOverBGLabel.add(myAskUserToPlayAgainPanel);
    }

}
