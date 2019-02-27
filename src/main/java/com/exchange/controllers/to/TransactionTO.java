package com.exchange.controllers.to;

public class TransactionTO {
	private long accountId;
	private String currencyFrom;
	private String currencyTo;
	private double amountFrom;
	public long getAccountId() {
		return accountId;
	}
	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}
	public String getCurrencyFrom() {
		return currencyFrom;
	}
	public void setCurrencyFrom(String currencyFrom) {
		this.currencyFrom = currencyFrom;
	}
	public String getCurrencyTo() {
		return currencyTo;
	}
	public void setCurrencyTo(String currencyTo) {
		this.currencyTo = currencyTo;
	}
	public double getAmountFrom() {
		return amountFrom;
	}
	public void setAmountFrom(double amountFrom) {
		this.amountFrom = amountFrom;
	}
	@Override
	public String toString() {
		return "TransactionTO [accountId=" + accountId + ", currencyFrom=" + currencyFrom + ", currencyTo=" + currencyTo
				+ ", amountFrom=" + amountFrom + "]";
	}
	 

}
