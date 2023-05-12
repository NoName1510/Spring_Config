package javabaseconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pojobean.AccountRepository;
import pojobean.AccountRepositoryImp;
import pojobean.AccountService;
import pojobean.AccountServiceImp;

@Configuration
public class BeanConfig {
    @Bean
    public AccountService accountService(){
        AccountServiceImp bean = new AccountServiceImp();
        bean.setAccountRepository(accountDao());
        return bean;
    }

    @Bean
    public AccountRepository accountDao() {
        AccountRepositoryImp bean = new AccountRepositoryImp();
        return bean;
    }

}
