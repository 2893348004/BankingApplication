package com.Merchant.Merchant.Merchant;

import javax.persistence.*;


@Entity
@Table(name="Token_Merchant_Customers")
public class Token_Merchant_Customers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 128, nullable = false)
    private String firstName;

    @Column(length = 128, nullable = false)
    private String lastName;

    @Column(length = 128, nullable = false)
    private String address;

    @Column(name="city", length = 50 , nullable = false)
    private String city;

    @Column(name="province_state", length = 20 , nullable = false)
    private String provinceOrState;

    @Column(name="postal_code", length = 12 , nullable = false)
    private String postalCode;

    @Column(length = 25, nullable = false)
    private String phoneNumber;

    @Column(name="email", length = 80 , nullable = false)
    private String email;


}
