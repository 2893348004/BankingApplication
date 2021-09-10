package com.Merchant.Merchant.Transactions;


import org.hibernate.cache.spi.support.AbstractReadWriteAccess;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {



    @Query("SELECT c FROM Transaction c WHERE c.cardNumber = :cardNumber ORDER BY c.id DESC ")
    public  Transaction findCurrentTransaction2(@Param("cardNumber") String cardNumber );


}
