package com.perisic.beds.peripherals;

import java.awt.BorderLayout;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * Shows a image from an URL in a JFrame. This uses a GET request. 
 */
public class ShowImageFromURL {
	/**
	 * Displays an image read from an URL within a JFrame.
	 * @param urlLocation An URL pointing to a image. 
	 * @wbp.parser.entryPoint
	 */
	public static void show(String urlLocation) { 
		Image image = null;
		try {
			URL url = new URL(urlLocation);
			image = ImageIO.read(url);	
			JFrame frame = new JFrame();
			JLabel lblimage = new JLabel(new ImageIcon(image));
			frame.getContentPane().add(lblimage,BorderLayout.CENTER);
			frame.setSize(743000, 413000);
			frame.setVisible(true);
		} catch (IOException e) {
			System.out.println("Something went wrong, sorry:"+e.toString()); 
			e.printStackTrace();
		}




	}
}
