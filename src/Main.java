import views.CharacterSelectionPanel;
import views.MainFrame;
import views.MainMenuPanel;

public class Main {

    public static void main ( final String[] theArgs) {
        MainFrame mf = new MainFrame();
        MainMenuPanel mp = new MainMenuPanel();
        CharacterSelectionPanel csp = new CharacterSelectionPanel();

        mf.add(mp);
//        mf.add(csp);
        mf.pack();
        mf.setVisible(true);
    }

}
