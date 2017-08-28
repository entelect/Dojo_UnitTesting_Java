package za.co.entelect.dojo.service;

import org.junit.Test;
import za.co.entelect.dojo.domain.BankAccount;

public class CardApplicationServiceTest {

    private static final BankAccount TEST_BANK_ACCOUNT_BALANCE_4999 = new BankAccount(4999_49);

    private CardApplicationService cardApplicationService = new CardApplicationServiceImpl();

    @Test
    public void testNoBankAccountDeclined(){
        //assertEquals(); NO_BANK_ACCOUNT_DECLINED
    }

    // todo: Add more tests...
}