package za.co.entelect.dojo.services;

import org.junit.Assert;
import org.junit.Test;
import za.co.entelect.dojo.services.ValidationService;
import za.co.entelect.dojo.services.ValidationServiceImpl;


public class ValidationServiceImplTest {

    @Test
    public void testIsValidCardNumber_valid16() throws Exception {
        ValidationService validation = new ValidationServiceImpl();
        String cardNumber = "4388576018410707";
        Assert.assertTrue(validation.isValidCardNumber(cardNumber));
    }

    @Test
    public void testIsValidCardNumber_valid19() throws Exception {
        ValidationService validation = new ValidationServiceImpl();
        String cardNumber = "6304219447607087665";
        Assert.assertTrue(validation.isValidCardNumber(cardNumber));
    }

    @Test
    public void testIsValidCardNumber_invalid16() throws Exception {
        ValidationService validation = new ValidationServiceImpl();
        String cardNumber = "4388576018402626";
        Assert.assertFalse(validation.isValidCardNumber(cardNumber));
    }

}