package view;

import javax.swing.JLabel;
import javax.swing.JToolBar;

@SuppressWarnings("serial")
public class StatusPanel extends JToolBar
{
	private String currentAction = "";
	
	private JLabel statusLabel = new JLabel("Your status will be displayed here!");
	
	public StatusPanel()
	{	
		//setFloatable so that it cannot be separated from the AppFrame
		this.setFloatable(false);
		add(statusLabel);
	}
	
	public void setCurrentActionString(String current) {
		this.currentAction = current;
		statusLabel.setText(this.currentAction);
	}
	
	public void clearCurrentActionString() {
		this.currentAction = "";
	}
}
