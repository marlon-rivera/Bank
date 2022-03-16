package models;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JTextField;

public class FilterInteger extends KeyAdapter {

	private JTextField text;
	
	public FilterInteger(JTextField text) {
		this.text = text;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
        if ((e.getKeyChar() >= '0' && e.getKeyChar() <= '9')) {
           text.setEditable(true);
        } else if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE){
       	 text.setEditable(true);
        }else {
       	 text.setEditable(false);
        }
	}
}
