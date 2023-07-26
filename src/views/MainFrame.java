package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {

    /** . */
    private JPanel myCardPanel = new JPanel(new CardLayout());
    /** . */
    private MainMenuPanel mp = new MainMenuPanel();
    /** . */
    private CharacterSelectionPanel csp = new CharacterSelectionPanel();


    public MainFrame() {
        setUpFramePanels();
        setUpMainFrame();
        setUpPanelButtons();
    }


    private void setUpMainFrame() {

        this.setSize(1280, 720);
        this.setTitle("Dungeon Adventure");

        final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        final int centerX = (screenSize.width - this.getWidth()) / 2;
        final int centerY = (screenSize.height - this.getHeight()) / 2;
        // Set the frame to the center of the monitor
        this.setLocation(centerX, centerY);

        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        this.add(myCardPanel);
        this.pack();

        this.setVisible(true);
    }

    public void changeScreen(String theScreen) {
        ((CardLayout) myCardPanel.getLayout()).show(myCardPanel, theScreen);
    }

    private void setUpFramePanels() {
        myCardPanel.add(mp, "Main");
        myCardPanel.add(csp, "NewGame");
    }


    private void setUpPanelButtons() {
        mp.myStartNewGameBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                mf.changeScreen("NewGame");
                changeScreen("NewGame");
            }
        });

        mp.myLoadGameBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("LOADING");
            }
        });

        mp.myOptionBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("OPTIONS");
            }
        });

        mp.myExitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        csp.myBackBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeScreen("Main");
            }
        });
    }
}
