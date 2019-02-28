package com.exchange.service;

import java.util.Date;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exchange.controllers.to.TransactionTO;
import com.exchange.core.Account;
import com.exchange.core.MoneyTransaction;
import com.exchange.dao.MoneyTransactionRepository;

@Service
public class MoneyTransactionService {

	@Autowired
	private MoneyTransactionRepository moneyTransactionRepository;
	@Autowired
	private AccountService accountService;
	@Autowired
	private ExchangeRateService exchangeService;
	
	public MoneyTransaction findById(Long id) {
		return moneyTransactionRepository.findById(id).orElseThrow(EntityNotFoundException::new);
	}
	
	@Transactional
	public void addTransaction(TransactionTO to) {
		MoneyTransaction transaction = new MoneyTransaction();

		Account account = accountService.findById(to.getAccountId());
		double rate = exchangeService.getExchangeRate(to.getCurrencyFrom(), to.getCurrencyTo());
		double amountTo = to.getAmountFrom() * rate;
		
		transaction.setAccount(account);
		transaction.setAmountFrom(to.getAmountFrom());
		transaction.setAmountTo(amountTo);
		transaction.setCurrencyFrom(to.getCurrencyFrom());
		transaction.setCurrencyTo(to.getCurrencyTo());
		transaction.setDate("2/28/2019");

		moneyTransactionRepository.save(transaction);
	}
	
}
