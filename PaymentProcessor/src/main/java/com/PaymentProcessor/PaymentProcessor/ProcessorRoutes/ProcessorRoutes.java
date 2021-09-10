package com.PaymentProcessor.PaymentProcessor.ProcessorRoutes;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.converter.crypto.CryptoDataFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.crypto.KeyGenerator;

@Component
public class ProcessorRoutes extends RouteBuilder {


    @Autowired
    private IsThisValidNumber isThisValidNumber;

    @Autowired
    private WhoIsCardIssuer whoIsCardIssuer;

    @Autowired
    private GenerateMessage generateMessage;

    final String publicKeyFileName="file:D:/WorkProjectsFolder/BankingApplication/adrien_0x72044B6E_public.asc";
    final String keyUserid="adrien <zag.adrien@hotmail.com>";
    final String secretKeyFileName="file:D:/WorkProjectsFolder/BankingApplication/adrien_0x72044B6E_SECRET.asc";
    final String keyPassword="Adrien.2021";

    @Override
    public void configure() throws Exception {



        from("activemq: merchant-to-processor-transaction")
                .unmarshal().pgp(secretKeyFileName,keyUserid,keyPassword)
                .bean(isThisValidNumber, "Luhnalgorithm" )
                .log("${body}")
                .choice()
                        .when(body().contains("INVALID NUMBER"))
                        .bean(generateMessage, "genericError" )
                         .marshal().pgp(publicKeyFileName, keyUserid).to("activemq: processor-to-merchant-transaction-error-invalid")
                .otherwise()
                .bean(whoIsCardIssuer, "WhoIsBank" )
                .choice()
                        .when(body().contains("Bank Not Found")).marshal().pgp(publicKeyFileName, keyUserid).to("activemq: processor-to-merchant-transaction-error")
                        .when(body().contains("JPMorganChase")).marshal().pgp(publicKeyFileName, keyUserid).to("activemq: processor-to-Bank-transaction-JPMorganChase")
                        .when(body().contains("American Express")).marshal().pgp(publicKeyFileName, keyUserid).to("activemq: processor-to-Bank-transaction-American Express")
                        .when(body().contains("Bank of America")).marshal().pgp(publicKeyFileName, keyUserid).to("activemq: processor-to-Bank-transaction-Bank of America")
                        .when(body().contains("Barclays")).marshal().pgp(publicKeyFileName, keyUserid).to("activemq: processor-to-Bank-transaction-Barclays")
                        .when(body().contains("Citi Bank")).marshal().pgp(publicKeyFileName, keyUserid).to("activemq: processor-to-Bank-transaction-Citi Bank")
                        .when(body().contains("USAA")).marshal().pgp(publicKeyFileName, keyUserid).to("activemq: processor-to-Bank-transaction-USAA")
                        .when(body().contains("Capital One")).marshal().pgp(publicKeyFileName, keyUserid).to("activemq: processor-to-Bank-transaction-Capital One")
                        .when(body().contains("Wells Fargo")).marshal().pgp(publicKeyFileName, keyUserid).to("activemq: processor-to-Bank-transaction-Wells Fargo")
                        .when(body().contains("Discover")).marshal().pgp(publicKeyFileName, keyUserid).to("activemq: processor-to-Bank-transaction-Discover")
                .end()
                .unmarshal().pgp(secretKeyFileName,keyUserid,keyPassword)
                .log("${body}");





        from("activemq: banks-to-processor-transaction-error")
              //  .unmarshal().pgp(secretKeyFileName,keyUserid,keyPassword)
              //  .bean(generateMessage, "genericError" )
              //  .marshal().pgp(publicKeyFileName, keyUserid)
                .to("activemq: processor-to-merchant-transaction-error");




        from("activemq: banks-to-processor-transaction-error-insufficient")
                //  processing omitted
                .to("activemq: processor-to-merchant-transaction-error");



        from("activemq: banks-to-processor-transaction-finished")
                .to("activemq: processor-to-merchant-transaction-finished");




    }

}
