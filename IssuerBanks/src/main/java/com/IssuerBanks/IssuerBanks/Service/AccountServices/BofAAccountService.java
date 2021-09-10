package com.IssuerBanks.IssuerBanks.Service.AccountServices;

import com.IssuerBanks.IssuerBanks.CustomerBankAccounts.BankofAmericaAccounts;
import com.IssuerBanks.IssuerBanks.CustomerBankAccounts.BarclaysAccounts;
import com.IssuerBanks.IssuerBanks.Repositories.AccountRepositories.AccountRepository_BofA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public class BofAAccountService {

    private AccountRepository_BofA accountRepo;



    public BankofAmericaAccounts getAccount(String customerAccount){

        var x = accountRepo.findByCustomerAccount(customerAccount);

        return x;

    }

    public List<BankofAmericaAccounts> getAccountsByCity(String city){

        var x = accountRepo.findByCity(city);

        return x;

    }

    public List<BankofAmericaAccounts> getAccountsByState( String province_state){
        var x = accountRepo.findByState(province_state);

        return x;

    }

    public List<BankofAmericaAccounts> getAccountsByZIPCODE (String postal_code){

        var x = accountRepo.findByPostalCode(postal_code);

        return x;

    }
}
