package za.co.entelect.dojo.service;

import za.co.entelect.dojo.domain.BankAccount;
import za.co.entelect.dojo.enums.CardApplicationResult;

/**
 * Service to determine if a client will be approved for a new credit card
 */
public class CardApplicationServiceImpl implements CardApplicationService {

    private long MIN_EMPLOYED_BALANCE_IN_CENTS = 5_000_00;

    public CardApplicationResult applyForCreditCard(BankAccount... bankAccounts){
        if(hasBankAccount(bankAccounts)){
            return CardApplicationResult.NO_BANK_ACCOUNT_DECLINED;
        }

        long totalBalance = getTotalBalance(bankAccounts);

        if(totalBalance < MIN_EMPLOYED_BALANCE_IN_CENTS){
            return CardApplicationResult.MIN_BALANCE_DECLINED;
        }

        return CardApplicationResult.APPROVED;
    }

    private long getTotalBalance(BankAccount[] bankAccounts) {
        long totalBalance  = 0;
        for (BankAccount bankAccount : bankAccounts) {
            totalBalance += bankAccount.getBalanceInCents();
        }

        return totalBalance;
    }

    private boolean hasBankAccount(BankAccount[] bankAccounts) {
        return bankAccounts == null || bankAccounts.length == 0;
    }
}