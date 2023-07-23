package Views;

import javax.swing.JFrame;
import java.awt.*;

public class MainFrame {

    /** . */
    final JFrame myMainFrame = new JFrame();

    public MainFrame() {
        setUpMainFrame();
    }


    private void setUpMainFrame() {
        myMainFrame.setVisible(true);
        myMainFrame.setSize(800, 600);
        myMainFrame.setTitle("Dungeon Adventure");

        final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        final int centerX = (screenSize.width - myMainFrame.getWidth()) / 2;
        final int centerY = (screenSize.height - myMainFrame.getHeight()) / 2;
        // Set the frame to the center of the monitor
        myMainFrame.setLocation(centerX, centerY);

        myMainFrame.setResizable(true);
        myMainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }




}
