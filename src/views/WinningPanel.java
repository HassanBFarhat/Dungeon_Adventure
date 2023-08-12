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
 * @author Avinash Bavisetty
 * @author Hassan Bassam Farhat
 * @version Summer 2023
 */

/**
 *
 * @author Hassan Bassam Farhat
 * @version Summer 2023
 */
public class WinningPanel extends JPanel {

    // constants

    /** . */
    private static final String LABEL_FONT_STYLE = "Freestyle Script";
    /** . */
    private static final int LABEL_FONT_SIZE = 30;
    /** . */
    private static final int BUTTON_FONT_SIZE = 29;
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
    private static final int MAIN_MENU_BTN_X_AXIS = 155;
    /** . */
    private static final int MAIN_MENU_BTN_Y_AXIS = 200;
    /** . */
    private static final int CONGRATS_TEXT_X_AXIS = 20;
    /** . */
    private static final int CONGRATS_TEXT_Y_AXIS = 75;
    /** . */
    private static final int CONGRATS_TEXT_WIDTH = 380;
    /** . */
    private static final int CONGRATS_TEXT_HEIGHT = 100;


    // instance fields

    /** . */
    private JPanel myCongratulateUserPanel;
    /** . */
    private JButton myMainMenuButton;
    /** . */
    private JTextArea myTextCongratulations;
    /** . */
    private JLabel myWinningGameBGLabel;


    // constructor

    public WinningPanel() {
        this.setLayout(new OverlayLayout(this));
        instantiateInstanceDataFields();
        addBackgroundImage();
        setTheSizeOfTheButtonsAndBoundsOnThisPanel();
        setUpTextCongratulatingUser();
        setUpPanelAndAddAllComponentsToIt();
        setUpBGPanelStyleAndAddPanelToIt();
    }


    // methods

    /** . */
    public JButton getMyMainMenuBtn() {
        return myMainMenuButton;
    }


    // private methods

    /** . */
    private void instantiateInstanceDataFields() {
        final ImageIcon winningBGImg = new ImageIcon("src/imgs/WonGameScreen.jpg");
        final String gameInfoText = """
                CONGRATULATIONS!!!\s
                You fought a long battle, and prevailed\s
                to escape the dungeon!""";
        myCongratulateUserPanel = new JPanel();
        myMainMenuButton = new JButton("Main Menu");
        myTextCongratulations = new JTextArea(gameInfoText);
        myWinningGameBGLabel = new JLabel(winningBGImg);
    }

    /** . */
    private void addBackgroundImage() {
        this.add(myWinningGameBGLabel);
    }

    /** . */
    private void setTheSizeOfTheButtonsAndBoundsOnThisPanel() {
        myMainMenuButton.setBounds(MAIN_MENU_BTN_X_AXIS, MAIN_MENU_BTN_Y_AXIS,
                                   BUTTON_WIDTH, BUTTON_HEIGHT);
        myMainMenuButton.setFont(new Font(LABEL_FONT_STYLE, Font.BOLD, BUTTON_FONT_SIZE));
    }

    /** . */
    private void setUpTextCongratulatingUser() {
        myTextCongratulations.setBounds(CONGRATS_TEXT_X_AXIS, CONGRATS_TEXT_Y_AXIS,
                                        CONGRATS_TEXT_WIDTH, CONGRATS_TEXT_HEIGHT);
        myTextCongratulations.setBackground(Color.GRAY);
        myTextCongratulations.setBorder(BorderFactory.createEmptyBorder());
        myTextCongratulations.setForeground(Color.WHITE);
        myTextCongratulations.setFont(new Font(LABEL_FONT_STYLE, Font.BOLD, LABEL_FONT_SIZE));
        myTextCongratulations.setEditable(false);
    }

    /** . */
    private void setUpPanelAndAddAllComponentsToIt() {
        myCongratulateUserPanel.setLayout(null);
        myCongratulateUserPanel.setBackground(Color.GRAY);
        myCongratulateUserPanel.setBounds(PANEL_X_AXIS, PANEL_Y_AXIS,
                                          PANEL_WIDTH, PANEL_HEIGHT);
        myCongratulateUserPanel.add(myMainMenuButton);
        myCongratulateUserPanel.add(myTextCongratulations);
    }

    /** . */
    private void setUpBGPanelStyleAndAddPanelToIt() {
        myWinningGameBGLabel.setLayout(null);
        myWinningGameBGLabel.add(myCongratulateUserPanel);
    }

}
