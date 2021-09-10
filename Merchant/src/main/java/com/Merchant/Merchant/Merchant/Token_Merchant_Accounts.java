package com.Merchant.Merchant.Merchant;


import javax.persistence.*;


@Entity
@Table(name="Token_Merchant_Accounts")
public class Token_Merchant_Accounts {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 128, nullable = false)
    private String address;

    @Column(name="city", length = 50 , nullable = false)
    private String city;

    @Column(name="province_state", length = 20 , nullable = false)
    private String provinceOrState;

    @Column(name="postal_code", length = 12 , nullable = false)
    private String postalCode;

    @Column(name="fullAddress", nullable = false)
    private String fullAddress;

    @Column(name="balance")
    private int balance;

}
