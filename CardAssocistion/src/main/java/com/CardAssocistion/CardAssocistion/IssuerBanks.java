package com.CardAssocistion.CardAssocistion;

import javax.persistence.*;

@Entity
@Table(name="IssuerBanks")
public class IssuerBanks {


        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;

        @Column(name="bank_Id" , nullable = false)
        private int bankId;

        @Column(name="issuer_Name", length = 50 , nullable = false)
        private String issuerName;

        @Column(name="bank_address", length = 128 , nullable = false)
        private String bankAddress;

        @Column(name="city", length = 50 , nullable = false)
        private String city;

        @Column(name="province_state", length = 20 , nullable = false)
        private String provinceOrState;

        @Column(name="postal_code", length = 12 , nullable = false)
        private String postalCode;

        @Column(name="country", length = 12, nullable = false )
        private String country;



}
