package zollernextras.lib.enums;

public enum State {
	OFF(0), ON(1);
	
	private State st;
	private int intState;
	
	private State(int st) {
		intState = st;
	}
	
	private State(State st) {
		this.st = st;
	}
	
	public void setState(int st) {
		intState = st;
	}
	
	public void setState(State st) {
		this.st = st;
	}
	
	public int getState() {
		return intState;
	}
	
	public State getActualState() {
		return st;
	}
}
