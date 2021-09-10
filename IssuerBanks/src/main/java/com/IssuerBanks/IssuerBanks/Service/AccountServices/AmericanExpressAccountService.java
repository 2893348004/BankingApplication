package com.IssuerBanks.IssuerBanks.Service.AccountServices;

import com.IssuerBanks.IssuerBanks.CustomerBankAccounts.AmericanExpressAccounts;
import com.IssuerBanks.IssuerBanks.CustomerBankAccounts.BarclaysAccounts;
import com.IssuerBanks.IssuerBanks.Repositories.AccountRepositories.AccountRepository_American_Express;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;


public class AmericanExpressAccountService {


    private AccountRepository_American_Express accountRepository_american_express;

    public AmericanExpressAccounts  getAccount(String customerAccount){

        var x = accountRepository_american_express.findByCustomerAccount(customerAccount);

        return x;

    }

    public List<AmericanExpressAccounts> getAccountsByCity(String city){

        var x = accountRepository_american_express.findByCity(city);

        return x;

    }

    public List<AmericanExpressAccounts> getAccountsByState( String province_state){
        var x = accountRepository_american_express.findByState(province_state);

        return x;

    }

    public List<AmericanExpressAccounts> getAccountsByZIPCODE (String postal_code){

        var x = accountRepository_american_express.findByPostalCode(postal_code);

        return x;

    }



}
