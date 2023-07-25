package views;

import javax.swing.*;
import java.awt.*;

public class MainMenuPanel extends JPanel {


    /** . */
    final JButton myStartNewGameBtn = new JButton("New Game");

    /** . */
    final JButton myLoadGameBtn = new JButton("Load");

    /** . */
    final JButton myOptionBtn = new JButton("Options");

    /** . */
    final JButton myExitBtn = new JButton("Exit");


    /** . */
    final ImageIcon myMainMenuBGImg = new ImageIcon("src/imgs/MainMenuBG_Image.jpg");

    /** . */
    final JLabel myMainMenuBGLabel = new JLabel(myMainMenuBGImg);


    public MainMenuPanel() {
        this.setLayout(new OverlayLayout(this));
        GridBagConstraints gbc = new GridBagConstraints();

        this.add(myMainMenuBGLabel);

        myMainMenuBGLabel.setLayout(new GridBagLayout());


        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.PAGE_END;
        gbc.insets = new Insets(10, 10, 10, 10);


        gbc.gridx = 1;
        myMainMenuBGLabel.add(myStartNewGameBtn, gbc);

        gbc.gridx = 2;
        myMainMenuBGLabel.add(myLoadGameBtn, gbc);

        gbc.gridx = 3;
        myMainMenuBGLabel.add(myOptionBtn, gbc);

        gbc.gridx = 4;
        myMainMenuBGLabel.add(myExitBtn, gbc);
    }



    private void setUpMainMenuScreen() {





    }




}
