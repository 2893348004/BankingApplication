package com.Merchant.Merchant.MerchantRoutes;

import com.Merchant.Merchant.Transactions.TransactionService;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.converter.crypto.CryptoDataFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.crypto.KeyGenerator;


@Component
public class TransactionRoutes extends RouteBuilder {



    @Autowired
    private MessageProcessor messageProcessor;


    final String publicKeyFileName="file:D:/WorkProjectsFolder/BankingApplication/adrien_0x72044B6E_public.asc";
    final String keyUserid="adrien <zag.adrien@hotmail.com>";
    final String secretKeyFileName="file:D:/WorkProjectsFolder/BankingApplication/adrien_0x72044B6E_SECRET.asc";
    final String keyPassword="Adrien.2021";



    @Override
    public void configure() throws Exception {


        /// OUTBOUND ROUTES

        from("file:D:/WorkProjectsFolder/BankingApplication/Merchant/transactionsAttemptFolders")
                .convertBodyTo(String.class)
                .marshal().pgp(publicKeyFileName, keyUserid)
                .to("activemq:merchant-to-processor-transaction");







    /// INBOUND ROUTES


        from("activemq: processor-to-merchant-transaction-error-invalid")
                .unmarshal().pgp(secretKeyFileName,keyUserid,keyPassword)
                .bean(messageProcessor, "invalid")
                .log("${body}");

        from("activemq: processor-to-merchant-transaction-error")
                .unmarshal().pgp(secretKeyFileName,keyUserid,keyPassword)
                .bean(messageProcessor, "processFail")
                .log("${body}");


        from("activemq: processor-to-merchant-transaction-finished")
                .unmarshal().pgp(secretKeyFileName,keyUserid,keyPassword)
                .bean(messageProcessor, "processPass")
                .log("${body}");







    }


}
