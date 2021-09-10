package com.IssuerBanks.IssuerBanks.Service.CardServices;


import com.IssuerBanks.IssuerBanks.Cards.AmericanExpressCards;
import com.IssuerBanks.IssuerBanks.Cards.BarclaysCards;
import com.IssuerBanks.IssuerBanks.Factories.CardFactory;
import com.IssuerBanks.IssuerBanks.Repositories.CardRepositories.CardRepository_Barclays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BarclaysCardService  implements CardFactory {

    @Autowired
    private CardRepository_Barclays cardRepo;


    @Override
    public boolean authenticateTransaction(String id,String cardNumber,
                                           String firstName,String lastName,
                                           String expiry,int pin,int bin,int  ccv) {

        BarclaysCards card = cardRepo.findByCardNumber(cardNumber);

        var cardexp = card.getExp();
        var cardbin = card.getBin();
        var cardpin = card.getPin();
        var cardccv = card.getCcv();
        var flagged = card.isFlagged();
        var locked = card.isLocked();


        if(cardbin != bin){return false;}
        if(cardccv != ccv){return false;}
        if(cardpin != pin){return false;}
        if(locked){return false;}
        if(flagged){return false;}
        if(cardexp != expiry){return false;}
        if(locked){return false;}
        if(flagged){return false;}


        return true;


    }

    @Override
    public boolean authorizeTransaction(String id,String cardNumber, String firstName,
                                        String lastName, String  expiry,
                                        int pin,int bin,int ccv,double amount ) {

        BarclaysCards card = cardRepo.findByCardNumber(cardNumber);

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
        if(locked){return false;}
        if(flagged){return false;}
        if(cardexp != expiry){return false;}
        if(locked){return false;}
        if(flagged){return false;}

        if( amount > balance){return false;}

        double newBalance = balance - amount;
        card.setBalance(newBalance);

        cardRepo.save(card);

        return true;

    }


    public Iterable<BarclaysCards> getAllCards(){

        var x =  cardRepo.findAll();

        return x;
    }

    public Iterable<BarclaysCards> getAllLockedCards(){

        var x =  cardRepo.findByFlagged();

        return x;
    }

    public BarclaysCards getByAccount(String accountNumber){

        var x = cardRepo.findByCustomerAccount(accountNumber);

        return x;
    }

    public BarclaysCards getByCardNumber(String cardNumber){

        var x = cardRepo.findByCardNumber(cardNumber);

        return x;
    }


    public List<BarclaysCards> getByAssociation(int association){

        var x = cardRepo.findByCardAssociation(association);

        return x;
    }


    public List<BarclaysCards> getAllFlagged( ){

        var x = cardRepo.findByFlagged();

        return x;
    }

    public List<BarclaysCards> getAllLocked( ){

        var x = cardRepo.findByLocked();

        return x;
    }


    public List<BarclaysCards> getByExpDate(String expDate){

        var x = cardRepo.findByExp(expDate);

        return x;
    }



}
