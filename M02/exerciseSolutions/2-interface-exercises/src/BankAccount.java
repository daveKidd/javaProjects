public class BankAccount implements MoneyStorage {
    /*
    1. Add a new class to the project named `BankAccount`.
    2. `BankAccount` must implement `MoneyStorage`.
    3. Complete the implementation. Add fields, constructors, and getters as required.
        (Refer to `Mortgage` for inspiration, but with a positive balance.)
    5. Rules:
        - Deposits must be positive values.
        - Can overdraw up to -25.00 dollars, but no lower.
        (The balance is allowed to go negative.)
     */

    private double balance;
    private String accountNumber;

    public BankAccount(double balance, String accountNumber) {
        this.balance = balance;
        this.accountNumber = accountNumber;
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public String getDescription() {
        return String.format("Bank Account #%s", accountNumber);
    }

    @Override
    public boolean deposit(double amount) {
        if (amount > 0.0) {
            balance += amount;
            return true;
        }
        return false;
    }

    @Override
    public double withdraw(double amount) {
        if (amount <= 0) {
            return 0;
        }
        balance -= amount;
        if(balance >= -25){
            return amount;
        }else{
            return balance;
        }
    }

}
