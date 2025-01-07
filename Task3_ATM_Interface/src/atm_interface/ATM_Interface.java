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
	public void deposit()
	{
		System.out.println("Enter Amount to Deposit: ");
		Scanner sc = new Scanner(System.in);
		float amount = sc.nextFloat();
		try
		{
			if(amount <= 10000f) 
			{
				transactions++;
				balance += amount;
				System.out.println("\nDeposit Successful");
				String str = amount + "Rs Deposited\n";
				transactionHistory = transactionHistory.concat(str);
			}
			else
			{
				System.out.println("\nSorry the limit is 10000");
			}
		}
		catch(Exception e)
		{
			
		}
	}
	public void transfer()
	{	Scanner sc = new Scanner(System.in);
		System.out.println("Enter Recipent's name: ");
		String recipent = sc.nextLine();
		System.out.println("Enter Amount to Trasfer: ");
		float amount = sc.nextFloat();
		try
		{
			if(balance >= amount)
			{
			if(amount <= 50000f) 
			{
				transactions++;
				balance -= amount;
				System.out.println("\nSuccessfully Trasnfered to "+ recipent);
				String str = amount + "Rs Transfered to "+ recipent +"\n";
				transactionHistory = transactionHistory.concat(str);
			}
			else
			{
				System.out.println("\nSorry the limit is 50000");
			}
			}
			else 
			{
				System.out.println("Insufficient Balance");
			}
		}
		catch(Exception e)
		{
			
		}
	}
	
	public void checkBalance() 
	{
		System.out.println("\n" + balance +"Rs");
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

public class ATM_Interface 
{
	public static int takenIntegerInput(int limit)
	{
		int input = 0;
		boolean flag = false;
		
		while(!flag)
		{
			try {
				Scanner sc = new Scanner(System.in);
				input = sc.nextInt();
				flag = true;
				
				if(flag && input>limit || input < 1)
				{
					System.out.println("Choose the Number Between 1 to "+ limit);
					flag = false;
				}
			}
			catch(Exception e)
			{
				System.out.println("Enter only Integer Values");
				flag = false;
			}
		}
		return input;
	}
	public static void main(String[] args) 
	{
		System.out.println("\n**********Welcome To ATM Interface*********");
		System.out.println("Choose What You Want to Do....");
		System.out.println(" 1. Resister\n2.Exit");
		int choose = takenIntegerInput(2);
		
		if(choose == 1)
		{
			BankAccount b = new BankAccount();
			b.register();
			while(true)
			{
				System.out.println("Choose What You Want to Do....");
				System.out.println(" 1. Resister\n2.Exit");
				int ch = takenIntegerInput(2);
				if(ch==1)
				{
					if(b.login())
					{
						System.out.println("\nWelcome Back "+ b.name+".......");
						boolean isFinished =false;
						while(!isFinished)
						{
							System.out.println("Choose What You Want to Do....");
							System.out.println(" \n1.Withdraw\n2.Deposit\n3.Transfer\n4.Check Balance\n5.Transaction History\n6.Exit");
							
							int c = takenIntegerInput(2);
							switch(c)
							{
							case 1:
								b.withdraw();
							case 2:
								b.deposit();
							case 3:
								b.transfer();
							case 4:
								b.checkBalance();
							case 5:
								b.transHistory();
							case 6:
								isFinished = true;
								break;
							}
							
						}
					}
					else
					{
						System.exit(0);
					}
				}
				else
				{
					System.exit(0);
				}
			}
		}
	}
	
}
