package view;

import javax.swing.SwingUtilities;

import model.interfaces.Coin;
import model.interfaces.CoinPair;
import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.interfaces.GameEngineCallback;
import view.model.PlayerStates;

public class GameEngineCallbackGUI implements GameEngineCallback{

	private AppFrame af;
	private PlayerStates ps;

	public GameEngineCallbackGUI(AppFrame af, PlayerStates ps) {

		this.af = af;
		this.ps = ps;
	}

	@Override
	public void playerCoinUpdate(Player player, Coin coin, GameEngine engine) {
		SwingUtilities.invokeLater(new Runnable()
		{
			@Override
			public void run()
			{
				af.getCoinSplitPanes().getCoinPanel().setCoinIcon(player.getResult().getCoin1());
				af.getCoinSplitPanes().getCoinPanel().setCoinIcon(player.getResult().getCoin2());
				af.getCoinSplitPanes().setCurrentPlayerUpdate(player, ps.getPlayerWithState(player.getPlayerId()));
				af.getStatusPanel().setCurrentActionString("Spinning " + player.getPlayerName() + "...");
			}
		});
	}

	@Override
	public void spinnerCoinUpdate(Coin coin, GameEngine engine) {
		SwingUtilities.invokeLater(new Runnable()
		{
			@Override
			public void run()
			{
				af.getCoinSplitPanes().getCoinPanel().setCoinIcon(coin);
				af.getStatusPanel().setCurrentActionString("Spinning spinner...");
			}
		});

	}

	@Override
	public void playerResult(Player player, CoinPair coinPair, GameEngine engine) {
		SwingUtilities.invokeLater(new Runnable()
		{
			@Override
			public void run()
			{
				af.getCoinSplitPanes().setCurrentPlayerUpdate(player, ps.getPlayerWithState(player.getPlayerId()));
				af.getStatusPanel().setCurrentActionString("Player finished spinning! The player's results are: "
						+ coinPair.getCoin1().getFace() + " and "+ coinPair.getCoin2().getFace());

			}
		});

	}

	@Override
	public void spinnerResult(CoinPair coinPair, GameEngine engine) {

		String status = "";
		status += "<html>" + "Spinner finished spinning! The spinner's results are: " + "<br>" 
				+ coinPair.getCoin1().getFace() + " and "+ coinPair.getCoin2().getFace();
		af.getStatusPanel().setCurrentActionString(status);

	}

}