package util;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JLabel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;
import javax.swing.text.JTextComponent;

public class TextPrompt extends JLabel implements FocusListener, DocumentListener {

	private static final long serialVersionUID = 1L;

	public enum Show {
		ALWAYS, GAINED, LOST;
	}

	public void focusGained(FocusEvent e) {
		check();
	}

	public void focusLost(FocusEvent e) {
		focusLost++;
		check();
	}

	public void insertUpdate(DocumentEvent e) {
		check();
	}

	public void removeUpdate(DocumentEvent e) {
		check();
	}

	public void changedUpdate(DocumentEvent e) {
	}

	private JTextComponent component;
	private Document document;

	private Show show;
	private boolean showPromptOnce;
	private int focusLost;

	public TextPrompt(String text, JTextComponent component) {
		this(text, component, Show.ALWAYS);
	}

	public TextPrompt(String text, JTextComponent component, Show show) {
		this.component = component;
		setShow(show);
		document = component.getDocument();

		setText(text);
		setFont(component.getFont());

		setForeground(Color.BLACK);
		setHorizontalAlignment(JLabel.LEADING);

		component.addFocusListener(this);
		document.addDocumentListener(this);

		component.setLayout(new BorderLayout());
		component.add(this);
		check();
	}

	public void change(float a) {
		change((int) (a * 255));
	}

	public void change(int a) {
		a = a > 255 ? 255 : a < 0 ? 0 : a;

		Color fontColor = getForeground();
		int red = fontColor.getRed();
		int green = fontColor.getGreen();
		int blue = fontColor.getBlue();

		Color color = new Color(red, green, blue, a);
		super.setForeground(color);
	}

	public void changeStyle(int style) {
		setFont(getFont().deriveFont(style));
	}

	public Show getShow() {
		return show;
	}

	public void setShow(Show show) {
		this.show = show;
	}

	public boolean getShowPromptOnce() {
		return showPromptOnce;
	}

	public void setShowPromptOnce(boolean showPromptOnce) {
		this.showPromptOnce = showPromptOnce;
	}

	private void check() {

		if (document.getLength() > 0) {
			setVisible(false);
			return;
		}

		if (showPromptOnce && focusLost > 0) {
			setVisible(false);
			return;
		}

		if (component.hasFocus()) {
			if (show == Show.ALWAYS || show == Show.GAINED)
				setVisible(true);
			else
				setVisible(false);
		} else {
			if (show == Show.ALWAYS || show == Show.LOST)
				setVisible(true);
			else
				setVisible(false);
		}
	}
}