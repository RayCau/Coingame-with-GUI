package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.GameEngineImpl;
import model.SimplePlayer;
import view.AppFrame;
import view.CoinToolBar;
import view.model.PlayerStates;
import view.model.PlayerWithState;

public class AddPlayerListener implements ActionListener {
	private CoinToolBar ctb;
	private GameEngineImpl gei;
	private AppFrame af;
	private PlayerStates ps;

	public AddPlayerListener (CoinToolBar ctb, GameEngineImpl gei, AppFrame af, PlayerStates ps) {
		this.ctb = ctb;
		this.gei = gei;
		this.af = af;
		this.ps = ps;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(ctb.getCoinMenuBar().addPlayerOption() == 0) {

			int checkThisPoints = 0;
			try {
				checkThisPoints = Integer.parseInt(this.ctb.getCoinMenuBar().getPlayPoints());
			}catch(NumberFormatException nfe) {
				checkThisPoints = 0;
			}

			if(checkInput(this.ctb.getCoinMenuBar().getIDTXT(), this.ctb.getCoinMenuBar().getNameTXT(), 
					checkThisPoints)) {
				
				if(hasDuplicate(this.ctb.getCoinMenuBar().getIDTXT())) {
					JOptionPane.showMessageDialog(null, "That player already exists."
							,"Alert", JOptionPane.ERROR_MESSAGE);
				}
				else {
					//Sets variables as the inputted data from the optionPane
					String ID = this.ctb.getCoinMenuBar().getIDTXT();		
					String name = this.ctb.getCoinMenuBar().getNameTXT();
					int points = Integer.parseInt(this.ctb.getCoinMenuBar().getPlayPoints());
					
					//creates new player with specified inputs
					SimplePlayer player = new SimplePlayer(ID, name, points);
					//resets player so that when they are added, they are added with NO_BET and 0 points
					player.resetBet();
					
					//adds player to the game engine
					gei.addPlayer(player);
					
					//creates new player with state for the SimplePlayer with the same ID
					PlayerWithState pws = new PlayerWithState(player);
					pws.setPreviousPoints(player.getPoints());
		
					//adds the playerwithstate to the playerstates hashmap
					ps.addPlayerWithState(pws);
					
					ctb.getComboBox().addItem(player.getPlayerId());
					af.getCoinSplitPanes().setCurrentPlayerUpdate(player, ps.getPlayerWithState(ID));

					ctb.getComboBox().setSelectedItem(ID);
					af.getStatusPanel().setCurrentActionString("Added player " + player.getPlayerName());
				}
			}
			else {
				//else return an error message 
				JOptionPane.showMessageDialog(null, "You have entered one or more invalid inputs. "
						+ "Input requires a string, string and integer greater than 1 respectively."
						,"Alert", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	//helper validation method for ID, name and points
	public boolean checkInput(String ID, String name, int points){
		boolean valid = false;
		if(ID.trim().length() == 0 || name.trim().length() == 0 || points <= 1) {
			valid = false;
			return false;
		}
		else {
			valid = true;
			return valid;
		}

	}
	//helper hasDuplicate checks if there is already a player with that ID variable.
	public boolean hasDuplicate(String ID) {
		boolean duplicate = false;
		if (gei.getAllPlayers().contains(gei.getPlayer(ID))) {
			duplicate = true;
			return duplicate;
		}else {
			duplicate = false;
			return duplicate;
		}

	}
}
