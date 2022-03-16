package models;

import views.Constants;

public class AccountNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public AccountNotFoundException() {
		super(Constants.createInstance().getProperty(Constants.ACCOUNT_NOT_FOUND_EXCEPTION));
	}
}
