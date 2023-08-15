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
 *  This is the panel that is displayed when the player wins the game, finding all the keys
 *  and making his/her way to the exit of the dungeon.
 *
 *  @author Hassan Bassam Farhat
 *  @author Avinash Bavisetty
 *  @version Summer 2023
 */
public class WinningPanel extends JPanel {

    // constants
    /** Font used for the winning label. */
    private static final String LABEL_FONT_STYLE = "Freestyle Script";
    /** Size used for the winning label. */
    private static final int LABEL_FONT_SIZE = 30;
    /** Return to main menu button font size. */
    private static final int BUTTON_FONT_SIZE = 29;
    /** Return to main menu button width. */
    private static final int BUTTON_WIDTH = 120;
    /** Return to main menu button height. */
    private static final int BUTTON_HEIGHT = 40;
    /** Winning panel x-axis location. */
    private static final int PANEL_X_AXIS = 440;
    /** Winning panel y-axis location. */
    private static final int PANEL_Y_AXIS = 250;
    /** Winning panel width size. */
    private static final int PANEL_WIDTH = 410;
    /** Winning panel height size. */
    private static final int PANEL_HEIGHT = 300;
    /** Return to main menu x-axis location. */
    private static final int MAIN_MENU_BTN_X_AXIS = 155;
    /** Return to main menu y-axis location. */
    private static final int MAIN_MENU_BTN_Y_AXIS = 200;
    /** Congratulations text x-axis location. */
    private static final int CONGRATS_TEXT_X_AXIS = 20;
    /** Congratulations text y-axis location. */
    private static final int CONGRATS_TEXT_Y_AXIS = 75;
    /** Congratulations text width size. */
    private static final int CONGRATS_TEXT_WIDTH = 380;
    /** Congratulations text height size. */
    private static final int CONGRATS_TEXT_HEIGHT = 100;


    // instance fields

    /** Panel that holds the congratulating text to player. */
    private JPanel myCongratulateUserPanel;
    /** Button to return back to main menu. */
    private JButton myMainMenuButton;
    /** The actual congratulations text to the winning player. */
    private JTextArea myTextCongratulations;
    /** Label that holds background image for winning the game. */
    private JLabel myWinningGameBGLabel;


    // constructor

    /** Sets up the winning panel instantiations for the panel to operate as necessary. */
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

    /**
     *  Returns the myMainMenuButton for use of action listener to take player back to
     *  main menu.
     */
    public JButton getMyMainMenuBtn() {
        return myMainMenuButton;
    }


    // private methods

    /** Sets up all the instance fields with their appropriate data type instantiations. */
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

    /** Adds the winning background image to the myWinningGameBGLabel. */
    private void addBackgroundImage() {
        this.add(myWinningGameBGLabel);
    }

    /** Sets up the return to main menu button size and bounds. */
    private void setTheSizeOfTheButtonsAndBoundsOnThisPanel() {
        myMainMenuButton.setBounds(MAIN_MENU_BTN_X_AXIS, MAIN_MENU_BTN_Y_AXIS,
                                   BUTTON_WIDTH, BUTTON_HEIGHT);
        myMainMenuButton.setFont(new Font(LABEL_FONT_STYLE, Font.BOLD, BUTTON_FONT_SIZE));
    }

    /** Sets up the bounds and style for the congratulating winning the game text. */
    private void setUpTextCongratulatingUser() {
        myTextCongratulations.setBounds(CONGRATS_TEXT_X_AXIS, CONGRATS_TEXT_Y_AXIS,
                                        CONGRATS_TEXT_WIDTH, CONGRATS_TEXT_HEIGHT);
        myTextCongratulations.setBackground(Color.GRAY);
        myTextCongratulations.setBorder(BorderFactory.createEmptyBorder());
        myTextCongratulations.setForeground(Color.WHITE);
        myTextCongratulations.setFont(new Font(LABEL_FONT_STYLE, Font.BOLD, LABEL_FONT_SIZE));
        myTextCongratulations.setEditable(false);
    }

    /** Sets up the panel to hold all the components size and bounds. */
    private void setUpPanelAndAddAllComponentsToIt() {
        myCongratulateUserPanel.setLayout(null);
        myCongratulateUserPanel.setBackground(Color.GRAY);
        myCongratulateUserPanel.setBounds(PANEL_X_AXIS, PANEL_Y_AXIS,
                                          PANEL_WIDTH, PANEL_HEIGHT);
        myCongratulateUserPanel.add(myMainMenuButton);
        myCongratulateUserPanel.add(myTextCongratulations);
    }

    /** Adds all the components to the background of the winning panel. */
    private void setUpBGPanelStyleAndAddPanelToIt() {
        myWinningGameBGLabel.setLayout(null);
        myWinningGameBGLabel.add(myCongratulateUserPanel);
    }

}
