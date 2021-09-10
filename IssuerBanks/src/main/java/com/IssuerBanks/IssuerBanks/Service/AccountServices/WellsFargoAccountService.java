package com.IssuerBanks.IssuerBanks.Service.AccountServices;


import com.IssuerBanks.IssuerBanks.CustomerBankAccounts.USAAAccounts;
import com.IssuerBanks.IssuerBanks.CustomerBankAccounts.WellsFargoAccounts;
import com.IssuerBanks.IssuerBanks.Repositories.AccountRepositories.AccountRepository_Wells_Fargo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public class WellsFargoAccountService {


    private AccountRepository_Wells_Fargo accountRepo;


    public WellsFargoAccounts getAccount(String customerAccount){

        var x = accountRepo.findByCustomerAccount(customerAccount);

        return x;

    }

    public List<WellsFargoAccounts> getAccountsByCity(String city){

        var x = accountRepo.findByCity(city);

        return x;

    }

    public List<WellsFargoAccounts> getAccountsByState( String province_state){
        var x = accountRepo.findByState(province_state);

        return x;

    }

    public List<WellsFargoAccounts> getAccountsByZIPCODE (String postal_code){

        var x = accountRepo.findByPostalCode(postal_code);

        return x;

    }
}
