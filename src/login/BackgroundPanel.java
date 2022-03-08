package login;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BackgroundPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	private JLabel imageLabel;
	
	public BackgroundPanel(Image image) {
		initComponents(image);
	}
	
	private void initComponents(Image image) {
		imageLabel = new JLabel();
		Image imageScaled = image.getScaledInstance(800, 450, Image.SCALE_SMOOTH);
		imageLabel.setIcon(new ImageIcon(imageScaled));
		this.add(imageLabel);
	}
}
