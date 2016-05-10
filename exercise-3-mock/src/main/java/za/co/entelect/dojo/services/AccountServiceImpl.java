package za.co.entelect.dojo.services;

import za.co.entelect.dojo.Card;
import za.co.entelect.dojo.enums.ResponseEnum;
import za.co.entelect.dojo.exceptions.AccountException;

public class AccountServiceImpl implements AccountService {

    @Override
    public void withdrawMoney(Card aCard, double transactionAmount, double bankChargeAmount) {
        double totalAmount = transactionAmount + bankChargeAmount;
        if (aCard.getAvailableBalance() > totalAmount) {
            double newBalance = aCard.getAvailableBalance() - transactionAmount - bankChargeAmount;
            aCard.setAvailableBalance(newBalance);
        } else {
            throw new AccountException(ResponseEnum.INSUFFICIENT_FUNDS);
        }
    }
}
