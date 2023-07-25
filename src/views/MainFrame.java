package views;

import javax.swing.JFrame;
import java.awt.*;

public class MainFrame extends JFrame {


    public MainFrame() {
        setUpMainFrame();
    }


    private void setUpMainFrame() {
        this.setVisible(true);
        this.setSize(1280, 720);
        this.setTitle("Dungeon Adventure");

        final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        final int centerX = (screenSize.width - this.getWidth()) / 2;
        final int centerY = (screenSize.height - this.getHeight()) / 2;
        // Set the frame to the center of the monitor
        this.setLocation(centerX, centerY);

        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }




}
