package com.IssuerBanks.IssuerBanks.Factories;

public interface CardFactory {

    boolean authenticateTransaction(String id,String cardNumber,  String firstName,String lastName,String expiry,int pin,int bin,int  ccv);
    boolean authorizeTransaction(String id,String cardNumber, String firstName,String lastName, String  expiry,int pin,int bin,int ccv,double amount );

}
