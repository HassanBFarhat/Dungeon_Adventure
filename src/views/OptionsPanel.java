package views;

import javax.swing.*;

public class OptionsPanel extends JPanel {

    /** . */
    final JLabel myAudioText = new JLabel("Audio Volume: ");
    /** . */
    final JSlider myAudioSlider = new JSlider();
    /** . */
    final JLabel myAudioOnOffText = new JLabel("Audio On/Off: ");
    /** . */
    final JToggleButton myAudioOnOffBtn = new JToggleButton("On/Off");
    /** . */
    final JButton myGeneralInfoBtn = new JButton("General Information");
    /** . */
    final JButton myGameHelpBtn = new JButton("Game Help");
    /** . */
    final JButton myBackBtn = new JButton("Back");

    /** . */
    final ImageIcon myMainMenuBGImg = new ImageIcon("src/imgs/MainMenuBG_Image.jpg");
    /** . */
    final JLabel myNewGameBGLabel = new JLabel(myMainMenuBGImg);

    /** . */
    final JPanel myTransparentHoldingPanel = new JPanel();


    public OptionsPanel() {

    }



}
