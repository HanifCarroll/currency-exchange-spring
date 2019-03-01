package com.exchange.controllers;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exchange.controllers.to.ExchangeRateTO;
import com.exchange.controllers.to.TransactionTO;
import com.exchange.core.ExchangeRate;
import com.exchange.core.MoneyTransaction;
import com.exchange.service.ExchangeRateService;
import com.exchange.service.MoneyTransactionService;

@RestController
@RequestMapping(path="/transaction")
public class MoneyTransactionController {

	@Autowired
	private MoneyTransactionService moneyTransactionService;
	@Autowired
	private ExchangeRateService exchangeRateService;
	
	@PostMapping
	@Transactional
	public MoneyTransaction exchange(@RequestBody TransactionTO to) {
		return moneyTransactionService.addTransaction(to);
	}
	@PostMapping(path="/{currencyFrom}")
	@Transactional
	public ExchangeRate newRate(@PathVariable("currencyFrom") String currencyFrom, @RequestBody ExchangeRateTO to) {
		return exchangeRateService.addExchangeRate(currencyFrom, to);
	}
	
	
}
