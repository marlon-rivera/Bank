package views;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

public class BankButton extends JButton {

	private static final long serialVersionUID = 1L;
	private Color backgroundColor;
	private int width;
	private int height;
	
	public BankButton(String text, String command, ActionListener listener, Color backgroundColorP,
			Color backgroundColorS, int width, int height) {
		super(text);
		this.width = width;
		this.height = height;
		this.backgroundColor = backgroundColorP;
		this.setForeground(Color.WHITE);
		this.setFont(new Font("Arial", Font.PLAIN, 15));
		this.setBackground(new Color(0, 0, 0, 0));
		this.setPreferredSize(new Dimension(width, height));
		this.setBorderPainted(false);
		this.setOpaque(false);
		this.setFocusPainted(false);
		this.setCursor(new Cursor(Cursor.HAND_CURSOR));
		this.setActionCommand(command);
		this.addActionListener(listener);
		this.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {
				if (isEnabled()) {
					backgroundColor = backgroundColorS;
				}
				repaint();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				backgroundColor = backgroundColorP;
				repaint();
			}
		});
	}

	public int getWidthButton() {
		return this.width;
	}

	public int getHeightButton() {
		return this.height;
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		g2d.setColor(backgroundColor);
		g2d.fillRect(0, 0, getWidth(), getHeight());
		super.paintComponent(g);
	}
}
