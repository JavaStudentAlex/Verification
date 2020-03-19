package lab10;
public abstract class Customer {

    protected String name;
    protected String surname;
    protected String email;
    protected Account account;
    protected double companyOverdraftDiscount = 1;

    public Customer(String name, String surname, String email, Account account) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.account = account;
    }

    // use only to create companies
    public Customer(String name, String email, Account account, double companyOverdraftDiscount) {
        this.name = name;
        this.email = email;
        this.account = account;
        this.companyOverdraftDiscount = companyOverdraftDiscount;
    }

    protected abstract double calculateClientMoney(Account account, double sum);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void withdraw(double sum, String currency) {
        if (!account.getAccountState().getCurrency().equals(currency)) {
            throw new RuntimeException("Can't extract withdraw " + currency);
        }

        account.getAccountState().setMoney(calculateClientMoney(account, sum));
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String printCustomerDaysOverdrawn() {
        String fullName = getFullName();

        return account.printCustomerDaysOverdrawn(fullName);
    }

    public String printCustomerMoney() {
        String fullName = getFullName();

        return account.printCustomerMoney(fullName);
    }

    public String printCustomerAccount() {
        return  account.printCustomerAccount();
    }

    public String getFullName () {
        return name + " " + surname + " ";
    }
}
