package application.context;

import java.net.URL;
import java.util.Calendar;
import java.util.ResourceBundle;

import javafx.beans.Observable;
import javafx.beans.binding.LongBinding;
import javafx.beans.value.ObservableLongValue;
import javafx.beans.value.ObservableNumberValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import application.states.*;

import java.util.Timer;

public class Clock implements Initializable{
	 @FXML private Button btnIncrement;
	 @FXML private Button btnChange;
	 @FXML private Button btnCancel;
	 @FXML private Button btnDecrement;
	private final String highlightStyle="-fx-background-color: yellow;";
	private final String notHightlightStyle="-fx-background-color: white;";
		
	 
	@FXML
	private Calendar time;
	
	private Timer timer;
	
	
	@FXML
	private IState currentState;
	
	@FXML
	private TextFlow txtFlwHours, txtFlwMinutes,txtFlwSeconds;
	
	@FXML
	private Text txtHours,	txtMinutes, txtSeconds;
	
	@FXML
	private ObservableLongValue longValue = new LongBinding() {
		@Override
		protected long computeValue() {
			return getTime().getTimeInMillis();
		}
	}; 

	@FXML
	private void handleChangeButton(ActionEvent event){
		changeMode();
	}
	
	@FXML
	private void handleDecrementButton(ActionEvent event){
		decrement();
	}
	
	@FXML
	private void handleIncrementButton(ActionEvent event){
		increment();
	}
	
	@FXML
	private void handleCancelButton(ActionEvent event){
		cancel();
	}
	
	
	public Clock(){
		time = Calendar.getInstance();
		currentState = new DisplayTimeState(this);
	}
	
	
	
	/**
	 * + button event handler.  Off loads the logic to the current state.
	 */
	public void increment(){
		currentState.increment();
	}
	
	/**
	 * - button event handler.  Off loads the logic to current state.
	 */
	public void decrement(){
		currentState.decrement();
	}
	
	/**
	 * change mode button event handler
	 */
	public void changeMode(){
		currentState.changeMode();
	}
	
	/**
	 * cancel button event handler
	 */
	public void cancel(){
		currentState.cancel();
	}
	
	/**
	 * @param nextState
	 * states call this method from their changeMode() implementation
	 */
	public void setState(IState nextState){
		currentState = nextState;
		setHighlightedUnit();
		
	}
	
	/**
	 * @param showButtons - true means show +- and cancel buttons false hides them
	 */
	public void toggleUpdateButtons(boolean showButtons){
		btnDecrement.setVisible(showButtons);
		btnIncrement.setVisible(showButtons);
		btnCancel.setVisible(showButtons);
	}
	
	/**
	 * Hightlights the units being edited based off the type of the current state.  
	 * We could have done this in the state's themselves but it is easier to consolidate it here.
	 */
	private void setHighlightedUnit(){
		
		if(currentState instanceof SetHoursState){
			txtFlwHours.setStyle(highlightStyle);
			txtFlwMinutes.setStyle(notHightlightStyle);
			txtFlwSeconds.setStyle(notHightlightStyle);
			
		}else if (currentState instanceof SetMinutesState){
			txtFlwHours.setStyle(notHightlightStyle);
			txtFlwMinutes.setStyle(highlightStyle);
			txtFlwSeconds.setStyle(notHightlightStyle);
			
		}else if (currentState instanceof SetSecondsState){
			txtFlwHours.setStyle(notHightlightStyle);
			txtFlwMinutes.setStyle(notHightlightStyle);
			txtFlwSeconds.setStyle(highlightStyle);
		}else{
			txtFlwHours.setStyle(notHightlightStyle);
			txtFlwMinutes.setStyle(notHightlightStyle);
			txtFlwSeconds.setStyle(notHightlightStyle);
		}
		
		
	}
	
	/**
	 * this will update the values for the hours, minutes, seconds controls.
	 * states call into this
	 */
	public void rePaintTimeControls(){
		txtHours.setText(Integer.toString(time.get(Calendar.HOUR_OF_DAY)));
		txtMinutes.setText(Integer.toString(time.get(Calendar.MINUTE)));
		txtSeconds.setText(Integer.toString(time.get(Calendar.SECOND)));
	}
	
	public Calendar getTime() {
		return time;
	}

	public void setTime(Calendar time) {
		this.time = time;
	}

	public IState getCurrentState() {
		return currentState;
	}

	public void setCurrentState(IState currentState) {
		this.currentState = currentState;
	}

	public ObservableLongValue getLongValue() {
		return longValue;
	}

	protected void setLongValue(ObservableLongValue longValue) {
		this.longValue = longValue;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		rePaintTimeControls();
		
	}
}
