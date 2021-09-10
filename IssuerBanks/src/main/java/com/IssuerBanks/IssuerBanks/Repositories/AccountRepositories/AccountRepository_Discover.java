package com.IssuerBanks.IssuerBanks.Repositories.AccountRepositories;


import com.IssuerBanks.IssuerBanks.CustomerBankAccounts.BarclaysAccounts;
import com.IssuerBanks.IssuerBanks.CustomerBankAccounts.CitiBankAccounts;
import com.IssuerBanks.IssuerBanks.CustomerBankAccounts.DiscoverAccounts;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository_Discover extends PagingAndSortingRepository<DiscoverAccounts,Integer> {

    @Query("SELECT c FROM DiscoverAccounts c WHERE c.customerAccount = :customerAccount")
    public DiscoverAccounts findByCustomerAccount(@Param("customerAccount") String customerAccount);

    @Query("SELECT c FROM BarclaysAccounts c WHERE c.postalCode = ?1")
    public List<DiscoverAccounts> findByPostalCode(String postal_code);

    @Query("SELECT c FROM BarclaysAccounts c WHERE c.provinceOrState = ?1")
    public List<DiscoverAccounts> findByState(String province_state);

    @Query("SELECT c FROM BarclaysAccounts c WHERE c.city = ?1")
    public List<DiscoverAccounts> findByCity(String city);




}
