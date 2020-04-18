package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.GameEngineImpl;
import model.enumeration.BetType;
import model.interfaces.Player;
import view.AppFrame;
import view.model.PlayerStates;

public class PlaceBetListener implements ActionListener {
	private GameEngineImpl gei;
	private AppFrame af;
	private PlayerStates ps;

	public PlaceBetListener(GameEngineImpl gei, AppFrame af, PlayerStates ps) {
		this.gei = gei;
		this.af = af;
		this.ps = ps;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(af.getCoinToolBar().getCoinMenuBar().placeBetOption() == 0) {
			int checkThisPoints = 0;
			try {
				checkThisPoints = this.af.getCoinToolBar().getCoinMenuBar().getBetPointsField();
			}catch(NumberFormatException nfe) {
				JOptionPane.showMessageDialog(null, "Please enter a valid value for points."
						,"Alert", JOptionPane.ERROR_MESSAGE);
				checkThisPoints = 0;
			}
			if(playerExists(this.af.getCoinToolBar().getCoinMenuBar().getBetIDField())) {
				if (checkInput(this.af.getCoinToolBar().getCoinMenuBar().getBetIDField(), checkThisPoints)) {
					
					String betPlayerID = this.af.getCoinToolBar().getCoinMenuBar().getBetIDField();
					int betPoints = this.af.getCoinToolBar().getCoinMenuBar().getBetPointsField();
					BetType betType = null;


					if(this.af.getCoinToolBar().getCoinMenuBar().getBetTypeField() == BetType.COIN1) {
						betType = BetType.COIN1;
					}
					else if(this.af.getCoinToolBar().getCoinMenuBar().getBetTypeField() == BetType.COIN2) {
						betType = BetType.COIN2;
					}
					else if(this.af.getCoinToolBar().getCoinMenuBar().getBetTypeField() == BetType.BOTH) {
						betType = BetType.BOTH;
					}
					else if(this.af.getCoinToolBar().getCoinMenuBar().getBetTypeField() == BetType.NO_BET) {
						betType = BetType.NO_BET;
					}

					Player player = this.gei.getPlayer(betPlayerID);
					
					this.gei.placeBet(player, betPoints, betType);
					
					this.ps.getPlayerWithState(betPlayerID).setBetPoints(betPoints);

					this.af.getCoinToolBar().getComboBox().setSelectedItem(betPlayerID);
					
					this.af.getStatusPanel().setCurrentActionString("Placed bet for player " + player.getPlayerName()
																	+ " of amount " + betPoints);
				} else {
					JOptionPane.showMessageDialog(null, "You have entered one or more invalid inputs. To place a bet, "
							+ "input requires a string, and an integer greater than 0 but less than "
							+ "or equal to your player's points respectively."
							,"Alert", JOptionPane.ERROR_MESSAGE);
				}				
			}else {
				JOptionPane.showMessageDialog(null, "You have not entered a valid player. Please enter an existing player, or create a"
						+ " new player"
						,"Alert", JOptionPane.ERROR_MESSAGE);
			}
		}

	}
	//helper validation methods
	
	public boolean checkInput(String ID, int betPoints) {
		boolean valid = false;
		if(betPoints > gei.getPlayer(ID).getPoints() || betPoints < 0 || ID.trim().length() == 0 ) {
			valid = false;
			return valid;
		}else {
			valid = true;
			return valid;
		}
	}

	public boolean playerExists(String ID) {
		boolean exists = false;
		if(gei.getAllPlayers().contains(gei.getPlayer(ID))) {
			exists = true;
			return exists;
		}
		else {
			exists = false;
			return exists;
		}
	}
}


