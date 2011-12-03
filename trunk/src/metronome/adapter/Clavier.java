package metronome.adapter;

public class Clavier implements IClavier{

	private boolean[] touchePresse_;
	
	public Clavier() {
		touchePresse_ = new boolean[4];
	}
	
	@Override
	public boolean touchePresse(int i) {
		
		if(touchePresse_[i]){
			touchePresse_[i] = false;
			return true;
		}
		return false;
	}
	
	public void setTouchePresse(int touchePresse){
		touchePresse_[touchePresse] = true;
		System.out.println("Clavier.setTouchePresse()");
	}

}
