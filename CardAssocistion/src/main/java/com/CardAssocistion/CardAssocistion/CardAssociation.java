package com.CardAssocistion.CardAssocistion;


import javax.persistence.*;


@Entity
@Table(name="CardAssociations")
public class CardAssociation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="card_Association", nullable = false)
    private int cardAssociation;

    @Column(name="name", length = 50 , nullable = false)
    private String name;


}
