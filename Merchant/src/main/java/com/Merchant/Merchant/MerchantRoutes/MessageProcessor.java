package com.Merchant.Merchant.MerchantRoutes;


import com.Merchant.Merchant.Transactions.Transaction;
import com.Merchant.Merchant.Transactions.TransactionRepository;
import com.Merchant.Merchant.Transactions.TransactionService;
import org.apache.camel.Exchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class MessageProcessor {

    @Autowired
    private TransactionService transactionService;


    public String processFail(Exchange exchange){

        var custom = exchange.getIn().getBody(String.class);

        List<String> elementList = Arrays.asList(custom.split(","));

        String message =  elementList.get(12);
        String cardNo =  elementList.get(1);


        return message;
    }

    public String processPass(Exchange exchange){

        var custom = exchange.getIn().getBody(String.class);

        List<String> elementList = Arrays.asList(custom.split(","));

        String message =  elementList.get(12);
        String cardNo =  elementList.get(1);


        return message ;
    }

    public String invalid(Exchange exchange){

        var custom = exchange.getIn().getBody(String.class);

        List<String> elementList = Arrays.asList(custom.split(","));

        if(elementList.contains("INVALID NUMBER")){
            return "TRANSACTION REJECTED" ;
        }
        return "ERROR";
    }



}
