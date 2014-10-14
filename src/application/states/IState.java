package application.states;

public interface IState {

	void increment();
	void decrement();
	void cancel();
	void changeMode();
	void timerTick();
}
