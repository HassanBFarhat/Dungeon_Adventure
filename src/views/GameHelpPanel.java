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
 *
 * @author Hassan Bassam Farhat
 * @version Summer 2023
 */
public class GameHelpPanel extends JPanel {

    // constants

    /** . */
    private static final String LABEL_FONT_STYLE = "Freestyle Script";
    /** . */
    private static final int LABEL_FONT_SIZE = 30;
    /** . */
    private static final Color GRAY_TRANSPARENT_COLOR = new Color(128, 128, 128, 80);
    /** . */
    private static final int TRANSPARENT_PANEL_X_AXIS = 340;
    /** . */
    private static final int TRANSPARENT_PANEL_Y_AXIS = 50;
    /** . */
    private static final int TRANSPARENT_PANEL_WIDTH = 600;
    /** . */
    private static final int TRANSPARENT_PANEL_HEIGHT = 600;
    /** . */
    private static final int BACK_BUTTON_X_AXIS = 50;
    /** . */
    private static final int BACK_BUTTON_Y_AXIS = 550;
    /** . */
    private static final int BACK_BUTTON_WIDTH = 75;
    /** . */
    private static final int BACK_BUTTON_HEIGHT = 30;
    /** . */
    private static final int HELP_TEXT_AREA_X_AND_Y_AXIS = 10;
    /** . */
    private static final int HELP_TEXT_AREA_WIDTH = 590;
    /** . */
    private static final int HELP_TEXT_AREA_HEIGHT = 530;
    /** . */
    private static final int BACK_BTN_FONT_SIZE = 28;

    // instance fields
    /** . */
    private JLabel myGameHelpBGLabel;
    /** . */
    private JPanel myTransparentHoldingPanel;
    /** . */
    private JButton myBackBtn;
    /** . */
    private JTextArea myGameHelpTextArea;


    // constructor

    public GameHelpPanel() {
        instantiateInstanceDataFields();
        setUpThisPanelsLayoutAndAddBGImg();
        setUpConditionsAndStyleForGameHelpText();
        setUpAllButtonsBounds();
        setUpTransparentPanelStyleAndAddAllComponentsToIt();
        setUpBGPanelStyleAndAddTransparentPanelToIt();
    }


    // methods

    /** . */
    public JButton getMyBackBtn() {
        return myBackBtn;
    }

    // private methods

    /** . */
    private void instantiateInstanceDataFields() {
        final String gameHelpText = """
                - Press on screen North, South, East, West buttons to move\s
                  throughout the dungeon. Or use arrow keys or WASD keys.\s
                - When battling a monster, use Attack for normal attack, use\s
                  Special Attack for Hero's Special move, use Heal to heal\s
                  if you have any potions, and use Block to try and block monster.\s
                - Healing Potions are picked up automatically when the hero enters\s
                  a room of the dungeon.\s
                - Inventory is accessed through the "Inventory" button in the main\s
                  game panel. Tells you how many potions and which pillars you've\s
                  collected.\s
                - Options Menu can be accessed by pressing ESC key.\s
                - The button "Save" on the main game panel is used to save current\s
                  game.""";
        final ImageIcon bgImg = new ImageIcon("src/imgs/MainMenuBG_Image.jpg");
        myGameHelpBGLabel = new JLabel(bgImg);
        myTransparentHoldingPanel = new JPanel();
        myBackBtn = new JButton("Back");
        myGameHelpTextArea = new JTextArea(gameHelpText);
    }

    /** . */
    private void setUpThisPanelsLayoutAndAddBGImg() {
        this.setLayout(new OverlayLayout(this));
        this.add(myGameHelpBGLabel);
    }

    /** . */
    private void setUpConditionsAndStyleForGameHelpText() {
        //TODO: NEED TO FIGURE OUT A WAY TO MAKE TEXT NON SELECTABLE BY USER
        myGameHelpTextArea.setFont(new Font(LABEL_FONT_STYLE, Font.BOLD, LABEL_FONT_SIZE));
        myGameHelpTextArea.setForeground(Color.WHITE);
        myGameHelpTextArea.setLineWrap(true);
        myGameHelpTextArea.setWrapStyleWord(true);
        myGameHelpTextArea.setEditable(false);
        myGameHelpTextArea.setOpaque(false);
        myGameHelpTextArea.setFocusable(false);
        myGameHelpTextArea.setBounds(HELP_TEXT_AREA_X_AND_Y_AXIS, HELP_TEXT_AREA_X_AND_Y_AXIS,
                                     HELP_TEXT_AREA_WIDTH, HELP_TEXT_AREA_HEIGHT);
    }

    /** . */
    private void setUpAllButtonsBounds() {
        myBackBtn.setBounds(BACK_BUTTON_X_AXIS, BACK_BUTTON_Y_AXIS,
                            BACK_BUTTON_WIDTH, BACK_BUTTON_HEIGHT);
        myBackBtn.setFont(new Font(LABEL_FONT_STYLE, Font.BOLD, BACK_BTN_FONT_SIZE));
    }

    /** . */
    private void setUpTransparentPanelStyleAndAddAllComponentsToIt() {
        myTransparentHoldingPanel.setLayout(null);
        myTransparentHoldingPanel.setBackground(GRAY_TRANSPARENT_COLOR);
        myTransparentHoldingPanel.setBounds(TRANSPARENT_PANEL_X_AXIS, TRANSPARENT_PANEL_Y_AXIS,
                                            TRANSPARENT_PANEL_WIDTH, TRANSPARENT_PANEL_HEIGHT);
        myTransparentHoldingPanel.add(myGameHelpTextArea);
        myTransparentHoldingPanel.add(myBackBtn);
    }

    /** . */
    private void setUpBGPanelStyleAndAddTransparentPanelToIt() {
        myGameHelpBGLabel.setLayout(null);
        myGameHelpBGLabel.add(myTransparentHoldingPanel);
    }

}
