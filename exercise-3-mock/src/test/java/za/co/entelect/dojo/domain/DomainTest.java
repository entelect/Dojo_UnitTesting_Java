package za.co.entelect.dojo.domain;

import org.junit.Test;
import za.co.entelect.dojo.enums.CardValidationErrorType;
import za.co.entelect.dojo.exceptions.ValidationException;

import static junit.framework.Assert.*;
import static junit.framework.TestCase.assertFalse;

public class DomainTest {

    @Test
    public void testPositiveBalance() {
        BankAccount bankAccountNegative = new BankAccount(-100);
        assertFalse(bankAccountNegative.hasPositiveBalance());

        BankAccount bankAccountPositive = new BankAccount(10);
        assertTrue(bankAccountPositive.hasPositiveBalance());
        assertNotNull(bankAccountPositive.toString());
    }

    @Test
    public void testException() {
        ValidationException exception = new ValidationException(CardValidationErrorType.TRACK2_INVALID_LENGTH);
        assertEquals(CardValidationErrorType.TRACK2_INVALID_LENGTH, exception.getCardValidationErrorType());
    }
}