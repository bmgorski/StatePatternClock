package application.states;

import java.util.Calendar;

import application.context.*;

public class SetSecondsState extends StateBase {

	public SetSecondsState(ClockController clock) {
		super(clock);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void increment() {
		aClock.getTime().add(Calendar.SECOND, 1);
		if(aClock.getTxtSeconds() != null){
			aClock.getTxtSeconds().setText(Integer.toString(aClock.getTime().get(Calendar.SECOND)));
		}
	}

	@Override
	public void decrement() {
		aClock.getTime().add(Calendar.SECOND, -1);
		if(aClock.getTxtSeconds() != null){
			aClock.getTxtSeconds().setText(Integer.toString(aClock.getTime().get(Calendar.SECOND)));
		}
	}

	@Override
	public void setHighlightedUnit() {
		aClock.getTxtFlwHours().setStyle(ClockController.NON_HIGH_LIGHT_STYLE);
		aClock.getTxtFlwMinutes().setStyle(ClockController.NON_HIGH_LIGHT_STYLE);
		aClock.getTxtFlwSeconds().setStyle(ClockController.HIGH_LIGHT_STYLE);
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
		aClock.setState(new SetMinutesState(aClock));
		aClock.getSecondTimer().play();
	}

	@Override
	public void changeMode() {
		aClock.setState(new DisplayTimeState(aClock));
		aClock.toggleUpdateButtons(false);
		aClock.getSecondTimer().play();
	}
}
