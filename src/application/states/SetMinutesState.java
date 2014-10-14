package application.states;

import java.util.Calendar;

import application.context.*;

public class SetMinutesState extends StateBase{

	public SetMinutesState(Clock clock) {
		super(clock);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void increment() {
		AClock.Time.add(Calendar.MINUTE, 1);
		AClock.rePaintTimeControls();
	}

	@Override
	public void decrement() {
		AClock.Time.add(Calendar.MINUTE, -1);
		AClock.rePaintTimeControls();
	}

	@Override
	public void timerTick() {
		// TODO Auto-generated method stub
		
	}

}
