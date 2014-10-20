package application.states;

import application.context.*;

public abstract class StateBase implements IState {
	protected Clock aClock;

	public StateBase(Clock clock) {
		aClock = clock;
	}

	@Override
	public void changeMode() {
		if (this instanceof DisplayTimeState) {
			aClock.setState(new SetHoursState(aClock));

			aClock.toggleUpdateButtons(true);
		} else if (this instanceof SetHoursState) {
			aClock.setState(new SetMinutesState(aClock));
		} else if (this instanceof SetMinutesState) {
			aClock.setState(new SetSecondsState(aClock));
		} else if (this instanceof SetSecondsState) {
			aClock.setState(new DisplayTimeState(aClock));
			aClock.toggleUpdateButtons(false);
		}
	}

	@Override
	public void cancel() {
		if (this instanceof DisplayTimeState) {
			// the state diagram show that cancel button isn't present on
			// displaytime mode. So this should never be invoked.
		} else if (this instanceof SetHoursState) {
			aClock.setState(new DisplayTimeState(aClock));
			aClock.toggleUpdateButtons(false);
		} else if (this instanceof SetMinutesState) {
			aClock.setState(new SetHoursState(aClock));
		} else if (this instanceof SetSecondsState) {
			aClock.setState(new SetMinutesState(aClock));
		}
	}

}