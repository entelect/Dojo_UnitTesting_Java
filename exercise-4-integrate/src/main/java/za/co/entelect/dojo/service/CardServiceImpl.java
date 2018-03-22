package za.co.entelect.dojo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.co.entelect.dojo.domain.Card;

@Component
public class CardServiceImpl implements CardService {

    private long BANK_CHARGE = 200L;

    @Autowired
    private CardDataValidationService CardDataValidationService;

    @Autowired
    private PinService pinService;

    @Autowired
    private AccountService accountService;

    @Override
    public void withdrawMoney(Card aCard, long transactionAmountInCents) {
        CardDataValidationService.isValid(aCard.getCardData());
        pinService.validatePin(aCard.getPinBlock(), aCard.getCardNumber());
        accountService.withdrawMoney(aCard, transactionAmountInCents, BANK_CHARGE);
    }
}
