package za.co.entelect.dojo.service;

import org.junit.Assert;
import org.junit.Test;


public class ValidationServiceImplTest {

    private static final String VALID_CARD_NUMBER_1 = "4388576018410707";
    private static final String VALID_CARD_NUMBER_2 = "6304219447607087665";
    private static final String INVALID_CARD_NUMBER = "4388576018402626";

    @Test
    public void testIsValidCardNumber_valid16() throws Exception {
        ValidationService validation = new ValidationServiceImpl();
        Assert.assertTrue(validation.isValidCardNumber(VALID_CARD_NUMBER_1));
    }

    @Test
    public void testIsValidCardNumber_valid19() throws Exception {
        ValidationService validation = new ValidationServiceImpl();
        Assert.assertTrue(validation.isValidCardNumber(VALID_CARD_NUMBER_2));
    }

    @Test
    public void testIsValidCardNumber_invalid16() throws Exception {
        ValidationService validation = new ValidationServiceImpl();
        Assert.assertFalse(validation.isValidCardNumber(INVALID_CARD_NUMBER));
    }

}