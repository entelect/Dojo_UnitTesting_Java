package za.co.entelect.dojo.service;

import za.co.entelect.dojo.Card;

public interface CardService {

    void withdrawMoney(Card aCard, long transactionAmount);
}
