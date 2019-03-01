package com.exchange.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
	public MoneyTransaction addTransaction(TransactionTO to) {
		MoneyTransaction transaction = new MoneyTransaction();

		Account account = accountService.findById(to.getAccountId());
		double rate = exchangeService.getCurrentExchangeRate(to.getCurrencyFrom(), to.getCurrencyTo());
		double amountTo = to.getAmountFrom() * rate;
		
		transaction.setAccount(account);
		transaction.setRate(rate);
		transaction.setAmountFrom(to.getAmountFrom());
		transaction.setAmountTo(amountTo);
		transaction.setCurrencyFrom(to.getCurrencyFrom());
		transaction.setCurrencyTo(to.getCurrencyTo());
		
		LocalDateTime dt = LocalDateTime.now().withYear(2019);
		transaction.setDate(dt.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));

		return moneyTransactionRepository.save(transaction);
	}
	
}
