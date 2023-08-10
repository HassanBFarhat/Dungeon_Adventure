package views;


import javax.swing.*;
import java.awt.*;

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
    private void instantiateInstanceDataFields() {
        final ImageIcon GameOverBGImg = new ImageIcon("src/imgs/GameOverScreen.jpg");

        final String gameInfoText = """
                Unfortunately, the Hero has perished.\s
                Would you like to play again?""";

        myAskUserToPlayAgainPanel = new JPanel();
        myYesPlayAgainButton = new JButton("Yes");
        myMainMenuButton = new JButton("Main Menu");
        myTextToPlayAgainButton = new JTextArea(gameInfoText);
        myGameOverBGLabel = new JLabel(GameOverBGImg);
    }

    /** . */
    private void addBackgroundImage() {
        this.add(myGameOverBGLabel);
    }

    /** . */
    private void setTheSizeOfTheButtonsAndBoundsOnThisPanel() {
        myYesPlayAgainButton.setBounds(80, 200,
                                        BUTTON_WIDTH, BUTTON_HEIGHT);
        myYesPlayAgainButton.setFont(new Font(LABEL_FONT_STYLE, Font.BOLD, 29));
        myMainMenuButton.setBounds(230, 200,
                                    BUTTON_WIDTH, BUTTON_HEIGHT);
        myMainMenuButton.setFont(new Font(LABEL_FONT_STYLE, Font.BOLD, 29));
    }


    private void setUpTextAskingUserToPlayAgain() {
        myTextToPlayAgainButton.setBounds(20,75, 380,100);
        myTextToPlayAgainButton.setBackground(Color.GRAY);
        myTextToPlayAgainButton.setBorder(BorderFactory.createEmptyBorder());
        myTextToPlayAgainButton.setForeground(Color.WHITE);
        myTextToPlayAgainButton.setFont(new Font(LABEL_FONT_STYLE, Font.BOLD, LABEL_FONT_SIZE));
        myTextToPlayAgainButton.setEditable(false);
    }

    /** . */
    private void setUpPlayAgainPanelAndAddAllComponentsToIt() {
        myAskUserToPlayAgainPanel.setLayout(null);
        myAskUserToPlayAgainPanel.setBackground(Color.GRAY);
        myAskUserToPlayAgainPanel.setBounds(PANEL_X_AXIS, PANEL_Y_AXIS, PANEL_WIDTH, PANEL_HEIGHT);
        myAskUserToPlayAgainPanel.add(myYesPlayAgainButton);
        myAskUserToPlayAgainPanel.add(myMainMenuButton);
        myAskUserToPlayAgainPanel.add(myTextToPlayAgainButton);
    }

    /** . */
    private void setUpBGPanelStyleAndAddPanelToIt() {
        myGameOverBGLabel.setLayout(null);
        myGameOverBGLabel.add(myAskUserToPlayAgainPanel);
    }



    public JButton getPlayAgainBtn() {
        return myYesPlayAgainButton;
    }

    public JButton getMyMainMenuBtn() {
        return myMainMenuButton;
    }

}
