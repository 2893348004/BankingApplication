package com.IssuerBanks.IssuerBanks.Repositories.AccountRepositories;


import com.IssuerBanks.IssuerBanks.CustomerBankAccounts.BarclaysAccounts;
import com.IssuerBanks.IssuerBanks.CustomerBankAccounts.DiscoverAccounts;
import com.IssuerBanks.IssuerBanks.CustomerBankAccounts.WellsFargoAccounts;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository_Wells_Fargo extends PagingAndSortingRepository<WellsFargoAccounts,Integer> {

    @Query("SELECT c FROM WellsFargoAccounts c WHERE c.customerAccount = :customerAccount")
    public WellsFargoAccounts findByCustomerAccount(@Param("customerAccount") String customerAccount);

    @Query("SELECT c FROM BarclaysAccounts c WHERE c.postalCode = ?1")
    public List<WellsFargoAccounts> findByPostalCode(String postal_code);

    @Query("SELECT c FROM BarclaysAccounts c WHERE c.provinceOrState = ?1")
    public List<WellsFargoAccounts> findByState(String province_state);

    @Query("SELECT c FROM BarclaysAccounts c WHERE c.city = ?1")
    public List<WellsFargoAccounts> findByCity(String city);



}
