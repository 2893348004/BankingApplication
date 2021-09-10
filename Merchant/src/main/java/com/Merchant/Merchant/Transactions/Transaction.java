package com.Merchant.Merchant.Transactions;


import javax.persistence.*;


@Entity
@Table(name="Transaction")
public class Transaction {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 45, nullable = false)
    private String firstName;

    @Column(name="lastName", length = 45 , nullable = false)
    private String lastName;

    @Column(name="cardNumber", length = 16 , nullable = false)
    private String cardNumber;

    @Column(name="exp", length = 6 , nullable = false)
    private String exp;

    @Column(name="pin", length = 4 , nullable = false)
    private String pin;

    @Column(name="bin", length = 6 , nullable = false)
    private String bin;

    @Column(name="ccv", length = 3 , nullable = false)
    private String ccv;

    @Column(name="amount", length = 255 , nullable = false)
    private float amount;



    public  Transaction (){}

    private static Integer incrementor;

    public Integer getIncrementor() {
        if(incrementor == null) return  1;
        if(incrementor != null) {
            incrementor++;}
        return incrementor;
    }


    public Integer getId() {
        return id;
    }

    public String getBin() {
        return bin;
    }

    public void setBin(String bin) {
        this.bin = bin;
    }

    public String getCcv() {
        return ccv;
    }

    public void setCcv(String ccv) {
        this.ccv = ccv;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getExp() {
        return exp;
    }

    public void setExp(String exp) {
        this.exp = exp;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }



}


