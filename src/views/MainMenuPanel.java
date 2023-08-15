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

    /** Font size. */
    private static final int TITLE_FONT_SIZE = 120;
    /** button width. */
    private static final int BUTTON_WIDTH = 100;
    /** button height. */
    private static final int BUTTON_HEIGHT = 40;
    /** all buttons x coordinate. */
    private static final int ALL_BUTTONS_X_AXIS = 590;
    /** start button y coordinate. */
    private static final int START_BUTTON_Y_AXIS = 300;
    /** load button y coordinate. */
    private static final int LOAD_BUTTON_Y_AXIS = 340;
    /** options button y coordinate. */
    private static final int OPTIONS_BUTTON_Y_AXIS = 380;
    /** exit button y coordinate. */
    private static final int EXIT_BUTTON_Y_AXIS = 420;
    /** Font Style. */
    private static final String FONT_LABEL = "Freestyle Script";
    /** Font size. */
    private static final int FONT_SIZE = 17;
    /** title width. */
    private static final int TITLE_WIDTH = 900;
    /** title height . */
    private static final int TITLE_HEIGHT = 150;
    /** title x coordinate. */
    private static final int TITLE_X_AXIS = 190;


    // instance fields

    /** start new game button starts new game. */
    private JButton myStartNewGameBtn;
    /** load game button loads game. */
    private JButton myLoadGameBtn;
    /** options button provides options. */
    private JButton myOptionBtn;
    /** exit button exits the program. */
    private JButton myExitBtn;
    /** mainmenu background label. */
    private JLabel myMainMenuBGLabel;
    /** title of the game label. */
    private JLabel myTitleLabel;


    // constructor

    /** sets up the MainMenuPanel as well as the components required for the components that need to be displayed. */
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

    /** gets start new game button. */
    public JButton getStartNewGameBtn() {
        return myStartNewGameBtn;
    }

    /** gets load game button. */
    public JButton getLoadGameBtn() {
        return myLoadGameBtn;
    }

    /** get options button. */
    public JButton getOptionsBtn() {
        return myOptionBtn;
    }

    /** get exit button. */
    public JButton getExitBtn() {
        return myExitBtn;
    }


    // private methods

    /** instantiating data fields for MainMenuPanel that provides info regarding main menu. */
    private void instantiateInstanceDataFields() {
        final ImageIcon mainMenuBGImg = new ImageIcon("src/imgs/MainMenuBG_Image.jpg");
        myStartNewGameBtn = new JButton("NEW GAME");
        myLoadGameBtn = new JButton("LOAD");
        myOptionBtn = new JButton("OPTIONS");
        myExitBtn = new JButton("EXIT");
        myMainMenuBGLabel = new JLabel(mainMenuBGImg);
        myTitleLabel = new JLabel("Dungeon Adventure");
    }

    /** adds background image to the main menu. */
    private void addBackgroundImage() {
        this.add(myMainMenuBGLabel);
    }

    /** sets up the title and bounds of the title. */
    private void setUpTitleAndBounds() {
        this.setLayout(new OverlayLayout(this));
        myTitleLabel.setFont(new Font("Vivaldi", Font.BOLD, TITLE_FONT_SIZE));
        myTitleLabel.setForeground(Color.WHITE);
        myTitleLabel.setBounds(TITLE_X_AXIS, 0, TITLE_WIDTH, TITLE_HEIGHT);
        this.add(myMainMenuBGLabel);
    }

    /** sets the size and bounds of the buttons on this panel. */
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

    /** centers all of the components on the panel . */
    private void centerAllComponentsOnThisPanel() {
        myTitleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        myStartNewGameBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        myLoadGameBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        myOptionBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        myExitBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
    }

    /** adds title and buttons on top of the background image. */
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
