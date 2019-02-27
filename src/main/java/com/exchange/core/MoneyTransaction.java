package com.exchange.core;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="MONEYTRANSACTION")
public class MoneyTransaction {
	
	@Id  
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="TRANID")
	private long id;
	@Column(name="CURRENCY_FROM")
	private String currencyFrom;
	@Column(name="CURRENCY_TO")
    private String currencyTo;
	@Column(name="RATE")
	private double rate;
	@Column(name="AMOUNT_FROM")
    private double amountFrom;
	@Column(name="AMOUNT_TO")
	private double amountTo;
	@Column(name="TRANDATE")
    private String date;
	@ManyToOne
	@JoinColumn(name="ACCOUNTID")
    private Account account;
    
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
	public double getAmountFrom() {
		return amountFrom;
	}
	public void setAmountFrom(double amountFrom) {
		this.amountFrom = amountFrom;
	}
	public double getAmountTo() {
		return amountTo;
	}
	public void setAmountTo(double amountTo) {
		this.amountTo = amountTo;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	@Override
	public String toString() {
		return "MoneyTransaction [id=" + id + ", currencyFrom=" + currencyFrom + ", currencyTo=" + currencyTo
				+ ", rate=" + rate + ", amountFrom=" + amountFrom + ", amountTo=" + amountTo + ", date=" + date
				+ ", account=" + account + "]";
	}

    
    
}
