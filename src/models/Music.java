package models;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *  This class holds the games music and methods to playing and stopping the music at any time.
 *
 *  @author Hassan Bassam Farhat
 *  @version Summer 2023
 */
public class Music {

    // constants
    /** The path to where the music file is. */
    private static final String MUSIC_FILE_PATH = "src/music/track001.wav";


    // instance fields
    /** Holds the current audio clip to be played in the game. */
    private Clip myAudioClip;


    // constructors

    /**
     *  Constructor calls on playAudio() method to have audio playing as soon as game started.
     */
    public Music() {
        playAudio();
    }


    // methods

    /**
     *  Tries to obtain the audio file, and then places into myAudioClip to then play
     *  the audio continuously throughout the game, unless otherwise specified.
     */
    public void playAudio() {
        try {
            final File audioFile = new File(MUSIC_FILE_PATH);
            if (audioFile.exists()) {
                final URL audioURL = audioFile.toURI().toURL();

                final AudioInputStream audioInputStream =
                        AudioSystem.getAudioInputStream(audioURL);

                myAudioClip = AudioSystem.getClip();
                myAudioClip.open(audioInputStream);
                myAudioClip.loop(Clip.LOOP_CONTINUOUSLY);
                myAudioClip.start();
                audioInputStream.close();
            }
        } catch (final LineUnavailableException
                       | UnsupportedAudioFileException | IOException e) {
            e.printStackTrace();
        }
    }

    /** Will stop the audio being played in the game when this method is called. */
    public void stopAudio() {
        if (myAudioClip != null && myAudioClip.isRunning()) {
            myAudioClip.stop();
            myAudioClip.setFramePosition(0);
            myAudioClip.close();
        }
    }

    /** Returns the audio clip to whomever called it. */
    public Clip getMyAudioClip() {
        return myAudioClip;
    }

}
