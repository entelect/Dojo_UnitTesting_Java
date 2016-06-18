package za.co.entelect.dojo.service;

import za.co.entelect.dojo.domain.Card;

public class CardServiceImpl implements CardService {

    private long BANK_CHARGE_IN_CENTS = 20L;

    private Track2DataValidationService track2DataValidationService;

    private PinService pinService;

    private AccountService accountService;

    public CardServiceImpl() {
        track2DataValidationService = new Track2DataValidationServiceImpl();
        pinService = new PinServiceImpl();
        accountService = new AccountServiceImpl();
    }

    @Override
    public void withdrawMoney(Card aCard, long transactionAmount) {
        track2DataValidationService.isValid(aCard.getTrack2());
        pinService.validatePin(aCard.getPinBlock(), aCard.getCardNumber());
        accountService.withdrawMoney(aCard, transactionAmount, BANK_CHARGE_IN_CENTS);
    }
}
