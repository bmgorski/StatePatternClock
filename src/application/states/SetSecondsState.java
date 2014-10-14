package application.states;

import java.util.Calendar;

import application.context.*;

public class SetSecondsState extends StateBase{

	public SetSecondsState(Clock clock) {
		super(clock);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void increment() {
		AClock.Time.add(Calendar.SECOND, 1);
		AClock.rePaintTimeControls();
	}

	@Override
	public void decrement() {
		AClock.Time.add(Calendar.SECOND, -1);
		AClock.rePaintTimeControls();
	}

	@Override
	public void timerTick() {
		// TODO Auto-generated method stub
		
	}

}
