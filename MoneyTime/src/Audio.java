import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Audio {
    //played when you answer incorrectly.
    public void losingSound() {
        try {
            URL url1 = this.getClass().getClassLoader().getResource("assets/losingSound.wav");
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(url1);
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();
        } catch (UnsupportedAudioFileException f) {
            f.printStackTrace();
        } catch (IOException f) {
            f.printStackTrace();
        } catch (LineUnavailableException f) {
            f.printStackTrace();
        }
    }

    //played when the user clicks on either online mode or offline mode buttons
    public void enteringSound() {
        try {
            URL url1 = this.getClass().getClassLoader().getResource("assets/enteringSound.wav");
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(url1);
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();
        } catch (UnsupportedAudioFileException f) {
            f.printStackTrace();
        } catch (IOException f) {
            f.printStackTrace();
        } catch (LineUnavailableException f) {
            f.printStackTrace();
        }
    }

    //played when the user answers the given question correctly.
    public void applauseSound1() {
        try {
            URL url1 = this.getClass().getClassLoader().getResource("assets/applause1.wav");
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(url1);
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();
        } catch (UnsupportedAudioFileException f) {
            f.printStackTrace();
        } catch (IOException f) {
            f.printStackTrace();
        } catch (LineUnavailableException f) {
            f.printStackTrace();
        }
    }

    /*played when the user clicks on collect money
      or when the user answers the final question correctly*/
    public void applauseSound2() {
        try {
            URL url1 = this.getClass().getClassLoader().getResource("assets/applause3.wav");
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(url1);
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();
        } catch (UnsupportedAudioFileException f) {
            f.printStackTrace();
        } catch (IOException f) {
            f.printStackTrace();
        } catch (LineUnavailableException f) {
            f.printStackTrace();
        }
    }

    //played when the user exhaust all his attempts
    public void buzzerSound2() {
        try {
            URL url1 = this.getClass().getClassLoader().getResource("assets/buzzer2.wav");
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(url1);
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();
        } catch (UnsupportedAudioFileException f) {
            f.printStackTrace();
        } catch (IOException f) {
            f.printStackTrace();
        } catch (LineUnavailableException f) {
            f.printStackTrace();
        }
    }

    //played when the user clicks the audience button
    public void chargeSound() {
        try {
            URL url1 = this.getClass().getClassLoader().getResource("assets/charge.wav");
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(url1);
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();
        } catch (UnsupportedAudioFileException f) {
            f.printStackTrace();
        } catch (IOException f) {
            f.printStackTrace();
        } catch (LineUnavailableException f) {
            f.printStackTrace();
        }
    }

    //played when the user clicks the 1-up question button
    public void cameraSound1() {
        try {
            URL url1 = this.getClass().getClassLoader().getResource("assets/camera1.wav");
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(url1);
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();
        } catch (UnsupportedAudioFileException f) {
            f.printStackTrace();
        } catch (IOException f) {
            f.printStackTrace();
        } catch (LineUnavailableException f) {
            f.printStackTrace();
        }
    }

    //played when the user clicks the 50/50 button
    public void cameraSound2() {
        try {
            URL url1 = this.getClass().getClassLoader().getResource("assets/camera2.wav");
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(url1);
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();
        } catch (UnsupportedAudioFileException f) {
            f.printStackTrace();
        } catch (IOException f) {
            f.printStackTrace();
        } catch (LineUnavailableException f) {
            f.printStackTrace();
        }
    }

    //played when the user clicks the rock.paper.scissor button
    public void cameraSound4() {
        try {
            URL url1 = this.getClass().getClassLoader().getResource("assets/camera4.wav");
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(url1);
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();
        } catch (UnsupportedAudioFileException f) {
            f.printStackTrace();
        } catch (IOException f) {
            f.printStackTrace();
        } catch (LineUnavailableException f) {
            f.printStackTrace();
        }
    }


}
