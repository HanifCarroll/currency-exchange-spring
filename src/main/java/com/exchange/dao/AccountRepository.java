package com.exchange.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.exchange.core.Account;

@Repository
public interface AccountRepository extends PagingAndSortingRepository<Account, Long> {

}
