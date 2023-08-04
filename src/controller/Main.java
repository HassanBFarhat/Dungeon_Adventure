package controller;

import views.MainFrame;

public final class Main {

    private Main() {
        // Utility class shouldn't have public or default constructor.
    }

    public static void main(final String[] theArgs) {
        new MainFrame();
    }

}
