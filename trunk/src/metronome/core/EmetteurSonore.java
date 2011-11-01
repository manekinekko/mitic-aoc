package metronome.core;

import java.io.File;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.DataLine.Info;

public class EmetteurSonore implements IEmetteurSonore {

	private String filename_;
	private AudioInputStream audioInputStream_;
	private AudioFormat audioFormat_;
	private Info info_;
	private SourceDataLine source_;

	public EmetteurSonore() {
		filename_ = "src/metronome/assets/tac.wav";
		try {
			audioInputStream_ = AudioSystem.getAudioInputStream(new File(filename_));
			audioFormat_ = audioInputStream_.getFormat();
			info_ = new Info(SourceDataLine.class, audioFormat_);
			source_ = (SourceDataLine) AudioSystem.getLine(info_);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	private class AudioPlayer extends Thread{
		
		public void run(){
			try {
				audioInputStream_ = AudioSystem.getAudioInputStream(new File(filename_));
				audioFormat_ = audioInputStream_.getFormat();
				info_ = new Info(SourceDataLine.class, audioFormat_);
				source_ = (SourceDataLine) AudioSystem.getLine(info_);
				source_.open(audioFormat_);
				source_.start();

				int bufferSize = (int) audioFormat_.getSampleRate()* audioFormat_.getFrameSize();
				int bytesRead = 0;
				byte[] audioData = new byte[bufferSize];

				while (bytesRead > -1) {
					bytesRead = audioInputStream_.read(audioData, 0, audioData.length);
					if (bytesRead >= 0)
						source_.write(audioData, 0, bytesRead);
				}

				// Continues data line I/O until its buffer is drained.
				source_.drain();

				// Closes the data line, freeing any resources such as the audio device.
				source_.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public void emettreClick() {
		AudioPlayer ap = new AudioPlayer();
		ap.start();
	}

}
