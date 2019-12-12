public class CheckingAccount extends BankAccount
{
	private int transactionCount;
	public CheckingAccount(String id)
	{
		id = this.getId();
	}
	
	public void deposit(double amount)
	{
		super.deposit(amount);
		transactionCount++;
	}
	
	public void withdraw(double amount)
	{
		super.withdraw(amount);
		transactionCount++;
	}
	
	public void deductFees()
	{
		if(transactionCount > 3)
		{
			double fees = (transactionCount - 3) * 2;
			super.withdraw(fees);
		}
		transactionCount = 0;
	}
	
	public void print()
	{
		System.out.println("卡号：" + getId() + "；余额：" 
			+ super.getBalance() + "；交易次数：" + transactionCount);
	}
	
	/*public static void main(String[] args)
	{
		CheckingAccount ca = new CheckingAccount("C001");
		ca.deposit(10000);
		ca.deposit(10000);
		ca.deposit(10000);
		ca.withdraw(10000);
		ca.withdraw(10000);
		ca.deductFees();
		ca.deposit(10000);
		ca.deposit(10000);
		ca.deposit(10000);
		ca.withdraw(10000);
		ca.withdraw(10000);
		ca.deductFees();
		System.out.println("卡号为" + ca.getId() + "的存款余额为" + ca.getBalance());
	}*/
}
