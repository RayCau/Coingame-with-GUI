package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.JPanel;

import model.enumeration.CoinFace;
import model.interfaces.Coin;


@SuppressWarnings("serial")
public class CoinPanel extends JPanel{

	public static final int NUM_COINS = 2;

	int coin1Icon = 0;
	int coin2Icon = 1;

	CoinView coin1 = new CoinView(0);
	CoinView coin2 = new CoinView(1);

	public CoinPanel()
	{ 
		setLayout(new GridLayout((int) Math.sqrt(NUM_COINS), (int) Math.sqrt(NUM_COINS)));

		add(coin1);
		add(coin2);

	}
	
	//Simply for styling, set background of coinpanel to lightgray!
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.setBackground(Color.lightGray);
	}

	public void setCoinIcon(Coin coin) {
		if(coin.getNumber() == 1) {
			if (coin.getFace() == CoinFace.HEADS) {
				coin1.setIcon(0);
			}
			else if (coin.getFace() == CoinFace.TAILS) {
				coin1.setIcon(1);
			}
		}
		else{
			if (coin.getFace() == CoinFace.HEADS) {
				coin2.setIcon(0);
			}
			else if (coin.getFace() == CoinFace.TAILS) {
				coin2.setIcon(1);
			}
		}

	}

}
