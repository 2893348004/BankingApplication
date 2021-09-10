package com.PaymentProcessor.PaymentProcessor.ProcessorRoutes;


import org.apache.camel.Exchange;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class GenerateMessage {


    public String genericError(Exchange exchange)  {

        var custom = exchange.getIn().getBody(String.class);


        List<String> elementList = Arrays.asList(custom.split(","));

        String id =  elementList.get(0);


        var newCustom = id + "," + "TRANSACTION REJECTED";

        exchange.getIn().setBody(newCustom);

        return exchange.getIn().getBody(String.class);

    }

    public String insufficientFunds(Exchange exchange)  {

        var custom = exchange.getIn().getBody(String.class);


        List<String> elementList = Arrays.asList(custom.split(","));

        String id =  elementList.get(0);


        var newCustom = id + "," + "INSUFFICIENT FUNDS";

        exchange.getIn().setBody(newCustom);

        return exchange.getIn().getBody(String.class);

    }

    public String success(Exchange exchange)  {

        var custom = exchange.getIn().getBody(String.class);


        List<String> elementList = Arrays.asList(custom.split(","));

        String id =  elementList.get(0);


        var newCustom = id + "," + "SUCCESS";

        exchange.getIn().setBody(newCustom);

        return exchange.getIn().getBody(String.class);

    }










}
