package com.PaymentProcessor.PaymentProcessor.ProcessorRoutes;


import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.commons.validator.routines.checkdigit.LuhnCheckDigit;
import org.springframework.stereotype.Component;

import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.List;

@Component
public class WhoIsCardIssuer {



        public String WhoIsBank(Exchange exchange)  {

            var custom = exchange.getIn().getBody(String.class);


            List<String> elementList = Arrays.asList(custom.split(","));

            String bin =  elementList.get(6);

            String bankName = identifyBank(bin);



            if(bankName == "Bank Not Found")
            {
                var failCustom = custom + "Bank Not Found";
                exchange.getIn().setBody(failCustom);

            }
            else
            {
                var passCustom = custom + bankName + "," ;
                exchange.getIn().setBody(passCustom);
            }

            return exchange.getIn().getBody(String.class);

        }









        public String identifyBank(String bin){

            String issuerBankName;

            switch (bin) {
                case "14720" :
                    issuerBankName =  "JPMorganChase";
                    return issuerBankName;
                case "79741" :
                    issuerBankName =  "American Express";
                    return issuerBankName;
                case "80011" :
                    issuerBankName =  "Bank of America";
                    return issuerBankName;
                case "59309" :
                    issuerBankName =  "Barclays";
                    return issuerBankName;
                case "42418"  :
                    issuerBankName =  "Citi Bank";
                    return issuerBankName;
                case "49123" :
                    issuerBankName =  "USAA";
                    return issuerBankName;
                case "14709" :
                    issuerBankName =  "Capital One";
                    return issuerBankName;
                case "46542"  :
                    issuerBankName =  "Wells Fargo";
                    return issuerBankName;
                case "1101"  :
                    issuerBankName =  "Discover";
                    return issuerBankName;

                default:
                    return "Bank Not Found";
            }

        }


}
