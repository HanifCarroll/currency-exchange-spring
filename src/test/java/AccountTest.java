import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.exchange.ExchangeApplication;
import com.exchange.core.Account;
import com.exchange.core.MoneyTransaction;
import com.exchange.service.AccountService;

@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT, classes=ExchangeApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class AccountTest {
	
	@Autowired
	private AccountService accountService;
	
	//@Test
	public void findById1LShouldReturnFredFlinstone() {
		Account account = accountService.findAccountById(1L);
		System.out.println(account.getFirstName() + account.getLastName());
		System.out.println(account.getTransactions());
	}
	
	//@Test
	public void saveShouldAddNewAccount() {
		Account newAccount = new Account("Hanif", "Carroll", "Test@Test.com", "Test@Paypal.com", "5/17/91", "USA");
		int oldSize = accountService.findAll().size();
		System.out.println(oldSize);
		accountService.save(newAccount);
		int newSize = accountService.findAll().size();
		System.out.println(newSize);
	}
	
	//@Test
	public void getAllAccountsShouldReturnAllAccounts() {
		Collection<Account> accounts = accountService.findAll();
		
		accounts.forEach(System.out::println);
	}
	
	@Test
	public void moneyTransaction1LShouldBelongToFred() {
		MoneyTransaction transaction = accountService.findTransactionById(1L);
		
		System.out.println(transaction.getAccount());
	}
	
}
