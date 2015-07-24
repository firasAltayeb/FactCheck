package moneyTime;

import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class moneyTimeAudio 
{
	//Plays the mtLosingSound.wav music file when instructed.
	public void losingSound()
	{
		try {

			URL url1 = this.getClass().getClassLoader().getResource("mtLosingSound.wav");
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
	
	//Plays the mtWinningSound.wav music file when instructed.
	public void winningSound()
	{
		try {

			URL url1 = this.getClass().getClassLoader().getResource("mtWinningSound.wav");
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
