package com.exchange.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.exchange.core.ExchangeRate;
import com.exchange.service.ExchangeRateService;

@RestController
public class ExchangeRateController {

	@Autowired
	private ExchangeRateService exchangeRateService;
	
	@GetMapping(path="/history/{from}")
	public Map<String, Map<String, Double>> getHistoricalData(@PathVariable("from") String from) {
		Map<String, Map<String, Double>> map = exchangeRateService.getHistoricalRates(from);
		
		return map;
	}
	
	@GetMapping(path="/history/{from}/{to}")
	public List<ExchangeRate> getExchangeRates(@PathVariable("from") String from, @PathVariable("to") String to) {
		return exchangeRateService.getExchangeRates(from, to);
	}
}
