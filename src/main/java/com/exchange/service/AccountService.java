package com.exchange.service;

import java.util.Collection;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
	public Account findAccountById(Long id) {
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
	
	public MoneyTransaction findTransactionById(Long id) {
		return moneyTransactionRepository.findById(id).orElseThrow(EntityNotFoundException::new);
	}
}
