package za.co.entelect.dojo.services;

import za.co.entelect.dojo.Card;

public interface CardService {

    void withdrawMoney(Card aCard, double transactionAmount);
}
