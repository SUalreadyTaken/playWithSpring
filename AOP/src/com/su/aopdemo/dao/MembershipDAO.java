package com.su.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

    public void addAccount() {
        System.out.println(getClass() + ": public void addAccount() \n");
    }

    public void addStar() {
        System.out.println(getClass() + ": public void addStar() \n");
    }



}
