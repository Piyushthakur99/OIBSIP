package com.oibsip.atm;

public class UserAuthentication {

    public boolean validateCredentials(String userId, String pin, Account account) {
        return account.getUserId().equals(userId) && account.getPin().equals(pin);
    }
}
