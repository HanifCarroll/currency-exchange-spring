package com.exchange.controllers;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exchange.controllers.to.AccountTO;
import com.exchange.core.Account;
import com.exchange.service.AccountService;

@RestController
@RequestMapping("/account")
public class AccountController {

	@Autowired
	private AccountService accountService;
	
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public Collection<Account> getAll() {
		return accountService.findAll();
	}
	
	@GetMapping(path="/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public Account get(@PathVariable("id") Long id) {
		return accountService.findById(id);
	}
	
	@PostMapping
	@Transactional
	public void create(@RequestBody AccountTO to) {
		accountService.save(to);
	}
}
