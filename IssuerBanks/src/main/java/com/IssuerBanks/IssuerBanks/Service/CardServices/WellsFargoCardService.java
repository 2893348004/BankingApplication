package com.IssuerBanks.IssuerBanks.Service.CardServices;

import com.IssuerBanks.IssuerBanks.Cards.DiscoverCards;
import com.IssuerBanks.IssuerBanks.Cards.WellsFargoCards;
import com.IssuerBanks.IssuerBanks.Factories.CardFactory;
import com.IssuerBanks.IssuerBanks.Repositories.CardRepositories.CardRepository_Wells_Fargo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WellsFargoCardService implements CardFactory {


    @Autowired
    private CardRepository_Wells_Fargo cardRepo;


    @Override
    public boolean authenticateTransaction(String id,String cardNumber,
                                           String firstName,String lastName,
                                           String expiry,int pin,int bin,int  ccv) {


        WellsFargoCards card = cardRepo.findByCardNumber(cardNumber);

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



        WellsFargoCards card = cardRepo.findByCardNumber(cardNumber);

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



    public Iterable<WellsFargoCards> getAllCards(){

        var x =  cardRepo.findAll();

        return x;
    }

    public Iterable<WellsFargoCards> getAllLockedCards(){

        var x =  cardRepo.findByFlagged();

        return x;
    }

    public WellsFargoCards getByAccount(String accountNumber){

        var x = cardRepo.findByCustomerAccount(accountNumber);

        return x;
    }

    public WellsFargoCards getByCardNumber(String cardNumber){

        var x = cardRepo.findByCardNumber(cardNumber);

        return x;
    }


    public List<WellsFargoCards> getByAssociation(int association){

        var x = cardRepo.findByCardAssociation(association);

        return x;
    }


    public List<WellsFargoCards> getAllFlagged( ){

        var x = cardRepo.findByFlagged();

        return x;
    }

    public List<WellsFargoCards> getAllLocked( ){

        var x = cardRepo.findByLocked();

        return x;
    }


    public List<WellsFargoCards> getByExpDate(String expDate){

        var x = cardRepo.findByExp(expDate);

        return x;
    }


}
