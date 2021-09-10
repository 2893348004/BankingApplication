package com.IssuerBanks.IssuerBanks.Factories;

import com.IssuerBanks.IssuerBanks.Service.CardServices.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BankFactoryProvider implements BankAbstractFactory{

@Autowired
public ChaseCardService chaseCardService;

    @Override
    public CardFactory createCardService(String bankname) {


        switch (bankname) {
            case "JPMorganChase" :

                return chaseCardService;

            case "American Express" :

                return new AmericanExpressCardService();
            case "Bank of America" :

                return new BofACardService();
            case "Barclays" :

                return new BarclaysCardService();
            case "Citi Bank"  :

                return new CitiBankCardService();
            case "USAA" :

                return new USAACardService();
            case "Capital One" :

                return new CapitalOneCardService();
            case "Wells Fargo"  :

                return new WellsFargoCardService();
            case "Discover"  :

                return new DiscoverCardService();

            default:
                return null;
        }


    }
}
