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
public interface Account_Repository_USAA extends PagingAndSortingRepository<USAAAccounts,Integer> {

    @Query("SELECT c FROM USAAAccounts c WHERE c.customerAccount = :customerAccount")
    public USAAAccounts findByCustomerAccount(@Param("customerAccount") String customerAccount);


    @Query("SELECT c FROM BarclaysAccounts c WHERE c.postalCode = ?1")
    public List<USAAAccounts> findByPostalCode(String postal_code);

    @Query("SELECT c FROM BarclaysAccounts c WHERE c.provinceOrState = ?1")
    public List<USAAAccounts> findByState(String province_state);

    @Query("SELECT c FROM BarclaysAccounts c WHERE c.city = ?1")
    public List<USAAAccounts> findByCity(String city);


}
