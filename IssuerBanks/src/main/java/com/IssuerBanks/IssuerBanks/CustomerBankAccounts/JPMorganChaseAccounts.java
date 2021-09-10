package com.IssuerBanks.IssuerBanks.CustomerBankAccounts;
import com.IssuerBanks.IssuerBanks.Cards.DiscoverCards;
import com.IssuerBanks.IssuerBanks.Cards.JPMorganChaseCards;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="JPMorganChaseAccounts")
public class JPMorganChaseAccounts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column(length = 128, nullable = false)
    private String firstName;

    @Column(length = 128, nullable = false)
    private String lastName;

    @Column(name= "customerAccount" ,length = 18, nullable = false, unique = true)
    private String customerAccount;

    @Column(length = 10, nullable = false)
    private String accountType;

    @Column(name="address", length = 128 , nullable = false)
    private String address;

    @Column(name="city", length = 50 , nullable = false)
    private String city;

    @Column(name="province_state", length = 50 , nullable = false)
    private String provinceOrState;

    @Column(name="postal_code", length = 12 , nullable = false)
    private String postalCode;


    public JPMorganChaseAccounts(String firstName, String lastName,
                            String customerAccount,
                            String accountType,
                            String address, String city,
                            String provinceOrState,
                            String postalCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.customerAccount = customerAccount;
        this.accountType = accountType;
        this.address = address;
        this.city = city;
        this.provinceOrState = provinceOrState;
        this.postalCode = postalCode;
    }


    public Integer getId() {
        return id;
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

    public String getCustomerAccount() {
        return customerAccount;
    }

    public void setCustomerAccount(String customerAccount) {
        this.customerAccount = customerAccount;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvinceOrState() {
        return provinceOrState;
    }

    public void setProvinceOrState(String provinceOrState) {
        this.provinceOrState = provinceOrState;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }


}
