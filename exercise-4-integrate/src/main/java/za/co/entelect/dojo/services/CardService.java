package za.co.entelect.dojo.services;

import za.co.entelect.dojo.Card;

public interface CardService {
    public void withdrawMoney(Card aCard, double transactionAmount);
}
