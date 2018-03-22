package za.co.entelect.dojo.service;

import za.co.entelect.dojo.domain.Card;

public class CardServiceImpl implements CardService {

    private long BANK_CHARGE_IN_CENTS = 20L;

    private CardDataValidationService CCDataValidationService;

    private PinService pinService;

    private AccountService accountService;

    public CardServiceImpl() {
        CCDataValidationService = new CardDataValidationServiceImpl();
        pinService = new PinServiceImpl();
        accountService = new AccountServiceImpl();
    }

    @Override
    public void withdrawMoney(Card aCard, long transactionAmount) {
        CCDataValidationService.isValid(aCard.getCardData());
        pinService.validatePin(aCard.getPinBlock(), aCard.getCardNumber());
        accountService.withdrawMoney(aCard, transactionAmount, BANK_CHARGE_IN_CENTS);
    }
}
