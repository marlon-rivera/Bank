package presenters;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import views.FrameMain;

public class Presenter implements ActionListener {

	private static final String COMMAND_CROSS = "X";
	private static final String COMMAND_BACK = "<";
	private static final String COMMAND_BACK_OPTIONS = "<<";
	private static final String COMMAND_REGISTER = "Signup";
	private static final String COMMAND_ENTER = "Enter";
	//private static final String COMMAND_CREATE_ACCOUNT = "CreateAccount";
	private static final String COMMAND_TRANSFER = "transfer";
	private static final String COMMAND_WITHDRAW = "withdraw";
	
	private FrameMain frameMain;
	
	public Presenter() {
		frameMain = new FrameMain(this);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		System.out.println(command);
		switch (command) {
		case COMMAND_CROSS:
			frameMain.setVisible(false);
			frameMain.dispose();
			break;
		case COMMAND_BACK:
			frameMain.hidePanelRegistration();
			frameMain.showLoginPanel();
			break;
		case COMMAND_REGISTER:
			frameMain.hideLoginPanel();
			frameMain.showPanelRegistration();
			break;
		case COMMAND_ENTER:
			frameMain.hideLoginPanel();
			frameMain.showMainPanel();
			break;
		case COMMAND_TRANSFER:
			frameMain.hideMainPanel();
			frameMain.showTransferPanel();
			break;
		case COMMAND_WITHDRAW:
			frameMain.hideMainPanel();
			frameMain.showWithdrawPanel();
			break;
		case COMMAND_BACK_OPTIONS:
			frameMain.hideTransferPanel();
			frameMain.hideWithdrawPanel();
			frameMain.showMainPanel();
			break;
		}
	}
}
