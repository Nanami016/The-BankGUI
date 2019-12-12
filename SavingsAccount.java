public class SavingsAccount extends BankAccount
{
	private double interestRate;
	
	public SavingsAccount(String id, double interestRate)
	{
		id = this.getId(); 
		this.interestRate = interestRate * 0.01;
	}
	
	public double getBalance()//方法的覆盖
	{
		System.out.println("假设已经往账户的手机发了一条短信");
		return super.getBalance();
	}
	
	public void addInterest( double interestRate )
	{
		double balance = super.getBalance();
		double interest = balance * interestRate;
		deposit(interest);
		//balance += balance * interestRate;
	}
	
	public void print()
	{
		System.out.println("卡号：" + getId() + "；余额：" 
			+ super.getBalance() + "；利率：" + interestRate);
	}
	
	/*public static void main(String[] args)
	{
		SavingsAccount sa = new SavingsAccount("S001", 3);
		sa.deposit(10000);
		sa.addInterest();
		sa.addInterest();
		sa.addInterest();
		System.out.println("卡号为" + sa.getId() + "的存款余额为" + sa.getBalance());
	}*/
}
