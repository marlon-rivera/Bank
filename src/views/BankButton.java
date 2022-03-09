package views;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class BankButton extends JButton {

	private static final long serialVersionUID = 1L;
	private Color colorBackground;
	private Color colorBackgroundAux;

	public BankButton(Object nameOrIcon, ActionListener listener, String actionCommand, int width, int heigth,
			Color colorForeground, Color colorBackgroundP, boolean isScaled) {
		this.colorBackground = colorBackgroundP;
		this.colorBackgroundAux = colorBackground;
		if (nameOrIcon instanceof String) {
			this.setText("GOH");
			//this.setForeground(colorForeground);
		} else {
			if (isScaled) {
				ImageIcon imageScaled = new ImageIcon(
						((ImageIcon) nameOrIcon).getImage().getScaledInstance(width / 2, heigth, Image.SCALE_DEFAULT));
				this.setIcon(imageScaled);
			} else {
				this.setIcon((ImageIcon) nameOrIcon);
			}
		}
		this.setOpaque(false);
		this.setBackground(new Color(0, 0, 0, 0));
		this.setForeground(colorForeground);
		this.addActionListener(actionListener);
		this.setActionCommand(actionCommand);
		this.setFocusPainted(false);
		this.setBorderPainted(false);
		this.setPreferredSize(new Dimension(width, heigth));
		this.setCursor(new Cursor(Cursor.HAND_CURSOR));
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if (isEnabled()) {
					colorBackground = Color.GRAY;
				}
				repaint();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				colorBackground = colorBackgroundAux;
				repaint();
			}
		});
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(colorBackground);
		g.fillRect(0, 0, getWidth(), getHeight());
	}
}
