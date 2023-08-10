package views;

import javax.swing.*;
import java.awt.*;

public class WinningPanel extends JPanel {

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
        myMainMenuButton.setBounds(155, 200,
                BUTTON_WIDTH, BUTTON_HEIGHT);
        myMainMenuButton.setFont(new Font(LABEL_FONT_STYLE, Font.BOLD, 29));
    }


    private void setUpTextCongratulatingUser() {
        myTextCongratulations.setBounds(20,75, 380,100);
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
        myCongratulateUserPanel.setBounds(PANEL_X_AXIS, PANEL_Y_AXIS, PANEL_WIDTH, PANEL_HEIGHT);
        myCongratulateUserPanel.add(myMainMenuButton);
        myCongratulateUserPanel.add(myTextCongratulations);
    }



    /** . */
    private void setUpBGPanelStyleAndAddPanelToIt() {
        myWinningGameBGLabel.setLayout(null);
        myWinningGameBGLabel.add(myCongratulateUserPanel);
    }


    public JButton getMyMainMenuBtn() {
        return myMainMenuButton;
    }





}
