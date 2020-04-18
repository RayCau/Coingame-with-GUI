package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import model.GameEngineImpl;
import model.interfaces.Player;
import view.AppFrame;
import view.helper.HelperMethods;
import view.model.PlayerStates;

public class SpinPlayerButtonListener implements ActionListener{

	private GameEngineImpl gei;
	private AppFrame af;
	private PlayerStates ps;
	private HelperMethods hm;

	public SpinPlayerButtonListener(GameEngineImpl gei, AppFrame af, PlayerStates ps, HelperMethods hm) {
		this.gei = gei;
		this.af = af;	
		this.ps = ps;
		this.hm = hm;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(this.af.getCoinToolBar().getComboBox().getSelectedItem() != null) {
			JButton thisButton = this.af.getCoinToolBar().getPlayerSpinButton();
			JButton SpinSpinner = this.af.getCoinToolBar().getSpinnerSpinButton();
			Player selected = gei.getPlayer(af.getCoinToolBar().getComboBox().getSelectedItem().toString());


			if(ps.getPlayerStateSpun(selected.getPlayerId()) == false) {
				thisButton.setEnabled(true);
				new Thread()
				{
					@Override
					public void run()
					{
						SpinSpinner.setEnabled(false);
						thisButton.setEnabled(false);

						gei.spinPlayer(selected, 100, 1000, 100, 50, 500, 50);

						SpinSpinner.setEnabled(true);
						thisButton.setEnabled(true);

						ps.getPlayerWithState(selected.getPlayerId()).setSpun(true);

						//if all players have bet and spun, then spinSpinner automatically
						if(ps.checkPlayersSpun() == true) {
							SpinSpinner.setEnabled(false);
							thisButton.setEnabled(false);

							gei.spinSpinner(100, 1000, 100, 50, 500, 50);

							SpinSpinner.setEnabled(true);
							thisButton.setEnabled(true);

							hm.reset();
							hm.removeZeroPointsPlayers();

							ps.setPWSCurrentPoints();
							ps.setWinLoss();

							ps.setAllPreviousPoints();

							//reselects selected to update summary panel
							int index = af.getCoinToolBar().getComboBox().getSelectedIndex();
							af.getCoinToolBar().getComboBox().setSelectedIndex(index);

							ps.resetPWSSpun();
						}	
					}
				}.start();

			} else {
				JOptionPane.showMessageDialog(null, "This Player has already been spun once this round!", "Alert", JOptionPane.ERROR_MESSAGE);
				thisButton.setEnabled(false);
			}
		}
		else {
			JOptionPane.showMessageDialog(null, "You must add a player before you spin!", "Alert", JOptionPane.ERROR_MESSAGE);
		}
	}
}