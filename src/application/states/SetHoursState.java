package application.states;

import java.util.Calendar;

import application.context.*;

public class SetHoursState extends StateBase{

	public SetHoursState(Clock clock) {
		super(clock);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void increment() {
		AClock.Time.add(Calendar.HOUR, 1);
		AClock.rePaintTimeControls();
	}

	@Override
	public void decrement() {
		AClock.Time.add(Calendar.HOUR, -1);
		AClock.rePaintTimeControls();
	}

	@Override
	public void timerTick() {
		// TODO Auto-generated method stub
		
	}

}
