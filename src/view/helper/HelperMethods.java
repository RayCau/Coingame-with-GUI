package view.helper;

import model.interfaces.GameEngine;
import view.AppFrame;
import view.model.PlayerStates;

/*This class contains helper methods that are repeatedly used in SpinPlayer and SpinSpinner button listeners.
* Contained here for ease of access and to mitigate code duplication.
*/
public class HelperMethods {

	private GameEngine gei;
	private AppFrame af;


	public HelperMethods(GameEngine gei, AppFrame af, PlayerStates ps) {
		this.gei = gei;
		this.af = af;
	}
	public void removeZeroPointsPlayers() {
		int count = af.getCoinToolBar().getComboBox().getItemCount();

		for (int i = 0; i < count; i++) {
			if(gei.getPlayer(af.getCoinToolBar().getComboBox().getItemAt(i)).getPoints() == 0){
				gei.removePlayer(gei.getPlayer(af.getCoinToolBar().getComboBox().getItemAt(i).toString()));
				af.getCoinToolBar().getComboBox().removeItemAt(i);
				af.getCoinSplitPanes().clearCurrentPlayerUpdate();
			};
		}
	}

	public void reset() {
		int count = af.getCoinToolBar().getComboBox().getItemCount();
		for (int i = 0; i < count; i++) {
			gei.getPlayer(af.getCoinToolBar().getComboBox().getItemAt(i)).resetBet();
		}
	}	

}
