package com.IssuerBanks.IssuerBanks.Service.AccountServices;

import com.IssuerBanks.IssuerBanks.CustomerBankAccounts.CapitalOneAccounts;
import com.IssuerBanks.IssuerBanks.CustomerBankAccounts.JPMorganChaseAccounts;
import com.IssuerBanks.IssuerBanks.Repositories.AccountRepositories.AccountRepository_Chase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public class ChaseAccountService {



    private AccountRepository_Chase accountRepo;


/*

    public JPMorganChaseAccounts getAccount(String customerAccount){

        var x = accountRepo.findByCustomerAccount(customerAccount);

        return x;

    }

    public List<JPMorganChaseAccounts> getAccountsByCity(String city){

        var x = accountRepo.findByCity(city);

        return x;

    }

    public List<JPMorganChaseAccounts> getAccountsByState( String province_state){
        var x = accountRepo.findByState(province_state);

        return x;

    }

    public List<JPMorganChaseAccounts> getAccountsByZIPCODE (String postal_code){

        var x = accountRepo.findByPostalCode(postal_code);

        return x;

    }*/
}
