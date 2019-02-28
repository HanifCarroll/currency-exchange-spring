package com.exchange.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exchange.controllers.to.ExchangeRateTO;
import com.exchange.core.ExchangeRate;
import com.exchange.dao.ExchangeRateRepository;

@Service
public class ExchangeRateService {

	@Autowired
	private ExchangeRateRepository exchangeRateRepository;
	
	public double getCurrentExchangeRate(String from, String to) {
		List<ExchangeRate> rates = exchangeRateRepository.findAllByCurrencyFromAndCurrencyToOrderByIdDesc(from, to);
		ExchangeRate exchangeRate = rates.stream().findFirst().orElseThrow(EntityNotFoundException::new);
		
		return exchangeRate.getRate();
	}
	
	public List<ExchangeRate> getExchangeRates(String from, String to) {
		List<ExchangeRate> rates = exchangeRateRepository.findAllByCurrencyFromAndCurrencyToOrderByIdDesc(from, to);
		return rates;
	}
	
	public ExchangeRate addExchangeRate(String from, String to, double rate, String year) {
		ExchangeRate exchangeRate = new ExchangeRate();
		
		exchangeRate.setCurrencyFrom(from);
		exchangeRate.setCurrencyTo(to);
		exchangeRate.setRate(rate);
		LocalDateTime dt = LocalDateTime.now().withYear(2019);
		exchangeRate.setDateOfTransaction(dt.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
		exchangeRateRepository.save(exchangeRate);
		
		return exchangeRate;
	}
	
	public Map<String, Map<String, Double>> getHistorialRates(String from) {
	       Collection<ExchangeRate> history = exchangeRateRepository.findByCurrencyFrom(from);
	       Map<String, Map<String, Double>> map =  history.stream().map(p-> {
	            ExchangeRateTO to = new ExchangeRateTO();
	            to.setRate(p.getRate());
	            LocalDate localDate = LocalDate.parse(p.getDateOfTransaction().substring(0, 10));
	            to.setYear(new Integer(localDate.getYear()).toString());
	            to.setCurrencyTo(p.getCurrencyTo());
	            return to;
	        })
	        .sorted((x,y)-> x.getYear().compareTo(y.getYear()))
	        .collect(Collectors.groupingBy(ExchangeRateTO::getCurrencyTo, Collectors.groupingBy(ExchangeRateTO::getYear, Collectors.averagingDouble(p-> p.getRate()))));      
	       return map;
	              
	        
	    }
}
