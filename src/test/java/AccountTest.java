import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.exchange.ExchangeApplication;

@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT, classes=ExchangeApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class AccountTest {
	
	@Test
	public void findById1LShouldReturnFredFlinstone() {
		
	}
	
	@Test
	public void saveShouldAddNewAccount() {
		
	}
	
	@Test
	public void getAllAccountsShouldReturnAllAccounts() {
		
	}
}
