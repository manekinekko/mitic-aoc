package metronome.adapter;

public class Molette implements IMolette {

	private float currentPosition_;

	public Molette() {
		currentPosition_ = 0.0F;
	}
	
	public void setCurrentPosition(float currentPosition) {
		this.currentPosition_ = currentPosition;
	}

	@Override
	public float position() {
		return currentPosition_;
	}

}
