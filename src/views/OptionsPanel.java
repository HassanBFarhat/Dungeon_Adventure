package views;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JToggleButton;
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
public class OptionsPanel extends JPanel {

    // constants

    /** . */
    private static final String LABEL_FONT_STYLE = "Freestyle Script";
    /** . */
    private static final int LABEL_FONT_SIZE = 28;
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
    private static final int AUDIO_TEXT_AND_SLIDER_WIDTH = 150;
    /** . */
    private static final int AUDIO_TEXT_AND_SLIDER_HEIGHT = 50;
    /** . */
    private static final int AUDIO_TEXT_AND_AUDIO_ON_OFF_TEXT_X_AXIS = 50;
    /** . */
    private static final int AUDIO_TEXT_AND_SLIDER_Y_AXIS = 30;
    /** . */
    private static final int SLIDER_X_AXIS = 200;
    /** . */
    private static final int AUDIO_ON_OFF_LABEL_WIDTH = 150;
    /** . */
    private static final int AUDIO_ON_OFF_LABEL_HEIGHT = 50;
    /** . */
    private static final int AUDIO_ON_OFF_BUTTON_WIDTH = 100;
    /** . */
    private static final int AUDIO_ON_OFF_AND_BACK_BUTTONS_HEIGHT = 30;
    /** . */
    private static final int GENERAL_INFO_BUTTON_Y_AXIS = 150;
    /** . */
    private static final int GENERAL_INFO_AND_GAME_HELP_BUTTONS_X_AXIS = 110;
    /** . */
    private static final int GENERAL_INFO_AND_GAME_HELP_BUTTONS_WIDTH = 200;
    /** . */
    private static final int GENERAL_INFO_AND_GAME_HELP_BUTTONS_HEIGHT = 30;
    /** . */
    private static final int GAME_HELP_BUTTON_Y_AXIS = 190;
    /** . */
    private static final int BACK_BUTTON_X_AXIS = 50;
    /** . */
    private static final int BACK_BUTTON_Y_AXIS = 240;
    /** . */
    private static final int BACK_BUTTON_WIDTH = 75;
    /** . */
    private static final int AUDIO_ON_OFF_X_AXIS = 225;
    /** . */
    private static final int AUDIO_ON_OFF_Y_AXIS = 95;
    /** . */
    private static final int SLIDER_HEIGHT = 20;
    /** . */
    private static final int SLIDER_Y_AXIS = 45;
    /** . */
    private static final int AUDIO_ON_OFF_TEXT_Y_AXIS = 80;


    // instance fields

    /** . */
    private JLabel myAudioText;
    /** . */
    private JSlider myAudioSlider;
    /** . */
    private JLabel myAudioOnOffText;
    /** . */
    private JToggleButton myAudioOnOffBtn;
    /** . */
    private JButton myGeneralInfoBtn;
    /** . */
    private JButton myGameHelpBtn;
    /** . */
    private JButton myBackBtn;
    /** . */
    private JLabel myOptionsBGLabel;
    /** . */
    private JPanel myTransparentHoldingPanel;


    // constructor

    public OptionsPanel() {
        instantiateInstanceDataFields();
        setUpThisPanelsLayoutAndAddBGImg();
        setUpAllLabelsStyleAndBoundsAndSliderBounds();
        setUpAllButtonsBounds();
        setUpTransparentPanelStyleAndAddAllComponentsToIt();
        setUpBGPanelStyleAndAddTransparentPanelToIt();
    }


    // methods

    /** . */
    public JButton getMyGeneralInfoBtn() {
        return myGeneralInfoBtn;
    }

    /** . */
    public JButton getMyGameHelpBtn() {
        return myGameHelpBtn;
    }

    /** . */
    public JButton getMyBackBtn() {
        return myBackBtn;
    }


    // private methods

    /** . */
    private void instantiateInstanceDataFields() {
        myAudioText = new JLabel("Audio Volume: ");
        myAudioSlider = new JSlider();
        myAudioOnOffText = new JLabel("Audio On/Off: ");
        myAudioOnOffBtn = new JToggleButton("On/Off");
        myGeneralInfoBtn = new JButton("General Information");
        myGameHelpBtn = new JButton("Game Help");
        myBackBtn = new JButton("Back");
        final ImageIcon bgImg = new ImageIcon("src/imgs/MainMenuBG_Image.jpg");
        myOptionsBGLabel = new JLabel(bgImg);
        myTransparentHoldingPanel = new JPanel();
    }

    /** . */
    private void setUpThisPanelsLayoutAndAddBGImg() {
        this.setLayout(new OverlayLayout(this));
        this.add(myOptionsBGLabel);
    }

    /** . */
    private void setUpAllLabelsStyleAndBoundsAndSliderBounds() {
        myAudioText.setFont(new Font(LABEL_FONT_STYLE, Font.BOLD, LABEL_FONT_SIZE));
        myAudioText.setForeground(Color.WHITE);
        myAudioText.setBounds(AUDIO_TEXT_AND_AUDIO_ON_OFF_TEXT_X_AXIS,
                              AUDIO_TEXT_AND_SLIDER_Y_AXIS,
                              AUDIO_TEXT_AND_SLIDER_WIDTH,
                              AUDIO_TEXT_AND_SLIDER_HEIGHT);
        myAudioSlider.setBounds(SLIDER_X_AXIS, SLIDER_Y_AXIS,
                                AUDIO_TEXT_AND_SLIDER_WIDTH, SLIDER_HEIGHT);
        myAudioOnOffText.setFont(new Font(LABEL_FONT_STYLE, Font.BOLD, LABEL_FONT_SIZE));
        myAudioOnOffText.setForeground(Color.WHITE);
        myAudioOnOffText.setBounds(AUDIO_TEXT_AND_AUDIO_ON_OFF_TEXT_X_AXIS,
                                   AUDIO_ON_OFF_TEXT_Y_AXIS,
                                   AUDIO_ON_OFF_LABEL_WIDTH,
                                   AUDIO_ON_OFF_LABEL_HEIGHT);
    }

    /** . */
    private void setUpAllButtonsBounds() {
        myAudioOnOffBtn.setBounds(AUDIO_ON_OFF_X_AXIS, AUDIO_ON_OFF_Y_AXIS,
                                  AUDIO_ON_OFF_BUTTON_WIDTH,
                                  AUDIO_ON_OFF_AND_BACK_BUTTONS_HEIGHT);
        myAudioOnOffBtn.setFont(new Font(LABEL_FONT_STYLE, Font.BOLD, LABEL_FONT_SIZE));
        myGeneralInfoBtn.setBounds(GENERAL_INFO_AND_GAME_HELP_BUTTONS_X_AXIS,
                                   GENERAL_INFO_BUTTON_Y_AXIS,
                                   GENERAL_INFO_AND_GAME_HELP_BUTTONS_WIDTH,
                                   GENERAL_INFO_AND_GAME_HELP_BUTTONS_HEIGHT);
        myGeneralInfoBtn.setFont(new Font(LABEL_FONT_STYLE, Font.BOLD, LABEL_FONT_SIZE));
        myGameHelpBtn.setBounds(GENERAL_INFO_AND_GAME_HELP_BUTTONS_X_AXIS,
                                GAME_HELP_BUTTON_Y_AXIS,
                                GENERAL_INFO_AND_GAME_HELP_BUTTONS_WIDTH,
                                GENERAL_INFO_AND_GAME_HELP_BUTTONS_HEIGHT);
        myGameHelpBtn.setFont(new Font(LABEL_FONT_STYLE, Font.BOLD, LABEL_FONT_SIZE));
        myBackBtn.setBounds(BACK_BUTTON_X_AXIS,
                            BACK_BUTTON_Y_AXIS,
                            BACK_BUTTON_WIDTH,
                            AUDIO_ON_OFF_AND_BACK_BUTTONS_HEIGHT);
        myBackBtn.setFont(new Font(LABEL_FONT_STYLE, Font.BOLD, LABEL_FONT_SIZE));
    }

    /** . */
    private void setUpTransparentPanelStyleAndAddAllComponentsToIt() {
        myTransparentHoldingPanel.setLayout(null);
        myTransparentHoldingPanel.setBackground(GRAY_TRANSPARENT_COLOR);
        myTransparentHoldingPanel.setBounds(TRANSPARENT_PANEL_X_AXIS, TRANSPARENT_PANEL_Y_AXIS,
                                            TRANSPARENT_PANEL_WIDTH, TRANSPARENT_PANEL_HEIGHT);
        myTransparentHoldingPanel.add(myAudioText);
        myTransparentHoldingPanel.add(myAudioSlider);
        myTransparentHoldingPanel.add(myAudioOnOffText);
        myTransparentHoldingPanel.add(myAudioOnOffBtn);
        myTransparentHoldingPanel.add(myGeneralInfoBtn);
        myTransparentHoldingPanel.add(myGameHelpBtn);
        myTransparentHoldingPanel.add(myBackBtn);
    }

    /** . */
    private void setUpBGPanelStyleAndAddTransparentPanelToIt() {
        myOptionsBGLabel.setLayout(null);
        myOptionsBGLabel.add(myTransparentHoldingPanel);
    }

}
