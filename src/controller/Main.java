package controller;

import views.MainFrame;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public final class Main {

    private Main() {
        // Utility class shouldn't have public or default constructor.
    }

    public static void main(final String[] theArgs) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        new MainFrame();
        music();
    }

    public static void music() throws UnsupportedAudioFileException, IOException, LineUnavailableException {

        File soundfile = new File("src/controller/track001.wav");
        AudioInputStream ais = AudioSystem.getAudioInputStream(soundfile);
        Clip clip = AudioSystem.getClip();
        clip.open(ais);
        clip.loop(Clip.LOOP_CONTINUOUSLY);
        clip.start();
    }

}
