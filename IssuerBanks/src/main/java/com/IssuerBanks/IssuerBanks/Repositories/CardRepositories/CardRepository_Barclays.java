package com.IssuerBanks.IssuerBanks.Repositories.CardRepositories;

import com.IssuerBanks.IssuerBanks.Cards.AmericanExpressCards;
import com.IssuerBanks.IssuerBanks.Cards.BarclaysCards;
import com.IssuerBanks.IssuerBanks.CustomerBankAccounts.AmericanExpressAccounts;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardRepository_Barclays extends PagingAndSortingRepository<BarclaysCards,Integer> {

    @Query("SELECT c FROM BarclaysCards c WHERE c.customerAccount = :customerAccount")
    public BarclaysCards findByCustomerAccount(@Param("customerAccount") String customerAccount);

    @Query("SELECT c FROM BarclaysCards c WHERE c.cardNumber = :cardNumber")
    public BarclaysCards findByCardNumber(@Param("cardNumber") String cardNumber);


    @Query("SELECT c FROM BarclaysCards c WHERE c.cardAssociation = :cardAssociation")
    public List<BarclaysCards> findByCardAssociation(@Param("cardAssociation") int cardAssociation);

    @Query("SELECT c FROM BarclaysCards c WHERE c.exp = :exp")
    public List<BarclaysCards> findByExp(@Param("exp") String exp);


    @Query("SELECT c FROM BarclaysCards c WHERE c.flagged = true")
    public List<BarclaysCards> findByFlagged();

    @Query("SELECT c FROM BarclaysCards c WHERE c.locked = true")
    public List<BarclaysCards> findByLocked();


}
