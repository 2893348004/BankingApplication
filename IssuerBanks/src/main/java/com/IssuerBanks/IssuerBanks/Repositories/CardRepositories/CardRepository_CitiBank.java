package com.IssuerBanks.IssuerBanks.Repositories.CardRepositories;

import com.IssuerBanks.IssuerBanks.Cards.AmericanExpressCards;
import com.IssuerBanks.IssuerBanks.Cards.CitiBankCards;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardRepository_CitiBank extends PagingAndSortingRepository<CitiBankCards,Integer> {

    @Query("SELECT c FROM CitiBankCards c WHERE c.customerAccount = :customerAccount")
    public CitiBankCards findByCustomerAccount(@Param("customerAccount") String customerAccount);

    @Query("SELECT c FROM CitiBankCards c WHERE c.cardNumber = :cardNumber")
    public CitiBankCards findByCardNumber(@Param("cardNumber") String cardNumber);


    @Query("SELECT c FROM CitiBankCards c WHERE c.cardAssociation = :cardAssociation")
    public List<CitiBankCards> findByCardAssociation(@Param("cardAssociation") int cardAssociation);

    @Query("SELECT c FROM CitiBankCards c WHERE c.exp = :exp")
    public List<CitiBankCards> findByExp(@Param("exp") String exp);


    @Query("SELECT c FROM CitiBankCards c WHERE c.flagged = true")
    public List<CitiBankCards> findByFlagged();

    @Query("SELECT c FROM CitiBankCards c WHERE c.locked = true")
    public List<CitiBankCards> findByLocked();
}
