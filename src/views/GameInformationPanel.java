package views;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.OverlayLayout;

public class GameInformationPanel extends JPanel {

    // constants

    /** . */
    private static final String LABEL_FONT_STYLE = "Arial";
    /** . */
    private static final int LABEL_FONT_SIZE = 15;
    /** . */
    private static final Color GRAY_TRANSPARENT_COLOR = new Color(128, 128, 128, 80);
    /** . */
    private static final int BACK_BUTTON_X_AXIS = 50;
    /** . */
    private static final int BACK_BUTTON_Y_AXIS = 240;
    /** . */
    private static final int BACK_BUTTON_WIDTH = 75;
    /** . */
    private static final int BACK_BUTTON_HEIGHT = 20;
    /** . */
    private static final int TRANSPARENT_PANEL_X_AXIS = 440;
    /** . */
    private static final int TRANSPARENT_PANEL_Y_AXIS = 200;
    /** . */
    private static final int TRANSPARENT_PANEL_WIDTH = 410;
    /** . */
    private static final int TRANSPARENT_PANEL_HEIGHT = 300;
    /** . */
    private static final int INFORMATION_TEXT_AREA_X_AXIS = 10;
    /** . */
    private static final int INFORMATION_TEXT_AREA_Y_AXIS = 5;
    /** . */
    private static final int INFORMATION_TEXT_AREA_WIDTH = 380;
    /** . */
    private static final int INFORMATION_TEXT_AREA_HEIGHT = 230;

    // instance fields

    /** . */
    private JLabel myGameInfoBGLabel;
    /** . */
    private JPanel myTransparentHoldingPanel;
    /** . */
    private JButton myBackBtn;
    /** . */
    private JTextArea myGameInfoTextArea;


    // constructor

    public GameInformationPanel() {
        instantiateInstanceDataFields();
        setUpThisPanelsLayoutAndAddBGImg();
        setUpConditionsAndStyleForGameInfoText();
        setUpAllButtonsBounds();
        setUpTransparentPanelStyleAndAddAllComponentsToIt();
        setUpBGPanelStyleAndAddTransparentPanelToIt();
    }


    // methods

    /** . */
    private void instantiateInstanceDataFields() {
        final String gameInfoText = """
                In this Dungeon Adventure Game, you will be placed\s
                within a room of the Dungeon with the task of visiting\s
                the rooms to obtain the 4 OO Principle keys:\s
                Abstraction, Encapsulation, Inheritance, Polymorphism.\s
                You have the option of choosing between 3 hero's,\s
                but know this... you're journey to obtaining the keys\s
                won't be an easy one. Your hero will have to fight a\s
                monster within each room.\s
                "Oh." What are the monsters you ask? Heh, win or\s
                lose, I guess you'll just have to play and find out!""";
        final ImageIcon bgImg = new ImageIcon("src/imgs/MainMenuBG_Image.jpg");
        myGameInfoBGLabel = new JLabel(bgImg);
        myTransparentHoldingPanel = new JPanel();
        myBackBtn = new JButton("Back");
        myGameInfoTextArea = new JTextArea(gameInfoText);
    }

    /** . */
    private void setUpThisPanelsLayoutAndAddBGImg() {
        this.setLayout(new OverlayLayout(this));
        this.add(myGameInfoBGLabel);
    }

    /** . */
    private void setUpConditionsAndStyleForGameInfoText() {
        //TODO: NEED TO FIGURE OUT A WAY TO MAKE TEXT NOT SELECTABLE BY USER
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

    /** . */
    private void setUpAllButtonsBounds() {
        myBackBtn.setBounds(BACK_BUTTON_X_AXIS, BACK_BUTTON_Y_AXIS,
                            BACK_BUTTON_WIDTH, BACK_BUTTON_HEIGHT);
    }

    /** . */
    private void setUpTransparentPanelStyleAndAddAllComponentsToIt() {
        myTransparentHoldingPanel.setLayout(null);
        myTransparentHoldingPanel.setBackground(GRAY_TRANSPARENT_COLOR);
        myTransparentHoldingPanel.setBounds(TRANSPARENT_PANEL_X_AXIS, TRANSPARENT_PANEL_Y_AXIS,
                                            TRANSPARENT_PANEL_WIDTH, TRANSPARENT_PANEL_HEIGHT);
        myTransparentHoldingPanel.add(myGameInfoTextArea);
        myTransparentHoldingPanel.add(myBackBtn);
    }

    /** . */
    private void setUpBGPanelStyleAndAddTransparentPanelToIt() {
        myGameInfoBGLabel.setLayout(null);
        myGameInfoBGLabel.add(myTransparentHoldingPanel);
    }

    /** . */
    public JButton getMyBackBtn() {
        return myBackBtn;
    }

}
