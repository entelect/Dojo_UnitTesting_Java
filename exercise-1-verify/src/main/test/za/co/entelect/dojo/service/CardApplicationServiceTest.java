package za.co.entelect.dojo.service;

import org.junit.Test;
import za.co.entelect.dojo.domain.BankAccount;
import za.co.entelect.dojo.enums.CardApplicationResult;

import static junit.framework.TestCase.assertEquals;

public class CardApplicationServiceTest {

    private static final BankAccount TEST_BANK_ACCOUNT_BALANCE_4999 = new BankAccount(4999_49);
    private static final BankAccount TEST_BANK_ACCOUNT_BALANCE_5000 = new BankAccount(5000_00);
    private static final BankAccount TEST_BANK_ACCOUNT_BALANCE_10000 = new BankAccount(10_000_00);
    private static final BankAccount TEST_BANK_ACCOUNT_BALANCE_NEGATIVE_1 = new BankAccount(-100);
    private static final BankAccount TEST_BANK_ACCOUNT_BALANCE_LOADED = new BankAccount(1_000_000_00);

    private CardApplicationService cardApplicationService = new CardApplicationServiceImpl();

    @Test
    public void testNoBankAccountDeclined(){
        //assertEquals(); NO_BANK_ACCOUNT_DECLINED
    }

    @Test
    public void testMinBalanceDeclined(){
        //assertEquals(); MIN_BALANCE_DECLINED
    }

    @Test
    public void testApproved(){
        //assertEquals(); APPROVED
    }
}