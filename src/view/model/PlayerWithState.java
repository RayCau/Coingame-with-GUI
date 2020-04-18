package view.model;

import model.interfaces.Player;

/*
 * Player state is a class which is instantiated when a new player is added. Same ID as player it is referencing.
 * Player state objects exist to check if players have been spun once, record win/loss etc.
*/
public class PlayerWithState {
	private Player player;
	
	//spun is set as true when a player has spun once a round and reset after spinner spins
	private boolean spun = false;
	
	//won and lost integers
	private int won = 0;
	private int lost = 0;
	
	//points integers to check if a player has won or lost
	private int currentPoints;
	private int betPoints;
	private int previousPoints;
	
	
	public PlayerWithState(Player player) {
		this.player = player;
	}
	

	//********************************************//
	public String getPlayerWithStateId() {
		return player.getPlayerId();
	}
	
	public int getPlayerWithStatePoints() {
		return player.getPoints();
	}
	
	public int getPlayerWithBetPoints() {
		return player.getBet();
	}
	//********************************************//
	
	public boolean getSpun() {
		return this.spun;
	}
	
	public void setSpun(boolean spun) {
		this.spun = spun;
	}
	//********************* Getters and Setters ***********************//
	
	public int getWon() {
		return this.won;
	}
	
	public void incrementWon() {
		this.won++;
	}
	
	public int getLost() {
		return this.lost;
	}
	
	public void incrementLost() {
		this.lost++;
	}

	
	//********************** Getters and setters **********************//
	
	public int getPreviousPoints() {
		return this.previousPoints;
	}
	
	public void setPreviousPoints(int previous) {
		this.previousPoints = previous;
		
	}
	
	public int getBetPoints() {
		return this.betPoints;
	}
	
	public void setBetPoints(int bet) {
		this.betPoints = bet;
	}
	
	public int getCurrentPoints() {
		return this.currentPoints;
	}
	
	public void setCurrentPoints(int currentPoints) {
		this.currentPoints = currentPoints;
	}

	
	//********************************************//

}
