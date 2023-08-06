package views;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.OverlayLayout;

public class GameHelpPanel extends JPanel {

    // constants

    /** . */
    private static final String LABEL_FONT_STYLE = "Arial";
    /** . */
    private static final int LABEL_FONT_SIZE = 15;
    /** . */
    private static final Color GRAY_TRANSPARENT_COLOR = new Color(128, 128, 128, 80);
    /** . */
    private static final int TRANSPARENT_PANEL_X_AXIS = 440;
    /** . */
    private static final int TRANSPARENT_PANEL_Y_AXIS = 200;
    /** . */
    private static final int TRANSPARENT_PANEL_WIDTH = 410;
    /** . */
    private static final int TRANSPARENT_PANEL_HEIGHT = 300;
    /** . */
    private static final int BACK_BUTTON_X_AXIS = 50;
    /** . */
    private static final int BACK_BUTTON_Y_AXIS = 240;
    /** . */
    private static final int BACK_BUTTON_WIDTH = 75;
    /** . */
    private static final int BACK_BUTTON_HEIGHT = 20;
    /** . */
    private static final int HELP_TEXT_AREA_X_AND_Y_AXIS = 10;
    /** . */
    private static final int HELP_TEXT_AREA_WIDTH = 380;
    /** . */
    private static final int HELP_TEXT_AREA_HEIGHT = 230;

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
    private void instantiateInstanceDataFields() {
        final String gameHelpText = """
                THIS IS A PLACE HOLDER ----- THIS IS A PLACEHOLDER\s
                THIS IS A PLACE HOLDER ----- THIS IS A PLACEHOLDER\s
                THIS IS A PLACE HOLDER ----- THIS IS A PLACEHOLDER\s
                THIS IS A PLACE HOLDER ----- THIS IS A PLACEHOLDER\s
                THIS IS A PLACE HOLDER ----- THIS IS A PLACEHOLDER\s
                THIS IS A PLACE HOLDER ----- THIS IS A PLACEHOLDER\s
                THIS IS A PLACE HOLDER ----- THIS IS A PLACEHOLDER\s
                THIS IS A PLACE HOLDER ----- THIS IS A PLACEHOLDER\s
                THIS IS A PLACE HOLDER ----- THIS IS A PLACEHOLDER\s
                THIS IS A PLACE HOLDER ----- THIS IS A PLACEHOLDER""";
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
        myGameHelpTextArea.setFocusable(false);  // This line makes the text unselectable
        myGameHelpTextArea.setBounds(HELP_TEXT_AREA_X_AND_Y_AXIS, HELP_TEXT_AREA_X_AND_Y_AXIS,
                                     HELP_TEXT_AREA_WIDTH, HELP_TEXT_AREA_HEIGHT);
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
        myTransparentHoldingPanel.add(myGameHelpTextArea);
        myTransparentHoldingPanel.add(myBackBtn);
    }

    /** . */
    private void setUpBGPanelStyleAndAddTransparentPanelToIt() {
        myGameHelpBGLabel.setLayout(null);
        myGameHelpBGLabel.add(myTransparentHoldingPanel);
    }

    /** . */
    public JButton getMyBackBtn() {
        return myBackBtn;
    }

}
