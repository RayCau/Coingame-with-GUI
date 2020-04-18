package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;

import javax.swing.JButton;

import model.GameEngineImpl;
import model.enumeration.BetType;
import model.interfaces.Player;
import view.AppFrame;
import view.model.PlayerStates;

//This class listens to button presses on items in the comboBox
public class CBActionListener implements ActionListener{

	private GameEngineImpl gei;
	private AppFrame apf;
	private PlayerStates ps;
	
	public CBActionListener(GameEngineImpl gei, AppFrame apf, PlayerStates ps) {
		this.gei = gei;
		this.apf = apf;
		this.ps = ps;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(this.apf.getCoinToolBar().getComboBox().getSelectedItem() != null) {

			String id = this.apf.getCoinToolBar().getComboBox().getSelectedItem().toString();
			Player player = this.gei.getPlayer(id);
			JButton spinButton = this.apf.getCoinToolBar().getPlayerSpinButton();

			this.apf.getCoinSplitPanes().setCurrentPlayerUpdate(player, ps.getPlayerWithState(id));
			
			if(player.getBetType() == null || player.getBetType() == BetType.NO_BET) {
				spinButton.setEnabled(false);
			}
			else {
				spinButton.setEnabled(true);
			}
		}
		else {
			this.apf.getCoinSplitPanes().clearCurrentPlayerUpdate();
		}		
	}
	
	public boolean isListContainMethod(Collection<Player> players) {
	    for (Player player : players) {
	        if (player.getBetType() == BetType.NO_BET) {
	            return false;
	        }
	    }	
	    return true;
	}
}
