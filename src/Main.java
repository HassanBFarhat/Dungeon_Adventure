import views.MainFrame;
import views.MainMenuPanel;

public class Main {

    public static void main ( final String[] theArgs) {
        MainFrame mf = new MainFrame();
        MainMenuPanel mp = new MainMenuPanel();

        mf.add(mp);
        mf.pack();
        mf.setVisible(true);
    }

}
