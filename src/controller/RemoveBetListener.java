package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.GameEngineImpl;
import model.enumeration.BetType;
import model.interfaces.Player;
import view.AppFrame;
import view.model.PlayerStates;

public class RemoveBetListener implements ActionListener{
	private AppFrame af;
	private GameEngineImpl gei;
	private PlayerStates ps;
	
	public RemoveBetListener(GameEngineImpl gei, AppFrame af, PlayerStates ps) {
		this.af = af;
		this.gei = gei;
		this.ps = ps;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(af.getCoinToolBar().getCoinMenuBar().removeBetOption() == 0) {
			Player thisPlayer = gei.getPlayer(af.getCoinToolBar().getCoinMenuBar().getRemoveBetField());
			if(thisPlayer != null) {
				if(!checkRemoved(thisPlayer)) {
					thisPlayer.resetBet();
					af.getCoinSplitPanes().setCurrentPlayerUpdate(thisPlayer, ps.getPlayerWithState(thisPlayer.getPlayerId()));
					af.getStatusPanel().setCurrentActionString("Removed bet on player " + thisPlayer.getPlayerName());
				}else {
					JOptionPane.showMessageDialog(null, "That player has already been reset or has not bet."
							,"Alert", JOptionPane.ERROR_MESSAGE);
				}
			}else {
				JOptionPane.showMessageDialog(null, "That player of the ID you entered does not exist."
						,"Alert", JOptionPane.ERROR_MESSAGE);
			}
		}

	}	

	public boolean checkRemoved(Player thisPlayer) {
		boolean removed = false;
		if(thisPlayer.getBetType() == BetType.NO_BET && thisPlayer.getBet() == 0) {
			removed = true;
			return removed;
		}
		return removed;
	}
}



