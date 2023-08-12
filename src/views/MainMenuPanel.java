package views;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.*;

/**
 * @author Avinash Bavisetty
 * @author Hassan Bassam Farhat
 * @version Summer 2023
 */

public class MainMenuPanel extends JPanel {

    // constants

    /** . */
    private static final int TITLE_FONT_SIZE = 120;
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
        addBackgroundImage();
        setUpTitleAndBounds();
        setTheSizeAndBoundsOfTheButtonsOnThisPanel();
        centerAllComponentsOnThisPanel();
        addTitleAndButtonsOnTopOfBGImage();
    }


    // methods

    /** . */
    private void instantiateInstanceDataFields() {
        final ImageIcon mainMenuBGImg = new ImageIcon("src/imgs/MainMenuBG_Image.jpg");

        myStartNewGameBtn = new JButton("NEW GAME");
        myLoadGameBtn = new JButton("LOAD");
        myOptionBtn = new JButton("OPTIONS");
        myExitBtn = new JButton("EXIT");
        myMainMenuBGLabel = new JLabel(mainMenuBGImg);
        myTitleLabel = new JLabel("Dungeon Adventure");
    }

    /** . */
    private void addBackgroundImage() {
        this.add(myMainMenuBGLabel);
    }

    /** . */
    private void setUpTitleAndBounds() {
        this.setLayout(new OverlayLayout(this));
        myTitleLabel.setFont(new Font("Vivaldi", Font.BOLD, TITLE_FONT_SIZE));
        myTitleLabel.setForeground(Color.WHITE);
//        myTitleLabel.setBorder(BorderFactory.createLineBorder(Color.RED));
        myTitleLabel.setBounds(190, 0, 900, 150);
        this.add(myMainMenuBGLabel);
    }

    /** . */
    private void setTheSizeAndBoundsOfTheButtonsOnThisPanel() {
        myStartNewGameBtn.setBounds(590, 300, BUTTON_WIDTH, BUTTON_HEIGHT);
        myStartNewGameBtn.setFont(new Font("Freestyle Script", Font.BOLD, 17));
        myLoadGameBtn.setBounds(590, 340, BUTTON_WIDTH, BUTTON_HEIGHT);
        myLoadGameBtn.setFont(new Font("Freestyle Script", Font.BOLD, 17));
        myOptionBtn.setBounds(590, 380, BUTTON_WIDTH, BUTTON_HEIGHT);
        myOptionBtn.setFont(new Font("Freestyle Script", Font.BOLD, 17));
        myExitBtn.setBounds(590, 420, BUTTON_WIDTH, BUTTON_HEIGHT);
        myExitBtn.setFont(new Font("Freestyle Script", Font.BOLD, 17));
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
        myMainMenuBGLabel.setLayout(null);

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
