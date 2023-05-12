package annotationbasedconfiguration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojobean.Account;
import pojobean.AccountRepository;
import pojobean.AccountService;
@Service("accountService")
public class AccountService2Imp implements AccountService {

    @Autowired
    private AccountRepository accountRepository;


    @Override
    public void tranferMoney(long fromAccountId, long toAccountId, double amount) {
        Account sourceAccount = accountRepository.find(fromAccountId);
        Account tagetAccount = accountRepository.find(toAccountId);
        sourceAccount.setBalance(sourceAccount.getBalance()-amount);
        tagetAccount.setBalance(tagetAccount.getBalance()+amount);
        accountRepository.update(sourceAccount);
        accountRepository.update(tagetAccount);
    }

    @Override
    public void depsoitMoney(long accountId, double amount) throws Exception {
        Account account = accountRepository.find(accountId);
        account.setBalance(account.getBalance()+amount);
        accountRepository.update(account);
    }

    @Override
    public Account getAccount(long accountId) {
        return accountRepository.find(accountId);
    }
}
