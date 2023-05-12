package dependencyInjection;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pojobean.AccountRepository;
import pojobean.AccountRepositoryImp;
import pojobean.AccountService;

@Configuration
public class BeanSetConfig {
    @Bean
    public AccountService accountService(){
        AccountServiceSetImp bean = new AccountServiceSetImp();
        bean.setAccountRepository(accountDao());
        return bean;
    }

    @Bean
    public AccountRepository accountDao() {
        AccountRepositoryImp bean = new AccountRepositoryImp();
        return bean;
    }

}
