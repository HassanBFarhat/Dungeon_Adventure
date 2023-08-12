package views;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
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
public class MainMenuPanel extends JPanel {

    // constants

    /** . */
    private static final int TITLE_FONT_SIZE = 120;
    /** . */
    private static final int BUTTON_WIDTH = 100;
    /** . */
    private static final int BUTTON_HEIGHT = 40;
    /** . */
    private static final int ALL_BUTTONS_X_AXIS = 590;
    /** . */
    private static final int START_BUTTON_Y_AXIS = 300;
    /** . */
    private static final int LOAD_BUTTON_Y_AXIS = 340;
    /** . */
    private static final int OPTIONS_BUTTON_Y_AXIS = 380;
    /** . */
    private static final int EXIT_BUTTON_Y_AXIS = 420;
    /** . */
    private static final String FONT_LABEL = "Freestyle Script";
    /** . */
    private static final int FONT_SIZE = 17;
    /** . */
    private static final int TITLE_WIDTH = 900;
    /** . */
    private static final int TITLE_HEIGHT = 150;
    /** . */
    private static final int TITLE_X_AXIS = 190;


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


    // private methods

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
        myTitleLabel.setBounds(TITLE_X_AXIS, 0, TITLE_WIDTH, TITLE_HEIGHT);
        this.add(myMainMenuBGLabel);
    }

    /** . */
    private void setTheSizeAndBoundsOfTheButtonsOnThisPanel() {
        myStartNewGameBtn.setBounds(ALL_BUTTONS_X_AXIS, START_BUTTON_Y_AXIS,
                                    BUTTON_WIDTH, BUTTON_HEIGHT);
        myStartNewGameBtn.setFont(new Font(FONT_LABEL, Font.BOLD, FONT_SIZE));
        myLoadGameBtn.setBounds(ALL_BUTTONS_X_AXIS, LOAD_BUTTON_Y_AXIS,
                                BUTTON_WIDTH, BUTTON_HEIGHT);
        myLoadGameBtn.setFont(new Font(FONT_LABEL, Font.BOLD, FONT_SIZE));
        myOptionBtn.setBounds(ALL_BUTTONS_X_AXIS, OPTIONS_BUTTON_Y_AXIS,
                              BUTTON_WIDTH, BUTTON_HEIGHT);
        myOptionBtn.setFont(new Font(FONT_LABEL, Font.BOLD, FONT_SIZE));
        myExitBtn.setBounds(ALL_BUTTONS_X_AXIS, EXIT_BUTTON_Y_AXIS,
                            BUTTON_WIDTH, BUTTON_HEIGHT);
        myExitBtn.setFont(new Font(FONT_LABEL, Font.BOLD, FONT_SIZE));
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

}
