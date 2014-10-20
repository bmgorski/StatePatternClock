package application.states;

import java.util.Calendar;

import application.context.*;

public class DisplayTimeState extends StateBase {

	public DisplayTimeState(ClockController clock) {
		super(clock);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Does nothing we don't increment in displaymode state
	 */
	@Override
	public void increment() {

	}

	/**
	 * Does nothing we don't decrement in displaymode state
	 */
	@Override
	public void decrement() {

	}

	@Override
	public void setHighlightedUnit() {
		aClock.getTxtFlwHours().setStyle(ClockController.NON_HIGH_LIGHT_STYLE);
		aClock.getTxtFlwMinutes().setStyle(ClockController.NON_HIGH_LIGHT_STYLE);
		aClock.getTxtFlwSeconds().setStyle(ClockController.NON_HIGH_LIGHT_STYLE);
	}

	@Override
	public void rePaintTimeControls() {
		if(aClock.getTxtHours() != null){
			aClock.getTxtHours().setText(Integer.toString(aClock.getTime().get(Calendar.HOUR_OF_DAY)));
		}
		if(aClock.getTxtMinutes() != null){
			aClock.getTxtMinutes().setText(Integer.toString(aClock.getTime().get(Calendar.MINUTE)));
		}
		if(aClock.getTxtSeconds() != null){
			aClock.getTxtSeconds().setText(Integer.toString(aClock.getTime().get(Calendar.SECOND)));
		}
	}

	@Override
	public void cancel() {
		//Not visible in this mode. so should not do anything if called
	}

	@Override
	public void changeMode() {
		aClock.setState(new SetHoursState(aClock));
		aClock.toggleUpdateButtons(true);
	}

}
