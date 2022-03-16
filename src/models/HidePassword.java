package models;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPasswordField;

public class HidePassword implements ActionListener {

	private JPasswordField passwordTxt;
	
	public HidePassword(JPasswordField passwordTxt) {
		this.passwordTxt = passwordTxt;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (passwordTxt.getEchoChar() == '•') {
			passwordTxt.setEchoChar((char) 0);
		} else {
			passwordTxt.setEchoChar('•');
		}
	}

}
