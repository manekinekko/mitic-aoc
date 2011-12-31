package metronome.core;

import java.io.File;
import java.io.InputStream;
import java.net.URL;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine.Info;
import javax.sound.sampled.SourceDataLine;

/**
 * Classe permettant de jouer un fichier Wav. Implémente l'interface
 * IEmetteurSonore pour sa méthode "emettreClick", utilisée pour jouer le tic du
 * métronome.
 * 
 * @author <ul>
 *         <li>Wassim Chegham (<a
 *         href=mailto:contact@cheghamwassim.com>contact@cheghamwassim.com</a>)</li>
 *         <li>Gurval Le Bouter (<a
 *         href=mailto:gurval.lebouter@gmail.com>gurval.lebouter@gmail.com</a>)</li>
 *         </ul>
 * @version 1.0
 * @see IEmetteurSonore
 */
public class EmetteurSonore implements IEmetteurSonore {

	private AudioInputStream audioInputStream_;
	private AudioFormat audioFormat_;
	private Info info_;
	private SourceDataLine source_;
	private URL waveFile_;

	/**
	 * Constructeur d'EmetteurSonore. Permet d'initialiser les différents objets
	 * nécessaires à la lecture du fichier wav.
	 * 
	 * @since 1.0
	 */
	public EmetteurSonore() {
		waveFile_ = getClass().getResource("/metronome/assets/tac.wav");
	}

	/**
	 * AudioPlayer est à a fois une inner class et un thread. Un appelle de la
	 * méthode start permet de lire un fichier audio. Un thread est utilisé afin
	 * de ne pas bloquer l'application durant la lecture du fichier.
	 * 
	 * @author <ul>
	 *         <li>Wassim Chegham (<a
	 *         href=mailto:contact@cheghamwassim.com>contact
	 *         @cheghamwassim.com</a>)</li>
	 *         <li>Gurval Le Bouter (<a
	 *         href=mailto:gurval.lebouter@gmail.com>gurval
	 *         .lebouter@gmail.com</a>)</li>
	 *         </ul>
	 * @version 1.0
	 * @since 1.0
	 */
	private class AudioPlayer extends Thread {

		/**
		 * Lance le thread et lis le fichier audio définit par la variable
		 * filename_.
		 * 
		 * @since 1.0
		 */
		public void run() {
			try {
				
				audioInputStream_ = AudioSystem.getAudioInputStream(waveFile_);
				audioFormat_ = audioInputStream_.getFormat();
				info_ = new Info(SourceDataLine.class, audioFormat_);
				source_ = (SourceDataLine) AudioSystem.getLine(info_);
				source_.open(audioFormat_);
				source_.start();

				int bufferSize = (int) audioFormat_.getSampleRate() * audioFormat_.getFrameSize();
				int bytesRead = 0;
				byte[] audioData = new byte[bufferSize];

				while (bytesRead > -1) {
					bytesRead = audioInputStream_.read(audioData, 0, audioData.length);
					if (bytesRead >= 0)
						source_.write(audioData, 0, bytesRead);
				}

				// Continues data line I/O until its buffer is drained.
				source_.drain();

				// Closes the data line, freeing any resources such as the audio
				// device.
				source_.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void emettreClick() {
		AudioPlayer ap = new AudioPlayer();
		ap.start();
	}

}
