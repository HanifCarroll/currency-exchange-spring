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
@Table(name="EXCHANGE_RATE")

public class ExchangeRate {
	@Id  
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="RATEID")
	private long id;
	@Column(name="SYMBOL_FROM")
	private String currencyFrom;
	@Column(name="SYMBOL_TO")
	private String currencyTo;
	@Column(name="DATE_OF_TRAN")
	private String DateOfTransaction;
	@Column(name="RATE")
	private double rate;
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
	public String getDateOfTransaction() {
		return DateOfTransaction;
	}
	public void setDateOfTransaction(String dateOfTransaction) {
		DateOfTransaction = dateOfTransaction;
	}
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
	@Override
	public String toString() {
		return "ExchangeRate [id=" + id + ", currencyFrom=" + currencyFrom + ", currencyTo=" + currencyTo
				+ ", DateOfTransaction=" + DateOfTransaction + ", rate=" + rate + "]";
	}
	
	
	
	
	
	
	
	
}
