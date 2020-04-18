package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JToolBar;


@SuppressWarnings("serial")
public class CoinToolBar extends JToolBar {
	
	
	private JComboBox<String> cb = new JComboBox<String>();
	
	private JButton jbPlayer = new JButton("Spin Player");
	private JButton jbSpinner = new JButton("Spin Spinner");
	
	private int width = 20, height = 5;
	
	private CoinMenuBar cmb = new CoinMenuBar();
	
	public CoinToolBar(){
		
		//add menu bar with items
		this.add(cmb.getMenuBar());
		
		
		//combo box
		cb.setMaximumSize(new Dimension(1000, 20));
		this.add(cb, "East");

		//player and spinner spin button
		this.jbPlayer.setSize(width, height);
		this.jbSpinner.setSize(width, height);
		this.add(jbPlayer, BorderLayout.EAST); 
		this.add(jbSpinner, BorderLayout.EAST); 
		
		setFloatable(false);
		setAlignmentY(CENTER_ALIGNMENT);
		
//		jbPlayer.setEnabled(false);
}
	
	//**************************** Add Action Listener to ComboBox ******************************//
	
	public void CreateCBCallback(ActionListener e) {
		cb.addActionListener(e);
	}
	
	public String getChosenCBItemName() {
		return (String) cb.getSelectedItem();
	}
	
	//**************************** Getters for components of tool bar ******************************//
	
	public CoinMenuBar getCoinMenuBar(){
		return cmb;
	}
	
	public JComboBox<String> getComboBox() {
		return cb;
	}
	
	public JButton getPlayerSpinButton(){
		return jbPlayer;
	}
	
	public JButton getSpinnerSpinButton(){
		return jbSpinner;
	}
	

	
}
