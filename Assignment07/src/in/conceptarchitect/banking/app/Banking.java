
package in.conceptarchitect.banking.app;

import in.conceptarchitect.atm.Atm;
import in.conceptarchitect.banking.BankAccount;
import in.conceptarchitect.utils.Input;

public class Banking {

	public static void main(String[] args) {

		BankAccount a1=new BankAccount(1, "Vivek","p@ss",20000,12);
		
		int choice=0;
		Atm atmObj = new Atm(a1);
		Input input=new Input();
		do {
			
			choice=input.readInt("1. Deposit\n2. Withdraw\n3.Credit Interst\n4.Show\n0.Exit\nChoose:");
			
			switch(choice) {
			case 1:
				atmObj.deposit();
				break;
			case 2:
				atmObj.withdraw();
				break;
				
			case 3:
				atmObj.creditInterest();
				break;
				
			case 4:
				atmObj.displayAccountDetails();
				break;
			case 0:
				break;
			default:
				System.out.println("Invalid Input.Retry");
			}
			System.out.println("\n\n");
		}while(choice!=0);
	}

}