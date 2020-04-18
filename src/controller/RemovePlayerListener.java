package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import model.GameEngineImpl;
import view.AppFrame;
import view.model.PlayerStates;

public class RemovePlayerListener implements ActionListener {

	private GameEngineImpl gei;
	private AppFrame af;
	private PlayerStates ps;

	public RemovePlayerListener(GameEngineImpl gei, AppFrame af, PlayerStates ps) {
		this.gei = gei;
		this.af = af;
		this.ps = ps;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if(af.getCoinToolBar().getCoinMenuBar().removePlayerOption() == 0) {
			
			JComboBox<String> comboBox = this.af.getCoinToolBar().getComboBox();
			String ID = this.af.getCoinToolBar().getCoinMenuBar().getRemoveIDField();
			
			if (comboBox.getSelectedIndex() > -1 && gei.getPlayer(ID) != null) {
				comboBox.removeItem(ID);  
				gei.removePlayer(gei.getPlayer(ID));	
				ps.removePlayerWithState(ID);
				af.getStatusPanel().setCurrentActionString("Removed player " + gei.getPlayer(ID).getPlayerName());
			}else {
				JOptionPane.showMessageDialog(null, "That player does not exist."
						,"Alert", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

}

