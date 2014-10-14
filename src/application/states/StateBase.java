package application.states;

import application.context.*;

public abstract class StateBase implements IState {
	protected Clock AClock;
	
	public StateBase(Clock clock){
		AClock=clock;
	}
	
	@Override
	public void changeMode(){
		if(this instanceof DisplayTimeState){
			AClock.setState(new SetHoursState(AClock));
			AClock.toggleUpdateButtons(true);
		}
		else if(this instanceof SetHoursState){
			AClock.setState(new SetMinutesState(AClock));		
		}
		else if(this instanceof SetMinutesState){
			AClock.setState(new SetSecondsState(AClock));
		}
		else if(this instanceof SetSecondsState){
			AClock.setState(new DisplayTimeState(AClock));
			AClock.toggleUpdateButtons(false);
		}
	}
	
	@Override
	public void cancel(){
		if(this instanceof DisplayTimeState){
			//the state diagram show that cancel button isn't present on displaytime mode.  So this should never be invoked.
		}
		else if(this instanceof SetHoursState){
			AClock.setState(new DisplayTimeState(AClock));
			AClock.toggleUpdateButtons(false);
		}
		else if(this instanceof SetMinutesState){
			AClock.setState(new SetHoursState(AClock));
		}
		else if(this instanceof SetSecondsState){
			AClock.setState(new SetMinutesState(AClock));
		}
	}
	
	
}