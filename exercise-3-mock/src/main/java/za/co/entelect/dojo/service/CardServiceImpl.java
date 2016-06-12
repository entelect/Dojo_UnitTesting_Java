package za.co.entelect.dojo.service;

import za.co.entelect.dojo.Card;

public class CardServiceImpl implements CardService {

    private long BANK_CHARGE_IN_CENTS = 20L;

    private ValidationService validationService;

    private PinService pinService;

    private AccountService accountService;

    public CardServiceImpl() {
        validationService = new ValidationServiceImpl();
        pinService = new PinServiceImpl();
        accountService = new AccountServiceImpl();
    }

    @Override
    public void withdrawMoney(Card aCard, long transactionAmount) {
        validationService.validateTrackData(aCard.getTrack2());
        pinService.validatePin(aCard.getPinBlock(), aCard.getCardNumber());
        accountService.withdrawMoney(aCard, transactionAmount, BANK_CHARGE_IN_CENTS);
    }
}
