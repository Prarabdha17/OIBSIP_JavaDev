package atm_interface;

import java.util.Scanner;

class BankAccount 
{
	String name;
	String userName;
	String password;
	String accountNo;
	float balance = 10000f;
	int transactions = 0;
	String transactionHistory = "";
	
	public void register() 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("\nEnter your Name: ");
		this.name = sc.nextLine();
		System.out.println("\nEnter your Username: ");
		this.userName = sc.nextLine();
		System.out.println("\nEnter your Password: ");
		this.password = sc.nextLine();
		System.out.println("\nEnter your Account Number: ");
		this.accountNo = sc.nextLine();
		System.out.println("\nRegistration Successful. Please Log in to your bank Account");
	}
	public boolean login() 
	{
		boolean isLogin = false;
		Scanner sc = new Scanner(System.in);
		while(!isLogin) 
		{
			System.out.println("\nEnter your Username: ");
			String Username = sc.nextLine();
			if(Username.equals(userName)) 
			{
				while(!isLogin) {
					System.out.println("\nEnter your Password: ");
					String Password = sc.nextLine();
					if(Password.equals(password)) 
					{
						System.out.println("Login Successful");
						isLogin = true;
					}
					else 
					{
						System.out.println("\nInvalid Password");
					}
				}
			}
			else 
			{
				System.out.println("\nUsername Not Found");
			}
		}
		return isLogin;
	}
	public void withdraw()
	{
		System.out.println("Enter Amount Withdraw: ");
		Scanner sc = new Scanner(System.in);
		float amount = sc.nextFloat();
		try
		{
			if(balance >= amount) 
			{
				transactions++;
				balance -= amount;
				System.out.println("\nWithdraw Successful");
				String str = amount + "Rs Withdrwan\n";
				transactionHistory = transactionHistory.concat(str);
			}
			else
			{
				System.out.println("\nInsufficient Balance");
			}
		}
		catch(Exception e)
		{
			
		}
	}
	
	public void transHistory() 
	{
		if(transactions==0)
		{
			System.out.println("No Transactions Happened");
		}
		else
		{
			System.out.println("\n"+transactionHistory);
		}
	}
}

public class ATM_Interface {

	
}
