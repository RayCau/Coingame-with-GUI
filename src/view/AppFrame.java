package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;


@SuppressWarnings("serial")
public class AppFrame extends JFrame {
	
	private CoinSplitPanes csp = new CoinSplitPanes();
	private CoinToolBar ctb = new CoinToolBar();
	private StatusPanel sp = new StatusPanel();
	
	//minimum dimensions as half of the screen size
	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();	
	private Dimension minimumSize = new Dimension ((screenSize.width/2), (screenSize.height/2));

	public AppFrame() {

		super("Coin Game");

		this.setBounds(100, 100, 1500, 750);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setLayout(new BorderLayout());

		//adds cointoolbar, coinsplitpanes and statuspanel
		this.add(ctb, BorderLayout.NORTH);
		this.add(csp, BorderLayout.CENTER);
		this.add(sp, BorderLayout.SOUTH);
		
		//sets the minimum size of the client to half of the screen size of the system
		this.setMinimumSize(minimumSize);
		//sets visible as true
		this.setVisible(true);



	}

	public CoinSplitPanes getCoinSplitPanes() {
		return this.csp;
	}
	public CoinToolBar getCoinToolBar() {
		return this.ctb;	
	}

	public StatusPanel getStatusPanel() {
		return this.sp;
	}


}

