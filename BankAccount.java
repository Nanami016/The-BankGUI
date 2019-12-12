public class BankAccount
{
	private String id;
	private double balance;
	
	public BankAccount()
	{
	}
	
	public BankAccount(String id)
	{
		this.id = id;
	}
	
	public String getId()
	{
		return id;
	}
	
	public double getBalance()
	{
		return balance;
	}
	
	public void deposit(double amount)
	{
		balance += amount;
	}
	
	public void withdraw(double amount)
	{
		balance -= amount;
	}
	
	public void print()
	{
		System.out.println("卡号" + id + "余额" + balance);
	}
	
	/*public static void main(String[] args)
	{
		BankAccount a = new BankAccount("ICBC001");
		a.deposit(1000000);
		System.out.println(a.getBalance());
		a.deposit(100);
		System.out.println(a.getBalance());
	}*/
}
