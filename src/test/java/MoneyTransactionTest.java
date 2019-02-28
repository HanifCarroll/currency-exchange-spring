import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.exchange.ExchangeApplication;
import com.exchange.controllers.to.TransactionTO;
import com.exchange.core.Account;
import com.exchange.core.MoneyTransaction;
import com.exchange.service.AccountService;
import com.exchange.service.MoneyTransactionService;

@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT, classes=ExchangeApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class MoneyTransactionTest {
	
	@Autowired
	private AccountService accountService;
	@Autowired
	private MoneyTransactionService transactionService;
	
	//@Test
	public void moneyTransaction1LShouldBelongToFred() {
		MoneyTransaction transaction = transactionService.findById(1L);
		
		System.out.println(transaction.getAccount());
	}
	
	//@Test
	public void addMoneyTransactionFromTransactionService() {
		Account fred = accountService.findById(1L);
		System.out.println(fred.getTransactions().size());
		TransactionTO transaction = new TransactionTO();
		transaction.setAccountId(1L);
		transaction.setAmountFrom(100);
		transaction.setCurrencyFrom("USD");
		transaction.setCurrencyTo("YEN");
		
		transactionService.addTransaction(transaction);
		Account updatedFred = accountService.findById(1L);
		System.out.println(updatedFred.getTransactions().size());
	}
	
	//@Test
	public void addMoneyTransactionFromAccountService() {
		Account fred = accountService.findById(1L);
		System.out.println(fred.getTransactions().size());
		TransactionTO transaction = new TransactionTO();
		transaction.setAccountId(1L);
		transaction.setAmountFrom(100);
		transaction.setCurrencyFrom("USD");
		transaction.setCurrencyTo("YEN");
		
		accountService.addTransactionToAccount(transaction);
		fred = accountService.findById(1L);
		System.out.println(fred.getTransactions().size());
		
	}
	
	@Test
	public void newTransactionShouldHaveUpdatedRate() {
		Account fred = accountService.findById(1L);
		TransactionTO transaction = new TransactionTO();
		transaction.setAccountId(1L);
		transaction.setAmountFrom(100);
		transaction.setCurrencyFrom("USD");
		transaction.setCurrencyTo("YEN");
		
		accountService.addTransactionToAccount(transaction);
		fred = accountService.findById(1L);
		
		System.out.println(fred.getTransactions());
	}

}
