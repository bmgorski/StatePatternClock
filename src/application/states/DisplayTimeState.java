package application.states;

import application.context.*;

public class DisplayTimeState extends StateBase{

	public DisplayTimeState(Clock clock) {
		super(clock);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Does nothing we don't increment in displaymode state
	 */
	@Override
	public void increment() {
		
	}

	/**
	 * Does nothing we don't decrement in displaymode state
	 */
	@Override
	public void decrement() {

		
	}

	@Override
	public void timerTick() {
		
		
	}

}
