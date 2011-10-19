package metronome.core;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.DataLine.Info;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.AudioSystem;

import java.io.File;

public class EmetteurSonore implements IEmetteurSonore{

	public void readWavFile(final String fileName) {
		Runnable runnableSound = new RunnableSound(fileName);
		Thread thread = new Thread(runnableSound);
		thread.start();      
	}

	class RunnableSound implements Runnable {

		private String fileName;
		
		public RunnableSound(String fileName) {
			this.fileName = fileName;
		}
		
		public void run() {
			try {
				AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(fileName));
				AudioFormat format = audioInputStream.getFormat();
				Info info = new Info(SourceDataLine.class, format);
				SourceDataLine source = (SourceDataLine)AudioSystem.getLine(info);
				source.open(format);
				source.start();
				int read = 0;
				byte[] audioData = new byte[16384];
				
				while(read > -1) {
					read = audioInputStream.read(audioData, 0 , audioData.length);
					if(read >= 0)
						source.write(audioData, 0, read);
				}
				
				source.drain();
				source.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public void emettreClick() {
		
	}

}
