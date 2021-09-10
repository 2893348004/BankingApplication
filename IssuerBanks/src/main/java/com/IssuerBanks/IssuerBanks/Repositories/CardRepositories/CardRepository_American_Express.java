package com.IssuerBanks.IssuerBanks.Repositories.CardRepositories;


import com.IssuerBanks.IssuerBanks.Cards.AmericanExpressCards;
import com.IssuerBanks.IssuerBanks.CustomerBankAccounts.WellsFargoAccounts;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardRepository_American_Express extends PagingAndSortingRepository<AmericanExpressCards,Integer> {

    @Query("SELECT c FROM AmericanExpressCards c WHERE c.customerAccount = :customerAccount")
    public AmericanExpressCards findByCustomerAccount(@Param("customerAccount") String customerAccount);

    @Query("SELECT c FROM AmericanExpressCards c WHERE c.cardNumber = :cardNumber")
    public AmericanExpressCards findByCardNumber(@Param("cardNumber") String cardNumber);


    @Query("SELECT c FROM AmericanExpressCards c WHERE c.cardAssociation = :cardAssociation")
    public List<AmericanExpressCards> findByCardAssociation(@Param("cardAssociation") int cardAssociation);

    @Query("SELECT c FROM AmericanExpressCards c WHERE c.exp = :exp")
    public List<AmericanExpressCards> findByExp(@Param("exp") String exp);


    @Query("SELECT c FROM AmericanExpressCards c WHERE c.flagged = true")
    public List<AmericanExpressCards> findByFlagged();

    @Query("SELECT c FROM AmericanExpressCards c WHERE c.locked = true")
    public List<AmericanExpressCards> findByLocked();







}
