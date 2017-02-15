//  Create the Account class
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
    System.out.println(checkingAccount);
    
    Account savingsAccount = new SavingsAccount(4321,10000,4.5);
    System.out.println(savingsAccount);
    savingsAccount.withdraw(12000);
    System.out.println(savingsAccount);
    savingsAccount.withdraw(8000);
    System.out.println(savingsAccount);
    
    
      /*Account savings = new SavingsAccount(1234, 500, 4.5);
		savings.setAnnualInterestRate(0.045);
		System.out.println(savings);
		savings.withdraw(100);
		System.out.println(savings);
		savings.withdraw(500);
		System.out.println(savings);
		
		CheckingAccount checking = new CheckingAccount(4321,100, 4.5);
		System.out.println(checking);
		checking.withdraw(50);
		System.out.println(checking);
		checking.withdraw(100);
		System.out.println(checking);
		checking.withdraw(100);
		System.out.println(checking);
     	*/
  }
}

class Account {
  private int id;
  public double balance;
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
		// method to get account details, returns a formatted string
			return String.format("Account ID: %d \t Account Type: %s\nBalance: $%.2f\nMonthly Interest: $%.2f"
					+ "\nDate Created: ", this.getId(), this.getClass().getSimpleName(), this.getBalance(), this.getMonthlyInterest()) +
					this.getDateCreated();
		}
}

class SavingsAccount extends Account{
	public SavingsAccount(){
		//this(0,0,0);
	}
	
	public SavingsAccount(int ID, double balance, double annualInterestRate){
		super(ID,balance,annualInterestRate);
	}
	
	public void withdraw(double withdrawal){
	// Savings account does not allow withdraw below balance.
		if(withdrawal > this.balance){
			System.out.println("**Insufficient funds.\n");
		}
		else
			this.balance -= withdrawal;
	}
}

class CheckingAccount extends Account{
	private final double LIMIT = 100.0;
	
	public CheckingAccount(){
		//this(0,0,0);
	}
	
	public CheckingAccount(int ID, double balance, double annualInterestRate){
		super(ID,balance,annualInterestRate);
	}

	public void withdraw(double amount){
	// Checking has an overdraft of up to LIMIT
		if(amount - this.balance > LIMIT){
			System.out.println("**Insufficient funds.\n");
		}
		else
			this.balance -= amount;
	}
}