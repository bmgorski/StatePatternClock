package application.states;

import java.util.Calendar;

import application.context.*;

public class SetMinutesState extends StateBase {

	public SetMinutesState(Clock clock) {
		super(clock);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void increment() {
		aClock.getTime().add(Calendar.MINUTE, 1);
		aClock.rePaintTimeControls();
	}

	@Override
	public void decrement() {
		aClock.getTime().add(Calendar.MINUTE, -1);
		aClock.rePaintTimeControls();
	}

	@Override
	public void timerTick() {
		// TODO Auto-generated method stub

	}

}
