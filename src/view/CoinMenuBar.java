package view;

import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.enumeration.BetType;

@SuppressWarnings("serial")
public class CoinMenuBar extends JMenuBar{

	private JMenuBar mb = new JMenuBar();
	private JMenu menu;  
	private JMenuItem i1, i2, i3, i4;

	//JOptionPane headings
	private String addPlayerHeading = "Add a Player", removePlayerHeading = "Remove a Player"
			, placeBetHeading = "Place a Bet", removeBetHeading = "Remove a Bet";

	//add player components
	private JLabel name = new JLabel("Enter Player Name: "), ID = new JLabel("Enter Player ID: ")
			, points = new JLabel("Enter your Player's Points: ");
	private JTextField playName = new JTextField(), playID = new JTextField(), playPoints = new JTextField();

	//remove player components
	private JLabel removePlayerID = new JLabel("Enter ID of Player you want to Remove: ");
	private JTextField removePlayerIDfield = new JTextField();

	//place bet components
	private JLabel betThisPlayer = new JLabel("Enter the ID of the Player that you want to bet: "), 
			betPoints = new JLabel("Enter the number of points you want to bet: "), 
			placeBetType = new JLabel("Enter the bet type you want to bet: ");
	private JTextField betThisPlayerField = new JTextField(); //has to be string
	private JTextField betPointsField = new JTextField(); //has to be an int
	private JComboBox<String> betTypeField = new JComboBox<String>(); 

	//remove bet components
	private JLabel removePlayerBet = new JLabel("Enter the ID of the Player whose bet you want removed: ");

	private JTextField removePlayerBetField = new JTextField();

	//JOptionPane pop up arrays
	private Object[] addPlayerInput = {name, playName, ID, playID, points, playPoints}, removePlayerInput = {removePlayerID, removePlayerIDfield}
	, placeBetInput = {betThisPlayer, betThisPlayerField, betPoints, betPointsField, placeBetType, betTypeField}
	, removeBetInput = {removePlayerBet, removePlayerBetField};

	CoinMenuBar(){  	  
		menu = new JMenu("Menu");  

		//adds items to betType combobox
		betTypeField.addItem("COIN1");
		betTypeField.addItem("COIN2");
		betTypeField.addItem("BOTH");
		betTypeField.addItem("NO_BET");

		//instantiate menuitems
		i1 = new JMenuItem ("Add Players"); 
		i2 = new JMenuItem ("Remove Player"); 		
		i3 = new JMenuItem ("Place a bet");	
		i4 = new JMenuItem ("Remove a bet");
		
		//adds all menu items to the menu
		menu.add(i1); 
		menu.add(i2); 
		menu.add(i3);
		menu.add(i4);
		
		//Adds menu to the menubar
		mb.add(menu);  
	}	

	public JMenuBar getMenuBar() {
		return mb;
	}
	//adds actionListener to menu items, called from the controller

	public void addActionListeneri1(ActionListener e) {
		i1.addActionListener(e);
	}

	public void addActionListeneri2(ActionListener e) {
		i2.addActionListener(e);
	}

	public void addActionListeneri3(ActionListener e) {
		i3.addActionListener(e);
	}

	public void addActionListeneri4(ActionListener e) {
		i4.addActionListener(e);
	}

	//add joptionpanes popups to menu items
	
	public int addPlayerOption() {
		int result = JOptionPane.showConfirmDialog(null, addPlayerInput, addPlayerHeading, JOptionPane.OK_CANCEL_OPTION);
		return result;
	}	


	public int removePlayerOption() {
		int result = JOptionPane.showConfirmDialog(null, removePlayerInput, removePlayerHeading, JOptionPane.OK_CANCEL_OPTION);
		return result;
	}	

	public int placeBetOption() {
		int result = JOptionPane.showConfirmDialog(null, placeBetInput, placeBetHeading, JOptionPane.OK_CANCEL_OPTION);
		return result;
	}

	public int removeBetOption() {
		int result = JOptionPane.showConfirmDialog(null, removeBetInput, removeBetHeading, JOptionPane.OK_CANCEL_OPTION);
		return result;
	}

	//place bet getters

	public BetType getBetTypeField() {
		return BetType.valueOf(this.betTypeField.getSelectedItem().toString());

	}

	public int getBetPointsField() {
		return Integer.parseInt(this.betPointsField.getText());
	}

	public String getBetIDField() {
		return this.betThisPlayerField.getText();
	}

	//add player getters 

	public String getNameTXT() {
		return this.playName.getText();
	}

	public String getIDTXT() {
		return this.playID.getText();
	}

	public String getPlayPoints() {
		return this.playPoints.getText();
	}

	//remove player getters

	public String getRemoveIDField() {
		return this.removePlayerIDfield.getText();
	}

	//remove bet getters

	public String getRemoveBetField() {
		return this.removePlayerBetField.getText();
	}
}
