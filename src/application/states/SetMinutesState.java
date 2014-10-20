package application.states;

import java.util.Calendar;

import application.context.*;

public class SetMinutesState extends StateBase {

	public SetMinutesState(ClockController clock) {
		super(clock);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void increment() {
		aClock.getTime().add(Calendar.MINUTE, 1);
		if (aClock.getTxtMinutes() != null) {
			aClock.getTxtMinutes().setText(
					Integer.toString(aClock.getTime().get(Calendar.MINUTE)));
		}
	}

	@Override
	public void decrement() {
		aClock.getTime().add(Calendar.MINUTE, -1);
		if (aClock.getTxtMinutes() != null) {
			aClock.getTxtMinutes().setText(
					Integer.toString(aClock.getTime().get(Calendar.MINUTE)));
		}
	}

	@Override
	public void setHighlightedUnit() {
		aClock.getTxtFlwHours().setStyle(ClockController.NON_HIGH_LIGHT_STYLE);
		aClock.getTxtFlwMinutes().setStyle(ClockController.HIGH_LIGHT_STYLE);
		aClock.getTxtFlwSeconds()
				.setStyle(ClockController.NON_HIGH_LIGHT_STYLE);
	}

	@Override
	public void rePaintTimeControls() {
		if (aClock.getTxtHours() != null) {
			aClock.getTxtHours()
					.setText(
							Integer.toString(aClock.getTime().get(
									Calendar.HOUR_OF_DAY)));
		}
		if (aClock.getTxtSeconds() != null) {
			aClock.getTxtSeconds().setText(
					Integer.toString(aClock.getTime().get(Calendar.SECOND)));
		}
	}

	@Override
	public void cancel() {
		aClock.setState(new SetHoursState(aClock));
	}

	@Override
	public void changeMode() {
		aClock.setState(new SetSecondsState(aClock));
		aClock.getSecondTimer().stop();
	}

}
