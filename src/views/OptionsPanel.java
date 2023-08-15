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
 *  This panel houses the various options to a player. Lowering or increasing the volume of
 *  the background music through a slider, toggling the music on my off, and accesses the
 *  GameHelp and GameInformation panels from this Options panel section.
 *
 *  @author Hassan Bassam Farhat
 *  @author Avinash Bavisetty
 *  @version Summer 2023
 */
public class OptionsPanel extends JPanel {

    // constants

    /** Font Style. */
    private static final String LABEL_FONT_STYLE = "Freestyle Script";
    /** Font size. */
    private static final int LABEL_FONT_SIZE = 28;
    /** transparent color. */
    private static final Color GRAY_TRANSPARENT_COLOR = new Color(128, 128, 128, 80);
    /** panel x coordinate. */
    private static final int TRANSPARENT_PANEL_X_AXIS = 440;
    /** panel y coordinate. */
    private static final int TRANSPARENT_PANEL_Y_AXIS = 200;
    /** panel width. */
    private static final int TRANSPARENT_PANEL_WIDTH = 410;
    /** panel height. */
    private static final int TRANSPARENT_PANEL_HEIGHT = 300;
    /** audio text and slider width. */
    private static final int AUDIO_TEXT_AND_SLIDER_WIDTH = 150;
    /** audio text and slider height. */
    private static final int AUDIO_TEXT_AND_SLIDER_HEIGHT = 50;
    /** audio text and audio on or off text x coordinate. */
    private static final int AUDIO_TEXT_AND_AUDIO_ON_OFF_TEXT_X_AXIS = 50;
    /** audio text and slider y coordinate. */
    private static final int AUDIO_TEXT_AND_SLIDER_Y_AXIS = 30;
    /** slider x coordinate. */
    private static final int SLIDER_X_AXIS = 200;
    /** audio on or off label width. */
    private static final int AUDIO_ON_OFF_LABEL_WIDTH = 150;
    /** audio on or off label height. */
    private static final int AUDIO_ON_OFF_LABEL_HEIGHT = 50;
    /** audio on or off button width. */
    private static final int AUDIO_ON_OFF_BUTTON_WIDTH = 100;
    /** audio on or off and back buttons height. */
    private static final int AUDIO_ON_OFF_AND_BACK_BUTTONS_HEIGHT = 30;
    /** general info button y coordinate. */
    private static final int GENERAL_INFO_BUTTON_Y_AXIS = 150;
    /** general info and game help buttons x coordinate. */
    private static final int GENERAL_INFO_AND_GAME_HELP_BUTTONS_X_AXIS = 110;
    /** general info and game help buttons width. */
    private static final int GENERAL_INFO_AND_GAME_HELP_BUTTONS_WIDTH = 200;
    /** general info and game help buttons height. */
    private static final int GENERAL_INFO_AND_GAME_HELP_BUTTONS_HEIGHT = 30;
    /** game help button y coordinate. */
    private static final int GAME_HELP_BUTTON_Y_AXIS = 190;
    /** back button x coordinate. */
    private static final int BACK_BUTTON_X_AXIS = 50;
    /**back button y coordinate . */
    private static final int BACK_BUTTON_Y_AXIS = 240;
    /** back button width. */
    private static final int BACK_BUTTON_WIDTH = 75;
    /** audio on or off x coordinate. */
    private static final int AUDIO_ON_OFF_X_AXIS = 225;
    /** audio on or off y coordinate. */
    private static final int AUDIO_ON_OFF_Y_AXIS = 95;
    /** slider height. */
    private static final int SLIDER_HEIGHT = 20;
    /** slider y coordinate. */
    private static final int SLIDER_Y_AXIS = 45;
    /** audio on or off text y coordinate. */
    private static final int AUDIO_ON_OFF_TEXT_Y_AXIS = 80;
    /** The max the music volume can be. */
    private static final int MAX_VOLUME = 100;


    // instance fields

    /** audio text . */
    private JLabel myAudioText;
    /** audio slider. */
    private JSlider myAudioSlider;
    /** audio on or off text. */
    private JLabel myAudioOnOffText;
    /** audio on or off button. */
    private JToggleButton myAudioOnOffBtn;
    /** general info. */
    private JButton myGeneralInfoBtn;
    /** game help button. */
    private JButton myGameHelpBtn;
    /** back button. */
    private JButton myBackBtn;
    /** options. */
    private JLabel myOptionsBGLabel;
    /** transparent holding panel. */
    private JPanel myTransparentHoldingPanel;


    /**
     *  Sets up the OptionsPanel as well as the components required for options to
     *  display correctly.
     */
    public OptionsPanel() {
        instantiateInstanceDataFields();
        setUpThisPanelsLayoutAndAddBGImg();
        setUpAllLabelsStyleAndBoundsAndSliderBounds();
        setUpAllButtonsBounds();
        setUpTransparentPanelStyleAndAddAllComponentsToIt();
        setUpBGPanelStyleAndAddTransparentPanelToIt();
    }


    // methods

    /** gets general info button. */
    public JButton getMyGeneralInfoBtn() {
        return myGeneralInfoBtn;
    }

    /** gets my game help button. */
    public JButton getMyGameHelpBtn() {
        return myGameHelpBtn;
    }

    /** gets back button. */
    public JButton getMyBackBtn() {
        return myBackBtn;
    }

    /** gets audio on or off buton. */
    public JToggleButton getMyAudioOnOffBtn() {
        return myAudioOnOffBtn;
    }

    /** gets audio slider button. */
    public JSlider getMyAudioSlider() {
        return myAudioSlider;
    }


    // private methods

    /** instantiating data fields for OPtionsPanel that provides options. */
    private void instantiateInstanceDataFields() {
        myAudioText = new JLabel("Audio Volume: ");
        myAudioSlider = new JSlider(0, MAX_VOLUME);
        myAudioOnOffText = new JLabel("Audio On/Off: ");
        myAudioOnOffBtn = new JToggleButton("On/Off");
        myGeneralInfoBtn = new JButton("General Information");
        myGameHelpBtn = new JButton("Game Help");
        myBackBtn = new JButton("Back");
        final ImageIcon bgImg = new ImageIcon("src/imgs/MainMenuBG_Image.jpg");
        myOptionsBGLabel = new JLabel(bgImg);
        myTransparentHoldingPanel = new JPanel();
    }

    /** sets the panel layout and adds background image. */
    private void setUpThisPanelsLayoutAndAddBGImg() {
        this.setLayout(new OverlayLayout(this));
        this.add(myOptionsBGLabel);
    }

    /** sets up all label styles and bounds, along with slider bounds in this panel. */
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

    /** sets ups all bounds for all of the buttons in this panel. */
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

    /** sets up panel and adds all suitable components to this panel. */
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

    /** set background panel style and add panel to this. */
    private void setUpBGPanelStyleAndAddTransparentPanelToIt() {
        myOptionsBGLabel.setLayout(null);
        myOptionsBGLabel.add(myTransparentHoldingPanel);
    }

}
