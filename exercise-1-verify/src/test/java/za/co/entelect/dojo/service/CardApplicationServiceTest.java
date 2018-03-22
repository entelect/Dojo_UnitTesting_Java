package za.co.entelect.dojo.service;

import org.junit.Test;
import za.co.entelect.dojo.domain.BankAccount;
import za.co.entelect.dojo.enums.CardApplicationResult;

import static junit.framework.TestCase.assertEquals;

public class CardApplicationServiceTest {

    private static final BankAccount TEST_BANK_ACCOUNT_BALANCE_4999 = new BankAccount(4999_00);

    private CardApplicationService cardApplicationService = new CardApplicationServiceImpl();

    @Test
    public void testNoBankAccountDeclined(){
        assertEquals(CardApplicationResult.NO_BANK_ACCOUNT_DECLINED, cardApplicationService.applyForCreditCard(null));
        //todo: Add more asserts here
    }

    // todo: Add more tests...
}