package za.co.entelect.dojo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.co.entelect.dojo.Card;

@Component
public class CardServiceImpl implements CardService {

    private double BANK_CHARGE = 2D;

    @Autowired
    private ValidationService validationService;

    @Autowired
    private PinService pinService;

    @Autowired
    private AccountService accountService;

    @Override
    public void withdrawMoney(Card aCard, long transactionAmountInCents) {
        validationService.validateTrackData(aCard.getTrack2());
        pinService.validatePin(aCard.getPinBlock(), aCard.getCardNumber());
        accountService.withdrawMoney(aCard, transactionAmount, BANK_CHARGE);
    }
}
