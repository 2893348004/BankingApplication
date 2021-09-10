package com.IssuerBanks.IssuerBanks.Repositories.AccountRepositories;

import com.IssuerBanks.IssuerBanks.CustomerBankAccounts.AmericanExpressAccounts;
import com.IssuerBanks.IssuerBanks.CustomerBankAccounts.BankofAmericaAccounts;
import com.IssuerBanks.IssuerBanks.CustomerBankAccounts.BarclaysAccounts;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository_BofA extends PagingAndSortingRepository<BankofAmericaAccounts,Integer> {

    @Query("SELECT c FROM BankofAmericaAccounts c WHERE c.customerAccount = :customerAccount")
    public BankofAmericaAccounts findByCustomerAccount(@Param("customerAccount") String customerAccount);

    @Query("SELECT c FROM BarclaysAccounts c WHERE c.postalCode = ?1")
    public List<BankofAmericaAccounts> findByPostalCode(String postal_code);

    @Query("SELECT c FROM BarclaysAccounts c WHERE c.provinceOrState = ?1")
    public List<BankofAmericaAccounts> findByState(String province_state);

    @Query("SELECT c FROM BarclaysAccounts c WHERE c.city = ?1")
    public List<BankofAmericaAccounts> findByCity(String city);

}
