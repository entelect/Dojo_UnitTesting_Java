package za.co.entelect.dojo.service;

import za.co.entelect.dojo.domain.BankAccount;
import za.co.entelect.dojo.enums.CardApplicationResult;

/**
 * Service to determine if a client will be approved for a new credit card
 */
public interface CardApplicationService {

    CardApplicationResult applyForCreditCard(BankAccount... bankAccounts);

}
