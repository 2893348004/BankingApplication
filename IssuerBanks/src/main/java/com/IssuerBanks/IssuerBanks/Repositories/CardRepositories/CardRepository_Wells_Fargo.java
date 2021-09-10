package com.IssuerBanks.IssuerBanks.Repositories.CardRepositories;


import com.IssuerBanks.IssuerBanks.Cards.AmericanExpressCards;
import com.IssuerBanks.IssuerBanks.Cards.WellsFargoCards;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardRepository_Wells_Fargo extends PagingAndSortingRepository<WellsFargoCards,Integer> {

    @Query("SELECT c FROM WellsFargoCards c WHERE c.customerAccount = :customerAccount")
    public WellsFargoCards findByCustomerAccount(@Param("customerAccount") String customerAccount);

    @Query("SELECT c FROM WellsFargoCards c WHERE c.cardNumber = :cardNumber")
    public WellsFargoCards findByCardNumber(@Param("cardNumber") String cardNumber);


    @Query("SELECT c FROM WellsFargoCards c WHERE c.cardAssociation = :cardAssociation")
    public List<WellsFargoCards> findByCardAssociation(@Param("cardAssociation") int cardAssociation);

    @Query("SELECT c FROM WellsFargoCards c WHERE c.exp = :exp")
    public List<WellsFargoCards> findByExp(@Param("exp") String exp);


    @Query("SELECT c FROM WellsFargoCards c WHERE c.flagged = true")
    public List<WellsFargoCards> findByFlagged();

    @Query("SELECT c FROM WellsFargoCards c WHERE c.locked = true")
    public List<WellsFargoCards> findByLocked();
}

