package za.co.entelect.dojo.service;

import org.springframework.stereotype.Component;
import za.co.entelect.dojo.domain.Card;
import za.co.entelect.dojo.enums.CardValidationErrorType;
import za.co.entelect.dojo.exceptions.AccountException;

@Component
public class AccountServiceImpl implements AccountService {

    @Override
    public void withdrawMoney(Card aCard, long transactionAmountInCents, long bankChargeAmountInCents) {
        long totalAmount = transactionAmountInCents + bankChargeAmountInCents;
        if (aCard.getAvailableBalanceInCents() > totalAmount) {
            long newBalance = aCard.getAvailableBalanceInCents() - totalAmount;
            aCard.setAvailableBalanceInCents(newBalance);
        } else {
            throw new AccountException(CardValidationErrorType.INSUFFICIENT_FUNDS);
        }
    }
}
