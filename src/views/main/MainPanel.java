package views.main;

import java.awt.Image;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import views.Constants;

public class MainPanel extends JPanel {

	private PanelInfoUser infoUser;
	private PanelInfoAccount infoAccount;
	private PanelOptions options;
	private JLabel labelBackground;

	public MainPanel(ActionListener listener) {
		this.setLayout(null);
		this.setSize(1000, 1000);
		initComponents(listener);
	}

	private void initComponents(ActionListener listener) {
		ImageIcon imageScaled = new ImageIcon(
				new ImageIcon(Constants.createInstance().getProperty(Constants.BAKCGROUND_LOGIN)).getImage()
						.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH));
		labelBackground = new JLabel(imageScaled);
		infoUser = new PanelInfoUser();
		infoAccount = new PanelInfoAccount();
		options = new PanelOptions(listener);
		System.out.println(getWidth());
		System.out.println(getHeight());
		this.add(labelBackground).setBounds(0, 0, getWidth(), getHeight());
		System.out.println(infoUser.getWidth());
		System.out.println(infoUser.getHeight());
		this.add(infoUser).setBounds(0,0,infoUser.getWidth(),infoUser.getHeight());
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setSize(1000, 1000);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(new MainPanel(null));
	}
}
