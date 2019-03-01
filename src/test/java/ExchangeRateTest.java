import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.exchange.ExchangeApplication;
import com.exchange.core.ExchangeRate;
import com.exchange.service.ExchangeRateService;

@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT, classes=ExchangeApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class ExchangeRateTest {

	@Autowired
	private ExchangeRateService exchangeService;
	
	//@Test
	public void getMostRecentRate() {
		double rate = exchangeService.getCurrentExchangeRate("USD", "YEN");
		System.out.println(rate);
	}
	
	//@Test
	public void addExchangeRate() {
		List<ExchangeRate> rates = exchangeService.getExchangeRates("USD", "YEN");
		System.out.println(rates);
		
		exchangeService.addExchangeRate("USD", "YEN", 143.12, "2019");
		
		rates = exchangeService.getExchangeRates("USD", "YEN");
		System.out.println(rates);
	}

	@Test
	public void testHistoricalRates() {
		Map<String, Map<String, Double>> map = exchangeService.getHistoricalRates("USD");
		assertThat(map.entrySet().size(), equalTo(3));
		map.entrySet().stream().forEach(e-> {
			System.out.println(e.getKey());
			e.getValue().entrySet().stream().forEach(p-> System.out.printf("%4s %5.2f %n",p.getKey(), p.getValue()));
		});
	}
}
