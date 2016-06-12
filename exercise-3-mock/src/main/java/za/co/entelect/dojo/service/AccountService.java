package za.co.entelect.dojo.service;

import za.co.entelect.dojo.domain.Card;

public interface AccountService {

    void withdrawMoney(Card aCard, long transactionAmountInCents, long bankChargeAmountInCents);
}

