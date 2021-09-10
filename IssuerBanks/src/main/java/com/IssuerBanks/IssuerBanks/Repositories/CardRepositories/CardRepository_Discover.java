package com.IssuerBanks.IssuerBanks.Repositories.CardRepositories;


import com.IssuerBanks.IssuerBanks.Cards.AmericanExpressCards;
import com.IssuerBanks.IssuerBanks.Cards.DiscoverCards;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardRepository_Discover extends PagingAndSortingRepository<DiscoverCards,Integer> {

    @Query("SELECT c FROM DiscoverCards c WHERE c.customerAccount = :customerAccount")
    public DiscoverCards findByCustomerAccount(@Param("customerAccount") String customerAccount);

    @Query("SELECT c FROM DiscoverCards c WHERE c.cardNumber = :cardNumber")
    public DiscoverCards findByCardNumber(@Param("cardNumber") String cardNumber);


    @Query("SELECT c FROM DiscoverCards c WHERE c.cardAssociation = :cardAssociation")
    public List<DiscoverCards> findByCardAssociation(@Param("cardAssociation") int cardAssociation);

    @Query("SELECT c FROM DiscoverCards c WHERE c.exp = :exp")
    public List<DiscoverCards> findByExp(@Param("exp") String exp);


    @Query("SELECT c FROM DiscoverCards c WHERE c.flagged = true")
    public List<DiscoverCards> findByFlagged();

    @Query("SELECT c FROM DiscoverCards c WHERE c.locked = true")
    public List<DiscoverCards> findByLocked();
}
