package application;

import controller.Controller;
import model.GameEngineImpl;
import view.AppFrame;
import view.GameEngineCallbackGUI;
import view.GameEngineCallbackImpl;
import view.model.PlayerStates;

public class Driver {


	public static void main(String[] args) {
		
		GameEngineImpl gei = new GameEngineImpl();
		AppFrame af = new AppFrame();
		PlayerStates ps = new PlayerStates(gei, af);
		GameEngineCallbackGUI gecbg = new GameEngineCallbackGUI(af, ps);
		
		gei.addGameEngineCallback(new GameEngineCallbackImpl());
		gei.addGameEngineCallback(gecbg);
		
		Controller cont = new Controller(gei, af, ps);
		cont.start();
		
	}

}