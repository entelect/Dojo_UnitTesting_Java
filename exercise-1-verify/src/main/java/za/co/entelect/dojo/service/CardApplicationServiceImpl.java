package za.co.entelect.dojo.service;

import za.co.entelect.dojo.domain.BankAccount;
import za.co.entelect.dojo.enums.CardApplicationResult;

/**
 * Service to determine if a client will be approved for a new credit card
 */
public class CardApplicationServiceImpl implements CardApplicationService {

    private long MIN_EMPLOYED_BALANCE_IN_CENTS = 5_000_00;
    private long MIN_UNEMPLOYED_BALANCE_IN_CENTS = 10_000_00;

    private int MAX_EMPLOYED_OVERDRAFT_ACCOUNT_ALLOWED = 1;

    public CardApplicationResult applyForCreditCard(boolean isEmployed, BankAccount... bankAccounts){
        if(hasBankAccount(bankAccounts)){
            return CardApplicationResult.NO_BANK_ACCOUNT_DECLINED;
        }

        int numAccountsInOverdraft = getNumAccountInOverdraft(bankAccounts);

        if(!isEmployed && numAccountsInOverdraft > 0){
            return CardApplicationResult.UNEMPLOYED_OVERDRAFT_DECLINED;
        }
        if(isEmployed && numAccountsInOverdraft > MAX_EMPLOYED_OVERDRAFT_ACCOUNT_ALLOWED){
            return CardApplicationResult.EMPLOYED_OVERDRAFT_DECLINED;
        }

        long totalBalance = getTotalBalance(bankAccounts);

        if((!isEmployed && totalBalance < MIN_UNEMPLOYED_BALANCE_IN_CENTS) ||  (isEmployed && totalBalance < MIN_EMPLOYED_BALANCE_IN_CENTS)){
            return CardApplicationResult.MIN_BALANCE_DECLINED;
        }

        return CardApplicationResult.APPROVED;
    }

    private int getNumAccountInOverdraft(BankAccount[] bankAccounts) {
        int overdraftAccountCount = 0;
        for (BankAccount bankAccount : bankAccounts) {
            if(!bankAccount.hasPositiveBalance()){
                overdraftAccountCount++;
            }
        }

        return overdraftAccountCount;
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