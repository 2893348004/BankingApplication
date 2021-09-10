package com.IssuerBanks.IssuerBanks.Cards;


import com.IssuerBanks.IssuerBanks.CustomerBankAccounts.AmericanExpressAccounts;
import com.IssuerBanks.IssuerBanks.CustomerBankAccounts.BarclaysAccounts;

import javax.persistence.*;

@Entity
@Table(name="BarclaysCards")
public class BarclaysCards {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column(name= "customerAccount" ,length = 18, nullable = false, unique = true)
    private String customerAccount;


    @Column(length = 16, nullable = false)
    private String cardNumber;

    @Column(length = 10, nullable = false)
    private String cardType;

    @Column(name="Card_Association" , nullable = false)
    private int cardAssociation;

    @Column(name="bin" , nullable = false)
    private int bin;

    @Column(name="exp" , nullable = false)
    private String exp;

    @Column(name="pin" , length = 4 , nullable = false)
    private int pin;

    @Column(name="ccv" , length = 3 , nullable = false)
    private int ccv;

    @Column(name="flagged" , nullable = false)
    private boolean flagged;

    @Column(name="locked" , nullable = false)
    private boolean locked;

    @Column(name="balance" , nullable = false)
    private double balance;


    public BarclaysCards( String customerAccount,String cardNumber,String exp, int pin, int ccv, boolean locked, boolean flagged,float balance,
                          String cardType, int cardAssociation, int bin
    ) {

        this.balance = balance;
        this.customerAccount = customerAccount;
        this.cardNumber = cardNumber;
        this.cardType = cardType;
        this.cardAssociation = cardAssociation;
        this.bin = bin;
        this.exp = exp;
        this.pin = pin;
        this.ccv = ccv;
        this.flagged = flagged;
        this.locked = locked;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCustomerAccount() {
        return customerAccount;
    }

    public void setCustomerAccount(String customerAccount) {
        this.customerAccount = customerAccount;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public int getCardAssociation() {
        return cardAssociation;
    }

    public void setCardAssociation(int cardAssociation) {
        this.cardAssociation = cardAssociation;
    }

    public int getBin() {
        return bin;
    }

    public void setBin(int bin) {
        this.bin = bin;
    }

    public String getExp() {
        return exp;
    }

    public void setExp(String exp) {
        this.exp = exp;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public int getCcv() {
        return ccv;
    }

    public void setCcv(int ccv) {
        this.ccv = ccv;
    }

    public boolean isFlagged() {
        return flagged;
    }

    public void setFlagged(boolean flagged) {
        this.flagged = flagged;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

}
