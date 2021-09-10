package com.PaymentProcessor.PaymentProcessor.ProcessorRoutes;


import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.commons.validator.routines.checkdigit.LuhnCheckDigit;
import org.springframework.stereotype.Component;

import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.List;

@Component
public class IsThisValidNumber {


    public String Luhnalgorithm(Exchange exchange)  {

        var custom = exchange.getIn().getBody(String.class);


        List<String> elementList = Arrays.asList(custom.split(","));

        String fullNumber =  elementList.get(1);

        String lastTenDigits = fullNumber.substring(fullNumber.length() - 10);



        boolean validCreditCardNumber = isValidCreditCardNumberLuhn(fullNumber);

        if(validCreditCardNumber)
        {
        var passCustom = custom + "VALID NUMBER" + ",";
        exchange.getIn().setBody(passCustom);

        }
        else
        {
            var failCustom = custom + "INVALID NUMBER" + ",";
            exchange.getIn().setBody(failCustom);
        }

        return exchange.getIn().getBody(String.class);

    }




    public static boolean isValidCreditCardNumberLuhn(String creditCardNumber)
    {
        return LuhnCheckDigit.LUHN_CHECK_DIGIT.isValid(creditCardNumber);
    }


}
