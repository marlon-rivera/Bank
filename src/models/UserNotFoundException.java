package models;

import views.Constants;

public class UserNotFoundException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public UserNotFoundException() {
		super(Constants.createInstance().getProperty(Constants.USER_NOT_FOUND_EXCEPTION));
	}
}
