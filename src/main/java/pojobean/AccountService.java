package pojobean;

public interface AccountService {
    void tranferMoney(long fromAccountId, long toAccountId, double amount);
    void depsoitMoney(long accountId, double amount) throws Exception;
    Account getAccount(long accountId);
}
