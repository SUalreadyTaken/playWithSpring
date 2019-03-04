package com.su.aopdemo;

import com.su.aopdemo.config.DemoConfig;
import com.su.aopdemo.dao.AccountDAO;
import com.su.aopdemo.dao.MembershipDAO;
import com.su.aopdemo.model.Account;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
        MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);

        List<Account> accountList = accountDAO.findAccounts();
        System.out.println("After calling >> " + accountList);

        System.out.println("\n --------------- \n");
        List<Account> accountListException = null;

        try{
            accountListException = accountDAO.findAccountsException(true);
        } catch (Exception e) {
            System.out.println("MAIN >> Caught exception >> " + e);
        }


        System.out.println("accountListException >> " + accountListException + " (because of exception)");

        System.out.println("\n --------------- \n");

        List<Account> handlingException = accountDAO.handlingExceptionFindAccounts(true);
        System.out.println("handlingException >> " + handlingException);

        System.out.println("\n --------------- \n");

//        Account account = new Account();
//        account.setName("A name");
//
//        accountDAO.addAccount();
//        System.out.println("\n --------------- \n");
//        accountDAO.addAccountString();
//        System.out.println("\n --------------- \n");
//        membershipDAO.addAccount();
//        System.out.println("\n --------------- \n");
//        membershipDAO.addStar();
//        System.out.println("\n --------------- \n");
//        accountDAO.addAccount(account, 1);
//        System.out.println("\n --------------- \n");
//        accountDAO.setName("tmp");
//        System.out.println("\n --------------- \n");
//        accountDAO.getName();
//        System.out.println("\n --------------- \n");

        context.close();

    }
}
