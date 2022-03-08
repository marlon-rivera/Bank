package models;

import java.time.LocalDate;

public class BankingTransaction {

	private LocalDate date;
	private TypeTransaction type;
	private double amount;

	public BankingTransaction(LocalDate date, TypeTransaction type, double amount) {
		this.date = date;
		this.type = type;
		this.amount = amount;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
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