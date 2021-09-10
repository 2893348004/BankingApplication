package com.IssuerBanks.IssuerBanks.IssuerBankRoutes;


import com.IssuerBanks.IssuerBanks.Factories.BankAbstractFactory;
import com.IssuerBanks.IssuerBanks.Factories.BankFactoryProvider;
import com.IssuerBanks.IssuerBanks.Factories.CardFactory;
import org.apache.camel.Exchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class AuthenticationForTransaction {

    @Autowired
    private BankFactoryProvider abstractFactory;


    private CardFactory cardFactory;


    public String isThisCorrectPerson(Exchange exchange){

        var custom = exchange.getIn().getBody(String.class);


        List<String> elementList = Arrays.asList(custom.split(","));

        String id =  elementList.get(0);
        String cardNumber =  elementList.get(1);
        String firstName =  elementList.get(2);
        String lastName =  elementList.get(3);
        String expiry =  elementList.get(4);
        int pin =  Integer.parseInt( elementList.get(5) ) ;
        int bin =  Integer.parseInt( elementList.get(6) ) ;
        int  ccv =  Integer.parseInt( elementList.get(7) ) ;

        String validityofnumber =  elementList.get(9);
        String bankname =  elementList.get(10);

        CardFactory cardFactory = getFactory(bankname);
        boolean isThisGuyLegit = cardFactory.authenticateTransaction(id,cardNumber,firstName,lastName,expiry,pin,bin,ccv);


       if(isThisGuyLegit == true)
        {
            var authenticated = custom + "LEGITIMATE CREDENTIALS" + ",";
            exchange.getIn().setBody(authenticated);

        }
        else if (isThisGuyLegit == false)
        {
            var notAuthenticated = custom + "NOT VALID CREDENTIALS" + ",";
            exchange.getIn().setBody(notAuthenticated);
        }

        return exchange.getIn().getBody(String.class);

    }


    public CardFactory getFactory(String bankname){
        return abstractFactory.createCardService(bankname);
    }





}
