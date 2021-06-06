package mc322.lab07.controller;

import mc322.lab07.controller.state.LoadState;
import mc322.lab07.controller.state.State;
import mc322.lab07.controller.state.TurnBeginState;
import mc322.lab07.model.Player;

public class StateMachineController {
	
	public static StateMachineController instance;
	
	private Player player1;
	
	private Player player2;
	
	private Player currentPlayer;
	
	private State currentState;
	
	private boolean wasSquareSelected;
	
	
	public StateMachineController(String namePlayer1, String namePlayer2){
		instance = this;
		player1 = new Player('W', 0, namePlayer1);
		player2 = new Player('B', 0, namePlayer2);
		currentState = null;
		this.wasSquareSelected = false;
	}
	
	
	public Player getPlayer1() {
		return this.player1;
	}
	
	public Player getPlayer2() {
		return this.player2;
	}
	
	public Player getCurrentPlayer(){
		return this.currentPlayer;
	}
	
	public void setCurrentPlayer(Player player) {
		this.currentPlayer = player;
	}

	public State getCurrentState(){
		return this.currentState;
	}
	
	public boolean getWasSquareSelected() {
		return this.wasSquareSelected;
	}
	
	public void setWasSquareSelected(boolean bool) {
		this.wasSquareSelected = bool;
	}
	
	public void changeTo(State state) {
		if (this.currentState != state) {
			
			if (this.currentState != null) {
				this.currentState.exit();
			}
			
			this.currentState = state;
			if (this.currentState != null) {
				this.currentState.enter();
			}
		}
	}
	
	
	public void startGame() {
		changeTo(new TurnBeginState());
	}
}
