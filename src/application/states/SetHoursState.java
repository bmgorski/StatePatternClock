package application.states;

import java.util.Calendar;

import application.context.*;

public class SetHoursState extends StateBase {

	public SetHoursState(ClockController clock) {
		super(clock);
	}

	@Override
	public void increment() {
		aClock.getTime().add(Calendar.HOUR, 1);
		if(aClock.getTxtHours() != null){
			aClock.getTxtHours().setText(Integer.toString(aClock.getTime().get(Calendar.HOUR_OF_DAY)));
		}
	}

	@Override
	public void decrement() {
		aClock.getTime().add(Calendar.HOUR, -1);
		if(aClock.getTxtHours() != null){
			aClock.getTxtHours().setText(Integer.toString(aClock.getTime().get(Calendar.HOUR_OF_DAY)));
		}
	}

	@Override
	public void setHighlightedUnit() {
		aClock.getTxtFlwHours().setStyle(ClockController.HIGH_LIGHT_STYLE);
		aClock.getTxtFlwMinutes().setStyle(ClockController.NON_HIGH_LIGHT_STYLE);
		aClock.getTxtFlwSeconds().setStyle(ClockController.NON_HIGH_LIGHT_STYLE);
	}

	@Override
	public void rePaintTimeControls() {
		if(aClock.getTxtMinutes() != null){
			aClock.getTxtMinutes().setText(Integer.toString(aClock.getTime().get(Calendar.MINUTE)));
		}
		if(aClock.getTxtSeconds() != null){
			aClock.getTxtSeconds().setText(Integer.toString(aClock.getTime().get(Calendar.SECOND)));
		}
	}

	@Override
	public void cancel() {
		aClock.setState(new DisplayTimeState(aClock));
		aClock.toggleUpdateButtons(false);
	}

	@Override
	public void changeMode() {
		aClock.setState(new SetMinutesState(aClock));
	}

}
