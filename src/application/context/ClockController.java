package application.context;

import java.net.URL;
import java.util.Calendar;
import java.util.ResourceBundle;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.binding.LongBinding;
import javafx.beans.value.ObservableLongValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.util.Duration;
import application.states.*;

public class ClockController implements Initializable {
	@FXML
	private Button btnIncrement;
	@FXML
	private Button btnChange;
	@FXML
	private Button btnCancel;
	@FXML
	private Button btnDecrement;
	
	public static final String HIGH_LIGHT_STYLE = "-fx-background-color: yellow;";
	public static final String NON_HIGH_LIGHT_STYLE = "-fx-background-color: white;";

	@FXML
	private Calendar time;

	private final Timeline secondTimer = new Timeline(new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {
	    @Override
	    public void handle(ActionEvent event) {
	        time.add(Calendar.SECOND, 1);
	        rePaintTimeControls();
	    }
	}));

	@FXML
	private IState currentState;

	@FXML
	private TextFlow txtFlwHours, txtFlwMinutes, txtFlwSeconds;

	@FXML
	private Text txtHours, txtMinutes, txtSeconds;

	public Button getBtnIncrement() {
		return btnIncrement;
	}

	public Button getBtnChange() {
		return btnChange;
	}

	public Button getBtnCancel() {
		return btnCancel;
	}

	public Button getBtnDecrement() {
		return btnDecrement;
	}

	public String getHighlightStyle() {
		return HIGH_LIGHT_STYLE;
	}

	public String getNotHightlightStyle() {
		return NON_HIGH_LIGHT_STYLE;
	}

	public Timeline getSecondTimer() {
		return secondTimer;
	}

	public TextFlow getTxtFlwHours() {
		return txtFlwHours;
	}

	public TextFlow getTxtFlwMinutes() {
		return txtFlwMinutes;
	}

	public TextFlow getTxtFlwSeconds() {
		return txtFlwSeconds;
	}

	public Text getTxtHours() {
		return txtHours;
	}

	public Text getTxtMinutes() {
		return txtMinutes;
	}

	public Text getTxtSeconds() {
		return txtSeconds;
	}

	@FXML
	private ObservableLongValue longValue = new LongBinding() {
		@Override
		protected long computeValue() {
			return getTime().getTimeInMillis();
		}
	};
	
	public ClockController() {
		time = Calendar.getInstance();
		currentState = new DisplayTimeState(this);
		secondTimer.setCycleCount(Animation.INDEFINITE);
		secondTimer.play();
	}

	@FXML
	private void handleChangeButton(ActionEvent event) {
		changeMode();
	}

	@FXML
	private void handleDecrementButton(ActionEvent event) {
		decrement();
	}

	@FXML
	private void handleIncrementButton(ActionEvent event) {
		increment();
	}

	@FXML
	private void handleCancelButton(ActionEvent event) {
		cancel();
	}

	/**
	 * + button event handler. Off loads the logic to the current state.
	 */
	public void increment() {
		currentState.increment();
	}

	/**
	 * - button event handler. Off loads the logic to current state.
	 */
	public void decrement() {
		currentState.decrement();
	}

	/**
	 * change mode button event handler
	 */
	public void changeMode() {
		currentState.changeMode();
	}

	/**
	 * cancel button event handler
	 */
	public void cancel() {
		currentState.cancel();
	}

	/**
	 * @param nextState
	 *            states call this method from their changeMode() implementation
	 */
	public void setState(IState nextState) {
		currentState = nextState;
		setHighlightedUnit();

	}

	/**
	 * @param showButtons
	 *            - true means show +- and cancel buttons false hides them
	 */
	public void toggleUpdateButtons(boolean showButtons) {
		btnDecrement.setVisible(showButtons);
		btnIncrement.setVisible(showButtons);
		btnCancel.setVisible(showButtons);
	}

	/**
	 * Hightlights the units being edited based off the type of the current
	 * state.
	 */
	private void setHighlightedUnit() {
		currentState.setHighlightedUnit();
	}

	/**
	 * this will update the values for the hours, minutes, seconds controls.
	 * states call into this
	 */
	public void rePaintTimeControls() {
		currentState.rePaintTimeControls();
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
