package com.IssuerBanks.IssuerBanks.Service.AccountServices;

import com.IssuerBanks.IssuerBanks.CustomerBankAccounts.DiscoverAccounts;
import com.IssuerBanks.IssuerBanks.CustomerBankAccounts.USAAAccounts;
import com.IssuerBanks.IssuerBanks.Repositories.AccountRepositories.Account_Repository_USAA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public class USAAAccountService {


    private Account_Repository_USAA accountRepo;



    public USAAAccounts getAccount(String customerAccount){

        var x = accountRepo.findByCustomerAccount(customerAccount);

        return x;

    }

    public List<USAAAccounts> getAccountsByCity(String city){

        var x = accountRepo.findByCity(city);

        return x;

    }

    public List<USAAAccounts> getAccountsByState( String province_state){
        var x = accountRepo.findByState(province_state);

        return x;

    }

    public List<USAAAccounts> getAccountsByZIPCODE (String postal_code){

        var x = accountRepo.findByPostalCode(postal_code);

        return x;

    }



}
