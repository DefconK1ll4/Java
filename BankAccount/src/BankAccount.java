public class BankAccount {
    /*
deposit method some sout in the methods
whitdraw method with balance checking some sout in the methods
     */
    private String accountNumber;
    private double balance;
    private String customerName;
    private String emailAddress;
    private String phoneNumber;


    public BankAccount(String accountNumber, double balance, String customerName, String emailAddress, String phoneNumber) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.customerName = customerName;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
    }
    public String getAccountNumber() {
        return this.accountNumber;
    }
    public double getBalance() {
        return this.balance;
    }
    public String getCustomerName() {
        return this.customerName;
    }
    public String getEmailAddress() {
        return this.emailAddress;
    }
    public String getPhoneNumber() {
        return this.phoneNumber;
    }
    public void setAccountNumber(String newAccountNumber) {
        this.accountNumber = newAccountNumber;
    }
    public void setBalance(double newBalance) {
        this.balance = newBalance;
    }
    public void setCustomerName(String newCustomerName) {
        this.customerName = newCustomerName;
    }
    public void setEmailAddress(String newEmailAddress) {
        this.emailAddress = newEmailAddress;
    }
    public void setPhoneNumber(String newPhoneNumber) {
        this.phoneNumber = newPhoneNumber;
    }
    public void deposit(double depositMoney) {
        System.out.println("Before deposit: " + this.balance);
        this.balance += depositMoney;
        System.out.println("Updated your balance: " + this.balance);
    }
    public void whitdraw(double whitdrawMoney) {
        if(this.balance < whitdrawMoney) {
            System.out.println("You're trying to whitdraw: " + whitdrawMoney + " but you only have: " + this.balance + " left.");
        } else if(whitdrawMoney < 0) {
            System.out.println("Invalid Value");
        } else {
            System.out.println("Before whidrawal: " + this.balance);
            this.balance -= whitdrawMoney;
            System.out.println("After whidrawal: " + this.balance);
        }
    }
}
