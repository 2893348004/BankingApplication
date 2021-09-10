package com.IssuerBanks.IssuerBanks.Repositories.AccountRepositories;


import com.IssuerBanks.IssuerBanks.CustomerBankAccounts.BarclaysAccounts;
import com.IssuerBanks.IssuerBanks.CustomerBankAccounts.CapitalOneAccounts;
import com.IssuerBanks.IssuerBanks.CustomerBankAccounts.JPMorganChaseAccounts;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository_Chase extends PagingAndSortingRepository<JPMorganChaseAccounts,Integer> {

    @Query("SELECT c FROM JPMorganChaseAccounts c WHERE c.customerAccount = :customerAccount")
    public JPMorganChaseAccounts findByCustomerAccount(@Param("customerAccount") String customerAccount);

    @Query("SELECT c FROM BarclaysAccounts c WHERE c.postalCode = ?1")
    public List<JPMorganChaseAccounts> findByPostalCode(String postal_code);

    @Query("SELECT c FROM BarclaysAccounts c WHERE c.provinceOrState = ?1")
    public List<JPMorganChaseAccounts> findByState(String province_state);

    @Query("SELECT c FROM BarclaysAccounts c WHERE c.city = ?1")
    public List<JPMorganChaseAccounts> findByCity(String city);

}
