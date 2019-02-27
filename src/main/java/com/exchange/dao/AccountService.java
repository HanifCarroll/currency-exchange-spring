package com.exchange.dao;

import java.util.Collection;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exchange.core.Account;

@Service
public class AccountService {
	
	@Autowired
	private AccountRepository accountRepository;
	
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
}
