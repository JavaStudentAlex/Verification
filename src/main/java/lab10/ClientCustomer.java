package lab10;
public class ClientCustomer extends Customer{
    public ClientCustomer(String name, String surname, String email, Account account) {
        super(name, surname, email, account);
    }


    protected double calculateClientMoney(Account account, double sum) {
        AccountState accountState = account.getAccountState();
        if (accountState.getMoney() < 0) {
            return (accountState.getMoney() - sum) - sum * account.overdraftFee();
        }

        return account.getMoney() - sum;
    }
}
