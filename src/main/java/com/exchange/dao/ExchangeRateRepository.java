package com.exchange.dao;

import java.util.Collection;
import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.exchange.core.ExchangeRate;
@Repository
public interface ExchangeRateRepository extends PagingAndSortingRepository<ExchangeRate, Long> {

	List<ExchangeRate> findAllByCurrencyFromAndCurrencyToOrderByIdDesc(String from, String to);

	Collection<ExchangeRate> findByCurrencyFrom(String from);
	
}
