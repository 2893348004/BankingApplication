package com.IssuerBanks.IssuerBanks.Repositories.CardRepositories;

import com.IssuerBanks.IssuerBanks.Cards.AmericanExpressCards;
import com.IssuerBanks.IssuerBanks.Cards.USAACards;
import com.IssuerBanks.IssuerBanks.CustomerBankAccounts.AmericanExpressAccounts;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardRepository_USAA extends PagingAndSortingRepository<USAACards,Integer> {

    @Query("SELECT c FROM USAACards c WHERE c.customerAccount = :customerAccount")
    public USAACards findByCustomerAccount(@Param("customerAccount") String customerAccount);

    @Query("SELECT c FROM USAACards c WHERE c.cardNumber = :cardNumber")
    public USAACards findByCardNumber(@Param("cardNumber") String cardNumber);


    @Query("SELECT c FROM USAACards c WHERE c.cardAssociation = :cardAssociation")
    public List<USAACards> findByCardAssociation(@Param("cardAssociation") int cardAssociation);

    @Query("SELECT c FROM USAACards c WHERE c.exp = :exp")
    public List<USAACards> findByExp(@Param("exp") String exp);


    @Query("SELECT c FROM USAACards c WHERE c.flagged = true")
    public List<USAACards> findByFlagged();

    @Query("SELECT c FROM USAACards c WHERE c.locked = true")
    public List<USAACards> findByLocked();
}
