package models;

public class BankingTransaction {

	private String date;
	private TypeTransaction type;
	private double amount;

	public BankingTransaction(String date, TypeTransaction type, double amount) {
		this.date = date;
		this.type = type;
		this.amount = amount;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public TypeTransaction getType() {
		return type;
	}

	public void setType(TypeTransaction type) {
		this.type = type;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
}