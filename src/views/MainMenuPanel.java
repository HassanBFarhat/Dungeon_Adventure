package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serial;
import java.io.Serializable;

public class MainMenuPanel extends JPanel {

    /** . */
//    final MainFrame mf = new MainFrame();




    /** . */
    final JButton myStartNewGameBtn = new JButton("NEW GAME");

    /** . */
    final JButton myLoadGameBtn = new JButton("     LOAD     ");

    /** . */
    final JButton myOptionBtn = new JButton(" OPTIONS  ");

    /** . */
    final JButton myExitBtn = new JButton("      EXIT      ");

    /** . */
    final ImageIcon myMainMenuBGImg = new ImageIcon("src/imgs/MainMenuBG_Image.jpg");

    /** . */
    final JLabel myMainMenuBGLabel = new JLabel(myMainMenuBGImg);

    /** . */
    final JLabel myTitleLabel = new JLabel("Dungeon Adventure");


    public MainMenuPanel() {
        this.setLayout(new OverlayLayout(this));

        myTitleLabel.setFont(new Font("Arial", Font.BOLD, 100));
        myTitleLabel.setForeground(Color.WHITE);
        this.add(myMainMenuBGLabel);

        myMainMenuBGLabel.setLayout(new BoxLayout(myMainMenuBGLabel, BoxLayout.Y_AXIS));

        myStartNewGameBtn.setPreferredSize(new Dimension(100, 40));
        myLoadGameBtn.setPreferredSize(new Dimension(100, 40));
        myOptionBtn.setPreferredSize(new Dimension(100, 40));
        myExitBtn.setPreferredSize(new Dimension(100, 40));

        myTitleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        myStartNewGameBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        myLoadGameBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        myOptionBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        myExitBtn.setAlignmentX(Component.CENTER_ALIGNMENT);

        myMainMenuBGLabel.add(myTitleLabel);
        myMainMenuBGLabel.add(Box.createVerticalGlue());
        myMainMenuBGLabel.add(myStartNewGameBtn);
        myMainMenuBGLabel.add(myLoadGameBtn);
        myMainMenuBGLabel.add(myOptionBtn);
        myMainMenuBGLabel.add(myExitBtn);
        myMainMenuBGLabel.add(Box.createVerticalGlue());

    }
}
