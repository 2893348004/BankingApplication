package com.IssuerBanks.IssuerBanks.IssuerBankRoutes;

import org.apache.camel.converter.crypto.CryptoDataFormat;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.crypto.KeyGenerator;


@Component
public class IssuerBankRoutes extends RouteBuilder {

    @Autowired
    private AuthenticationForTransaction authentication;

    @Autowired
    private AuthorizationForTransaction authorization;


    final String publicKeyFileName="file:D:/WorkProjectsFolder/BankingApplication/adrien_0x72044B6E_public.asc";
    final String keyUserid="adrien <zag.adrien@hotmail.com>";
    final String secretKeyFileName="file:D:/WorkProjectsFolder/BankingApplication/adrien_0x72044B6E_SECRET.asc";
    final String keyPassword="Adrien.2021";


    @Override
    public void configure() throws Exception {


        from("activemq: processor-to-Bank-transaction-JPMorganChase")
                .unmarshal().pgp(secretKeyFileName,keyUserid,keyPassword)
                .bean(authentication, "isThisCorrectPerson" )
                .log("${body}")
                .choice()
                .when(body().contains("NOT VALID CREDENTIALS")).marshal().pgp(publicKeyFileName, keyUserid).to("activemq: banks-to-processor-transaction-error")
                .otherwise()
                .bean(authorization, "doesPersonHaveTheFunds" )
                .log("${body}")
                .choice()
                .when(body().contains("INSUFFICIENT FUNDS")).marshal().pgp(publicKeyFileName, keyUserid).to("activemq: banks-to-processor-transaction-error-insufficient")
                .otherwise()

                .marshal().pgp(publicKeyFileName, keyUserid)
                .to("activemq: banks-to-processor-transaction-finished");



        from("activemq: processor-to-Bank-transaction-American Express")
                .unmarshal().pgp(secretKeyFileName,keyUserid,keyPassword)
                .bean(authentication, "isThisCorrectPerson" )
                .choice()
                .when(body().contains("NOT VALID CREDENTIALS")).marshal().pgp(publicKeyFileName, keyUserid).to("activemq: banks-to-processor-transaction-error")
                .otherwise()
                .bean(authorization, "doesPersonHaveTheFunds" )
                .choice()
                .when(body().contains("INSUFFICIENT FUNDS")).marshal().pgp(publicKeyFileName, keyUserid).to("activemq: banks-to-processor-transaction-error-insufficient")
                .otherwise()

                .marshal().pgp(publicKeyFileName, keyUserid)
                .to("activemq: banks-to-processor-transaction-finished");



        from("activemq: processor-to-Bank-transaction-Bank of America")
                .unmarshal().pgp(secretKeyFileName,keyUserid,keyPassword)
                .bean(authentication, "isThisCorrectPerson" )
                .choice()
                .when(body().contains("NOT VALID CREDENTIALS")).marshal().pgp(publicKeyFileName, keyUserid).to("activemq: banks-to-processor-transaction-error")
                .otherwise()
                .bean(authorization, "doesPersonHaveTheFunds" )
                .choice()
                .when(body().contains("INSUFFICIENT FUNDS")).marshal().pgp(publicKeyFileName, keyUserid).to("activemq: banks-to-processor-transaction-error-insufficient")
                .otherwise()

                .marshal().pgp(publicKeyFileName, keyUserid)
                .to("activemq: banks-to-processor-transaction-finished");


        from("activemq: processor-to-Bank-transaction-Barclays")
                .unmarshal().pgp(secretKeyFileName,keyUserid,keyPassword)
                .bean(authentication, "isThisCorrectPerson" )
                .choice()
                .when(body().contains("NOT VALID CREDENTIALS")).marshal().pgp(publicKeyFileName, keyUserid).to("activemq: banks-to-processor-transaction-error")
                .otherwise()
                .bean(authorization, "doesPersonHaveTheFunds" )
                .choice()
                .when(body().contains("INSUFFICIENT FUNDS")).marshal().pgp(publicKeyFileName, keyUserid).to("activemq: banks-to-processor-transaction-error-insufficient")
                .otherwise()

                .marshal().pgp(publicKeyFileName, keyUserid)
                .to("activemq: banks-to-processor-transaction-finished");


        from("activemq: processor-to-Bank-transaction-Citi Bank")
                .unmarshal().pgp(secretKeyFileName,keyUserid,keyPassword)
                .bean(authentication, "isThisCorrectPerson" )
                .choice()
                .when(body().contains("NOT VALID CREDENTIALS")).marshal().pgp(publicKeyFileName, keyUserid).to("activemq: banks-to-processor-transaction-error")
                .otherwise()
                .bean(authorization, "doesPersonHaveTheFunds" )
                .choice()
                .when(body().contains("INSUFFICIENT FUNDS")).marshal().pgp(publicKeyFileName, keyUserid).to("activemq: banks-to-processor-transaction-error-insufficient")
                .otherwise()

                .marshal().pgp(publicKeyFileName, keyUserid)
                .to("activemq: banks-to-processor-transaction-finished");




        from("activemq: processor-to-Bank-transaction-USAA")
                .unmarshal().pgp(secretKeyFileName,keyUserid,keyPassword)
                .bean(authentication, "isThisCorrectPerson" )
                .choice()
                .when(body().contains("NOT VALID CREDENTIALS")).marshal().pgp(publicKeyFileName, keyUserid).to("activemq: banks-to-processor-transaction-error")
                .otherwise()
                .bean(authorization, "doesPersonHaveTheFunds" )
                .choice()
                .when(body().contains("INSUFFICIENT FUNDS")).marshal().pgp(publicKeyFileName, keyUserid).to("activemq: banks-to-processor-transaction-error-insufficient")
                .otherwise()

                .marshal().pgp(publicKeyFileName, keyUserid)
                .to("activemq: banks-to-processor-transaction-finished");




        from("activemq: processor-to-Bank-transaction-Capital One")
                .unmarshal().pgp(secretKeyFileName,keyUserid,keyPassword)
                .bean(authentication, "isThisCorrectPerson" )
                .choice()
                .when(body().contains("NOT VALID CREDENTIALS")).marshal().pgp(publicKeyFileName, keyUserid).to("activemq: banks-to-processor-transaction-error")
                .otherwise()
                .bean(authorization, "doesPersonHaveTheFunds" )
                .choice()
                .when(body().contains("INSUFFICIENT FUNDS")).marshal().pgp(publicKeyFileName, keyUserid).to("activemq: banks-to-processor-transaction-error-insufficient")
                .otherwise()

                .marshal().pgp(publicKeyFileName, keyUserid)
                .to("activemq: banks-to-processor-transaction-finished");



        from("activemq: processor-to-Bank-transaction-Wells Fargo")
                .unmarshal().pgp(secretKeyFileName,keyUserid,keyPassword)
                .bean(authentication, "isThisCorrectPerson" )
                .choice()
                .when(body().contains("NOT VALID CREDENTIALS")).marshal().pgp(publicKeyFileName, keyUserid).to("activemq: banks-to-processor-transaction-error")
                .otherwise()
                .bean(authorization, "doesPersonHaveTheFunds" )
                .choice()
                .when(body().contains("INSUFFICIENT FUNDS")).marshal().pgp(publicKeyFileName, keyUserid).to("activemq: banks-to-processor-transaction-error-insufficient")
                .otherwise()

                .marshal().pgp(publicKeyFileName, keyUserid)
                .to("activemq: banks-to-processor-transaction-finished");


        from("activemq: processor-to-Bank-transaction-Discover")
                .unmarshal().pgp(secretKeyFileName,keyUserid,keyPassword)
                .bean(authentication, "isThisCorrectPerson" )
                .choice()
                .when(body().contains("NOT VALID CREDENTIALS")).marshal().pgp(publicKeyFileName, keyUserid).to("activemq: banks-to-processor-transaction-error")
                .otherwise()
                .bean(authorization, "doesPersonHaveTheFunds" )
                .choice()
                .when(body().contains("INSUFFICIENT FUNDS")).marshal().pgp(publicKeyFileName, keyUserid).to("activemq: banks-to-processor-transaction-error-insufficient")
                .otherwise()

                .marshal().pgp(publicKeyFileName, keyUserid)
                .to("activemq: banks-to-processor-transaction-finished");



    }













}









