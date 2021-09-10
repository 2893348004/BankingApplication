package com.IssuerBanks.IssuerBanks.Service.CardServices;

import com.IssuerBanks.IssuerBanks.Cards.CapitalOneCards;
import com.IssuerBanks.IssuerBanks.Cards.JPMorganChaseCards;
import com.IssuerBanks.IssuerBanks.Factories.CardFactory;
import com.IssuerBanks.IssuerBanks.Repositories.CardRepositories.CardRepository_Chase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChaseCardService implements CardFactory {


    @Autowired
    private CardRepository_Chase cardRepo;

    public ChaseCardService(){}




    @Override
    public boolean authenticateTransaction(String id,String cardNumber,
                                           String firstName,String lastName,
                                           String expiry,int pin,int bin,int  ccv){


        if(cardRepo.findByCardNumber(cardNumber) == null) return false;

        if(cardRepo.findByCardNumber(cardNumber) != null) {
        JPMorganChaseCards card = cardRepo.findByCardNumber(cardNumber);

        var cardexp = card.getExp();
        var cardbin = card.getBin();
        var cardpin = card.getPin();
        var cardccv = card.getCcv();
        var flagged = card.isFlagged();
        var locked = card.isLocked();


        if(cardbin != bin){return false;}
        if(cardccv != ccv){return false;}
        if(cardpin != pin){return false;}
       if(locked == true){return false;}
        if(flagged == true){return false;}
        if(!cardexp.contains(expiry)){return false;}


        }

        return true;


    }

    @Override
    public boolean authorizeTransaction(String id,String cardNumber, String firstName,
                                        String lastName, String  expiry,
                                        int pin,int bin,int ccv,double amount ) {


        if(cardRepo.findByCardNumber(cardNumber) == null) return false;

        if(cardRepo.findByCardNumber(cardNumber) != null) {


        JPMorganChaseCards card = cardRepo.findByCardNumber(cardNumber);

        var cardexp = card.getExp();
        var cardbin = card.getBin();
        var cardpin = card.getPin();
        var cardccv = card.getCcv();
        var flagged = card.isFlagged();
        var locked = card.isLocked();
        var balance = card.getBalance();



            if(cardbin != bin){return false;}
            if(cardccv != ccv){return false;}
            if(cardpin != pin){return false;}
            if(locked == true){return false;}
            if(flagged == true){return false;}
            if(!cardexp.contains(expiry)){return false;}





        if( amount > balance){return false;}


        double newBalance = balance - amount;
        card.setBalance(newBalance);

        cardRepo.save(card);
        }
        return true;
    }


    public Iterable<JPMorganChaseCards> getAllCards(){

        var x =  cardRepo.findAll();

        return x;
    }

    public Iterable<JPMorganChaseCards> getAllLockedCards(){

        var x =  cardRepo.findByFlagged();

        return x;
    }

    public JPMorganChaseCards getByAccount(String accountNumber){

        var x = cardRepo.findByCustomerAccount(accountNumber);

        return x;
    }

    public JPMorganChaseCards getByCardNumber(String cardNumber){

        var x = cardRepo.findByCardNumber(cardNumber);

        return x;
    }


    public List<JPMorganChaseCards> getByAssociation(int association){

        var x = cardRepo.findByCardAssociation(association);

        return x;
    }


    public List<JPMorganChaseCards> getAllFlagged( ){

        var x = cardRepo.findByFlagged();

        return x;
    }

    public List<JPMorganChaseCards> getAllLocked( ){

        var x = cardRepo.findByLocked();

        return x;
    }


    public List<JPMorganChaseCards> getByExpDate(String expDate){

        var x = cardRepo.findByExp(expDate);

        return x;
    }



}
