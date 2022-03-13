package views;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class BankButtonIcon extends JButton {

	public BankButtonIcon(ImageIcon icon, ActionListener listener, String command, int width, int heigth, boolean isScaled) {
		if(isScaled) {
			ImageIcon iconScaled = new ImageIcon(icon.getImage().getScaledInstance(width, heigth, Image.SCALE_SMOOTH));
			this.setIcon(iconScaled);
		}else {
			this.setIcon(icon);
		}
		this.setBackground(new Color(0,0,0,0));
		this.addActionListener(listener);
		this.setActionCommand(command);
		this.setBorderPainted(false);
		this.setCursor(new Cursor(Cursor.HAND_CURSOR));
		this.setFocusPainted(false);
	}
}