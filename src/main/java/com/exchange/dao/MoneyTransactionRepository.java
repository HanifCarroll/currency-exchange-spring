package com.exchange.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.exchange.core.MoneyTransaction;

public interface MoneyTransactionRepository extends PagingAndSortingRepository<MoneyTransaction, Long> {

}
