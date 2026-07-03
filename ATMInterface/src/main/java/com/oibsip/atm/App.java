package com.oibsip.atm;

public class App {

    public static void main(String[] args) {
        Account account = new Account("12345678", "4321", 50000.0);
        UserAuthentication authentication = new UserAuthentication();
        ATM atm = new ATM(account, authentication);
        atm.start();
    }
}
