package application.states;

import application.context.ClockController;

public interface IState {
	
	ClockController getClock();

	void increment();

	void decrement();

	void cancel();

	void changeMode();
	
	void setHighlightedUnit();
	
	void rePaintTimeControls();
}
