package com.su.aopdemo.dao;

import com.su.aopdemo.model.Account;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountDAO {

    private int id;
    private String name;


    public List<Account> findAccounts() {
        List<Account> accountList = new ArrayList<>();

        Account account = new Account(1, "First");
        Account account2 = new Account(2, "Second");
        Account account3 = new Account(3, "Third");

        accountList.add(account);
        accountList.add(account2);
        accountList.add(account3);

        return  accountList;
    }

    public List<Account> findAccountsException(boolean wantToThrowException) {

        if (wantToThrowException) {
            throw new RuntimeException("Made up exception");
        }

        return  findAccounts();
    }

    public List<Account> handlingExceptionFindAccounts(boolean wantToThrowException) {

        if (wantToThrowException) {
            throw new RuntimeException("Made up exception");
        }

        return  findAccounts();
    }


    public void addAccount() {
        System.out.println(getClass() + ": public void addAccount() \n");
    }

    public String addAccountString() {
        System.out.println(getClass() + ": public String addAccountString() \n");
        return "null";
    }

    public void addAccount(Account account, int id) {
        System.out.println(getClass() + ": public void addAccount(Account account, int id) \n");
    }

    public int getId() {
        System.out.println(getClass() + ": getId()\n");
        return id;
    }

    public void setId(int id) {
        System.out.println(getClass() + ": setId()\n");
        this.id = id;
    }

    public String getName() {
        System.out.println(getClass() + ": getName()\n");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass() + ": setName()\n");
        this.name = name;
    }

}
