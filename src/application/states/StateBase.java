package application.states;

import application.context.*;

public abstract class StateBase implements IState {
	protected ClockController aClock;

	public ClockController getClock() {
		return aClock;
	}

	public StateBase(ClockController clock) {
		aClock = clock;
	}
}