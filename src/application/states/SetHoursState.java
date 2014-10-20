package application.states;

import java.util.Calendar;

import application.context.*;

public class SetHoursState extends StateBase {

	public SetHoursState(Clock clock) {
		super(clock);
	}

	@Override
	public void increment() {
		aClock.getTime().add(Calendar.HOUR, 1);
		aClock.rePaintTimeControls();
	}

	@Override
	public void decrement() {
		aClock.getTime().add(Calendar.HOUR, -1);
		aClock.rePaintTimeControls();
	}

	@Override
	public void timerTick() {
		// TODO Auto-generated method stub

	}

}
