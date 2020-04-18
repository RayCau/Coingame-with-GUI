package controller;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;

import model.GameEngineImpl;
import model.enumeration.BetType;
import model.interfaces.Player;
import view.AppFrame;
import view.model.PlayerStates;

//This class listens to item states of the items in the comboBox
public class CBItemListener implements ItemListener{

	private GameEngineImpl gei;
	private AppFrame apf;


	public CBItemListener(GameEngineImpl gei, AppFrame apf, PlayerStates ps) {
		this.gei = gei;
		this.apf = apf;
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if(this.apf.getCoinToolBar().getComboBox().getSelectedItem()!= null) {

			JButton spinPlayer = apf.getCoinToolBar().getPlayerSpinButton();
			Player player = gei.getPlayer(this.apf.getCoinToolBar().getComboBox().getSelectedItem().toString());

			if(apf.getCoinToolBar().getComboBox().getSelectedItem() != null) {
				spinPlayer.setEnabled(false);
			}
			else {
				spinPlayer.setEnabled(true);
			}

			if(player.getBetType() == BetType.NO_BET || player.getBetType() == null) {
				spinPlayer.setEnabled(false);
			}
			else {
				spinPlayer.setEnabled(true);
			}
			
			
		}
	}
}
