package view.factory;

import java.io.File;

import javax.swing.ImageIcon;

//CoinIcons allows the code to access the image files for the coins 
public class CoinIcons {

	private static final String[] FILE_STRINGS = new String[] {"heads.png", "tails.png"};

	public static final int NUM_SIDES = FILE_STRINGS.length;

	public static ImageIcon getImageIcon(int i)
	{
		return new ImageIcon(String.format("images%s%s", File.separator, FILE_STRINGS[i]));
	}
}
