package views;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.OverlayLayout;

/**
 *  This panel lets the player know what this game is about and the tasks at hand that
 *  need to be executed to win/play the game.
 *
 *  @author Hassan Bassam Farhat
 *  @author Avinash Bavisetty
 *  @version Summer 2023
 */
public class GameInformationPanel extends JPanel {

    // constants

    /** Font Style. */
    private static final String LABEL_FONT_STYLE = "Freestyle Script";
    /** Font size. */
    private static final int LABEL_FONT_SIZE = 30;
    /** transparent color. */
    private static final Color GRAY_TRANSPARENT_COLOR = new Color(128, 128, 128, 80);
    /** back button x coordinate. */
    private static final int BACK_BUTTON_X_AXIS = 50;
    /**back button y coordinate . */
    private static final int BACK_BUTTON_Y_AXIS = 350;
    /** back button width. */
    private static final int BACK_BUTTON_WIDTH = 75;
    /** back button height. */
    private static final int BACK_BUTTON_HEIGHT = 30;
    /** panel x coordinate. */
    private static final int TRANSPARENT_PANEL_X_AXIS = 340;
    /** panel y coordinate. */
    private static final int TRANSPARENT_PANEL_Y_AXIS = 150;
    /** panel width. */
    private static final int TRANSPARENT_PANEL_WIDTH = 600;
    /** panel height. */
    private static final int TRANSPARENT_PANEL_HEIGHT = 400;
    /** information text area x coordinate. */
    private static final int INFORMATION_TEXT_AREA_X_AXIS = 15;
    /** information text area y coordinate. */
    private static final int INFORMATION_TEXT_AREA_Y_AXIS = 5;
    /** information text area width. */
    private static final int INFORMATION_TEXT_AREA_WIDTH = 590;
    /** information text area height. */
    private static final int INFORMATION_TEXT_AREA_HEIGHT = 340;
    /** Back button font size. */
    private static final int BACK_BTN_FONT_SIZE = 28;

    // instance fields

    /** gameinfo label. */
    private JLabel myGameInfoBGLabel;
    /** transparent holding panel. */
    private JPanel myTransparentHoldingPanel;
    /** back button. */
    private JButton myBackBtn;
    /** gameinfo text area. */
    private JTextArea myGameInfoTextArea;


    // constructor
    /** sets up the GameInformationPanel as well as the components
     * required for game information to display correctly. */

    public GameInformationPanel() {
        instantiateInstanceDataFields();
        setUpThisPanelsLayoutAndAddBGImg();
        setUpConditionsAndStyleForGameInfoText();
        setUpAllButtonsBounds();
        setUpTransparentPanelStyleAndAddAllComponentsToIt();
        setUpBGPanelStyleAndAddTransparentPanelToIt();
    }


    // methods

    /** gets back button. */
    public JButton getMyBackBtn() {
        return myBackBtn;
    }

    // private methods

    /** instantiating data fields for GameInformationPanel that provides options. */
    private void instantiateInstanceDataFields() {
        final String gameInfoText = """
                In this Dungeon Adventure Game, you will be placed within a room\s
                of the Dungeon with the task of visiting the rooms to obtain the\s
                4 OO Principle keys: Abstraction, Encapsulation, Inheritance, Polymorphism.\s
                You have the option of choosing between 3 hero's, but know this...\s
                you're journey to obtaining the keys won't be an easy one.\s
                Your hero will have to fight a monster within each room.\s
                "Oh." What are the monsters you ask? Heh, win or\s
                lose, I guess you'll just have to play and find out!""";
        final ImageIcon bgImg = new ImageIcon("src/imgs/MainMenuBG_Image.jpg");
        myGameInfoBGLabel = new JLabel(bgImg);
        myTransparentHoldingPanel = new JPanel();
        myBackBtn = new JButton("Back");
        myGameInfoTextArea = new JTextArea(gameInfoText);
    }

    /** sets the panel layout and adds background image. */
    private void setUpThisPanelsLayoutAndAddBGImg() {
        this.setLayout(new OverlayLayout(this));
        this.add(myGameInfoBGLabel);
    }

    /**
     *  Sets up conditions and style for the game info text to execute and to display
     *  correctly.
     */
    private void setUpConditionsAndStyleForGameInfoText() {
        myGameInfoTextArea.setFont(new Font(LABEL_FONT_STYLE, Font.BOLD, LABEL_FONT_SIZE));
        myGameInfoTextArea.setForeground(Color.WHITE);
        myGameInfoTextArea.setLineWrap(true);
        myGameInfoTextArea.setWrapStyleWord(true);
        myGameInfoTextArea.setEditable(false);
        myGameInfoTextArea.setOpaque(false);
        myGameInfoTextArea.setFocusable(true);
        myGameInfoTextArea.setBounds(INFORMATION_TEXT_AREA_X_AXIS,
                                     INFORMATION_TEXT_AREA_Y_AXIS,
                                     INFORMATION_TEXT_AREA_WIDTH,
                                     INFORMATION_TEXT_AREA_HEIGHT);
    }

    /** sets ups all bounds for all of the buttons in this panel. */
    private void setUpAllButtonsBounds() {
        myBackBtn.setBounds(BACK_BUTTON_X_AXIS, BACK_BUTTON_Y_AXIS,
                            BACK_BUTTON_WIDTH, BACK_BUTTON_HEIGHT);
        myBackBtn.setFont(new Font(LABEL_FONT_STYLE, Font.BOLD, BACK_BTN_FONT_SIZE));
    }

    /** sets up panel and adds all suitable components to this panel. */
    private void setUpTransparentPanelStyleAndAddAllComponentsToIt() {
        myTransparentHoldingPanel.setLayout(null);
        myTransparentHoldingPanel.setBackground(GRAY_TRANSPARENT_COLOR);
        myTransparentHoldingPanel.setBounds(TRANSPARENT_PANEL_X_AXIS, TRANSPARENT_PANEL_Y_AXIS,
                                            TRANSPARENT_PANEL_WIDTH, TRANSPARENT_PANEL_HEIGHT);
        myTransparentHoldingPanel.add(myGameInfoTextArea);
        myTransparentHoldingPanel.add(myBackBtn);
    }

    /** set background panel style and add panel to this. */
    private void setUpBGPanelStyleAndAddTransparentPanelToIt() {
        myGameInfoBGLabel.setLayout(null);
        myGameInfoBGLabel.add(myTransparentHoldingPanel);
    }

}
