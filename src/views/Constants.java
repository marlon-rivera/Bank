package views;

import java.awt.Color;
import java.awt.Font;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Constants extends Properties{

	
	private static final long serialVersionUID = 1L;
	public static String lenguageActual = "ES";
	private static Constants constants;
	
	private static final String PATH_LENGUAGE_ES = "src/res/Lenguage_ES.properties";
	private static final String PATH_LENGUAGE_EN = "src/res/Lenguage_EN.properties";
	
	//Lenguages
	
	public static final String LENGUAGE_ES = "ES";
	public static final String LENGUAGE_EN = "EN";
	
	//Images
	
	public static final String ICON_LOGIN = "ICON_LOGIN";
	public static final String ICON_BANK = "ICON_BANK";
	public static final String BAKCGROUND_LOGIN = "BAKCGROUND_LOGIN";
	public static final String SHOW_PASS = "SHOW_PASS";
	public static final String ICON_LOG_OUT = "ICON_LOG_OUT";
	
	//Colors BUTTONS
	
	public static final Color COLOR_BACKGROUND_P = new Color(0, 0, 0, 80);
	public static final Color COLOR_BACKGROUND_S = Color.GRAY;
	
	//Login Information Panel
	
	public static final String TEXT_USERNMAE = "TEXT_USERNAME";
	public static final String PLACE_HOLDER_USERNMAE = "PLACE_HOLDER_USERNMAE";
	public static final String TEXT_PASSWORD = "TEXT_PASSWORD";
	public static final String PLACE_HOLDER_PASSWORD = "PLACE_HOLDER_PASSWORD";
	public static final String BUTTON_ENTER = "BUTTON_ENTER";
	public static final String COMMAND_BUTTON_ENTER = "COMMAND_BUTTON_ENTER";
	public static final String BUTTON_REGISTER = "BUTTON_REGISTER";
	public static final String COMMAND_BUTTON_REGISTER = "COMMAND_BUTTON_REGISTER";
	public static final String TEXT_LANGUAGE = "TEXT_LANGUAGE";
	public static final Font FONT_LABEL = new Font("Arial", Font.PLAIN, 16);
	public static final String COMMAND_CHANGE_LANGUAGE = "changelanguage";
	
	//Panel Info Registration
	
	public static final String TEXT_NAME = "TEXT_NAME";
	public static final String PLACE_HOLDER_NAME="PLACE_HOLDER_NAME";
	public static final String TEXT_LAST_NAME = "TEXT_LAST_NAME";
	public static final String PLACE_HOLDER_LAST_NAME = "PLACE_HOLDER_LAST_NAME";
	public static final String TEXT_DATE_OF_BIRTH = "TEXT_DATE_OF_BIRTH";
	public static final String PLACE_HOLDER_DATE_OF_BIRTH = "PLACE_HOLDER_DATE_OF_BIRTH";
	public static final String TEXT_ID_NUMBER = "TEXT_ID_NUMBER";
	public static final String PLACE_HOLDER_ID_NUMBER = "PLACE_HOLDER_ID_NUMBER";
	public static final String TEXT_EMAIL = "TEXT_EMAIL";
	public static final String PLACE_HOLDER_EMAIL = "PLACE_HOLDER_EMAIL";
	public static final String TEXT_NUMBER_PHONE = "TEXT_NUMBER_PHONE";
	public static final String PLACE_HOLDER_NUMBER_PHONE = "PLACE_HOLDER_NUMBER_PHONE";
	public static final String TEXT_GENDER = "TEXT_GENDER";
	public static final String TEXT_CREATE_YOUT_ACCOUNT = "TEXT_CREATE_YOUT_ACCOUNT";
	public static final String BUTTON_CREATE_YOUR_ACCOUNT = "TEXT_BUTTON_CREATE_YOUR_ACCOUNT";
	public static final String COMMAND_BUTTON_CREATE_YOUR_ACCOUNT = "COMMAND_BUTTON_CREATE_YOUR_ACCOUNT";
	
	//Panel Main
	
	public static final String ICON_DEPOSIT = "ICON_DEPOSIT";              
	public static final String ICON_TRANSFER = "ICON_TRANSFER";
	public static final String ICON_WITHDRAW = "ICON_WITHDRAW";
	public static final String COMMAND_BUTTON_TRANSFER = "COMMAND_BUTTON_TRANSFER";
	public static final String COMMAND_BUTTON_DEPOSIT = "COMMAND_BUTTON_DEPOSIT";
	public static final String COMMAND_BUTTON_WITHDRAW = "COMMAND_BUTTON_WITHDRAW";
	public static final String TEXT_TRANSFER = "TEXT_TRANSFER"; 
	public static final String TEXT_DEPOSIT = "TEXT_DEPOSIT"; 
	public static final String TEXT_WITHDRAW = "TEXT_WITHDRAW";
	
	//Panel Info Account
	
	public static final String TEXT_NUMBER_ACCOUNT = "TEXT_NUMBER_ACCOUNT";
	public static final String TEXT_MONEY = "TEXT_MONEY";
	public static final String TEXT_USER = "TEXT_USER";
	public static final String DEFAULT_PHOTO = "DEFAULT_PHOTO";
	public static final String TEXT_AGE = "TEXT_AGE";
	public static final String BUTTON_SHOW_TRANSACTIONS = "BUTTON_SHOW_TRANSACTIONS";
	public static final String COMMAND_BUTTON_SHOW_TRANSACTIONS = "COMMAND_BUTTON_SHOW_TRANSACTIONS";
	public static final String TEXT_TRANSACTIONS = "TEXT_TRANSACTIONS"; 
	public static final String TEXT_TRANSACTION_AMOUNT = "TEXT_TRANSACTION_AMOUNT";
	public static final String TEXT_TRANSACTION_DATE = "TEXT_TRANSACTION_DATE";
	public static final String TEXT_TRANSACTION_TYPE = "TEXT_TRANSACTION_TYPE";
	public static final String BUTTON_NEXT_TRANSACTION = "BUTTON_NEXT_TRANSACTION";
	public static final String COMMAND_BUTTON_NEXT_TRANSACTION = "COMMAND_BUTTON_NEXT_TRANSACTION";
	public static final String BUTTON_PREVIOUS_TRANSACTION = "BUTTON_PREVIOUS_TRANSACTION";
	public static final String COMMAND_BUTTON_PREVIOUS_TRANSACTION = "COMMAND_BUTTON_PREIVOUS_TRANSACTION"; 
	
	//Main Panel
	
	public static final String TEXT_MAIN_MENU = "TEXT_MAIN_MENU";
	
	//TransferPanel
	
	public static final String TEXT_TARGET_ACCOUNT= "TEXT_TARGET_ACCOUNT";
	public static final String TEXT_AMOUNT = "TEXT_AMOUNT";
	public static final String BUTTON_MAKE_TRANSFER = "BUTTON_MAKE_TRANSFER";
	public static final String COMMAND_BUTTON_MAKE_TRANSFER = "COMMAND_BUTTON_MAKE_TRANSFER";
	public static final String COMMAND_BUTTON_BACK_OPTIONS = "COMMAND_BUTTON_BACK_OPTIONS";
	public static final String PLACE_HOLDER_AMOUNT = "PLACE_HOLDER_AMOUNT";
	public static final String PLACE_HOLDER_TARGE_ACCOUNT = "PLACE_HOLDER_TARGE_ACCOUNT";
	
	//WithdrawPanel
	
	public static final String COMMAND_BUTTON_MAKE_WITHDRAW = "COMMAND_BUTTON_MAKE_WITHDRAW";

	//DepositPanel
	
	public static final String COMMAND_BUTTON_MAKE_DEPOSIT = "makedeposit";
	
	//Main Frame 
	
	public static final String BUTTON_CROSS ="BUTTON_CROSS";
	public static final String COMMAND_BUTTON_CROSS = "COMMAND_BUTTON_CROSS"; 
	public static final String BUTTON_BACK = "BUTTON_BACK";
	public static final String COMMAND_BUTTON_BACK = "COMMAND_BUTTON_BACK";
	public static final String COMMAND_BUTTON_LOG_OUT = "COMMAND_BUTTON_LOG_OUT";
	public static final String ERROR = "Error";
	public static final String INFORMATION = "INFORMATION";
	
	//Error data
	
	public static final String ERROR_DATA_BLANK = "ERROR_DATA_BLANK";
	public static final String ERROR_DATA_USERNAME_LOGIN = "ERROR_DATA_USERNAME_LOGIN";
	public static final String ERROR_DATA_PASSWORD_LOGIN = "ERROR_DATA_PASSWORD_LOGIN";
	public static final String ACCOUNT_SUCCESSFULLY_CREATED = "ACCOUNT_SUCCESSFULLY_CREATED";
	public static final String TRANSFER_SUCCESSFULLY = "TRANSFER_SUCCESSFULLY";
	public static final String WITHDRAW_SUCCESSFULLY = "WITHDRAW_SUCCESSFULLY";
	public static final String DEPOSIT_SUCCESSFULLY = "DEPOSIT_SUCCESSFULLY";
	public static final String ERROR_TRANSACTIONS = "ERROR_TRANSACTIONS";
	
	//Exceptions
	
	public static final String USER_NOT_FOUND_EXCEPTION = "USER_NOT_FOUND_EXCEPTION";
	public static final String NOT_ENOUGH_MONEY_EXCEPTION = "NOT_ENOUGH_MONEY_EXCEPTION";
	public static final String ACCOUNT_NOT_FOUND_EXCEPTION = "ACCOUNT_NOT_FOUND_EXCEPTION";
	
	//BartChartJDialog
	
	public static final String WOMEN = "WOMEN";
	public static final String MEN = "MEN";
	public static final String QUANTITY = "QUANTITY";
	public static final String TITLE_BART_CHART = "TITLE_BART_CHART";
	public static final String ICON_BUTTON_BART_CHART = "src/res/bartchart.png";
	public static final String COMMAND_BUTTON_BART_CHART = "COMMAND_BUTTON_BART_CHART";
	
	
	
	public Constants(String path) {
		try {
			load(new FileReader(PATH_LENGUAGE_ES));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static Constants createInstance() {
		if(constants == null) {
			constants = new Constants(PATH_LENGUAGE_ES);
		}
		return constants;
	}
	
	public void changeLenguageES() {
		try {
			load(new FileReader(PATH_LENGUAGE_ES));
			lenguageActual = "ES";
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void changeLenguageEN() {
		try {
			load(new FileReader(PATH_LENGUAGE_EN));
			lenguageActual = "EN";
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
