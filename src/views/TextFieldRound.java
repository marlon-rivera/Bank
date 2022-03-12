package views;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JTextField;

public class TextFieldRound extends JTextField {

	private static final long serialVersionUID = 1L;

	public TextFieldRound(int size) {
	        super(size);
	        setOpaque(false);
	    }

	protected void paintComponent(Graphics g) {
		g.setColor(new Color(0,0,0,0));
		g.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
		super.paintComponent(g);
	}

	protected void paintBorder(Graphics g) {
		g.setColor(getForeground());
		g.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 15, 15);
	}
}
