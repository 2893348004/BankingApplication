package com.IssuerBanks.IssuerBanks.Service.AccountServices;

import com.IssuerBanks.IssuerBanks.CustomerBankAccounts.CitiBankAccounts;
import com.IssuerBanks.IssuerBanks.CustomerBankAccounts.JPMorganChaseAccounts;
import com.IssuerBanks.IssuerBanks.Repositories.AccountRepositories.AccountRepository_CitiBank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public class CitiBankAccountService {


    private AccountRepository_CitiBank accountRepo;


    public CitiBankAccounts getAccount(String customerAccount){

        var x = accountRepo.findByCustomerAccount(customerAccount);

        return x;

    }

    public List<CitiBankAccounts> getAccountsByCity(String city){

        var x = accountRepo.findByCity(city);

        return x;

    }

    public List<CitiBankAccounts> getAccountsByState( String province_state){
        var x = accountRepo.findByState(province_state);

        return x;

    }

    public List<CitiBankAccounts> getAccountsByZIPCODE (String postal_code){

        var x = accountRepo.findByPostalCode(postal_code);

        return x;

    }


}
