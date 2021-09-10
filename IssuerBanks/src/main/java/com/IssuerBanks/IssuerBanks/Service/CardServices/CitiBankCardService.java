package com.IssuerBanks.IssuerBanks.Service.CardServices;

import com.IssuerBanks.IssuerBanks.Cards.CitiBankCards;
import com.IssuerBanks.IssuerBanks.Cards.JPMorganChaseCards;
import com.IssuerBanks.IssuerBanks.Factories.CardFactory;
import com.IssuerBanks.IssuerBanks.Repositories.CardRepositories.CardRepository_CitiBank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CitiBankCardService implements CardFactory {


    @Autowired
    private CardRepository_CitiBank cardRepo;


    @Override
    public boolean authenticateTransaction(String id,String cardNumber,
                                           String firstName,String lastName,
                                           String expiry,int pin,int bin,int  ccv) {


        CitiBankCards card = cardRepo.findByCardNumber(cardNumber);

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


        CitiBankCards card = cardRepo.findByCardNumber(cardNumber);

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


    public Iterable<CitiBankCards> getAllCards(){

        var x =  cardRepo.findAll();

        return x;
    }

    public Iterable<CitiBankCards> getAllLockedCards(){

        var x =  cardRepo.findByFlagged();

        return x;
    }

    public CitiBankCards getByAccount(String accountNumber){

        var x = cardRepo.findByCustomerAccount(accountNumber);

        return x;
    }

    public CitiBankCards getByCardNumber(String cardNumber){

        var x = cardRepo.findByCardNumber(cardNumber);

        return x;
    }


    public List<CitiBankCards> getByAssociation(int association){

        var x = cardRepo.findByCardAssociation(association);

        return x;
    }


    public List<CitiBankCards> getAllFlagged( ){

        var x = cardRepo.findByFlagged();

        return x;
    }

    public List<CitiBankCards> getAllLocked( ){

        var x = cardRepo.findByLocked();

        return x;
    }


    public List<CitiBankCards> getByExpDate(String expDate){

        var x = cardRepo.findByExp(expDate);

        return x;
    }



}
