package view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import view.factory.CoinIcons;

@SuppressWarnings("serial")
public class CoinView extends JLabel {


	public CoinView(int i)
	{
		setHorizontalAlignment(JLabel.CENTER);
		setVerticalAlignment(JLabel.CENTER);		
		setIcon(CoinIcons.getImageIcon(i));
		setPreferredSize(new Dimension(250, 250));

	}
	
	//setIcon called by the GECGUI
	public void setIcon(int i) {
		setIcon(CoinIcons.getImageIcon(i));
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		ImageIcon icon = (ImageIcon) getIcon();
		redraw(g, this, icon.getImage());
	}
	
	public static void redraw(Graphics g, JLabel label, Image coinIcon) {
		double imageW = coinIcon.getWidth(null), imageH = coinIcon.getHeight(null);
		int canvasW = label.getWidth(), canvasH = label.getHeight();
		double x = 0.0, y = 0.0, x1 = 0.0, y1 = 0.0;

		double imageAspect = (imageH / imageW);

		if (imageW < canvasW && imageH < canvasH) {
			x = (canvasW - imageW)  / 2.0;
			y = (canvasH - imageH) / 2.0;
			x1 = imageW + x;
			y1 = imageH + y;

		} else {
			y = canvasH;
			canvasH = (int) (canvasW * imageAspect);
			y = (y - canvasH) / 2;
			x1 = canvasW + x; 
			y1 = canvasH + y;
		}
		//drawImage method suggested by casper
		g.drawImage(coinIcon, (int)x, (int)y, (int)x1, (int)y1, 0, 0, (int)imageW, (int)imageH, null);
	}
}

