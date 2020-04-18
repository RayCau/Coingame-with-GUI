package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import model.GameEngineImpl;
import view.AppFrame;
import view.helper.HelperMethods;
import view.model.PlayerStates;

public class SpinSpinnerButtonListener implements ActionListener{

	private GameEngineImpl gei;
	private AppFrame af;
	private PlayerStates ps;
	private HelperMethods hm;

	public SpinSpinnerButtonListener(GameEngineImpl gei, AppFrame af, PlayerStates ps, HelperMethods hm){
		this.gei = gei;
		this.af = af;
		this.ps = ps;
		this.hm = hm;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		JButton spinSpinner = af.getCoinToolBar().getSpinnerSpinButton();
		JButton spinPlayer = af.getCoinToolBar().getPlayerSpinButton();

		new Thread()
		{
			@Override
			public void run()
			{
				
				
				spinSpinner.setEnabled(true);
				spinPlayer.setEnabled(true);
				
				gei.spinSpinner(100, 1000, 100, 50, 500, 50);
				
				spinSpinner.setEnabled(false);
				spinPlayer.setEnabled(false);
				
				ps.setPWSCurrentPoints();
				ps.setWinLoss();
				
				ps.setAllPreviousPoints();
				
				int index = af.getCoinToolBar().getComboBox().getSelectedIndex();
				af.getCoinToolBar().getComboBox().setSelectedIndex(index);
				ps.resetPWSSpun();
				
				hm.reset();
				hm.removeZeroPointsPlayers();
			}
		}.start();

	}
		
}
