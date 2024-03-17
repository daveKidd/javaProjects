public class Person {

    private final String firstName;
    private final String lastName;
    private MoneyStorage moneyStorage;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName() {
        return String.format("%s %s", firstName, lastName);
    }

    public MoneyStorage getMoneyStorage() {
        return moneyStorage;
    }

    public void setMoneyStorage(MoneyStorage moneyStorage) {
        // HACK: We don't have the ability to create a wallet when is created under circumstances...
        // so only allow this to be done once.
        if (this.moneyStorage == null) {
            this.moneyStorage = moneyStorage;
        } else {

        }
    }








    // TODO Is this a good approach?
    // Pass through methods

    // PRO - Doesn't break existing code (could be many references)
    // CON - Method names are clear relative to "Person"

    public String getDescription() {
        if (moneyStorage != null) {
            return moneyStorage.getDescription();
        }
        return null;
    }

    public double getBalance() {
        if (moneyStorage != null) {
            return moneyStorage.getBalance();
        }
        return 0;
    }

    public boolean deposit(double amount) {
        if (moneyStorage != null) {
            return moneyStorage.deposit(amount);
        }
        return false;
    }
}