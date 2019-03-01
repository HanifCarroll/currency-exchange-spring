package com.exchange.service;

import java.util.Collection;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exchange.controllers.to.AccountTO;
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
	
	public void save(AccountTO to) {
		Account account = new Account();
		
		account.setFirstName(to.getFirstName());
		account.setLastName(to.getLastName());
		account.setContactEmail(to.getContactEmail());
		account.setPayPalEmail(to.getPayPalEmail());
		account.setDateOFBirth(to.getDateOFBirth());
		account.setCountryOfResidence(to.getCountryOfResidence());
		
		accountRepository.save(account);
	}
	
	@Transactional
	public void addTransactionToAccount(TransactionTO to) {
		Account account = accountRepository.findById(to.getAccountId()).orElseThrow(EntityNotFoundException::new);
		
		MoneyTransaction transaction = new MoneyTransaction();
		double rate = exchangeService.getCurrentExchangeRate(to.getCurrencyFrom(), to.getCurrencyTo());
		double amountTo = to.getAmountFrom() * rate;
		
		transaction.setAccount(account);
		transaction.setAmountFrom(to.getAmountFrom());
		transaction.setAmountTo(amountTo);
		transaction.setCurrencyFrom(to.getCurrencyFrom());
		transaction.setCurrencyTo(to.getCurrencyTo());
		transaction.setDate("2/28/2019");
		
		account.addTransaction(transaction);
	}

	public void update(AccountTO to) {
		
		Account account = findById(to.getId());
		
		account.setFirstName(to.getFirstName());
		account.setLastName(to.getLastName());
		account.setContactEmail(to.getContactEmail());
		account.setPayPalEmail(to.getPayPalEmail());
		account.setDateOFBirth(to.getDateOFBirth());
		account.setCountryOfResidence(to.getCountryOfResidence());
		
		accountRepository.save(account);
		
	}
	
}
