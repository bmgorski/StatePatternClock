package application.context;

import java.util.Calendar;

import javafx.fxml.FXML;
import application.states.*;

public class Clock {
	@FXML
	public Calendar Time;
	@FXML
	public IState CurrentState;
	
	public Clock(){
		Time = Calendar.getInstance();
		CurrentState = new DisplayTimeState(this);
	}
	
	/**
	 * + button event handler.  Off loads the logic to the current state.
	 */
	public void increment(){
		CurrentState.increment();
	}
	
	/**
	 * - button event handler.  Off loads the logic to current state.
	 */
	public void decrement(){
		CurrentState.decrement();
	}
	
	/**
	 * change mode button event handler
	 */
	public void changeMode(){
		CurrentState.changeMode();
	}
	
	/**
	 * cancel button event handler
	 */
	public void cancel(){
		CurrentState.cancel();
	}
	
	/**
	 * @param nextState
	 * states call this method from their changeMode() implementation
	 */
	public void setState(IState nextState){
		CurrentState = nextState;
		setHighlightedUnit();
	}
	
	/**
	 * @param showButtons - true means show +- and cancel buttons false hides them
	 */
	public void toggleUpdateButtons(boolean showButtons){
		if(showButtons){
			//TODO  add code to show +- cancel buttons
		}else{
			//TODO add code to hide +- cancel buttons
		}
	}
	
	/**
	 * Hightlights the units being edited based off the type of the current state.  
	 * We could have done this in the state's themselves but it is easier to consolidate it here.
	 */
	private void setHighlightedUnit(){
		
		if(CurrentState instanceof SetHoursState){
			//TODO add code to highlight hours
		}else if (CurrentState instanceof SetMinutesState){
			//TODO add code to highlight minutes
		}else if (CurrentState instanceof SetSecondsState){
			//TODO add code to highlight seconds
		}
		
	}
	
	/**
	 * this will update the values for the hours, minutes, seconds controls.
	 * states call into this
	 */
	public void rePaintTimeControls(){
		//TODO add code to redraw the time controls
	}
	
	
}
