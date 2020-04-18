package view.model;

import java.util.HashMap;
import java.util.Map;

import model.GameEngineImpl;
import view.AppFrame;

//Contains a hashmap of player states to check if players have been spun once, record win/loss etc.
public class PlayerStates {

	private Map <String, PlayerWithState> PWSMap = new HashMap<String, PlayerWithState>();
	private GameEngineImpl gei;
	private AppFrame af;

	public PlayerStates(GameEngineImpl gei, AppFrame af) {
		this.gei = gei;
		this.af = af;
	}

	public void addPlayerWithState(PlayerWithState playerWithState) {
		PWSMap.put(playerWithState.getPlayerWithStateId(), playerWithState);
	}

	public boolean removePlayerWithState(String ID) {
		boolean removed = false;
		if(PWSMap.containsKey(ID)) {
			PWSMap.remove(ID);
			removed = true;
			return removed;
		}else {
			removed = false;
			return removed;
		}
	}

	public PlayerWithState getPlayerWithState(String ID) {
		if (PWSMap.containsKey(ID)) {
			return PWSMap.get(ID);
		}
		else {
			return null;
		}
	}

	public boolean getPlayerStateSpun(String ID) {
		if(PWSMap.containsKey(ID)) {
			return PWSMap.get(ID).getSpun();		
		}
		else {
			return false;
		}
	}

	public boolean checkPlayersSpun() {
		for(Map.Entry<String, PlayerWithState> entry : PWSMap.entrySet()) {
			if(entry.getValue().getSpun() == false){
				return false;
			}
		}
		return true;
	}
	public void setPWSCurrentPoints() {
		for(Map.Entry<String, PlayerWithState> entry : PWSMap.entrySet()) {
			if(gei.getPlayer(entry.getKey()) != null) {
				entry.getValue().setCurrentPoints(gei.getPlayer(entry.getKey()).getPoints());
			}
		}
	}


	public void setWinLoss() {
		for(Map.Entry<String, PlayerWithState> entry : PWSMap.entrySet()) {
			if(entry.getValue().getCurrentPoints() == entry.getValue().getPreviousPoints() - entry.getValue().getBetPoints()) {
				entry.getValue().incrementLost();
			}else if
			(entry.getValue().getCurrentPoints() == entry.getValue().getPreviousPoints() + entry.getValue().getBetPoints()) {
				entry.getValue().incrementWon();
			}
		}
	}

	public void updateAllPlayers() {
		for(Map.Entry<String, PlayerWithState> entry : PWSMap.entrySet()) {
			af.getCoinSplitPanes().setCurrentPlayerUpdate(gei.getPlayer(entry.getKey()), getPlayerWithState(entry.getKey()));
		}
	}

	public void resetPWSSpun() {
		for(Map.Entry<String, PlayerWithState> entry : PWSMap.entrySet()) {
			entry.getValue().setSpun(false);
		}
	}
	
	public void setAllPreviousPoints() {
		for(Map.Entry<String, PlayerWithState> entry : PWSMap.entrySet()) {
			entry.getValue().setPreviousPoints(gei.getPlayer(entry.getKey()).getPoints());
		}
	}
}