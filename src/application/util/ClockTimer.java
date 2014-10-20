package application.util;

import java.util.Calendar;
import java.util.TimerTask;

import application.context.Clock;

public class ClockTimer extends TimerTask {
	private Clock clock;

	public ClockTimer(Clock clock) {
		this.clock = clock;
	}

	@Override
	public void run() {
		clock.getTime().add(Calendar.SECOND, 1);
	}
}
