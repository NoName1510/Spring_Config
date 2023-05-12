package dependencyInjection;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pojobean.AccountService;

public class MainTest {
    public static void main(String[] args) {

        usingWhat("");
    }

    private static void usingWhat(String what) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(BeanSetConfig.class);;
        if(what.equals("construc")){
            applicationContext   = new AnnotationConfigApplicationContext(BeanConstConfig.class);
        }
        AccountService accountService = applicationContext.getBean("accountService", AccountService.class);

        System.out.println("Before money transfer");
        System.out.println("Account 1 balance :" +accountService.getAccount(1).getBalance());
        System.out.println("Account 2 balance :" +accountService.getAccount(2).getBalance());

        accountService.tranferMoney(1,2,5.0);
        System.out.println("=================================");
        System.out.println("After transfer");
        System.out.println("Account 1 balance :" +accountService.getAccount(1).getBalance());
        System.out.println("Account 2 balance :" +accountService.getAccount(2).getBalance());

    }

}
