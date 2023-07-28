package views;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.OverlayLayout;

public class MainMenuPanel extends JPanel {

    // constants

    /** . */
    private static final int TITLE_FONT_SIZE = 100;
    /** . */
    private static final int BUTTON_WIDTH = 100;
    /** . */
    private static final int BUTTON_HEIGHT = 40;

    // instance fields

    /** . */
    private JButton myStartNewGameBtn;
    /** . */
    private JButton myLoadGameBtn;
    /** . */
    private JButton myOptionBtn;
    /** . */
    private JButton myExitBtn;
    /** . */
    private JLabel myMainMenuBGLabel;
    /** . */
    private JLabel myTitleLabel;


    // constructor

    public MainMenuPanel() {
        this.setLayout(new OverlayLayout(this));
        instantiateInstanceDataFields();
        setUpTitleAndAddBackgroundImage();
        setTheSizeOfTheButtonsOnThisPanel();
        centerAllComponentsOnThisPanel();
        addTitleAndButtonsOnTopOfBGImage();
    }


    // methods

    /** . */
    private void instantiateInstanceDataFields() {
        final ImageIcon mainMenuBGImg = new ImageIcon("src/imgs/MainMenuBG_Image.jpg");

        myStartNewGameBtn = new JButton("NEW GAME");
        myLoadGameBtn = new JButton("     LOAD     ");
        myOptionBtn = new JButton(" OPTIONS  ");
        myExitBtn = new JButton("      EXIT      ");
        myMainMenuBGLabel = new JLabel(mainMenuBGImg);
        myTitleLabel = new JLabel("Dungeon Adventure");
    }

    /** . */
    private void setUpTitleAndAddBackgroundImage() {
        myTitleLabel.setFont(new Font("Arial", Font.BOLD, TITLE_FONT_SIZE));
        myTitleLabel.setForeground(Color.WHITE);
        this.add(myMainMenuBGLabel);
    }

    /** . */
    private void setTheSizeOfTheButtonsOnThisPanel() {
        myStartNewGameBtn.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
        myLoadGameBtn.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
        myOptionBtn.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
        myExitBtn.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
    }

    /** . */
    private void centerAllComponentsOnThisPanel() {
        myTitleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        myStartNewGameBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        myLoadGameBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        myOptionBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        myExitBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
    }

    /** . */
    private void addTitleAndButtonsOnTopOfBGImage() {
        myMainMenuBGLabel.setLayout(new BoxLayout(myMainMenuBGLabel, BoxLayout.Y_AXIS));

        myMainMenuBGLabel.add(myTitleLabel);
        myMainMenuBGLabel.add(Box.createVerticalGlue());
        myMainMenuBGLabel.add(myStartNewGameBtn);
        myMainMenuBGLabel.add(myLoadGameBtn);
        myMainMenuBGLabel.add(myOptionBtn);
        myMainMenuBGLabel.add(myExitBtn);
        myMainMenuBGLabel.add(Box.createVerticalGlue());
    }

    /** . */
    public JButton getStartNewGameBtn() {
        return myStartNewGameBtn;
    }

    /** . */
    public JButton getLoadGameBtn() {
        return myLoadGameBtn;
    }

    /** . */
    public JButton getOptionsBtn() {
        return myOptionBtn;
    }

    /** . */
    public JButton getExitBtn() {
        return myExitBtn;
    }

}
