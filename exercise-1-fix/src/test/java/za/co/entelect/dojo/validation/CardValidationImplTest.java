package za.co.entelect.dojo.validation;

import org.junit.Assert;
import org.junit.Test;


public class CardValidationImplTest {

    @Test
    public void testIsValidCardNumber_valid16() throws Exception {
        CardValidation validation = new CardValidationImpl();
        String cardNumber = "4388576018410707";
        Assert.assertTrue(validation.isValidCardNumber(cardNumber));
    }

    @Test
    public void testIsValidCardNumber_valid19() throws Exception {
        CardValidation validation = new CardValidationImpl();
        String cardNumber = "6304219447607087665";
        Assert.assertTrue(validation.isValidCardNumber(cardNumber));
    }

    @Test
    public void testIsValidCardNumber_invalid16() throws Exception {
        CardValidation validation = new CardValidationImpl();
        String cardNumber = "4388576018402626";
        Assert.assertFalse(validation.isValidCardNumber(cardNumber));
    }
}