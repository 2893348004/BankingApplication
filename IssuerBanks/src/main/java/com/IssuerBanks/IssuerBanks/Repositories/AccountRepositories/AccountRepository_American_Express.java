package com.IssuerBanks.IssuerBanks.Repositories.AccountRepositories;

import com.IssuerBanks.IssuerBanks.CustomerBankAccounts.AmericanExpressAccounts;
import com.IssuerBanks.IssuerBanks.CustomerBankAccounts.BarclaysAccounts;
import com.IssuerBanks.IssuerBanks.CustomerBankAccounts.USAAAccounts;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository_American_Express extends PagingAndSortingRepository<AmericanExpressAccounts,Integer> {

    @Query("SELECT c FROM AmericanExpressAccounts c WHERE c.customerAccount = :customerAccount")
    public AmericanExpressAccounts findByCustomerAccount(@Param("customerAccount") String customerAccount);

    @Query("SELECT c FROM BarclaysAccounts c WHERE c.postalCode = ?1")
    public List<AmericanExpressAccounts> findByPostalCode(String postal_code);

    @Query("SELECT c FROM BarclaysAccounts c WHERE c.provinceOrState = ?1")
    public List<AmericanExpressAccounts> findByState(String province_state);

    @Query("SELECT c FROM BarclaysAccounts c WHERE c.city = ?1")
    public List<AmericanExpressAccounts> findByCity(String city);

}
