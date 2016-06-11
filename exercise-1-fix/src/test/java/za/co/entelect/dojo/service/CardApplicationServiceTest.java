package za.co.entelect.dojo.service;

import org.junit.Test;
import za.co.entelect.dojo.domain.BankAccount;
import za.co.entelect.dojo.enums.CardApplicationResult;

import static junit.framework.TestCase.assertEquals;

public class CardApplicationServiceTest {

    private static final boolean UNEMPLOYED = false;
    private static final boolean EMPLOYED = true;

    private static final BankAccount TEST_BANK_ACCOUNT_BALANCE_4999 = new BankAccount(4999_49);
    private static final BankAccount TEST_BANK_ACCOUNT_BALANCE_5000 = new BankAccount(5000_00);
    private static final BankAccount TEST_BANK_ACCOUNT_BALANCE_10000 = new BankAccount(10_000_00);
    private static final BankAccount TEST_BANK_ACCOUNT_BALANCE_NEGATIVE_1 = new BankAccount(-100);
    private static final BankAccount TEST_BANK_ACCOUNT_BALANCE_LOADED = new BankAccount(1_000_000_00);

    private CardApplicationService cardApplicationService = new CardApplicationServiceImpl();

    @Test
    public void testNoBankAccountDeclined(){
        assertEquals("Expected NO_BANK_ACCOUNT_DECLINED",
                CardApplicationResult.NO_BANK_ACCOUNT_DECLINED,
                cardApplicationService.applyForCreditCard(EMPLOYED, null));

        assertEquals("Expected NO_BANK_ACCOUNT_DECLINED",
                CardApplicationResult.NO_BANK_ACCOUNT_DECLINED,
                cardApplicationService.applyForCreditCard(EMPLOYED));
    }

    @Test
    public void testUnemployedOverdraftDeclined(){
        assertEquals(CardApplicationResult.UNEMPLOYED_OVERDRAFT_DECLINED,
                cardApplicationService.applyForCreditCard(UNEMPLOYED,
                        TEST_BANK_ACCOUNT_BALANCE_NEGATIVE_1, TEST_BANK_ACCOUNT_BALANCE_LOADED));
    }

    @Test
    public void testEmployedToManyAccountsInOverdraft(){
        assertEquals(CardApplicationResult.EMPLOYED_OVERDRAFT_DECLINED,
                cardApplicationService.applyForCreditCard(EMPLOYED,
                        TEST_BANK_ACCOUNT_BALANCE_NEGATIVE_1, TEST_BANK_ACCOUNT_BALANCE_NEGATIVE_1, TEST_BANK_ACCOUNT_BALANCE_10000));

        assertEquals(CardApplicationResult.EMPLOYED_OVERDRAFT_DECLINED,
                cardApplicationService.applyForCreditCard(EMPLOYED,
                        TEST_BANK_ACCOUNT_BALANCE_NEGATIVE_1, TEST_BANK_ACCOUNT_BALANCE_NEGATIVE_1, TEST_BANK_ACCOUNT_BALANCE_LOADED));
    }

    @Test
    public void testUnemployedMinBalanceDeclined(){
        assertEquals(CardApplicationResult.MIN_BALANCE_DECLINED,
                cardApplicationService.applyForCreditCard(UNEMPLOYED,
                        TEST_BANK_ACCOUNT_BALANCE_5000));

        assertEquals(CardApplicationResult.MIN_BALANCE_DECLINED,
                cardApplicationService.applyForCreditCard(UNEMPLOYED,
                        TEST_BANK_ACCOUNT_BALANCE_5000, TEST_BANK_ACCOUNT_BALANCE_4999));
    }

    @Test
    public void testEmployedMinBalanceDeclined(){
        assertEquals(CardApplicationResult.MIN_BALANCE_DECLINED,
                cardApplicationService.applyForCreditCard(EMPLOYED,
                        TEST_BANK_ACCOUNT_BALANCE_4999));

        assertEquals(CardApplicationResult.MIN_BALANCE_DECLINED,
                cardApplicationService.applyForCreditCard(EMPLOYED,
                        TEST_BANK_ACCOUNT_BALANCE_5000, TEST_BANK_ACCOUNT_BALANCE_NEGATIVE_1));
    }

    @Test
    public void testUnEmployedApproved(){
        assertEquals(CardApplicationResult.APPROVED,
                cardApplicationService.applyForCreditCard(UNEMPLOYED,
                        TEST_BANK_ACCOUNT_BALANCE_5000, TEST_BANK_ACCOUNT_BALANCE_5000));

        assertEquals(CardApplicationResult.APPROVED,
                cardApplicationService.applyForCreditCard(UNEMPLOYED,
                        TEST_BANK_ACCOUNT_BALANCE_10000));
    }

    @Test
    public void testEmployedApproved(){
        assertEquals(CardApplicationResult.APPROVED,
                cardApplicationService.applyForCreditCard(EMPLOYED,
                        TEST_BANK_ACCOUNT_BALANCE_5000));

        assertEquals(CardApplicationResult.APPROVED,
                cardApplicationService.applyForCreditCard(EMPLOYED,
                        TEST_BANK_ACCOUNT_BALANCE_NEGATIVE_1, TEST_BANK_ACCOUNT_BALANCE_5000, TEST_BANK_ACCOUNT_BALANCE_4999));
    }

}