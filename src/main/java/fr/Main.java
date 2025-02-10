package fr;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.HashMap;

public class Main {

	HashMap<String, BufferedImage> textures = new HashMap<String, BufferedImage>();
	public static void main(String[] args) {
		/*Jeu jeu = new Jeu();
		GUI gui = new GUI( jeu);
		jeu.setGUI( gui);*/

		// Load the image
		URL imageURL = Main.class.getClassLoader().getResource("16x16png.png");

		// Create JFrame
		JFrame frame = new JFrame("Test");
		frame.setSize(1680, 1200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null); // Disable layout manager for absolute positioning


		//testGenerate(frame, imageURL);



		// Make the frame visible
		frame.setVisible(true);

	}

	public void paintComponent(Graphics2D g){
		Graphics2D g2d = (Graphics2D) g;

		// Set nearest-neighbor interpolation to prevent blurring
		g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR);

		// Scale factor (e.g., 4x)
		int scale = 4;

		// Draw textures with nearest-neighbor scaling
		g2d.drawImage(textures.get("grass"), 50, 50, 16 * scale, 16 * scale, null);
		g2d.drawImage(textures.get("water"), 100, 50, 16 * scale, 16 * scale, null);
		g2d.drawImage(textures.get("stone"), 150, 50, 16 * scale, 16 * scale, null);
	}

	public static void testGenerate(JFrame fenetre,URL image){

		final int taille = 5;

		int xAxes = 0;
		int yAxes = 0;



		for (int i = 0; i < taille; i++) {

			for (int j = 0; j < taille; j++) {

				// Create JLabel for the image
				JLabel label = new JLabel();
				if (image != null) {
					ImageIcon originalIcon = new ImageIcon(image);
					Image scaledImage = originalIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
					label.setIcon(new ImageIcon(scaledImage));
				}

				// Set position and size of the label (Top-left corner)
				label.setBounds(xAxes, yAxes, 50, 50);


				xAxes += 50;

				// Add label to frame
				fenetre.add(label);

			}

			yAxes += 50;
			xAxes = 0;
		}
	}
}
