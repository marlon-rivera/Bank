package models;

import views.Constants;

public class NotEnoughMoneyException extends Exception {

	private static final long serialVersionUID = 1L;

	public NotEnoughMoneyException() {
		super(Constants.createInstance().getProperty(Constants.NOT_ENOUGH_MONEY_EXCEPTION));
	}
}
