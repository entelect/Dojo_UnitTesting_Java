package za.co.entelect.dojo.services;

import za.co.entelect.dojo.Card;

public class CardServiceImpl implements CardService {

    private double BANK_CHARGE = 2D;

    private ValidationService validationService;

    private PinService pinService;

    private AccountService accountService;

    public CardServiceImpl() {
        validationService = new ValidationServiceImpl();
        pinService = new PinServiceImpl();
        accountService = new AccountServiceImpl();
    }

    @Override
    public void withdrawMoney(Card aCard, double transactionAmount) {
        validationService.validateTrackData(aCard.getTrack2());
        pinService.validatePin(aCard.getPinBlock(), aCard.getCardNumber());
        accountService.withdrawMoney(aCard, transactionAmount, BANK_CHARGE);
    }
}
