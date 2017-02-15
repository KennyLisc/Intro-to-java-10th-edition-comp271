// Gustavo Assis Cardoso
// Lab2 - Part 2
// Page 445 #11.3
public class Accountdrv {
  public static void main (String[] args) {
    /*Account account = new Account(1122, 0, 4.5);

    account.deposit(3000);
    account.withdraw(2500);
    System.out.println("Balance is " + account.getBalance());
    System.out.println("Monthly interest is " +
    account.getMonthlyInterest());
    System.out.println("This account was created at " +
    account.getDateCreated());
    */
    
    Account checkingAccount = new CheckingAccount(1234,5000,4.5);
    System.out.println(checkingAccount);
    checkingAccount.withdraw(500);
    System.out.println(checkingAccount);
    checkingAccount.withdraw(5000);
    
    Account savingsAccount = new SavingsAccount(4321,10000,4.5);
    System.out.println(savingsAccount);
    savingsAccount.withdraw(12000);
    System.out.println(savingsAccount);
    savingsAccount.withdraw(8000);
    System.out.println(savingsAccount);
  }
}

class Account {
  private int id;
  protected double balance;
  private double annualInterestRate;
  private java.util.Date dateCreated;

  public Account() {
    dateCreated = new java.util.Date();
  }

  public Account(int id, double balance, double annualInterestRate) {
    this.id = id;
    this.balance = balance;
    this.annualInterestRate = annualInterestRate;
    dateCreated = new java.util.Date();
  }

  public int getId() {
    return this.id;
  }

  public double getBalance() {
    return balance;
  }

  public double getAnnualInterestRate() {
    return annualInterestRate;
  }

  public void setId(int id) {
    this.id =id;
  }

  public void setBalance(double balance) {
    this.balance = balance;
  }

  public void setAnnualInterestRate(double annualInterestRate) {
    this.annualInterestRate = annualInterestRate;
  }

  public double getMonthlyInterest() {
    return balance * (annualInterestRate / 1200);
  }

  public java.util.Date getDateCreated() {
    return dateCreated;
  }

  public void withdraw(double amount) {
    balance -= amount;
  }

  public void deposit(double amount) {
    balance += amount;
  }
  
  public String toString(){
			return String.format("Account ID: %d \nBalance is: $%.2f\nMonthly interest is: $%.2f"
					+ "\nThis account was created at: ", this.getId(), this.getBalance(), this.getMonthlyInterest()) +
					this.getDateCreated() + "\n";
		}
}

class SavingsAccount extends Account{
	public SavingsAccount(int ID, double balance, double annualInterestRate){
		super(ID,balance,annualInterestRate);
	}
	
	public void withdraw(double withdrawal){
	// Savings account does not allow withdraw below balance.
		if(withdrawal > this.balance){
			System.out.println("**Insufficient funds.\n\n");
		}
		else
			this.balance -= withdrawal;
	}
}

class CheckingAccount extends Account{
	private final double LIMIT = 100.0;
	
	public CheckingAccount(int ID, double balance, double annualInterestRate){
		super(ID,balance,annualInterestRate);
	}

	public void withdraw(double amount){
	// Checking has an overdraft of up to LIMIT
		if(amount - this.balance > LIMIT){
			System.out.println("**Insufficient funds.\n\n");
		}
		else
			this.balance -= amount;
	}
}