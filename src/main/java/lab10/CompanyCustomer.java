package lab10;
public class CompanyCustomer extends Customer{
    public CompanyCustomer(String name, String email, Account account, double companyOverDraft) {
        super(name, email, account, companyOverDraft);
    }

    protected double calculateClientMoney(Account account, double sum) {
        double clientOverDraftDiscount = this.companyOverdraftDiscount;
        if (account.getType().isPremium()) {
            clientOverDraftDiscount /= 2;
        }

        if (account.getMoney() < 0) {
            return (account.getMoney() - sum) - sum * account.overdraftFee() * clientOverDraftDiscount;
        }

        return account.getMoney() - sum;
    }
}
