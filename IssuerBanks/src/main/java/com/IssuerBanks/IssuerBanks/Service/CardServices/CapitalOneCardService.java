package com.IssuerBanks.IssuerBanks.Service.CardServices;

import com.IssuerBanks.IssuerBanks.Cards.BankofAmericaCards;
import com.IssuerBanks.IssuerBanks.Cards.CapitalOneCards;
import com.IssuerBanks.IssuerBanks.Factories.CardFactory;
import com.IssuerBanks.IssuerBanks.Repositories.CardRepositories.CardRepository_Capital_One;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CapitalOneCardService implements CardFactory {

    @Autowired
    private CardRepository_Capital_One cardRepo;



    @Override
    public boolean authenticateTransaction(String id,String cardNumber,
                                           String firstName,String lastName,
                                           String expiry,int pin,int bin,int  ccv) {

        CapitalOneCards card = cardRepo.findByCardNumber(cardNumber);

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


        CapitalOneCards card = cardRepo.findByCardNumber(cardNumber);

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



    public Iterable<CapitalOneCards> getAllCards(){

        var x =  cardRepo.findAll();

        return x;
    }

    public Iterable<CapitalOneCards> getAllLockedCards(){

        var x =  cardRepo.findByFlagged();

        return x;
    }

    public CapitalOneCards getByAccount(String accountNumber){

        var x = cardRepo.findByCustomerAccount(accountNumber);

        return x;
    }

    public CapitalOneCards getByCardNumber(String cardNumber){

        var x = cardRepo.findByCardNumber(cardNumber);

        return x;
    }


    public List<CapitalOneCards> getByAssociation(int association){

        var x = cardRepo.findByCardAssociation(association);

        return x;
    }


    public List<CapitalOneCards> getAllFlagged( ){

        var x = cardRepo.findByFlagged();

        return x;
    }

    public List<CapitalOneCards> getAllLocked( ){

        var x = cardRepo.findByLocked();

        return x;
    }


    public List<CapitalOneCards> getByExpDate(String expDate){

        var x = cardRepo.findByExp(expDate);

        return x;
    }




}
