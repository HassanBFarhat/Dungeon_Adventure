package views;

import javax.swing.*;
import java.awt.*;

public class GameHelpPanel extends JPanel {

    /** . */
    final ImageIcon myMainMenuBGImg = new ImageIcon("src/imgs/MainMenuBG_Image.jpg");
    /** . */
    final JLabel myGameHelpBGLabel = new JLabel(myMainMenuBGImg);
    /** . */
    final JPanel myTransparentHoldingPanel = new JPanel();

    /** . */
    final JButton myBackBtn = new JButton("Back");
    /** . */
    final String myGameHelpText = "THIS IS A PLACE HOLDER ----- THIS IS A PLACEHOLDER "
            + "THIS IS A PLACE HOLDER ----- THIS IS A PLACEHOLDER "
            + "THIS IS A PLACE HOLDER ----- THIS IS A PLACEHOLDER "
            + "THIS IS A PLACE HOLDER ----- THIS IS A PLACEHOLDER "
            + "THIS IS A PLACE HOLDER ----- THIS IS A PLACEHOLDER "
            + "THIS IS A PLACE HOLDER ----- THIS IS A PLACEHOLDER ";
    /** . */
    final JTextArea myGameHelpTextArea = new JTextArea(myGameHelpText);



    public GameHelpPanel() {
        this.setLayout(new OverlayLayout(this));
        this.add(myGameHelpBGLabel);

        myGameHelpBGLabel.setLayout(null);

        myTransparentHoldingPanel.setLayout(null);
        myTransparentHoldingPanel.setBackground(new Color(128,128,128, 80));
        myTransparentHoldingPanel.setBounds(440,200,410,300);

        //TODO: NEED TO FIGURE OUT A WAY TO MAKE TEXT NON SELECTABLE BY USER
        myGameHelpTextArea.setFont(new Font("Arial", Font.BOLD, 15));
        myGameHelpTextArea.setForeground(Color.WHITE);
        myGameHelpTextArea.setLineWrap(true);
        myGameHelpTextArea.setWrapStyleWord(true);
        myGameHelpTextArea.setEditable(false);
        myGameHelpTextArea.setOpaque(false);
        myGameHelpTextArea.setBounds(10,10, 380,230);

        myBackBtn.setBounds(50, 240, 75, 20);

        myTransparentHoldingPanel.add(myGameHelpTextArea);
        myTransparentHoldingPanel.add(myBackBtn);

        myGameHelpBGLabel.add(myTransparentHoldingPanel);
    }

}
