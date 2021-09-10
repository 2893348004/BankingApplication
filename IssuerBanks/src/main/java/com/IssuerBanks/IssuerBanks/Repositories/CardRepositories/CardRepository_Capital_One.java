package com.IssuerBanks.IssuerBanks.Repositories.CardRepositories;


import com.IssuerBanks.IssuerBanks.Cards.AmericanExpressCards;
import com.IssuerBanks.IssuerBanks.Cards.CapitalOneCards;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardRepository_Capital_One extends PagingAndSortingRepository<CapitalOneCards,Integer> {
    @Query("SELECT c FROM CapitalOneCards c WHERE c.customerAccount = :customerAccount")
    public CapitalOneCards findByCustomerAccount(@Param("customerAccount") String customerAccount);

    @Query("SELECT c FROM CapitalOneCards c WHERE c.cardNumber = :cardNumber")
    public CapitalOneCards findByCardNumber(@Param("cardNumber") String cardNumber);


    @Query("SELECT c FROM CapitalOneCards c WHERE c.cardAssociation = :cardAssociation")
    public List<CapitalOneCards> findByCardAssociation(@Param("cardAssociation") int cardAssociation);

    @Query("SELECT c FROM CapitalOneCards c WHERE c.exp = :exp")
    public List<CapitalOneCards> findByExp(@Param("exp") String exp);


    @Query("SELECT c FROM CapitalOneCards c WHERE c.flagged = true")
    public List<CapitalOneCards> findByFlagged();

    @Query("SELECT c FROM CapitalOneCards c WHERE c.locked = true")
    public List<CapitalOneCards> findByLocked();
}
