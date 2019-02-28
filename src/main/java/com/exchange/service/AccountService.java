package com.exchange.service;

import java.util.Collection;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exchange.controllers.to.TransactionTO;
import com.exchange.core.Account;
import com.exchange.core.MoneyTransaction;
import com.exchange.dao.AccountRepository;
import com.exchange.dao.MoneyTransactionRepository;

@Service
public class AccountService {
	
	@Autowired
	private AccountRepository accountRepository;
	@Autowired
	private MoneyTransactionRepository moneyTransactionRepository;
	@Autowired
	private ExchangeRateService exchangeService;
	
	public Account findById(Long id) {
		return accountRepository.findById(id).orElseThrow(EntityNotFoundException::new);
	}
	
	public Iterable<Account> findAllIterable() {
		return accountRepository.findAll();
	}
	
	public Collection<Account> findAll() {
		return (Collection<Account>) accountRepository.findAll();
	}
	
	public void save(Account account) {
		accountRepository.save(account);
	}
	
	@Transactional
	public void addTransactionToAccount(TransactionTO to) {
		Account account = accountRepository.findById(to.getAccountId()).orElseThrow(EntityNotFoundException::new);
		
		MoneyTransaction transaction = new MoneyTransaction();
		double rate = exchangeService.getExchangeRate(to.getCurrencyFrom(), to.getCurrencyTo());
		double amountTo = to.getAmountFrom() * rate;
		
		transaction.setAccount(account);
		transaction.setAmountFrom(to.getAmountFrom());
		transaction.setAmountTo(amountTo);
		transaction.setCurrencyFrom(to.getCurrencyFrom());
		transaction.setCurrencyTo(to.getCurrencyTo());
		transaction.setDate("2/28/2019");
		
		account.addTransaction(transaction);
	}
	
}
