package com.IssuerBanks.IssuerBanks.Factories;

public interface BankAbstractFactory<T> {
    CardFactory createCardService(String bankname) ;
}
