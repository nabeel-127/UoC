import java.util.Scanner;

public class BankAccount
{	
	private String name;
	private float balance = 0F;

	public BankAccount(String _name, float _balance)
	{
		name = _name;
		balance = _balance;
	}
	public void depositMoney(float money)
	{
		balance += money;
	}
	public float withdrawMoney(float money)
	{
		if (money <= balance)
			balance -= money;
		return balance;
	}
	public void displayInformation()
	{
		System.out.print("\033[H\033[2J");
		System.out.flush();
		System.out.println("Account Holder Name: " + name);
		System.out.println("Account Holder Balance: " + balance);
	}
	public float getBalance()
	{
		return balance;
	}

	public static void main(String[] args)
	{
		String name;
		float startingBalance = 0F, money = 0F;
		short options;

		System.out.print("\033[H\033[2J");
		System.out.flush();
		
		Scanner input = new Scanner(System.in);
		System.out.print("Enter Account Holder Name: ");
		name = input.nextLine();
		System.out.print("Enter Account Holder'starting balance: ");
		startingBalance = input.nextFloat();
		BankAccount myAccount = new BankAccount(name, startingBalance);

		boolean whileCondition = true;
		while (whileCondition)
		{
			System.out.print("\033[H\033[2J");
			System.out.flush();
			System.out.println("1. Display Information");
			System.out.println("2. Deposit Cash");
			System.out.println("3. Withdraw Cash");
			System.out.println("4. Exit");
			options = input.nextShort();
			switch (options)
			{
			case 1:
				myAccount.displayInformation();
				System.out.println("Press Enter to continue . . .");
				input.nextLine();
				input.nextLine();
				break;
			case 2:
				System.out.print("\033[H\033[2J");
				System.out.flush();
				System.out.print("Enter amount to deposit: ");
				money = input.nextFloat();
				myAccount.depositMoney(money);
				money = 0;
				break;
			case 3:
				System.out.print("\033[H\033[2J");
				System.out.flush();
				System.out.print("Enter amount to withdraw: ");
				money = input.nextFloat();
				if (money <= myAccount.getBalance())
					myAccount.withdrawMoney(money);
				else
				{
					System.out.println("Insufficient balance. Press Enter to continue . . .");
					input.nextLine();
					input.nextLine();
				}
				money = 0;
				break;
			case 4:
				System.out.print("\033[H\033[2J");
				System.out.flush();
				whileCondition = false;
				break;
			default:
				System.out.println("Only 4 options, choose from those genius -_-\nPress Enter to continue . . .");
				input.nextLine();
				input.nextLine();
			}
		}
		input.close();
	}
}