package in.conceptarchitect.banking.tests;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import in.conceptarchitect.banking.Bank;
import in.conceptarchitect.banking.BankAccount;

public class BankTests {
	
	BankAccount account;
	String name="Tiru";
	int accno=12;
    int targetaccno;
    int sourceaccno;
    BankAccount toAccount;
	String toName="Nara";
	String toPassword="pass";
	String correctPassword="pass";
	double balance=20000;
	double toBalance=50000;
	int interestRate=10;
	Bank bank;
	
	@Before
	public void init() {
		bank = new Bank("icici",interestRate);
		account=new BankAccount(name,correctPassword, balance);
	}
	
	
	@Test
	public void transfer_shouldFailIfFromAccountDoesntExist() {
		boolean result = bank.transfer(121, 2000, correctPassword,targetaccno);
		assertEquals(false,result);
		
	}
	@Test
	public void transfer_shouldFailIfInvalidToAccount() {
		boolean result = bank.transfer(1, 2000, correctPassword, 122);
		assertEquals(false,result);
		
	}
	
	@Test
	public void transfer_shouldFailForInvalidPassword() {
		boolean result = bank.transfer(sourceaccno, 1000, "abc", 111);
		assertEquals(false,result);
	}
	
	@Test
	public void transfer_shouldFailForInsufficientBalance() {
		
		boolean result = bank.transfer(sourceaccno, balance+1, correctPassword, targetaccno);
		assertEquals(false,result);
	
	}
	
	@Test
	public void transfer_shouldSucceedInHappyPath() {
//		boolean result = bank.transfer(sourceaccno, balance, correctPassword, targetaccno);
//		assertEquals(true,result);

	}
	
	@Test
	public void creditInterest_creditsOneMonthOfInterest() {
		
		double expectedBal =balance+(balance*interestRate)/1200;
		account.creditInterest(interestRate);
		double actualBalAfterInterest = account.getBalance();
		assertTrue(expectedBal==actualBalAfterInterest);
		
	}
	
	@Test
	public void closeAccount_failsForInvalidAccountNumber() {
		boolean result = bank.close(targetaccno+121, toPassword);
		assertEquals(false,result);
		
	}
	
	@Test
	public void closeAccount_cantWithdrawFromClosedAccount() {
		boolean result = bank.close(targetaccno, toPassword);
		if(result) {
			boolean withdrawSuccess = bank.withdraw(targetaccno, 2000, toPassword);
			assertEquals(false,withdrawSuccess);
		}
	}
	
	
	@Test
	public void openAccount_AssignsSequentialAccountNumber() {
		
	}
	
	
}
