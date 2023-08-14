package models;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;



public class Music {

    // constants
    /** . */
    private static final String MUSIC_FILE_PATH = "src/music/track001.wav";


    // instance fields
    /** . */
    private Clip myAudioClip;


    // constructors

    public Music() {
        playAudio();
    }


    // methods

    /** . */
    public void playAudio() {
        try {
            final File audioFile = new File(MUSIC_FILE_PATH);
            final AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
            final AudioFormat format = audioStream.getFormat();

            final DataLine.Info info = new DataLine.Info(Clip.class, format);
            myAudioClip = (Clip) AudioSystem.getLine(info);

            myAudioClip.open(audioStream);
            myAudioClip.loop(Clip.LOOP_CONTINUOUSLY);
            myAudioClip.start();
        } catch (final LineUnavailableException
                       | UnsupportedAudioFileException | IOException e) {
            e.printStackTrace();
        }
    }

    /** . */
    public void stopAudio() {
        if (myAudioClip != null && myAudioClip.isRunning()) {
            myAudioClip.stop();
            myAudioClip.setFramePosition(0);
            myAudioClip.close();
        }
    }

    /** . */
    public Clip getMyAudioClip() {
        return myAudioClip;
    }

}
