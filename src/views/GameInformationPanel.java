package views;

import javax.swing.*;
import javax.swing.text.Caret;
import javax.swing.text.DefaultCaret;
import java.awt.*;

public class GameInformationPanel extends JPanel {

    /** . */
    final ImageIcon myMainMenuBGImg = new ImageIcon("src/imgs/MainMenuBG_Image.jpg");
    /** . */
    final JLabel myGameInfoBGLabel = new JLabel(myMainMenuBGImg);
    /** . */
    final JPanel myTransparentHoldingPanel = new JPanel();

    /** . */
    final JButton myBackBtn = new JButton("Back");
    /** . */
    final String myGameInfoText = "In this Dungeon Adventure Game, you will be placed within a room "
            + "of the Dungeon with the task of visiting the rooms to obtain the 4 OO Principle keys: "
            + "Abstraction, Encapsulation, Inheritance, Polymorphism. \nYou have the option of choosing "
            + "between 3 hero's, but know this... you're journey to obtaining the keys won't be "
            + "an easy one. Your hero will have to fight a monster within each room. \n\"Oh.\" What are "
            + "the monsters you ask? Heh, win or lose, I guess you'll just have to play and find out!";
    /** . */
    final JTextArea myGameInfoTextArea = new JTextArea(myGameInfoText);
    /** . */
//    final JLabel myGameInfoTextArea = new JLabel(myGameInfoText);



    public GameInformationPanel() {
        this.setLayout(new OverlayLayout(this));
        this.add(myGameInfoBGLabel);

        myGameInfoBGLabel.setLayout(null);

        myTransparentHoldingPanel.setLayout(null);
        myTransparentHoldingPanel.setBackground(new Color(128,128,128, 80));
        myTransparentHoldingPanel.setBounds(440,200,410,300);

        //TODO: NEED TO FIGURE OUT A WAY TO MAKE TEXT NOT SELECTABLE BY USER
        myGameInfoTextArea.setFont(new Font("Arial", Font.BOLD, 15));
        myGameInfoTextArea.setForeground(Color.WHITE);
        myGameInfoTextArea.setLineWrap(true);
        myGameInfoTextArea.setWrapStyleWord(true);
        myGameInfoTextArea.setEditable(false);
        myGameInfoTextArea.setOpaque(false);
        myGameInfoTextArea.setFocusable(true);
        myGameInfoTextArea.setBounds(10,5, 380,230);

        myBackBtn.setBounds(50, 240, 75, 20);

        myTransparentHoldingPanel.add(myGameInfoTextArea);
        myTransparentHoldingPanel.add(myBackBtn);

        myGameInfoBGLabel.add(myTransparentHoldingPanel);
    }


}
