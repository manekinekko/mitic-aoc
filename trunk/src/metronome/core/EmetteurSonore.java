package metronome.core;

import java.io.File;
import java.io.IOException;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;

public class EmetteurSonore implements IEmetteurSonore {

	private Sequencer sequencer_;

	public EmetteurSonore() {

		Sequence sequence;

		try {
			// From file
			sequence = MidiSystem.getSequence(new File("src/metronome/assets/tac1.mid"));

			// Create a sequencer for the sequence
			sequencer_ = MidiSystem.getSequencer();
			sequencer_.open();
			sequencer_.setSequence(sequence);
		} catch (IOException e) {
		} catch (MidiUnavailableException e) {
		} catch (InvalidMidiDataException e) {
		}

	}

	@Override
	public void emettreClick() {
		sequencer_.start();
		sequencer_.setMicrosecondPosition(0);
	}

	public static void main(String[] args) {
		EmetteurSonore es = new EmetteurSonore();
		es.emettreClick();
	}

}
