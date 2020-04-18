package view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

import model.interfaces.Player;
import view.model.PlayerWithState;

@SuppressWarnings("serial")
public class CoinSplitPanes extends JSplitPane{

	private BorderLayout bl = new BorderLayout();
	private JPanel SummaryPane;
	private CoinPanel CoinTossPane;
	private Dimension minimumSize = new Dimension(350, 600);
	private JLabel currentPlayerUpdate = new JLabel();

	public CoinSplitPanes() {

		SummaryPane = new JPanel();

		CoinTossPane = new CoinPanel();

		SummaryPane.setLayout(bl);

		SummaryPane.add(currentPlayerUpdate, BorderLayout.NORTH);

		this.setLeftComponent(SummaryPane);
		this.setRightComponent(CoinTossPane);
		
		this.getLeftComponent().setMinimumSize(minimumSize);
	}
	
	public CoinPanel getCoinPanel() {
		return this.CoinTossPane;
	}

	public JPanel getSummaryPane() {
		return this.SummaryPane;
	}

	//updates current player jlabels for the summarypanel called by the GameEngineCallbackGUI

	public void setCurrentPlayerUpdate(Player player, PlayerWithState playerWithState) {
		if(player != null) {
			String linePlayer = "Current Player: " + player.getPlayerName(), linePlayerID = "Current Player ID: " + player.getPlayerId()
			, linePoints = "Current Player Points: " + player.getPoints(), lineBetType = "Current Player Bet: " + player.getBetType()
			, lineBetPoints = "Current Player Bet Points: " + player.getBet(), lineCoin1 = "Current Player COIN 1: " + player.getResult().getCoin1()
			, lineCoin2 = "Current Player COIN 2: " + player.getResult().getCoin2()
			, WinLossRatio = "Current Player Win/Loss: " + playerWithState.getWon() + "/" + playerWithState.getLost();

			this.currentPlayerUpdate.setText("<html>" + linePlayer + " <br> " + linePlayerID + " <br> " + linePoints + " <br> "
					+ lineBetType + " <br> " + lineBetPoints + " <br> " + lineCoin1 + " <br> " + lineCoin2 +
					"<br>"+ WinLossRatio + " <br> " + "</html>" );
		}else {
			JOptionPane.showMessageDialog(null, "Lost players have been removed!", "Alert", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	public void clearCurrentPlayerUpdate() {
		this.currentPlayerUpdate.setText("");
	}
}
