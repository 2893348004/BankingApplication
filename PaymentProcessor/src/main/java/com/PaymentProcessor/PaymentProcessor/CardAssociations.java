package com.PaymentProcessor.PaymentProcessor;


import javax.persistence.*;


@Entity
@Table(name="CardAssociations")
public class CardAssociations {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="card_Association", nullable = false)
    private int cardAssociation;

    @Column(name="name", length = 50 , nullable = false)
    private String name;

}
