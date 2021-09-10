package com.IssuerBanks.IssuerBanks.Repositories.CardRepositories;

import com.IssuerBanks.IssuerBanks.Cards.AmericanExpressCards;
import com.IssuerBanks.IssuerBanks.Cards.JPMorganChaseCards;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardRepository_Chase extends PagingAndSortingRepository<JPMorganChaseCards,Integer> {

    @Query("SELECT c FROM JPMorganChaseCards c WHERE c.customerAccount = :customerAccount")
    public JPMorganChaseCards findByCustomerAccount(@Param("customerAccount") String customerAccount);

    @Nullable
    @Query("SELECT c FROM JPMorganChaseCards c WHERE  c.cardNumber = :cardNumber")
    public JPMorganChaseCards findByCardNumber(@Param("cardNumber") String cardNumber);


    @Query("SELECT c FROM JPMorganChaseCards c WHERE c.cardAssociation = :cardAssociation")
    public List<JPMorganChaseCards> findByCardAssociation(@Param("cardAssociation") int cardAssociation);

    @Query("SELECT c FROM JPMorganChaseCards c WHERE c.exp = :exp")
    public List<JPMorganChaseCards> findByExp(@Param("exp") String exp);


    @Query("SELECT c FROM JPMorganChaseCards c WHERE c.flagged = true")
    public List<JPMorganChaseCards> findByFlagged();

    @Query("SELECT c FROM JPMorganChaseCards c WHERE c.locked = true")
    public List<JPMorganChaseCards> findByLocked();
}
