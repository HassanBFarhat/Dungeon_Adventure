package views;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame {

    // constants

    /** . */
    private static final String MAIN_MENU_PANEL = "Main";
    /** . */
    private static final String NEW_GAME_PANEL = "NewGame";
    /** . */
    private static final String OPTIONS_PANEL = "Option";
    /** . */
    private static final String GAME_INFO_PANEL = "GameInfo";
    /** . */
    private static final String GAME_HELP_PANEL = "GameHelp";
    /** . */
    private static final int FRAME_WIDTH = 1280;
    /** . */
    private static final int FRAME_HEIGHT = 720;

    // instance fields

    /** . */
    private JPanel myCardPanel;
    /** . */
    private MainMenuPanel myMainMenuPanel;
    /** . */
    private CharacterSelectionPanel myCharacterSelectionPanel;
    /** . */
    private OptionsPanel myOptionsPanel;
    /** . */
    private GameInformationPanel myGameInformationPanel;
    /** . */
    private GameHelpPanel myGameHelpPanel;


    // constructor

    public MainFrame() {
        instantiateInstanceDataFields();
        setUpFramePanels();
        setUpMainFrame();
        setUpPanelButtons();
    }


    // methods

    /** . */
    private void instantiateInstanceDataFields() {
        myCardPanel = new JPanel(new CardLayout());
        myMainMenuPanel = new MainMenuPanel();
        myCharacterSelectionPanel = new CharacterSelectionPanel();
        myOptionsPanel = new OptionsPanel();
        myGameInformationPanel = new GameInformationPanel();
        myGameHelpPanel = new GameHelpPanel();
    }

    /** . */
    private void setUpFramePanels() {
        myCardPanel.add(myMainMenuPanel, MAIN_MENU_PANEL);
        myCardPanel.add(myCharacterSelectionPanel, NEW_GAME_PANEL);
        myCardPanel.add(myOptionsPanel, OPTIONS_PANEL);
        myCardPanel.add(myGameInformationPanel, GAME_INFO_PANEL);
        myCardPanel.add(myGameHelpPanel, GAME_HELP_PANEL);
    }

    /** . */
    private void setUpMainFrame() {
        this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        this.setTitle("Dungeon Adventure");
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        final int centerX = (screenSize.width - this.getWidth()) / 2;
        final int centerY = (screenSize.height - this.getHeight()) / 2;
        // Set the frame to the center of the monitor
        this.setLocation(centerX, centerY);

        this.add(myCardPanel);
        this.pack();
        this.setVisible(true);
    }

    /** . */
    private void setUpPanelButtons() {
        myMainMenuPanel.myStartNewGameBtn.addActionListener(
                theAction -> changeScreen(NEW_GAME_PANEL));

        myMainMenuPanel.myLoadGameBtn.addActionListener(
                theAction -> System.out.println("LOADING"));

        myMainMenuPanel.myOptionBtn.addActionListener(
                theAction -> changeScreen(OPTIONS_PANEL));

        myMainMenuPanel.myExitBtn.addActionListener(
                theAction -> System.exit(0));

        myCharacterSelectionPanel.myBackBtn.addActionListener(
                theAction -> changeScreen(MAIN_MENU_PANEL));

        myOptionsPanel.myBackBtn.addActionListener(
                theAction -> changeScreen(MAIN_MENU_PANEL));

        myOptionsPanel.myGeneralInfoBtn.addActionListener(
                theAction -> changeScreen(GAME_INFO_PANEL));

        myOptionsPanel.myGameHelpBtn.addActionListener(
                theAction -> changeScreen(GAME_HELP_PANEL));

        myGameInformationPanel.myBackBtn.addActionListener(
                theAction -> changeScreen(OPTIONS_PANEL));

        myGameHelpPanel.myBackBtn.addActionListener(
                theAction -> changeScreen(OPTIONS_PANEL));
    }

    /** . */
    private void changeScreen(final String theScreen) {
        ((CardLayout) myCardPanel.getLayout()).show(myCardPanel, theScreen);
    }

}
