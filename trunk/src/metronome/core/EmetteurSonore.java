package metronome.core;

import javax.sound.midi.Instrument;
import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Synthesizer;

public class EmetteurSonore implements IEmetteurSonore {

	@Override
	public void emettreClick() {
		try {
			Synthesizer synth = MidiSystem.getSynthesizer();
			synth.open();

			final MidiChannel[] mc = synth.getChannels();
			Instrument[] instr = synth.getDefaultSoundbank().getInstruments();
			synth.loadInstrument(instr[76]); // Bottle Blow
			
			mc[4].noteOn(100, 100);
			
		} catch (MidiUnavailableException e) {
			System.out.println("Emettre click ne peut pas jouer du MIDI!");
		}
	}

//	public static void main(String[] args) {
//		EmetteurSonore es = new EmetteurSonore();
//		es.emettreClick();
//	}
	
}
