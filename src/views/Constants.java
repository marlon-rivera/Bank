package views;

import java.awt.Color;
import java.awt.Font;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Constants extends Properties {

	
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
	
	//Main Frame
	
	public static final String BUTTON_CROSS ="BUTTON_CROSS";
	public static final String COMMAND_BUTTON_CROSS = "COMMAND_BUTTON_CROSS"; 
	
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
