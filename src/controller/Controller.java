package controller;

import model.GameEngineImpl;
import view.AppFrame;
import view.helper.HelperMethods;
import view.model.PlayerStates;

public class Controller {

	private GameEngineImpl gei;
	private AppFrame af;
	private AddPlayerListener apl;
	private CBActionListener cal;
	private CBItemListener cil;
	private SpinPlayerButtonListener spbl;
	private RemovePlayerListener rpl;
	private PlaceBetListener pbl;
	private RemoveBetListener rbl;
	private SpinSpinnerButtonListener ssbl;
	private PlayerStates ps;
	private HelperMethods hm;

	public Controller(GameEngineImpl gei, AppFrame af, PlayerStates ps) {
		this.gei = gei;
		this.af = af;
		this.ps = ps;
	}

	public void start() {

		//Add addPlayerlisteners to menu bar items
		apl = new AddPlayerListener(this.af.getCoinToolBar(), gei, af, ps);
		this.af.getCoinToolBar().getCoinMenuBar().addActionListeneri1(apl);

		//add removePlayerListener to menubar
		rpl = new RemovePlayerListener(gei, af, ps);
		this.af.getCoinToolBar().getCoinMenuBar().addActionListeneri2(rpl);

		//add placebetlistener to menubar
		pbl = new PlaceBetListener(gei, af, ps);
		this.af.getCoinToolBar().getCoinMenuBar().addActionListeneri3(pbl);

		//add removebetlistener to menubar
		rbl = new RemoveBetListener(gei, af, this.ps);
		this.af.getCoinToolBar().getCoinMenuBar().addActionListeneri4(rbl);

	
		//Pass af and gei into HelpMethods constructor
		hm = new HelperMethods(this.gei, this.af, this.ps);
		
		//Add action listener to spinPlayer
		spbl = new SpinPlayerButtonListener(this.gei, this.af, this.ps, this.hm);
		this.af.getCoinToolBar().getPlayerSpinButton().addActionListener(spbl);

		//Add action listener to spinSpinner
		ssbl = new SpinSpinnerButtonListener(this.gei, this.af, this.ps, this.hm);
		this.af.getCoinToolBar().getSpinnerSpinButton().addActionListener(ssbl);

		//Add action listener and item listener to combo box
		cal = new CBActionListener(this.gei, this.af, this.ps);
		this.af.getCoinToolBar().getComboBox().addActionListener(cal);
		cil = new CBItemListener(this.gei, this.af, this.ps);
		this.af.getCoinToolBar().getComboBox().addItemListener(cil);



	}

}


