package views;

import javax.swing.*;
import java.awt.*;

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
    final JLabel myOptionsBGLabel = new JLabel(myMainMenuBGImg);

    /** . */
    final JPanel myTransparentHoldingPanel = new JPanel();


    public OptionsPanel() {
        this.setLayout(new OverlayLayout(this));
        this.add(myOptionsBGLabel);

        myOptionsBGLabel.setLayout(null);

        myTransparentHoldingPanel.setLayout(null);
        myTransparentHoldingPanel.setBackground(new Color(128,128,128, 80));
        myTransparentHoldingPanel.setBounds(440,200,410,300);

        myAudioText.setFont(new Font("Arial", Font.BOLD, 15));
        myAudioText.setForeground(Color.WHITE);
        myAudioText.setBounds(50, 50, 150, 20);
        myAudioSlider.setBounds(180, 50, 150, 20);

        myAudioOnOffText.setFont(new Font("Arial", Font.BOLD, 15));
        myAudioOnOffText.setForeground(Color.WHITE);
        myAudioOnOffText.setBounds(50, 100, 150, 20);
        myAudioOnOffBtn.setBounds(205,100,100,20);

        myGeneralInfoBtn.setBounds(125, 150, 150, 25);
        myGameHelpBtn.setBounds(125, 190, 150, 25);
        myBackBtn.setBounds(50, 240, 75, 20);

        myTransparentHoldingPanel.add(myAudioText);
        myTransparentHoldingPanel.add(myAudioSlider);
        myTransparentHoldingPanel.add(myAudioOnOffText);
        myTransparentHoldingPanel.add(myAudioOnOffBtn);
        myTransparentHoldingPanel.add(myGeneralInfoBtn);
        myTransparentHoldingPanel.add(myGameHelpBtn);
        myTransparentHoldingPanel.add(myBackBtn);

        myOptionsBGLabel.add(myTransparentHoldingPanel);
    }



}
