package za.co.entelect.dojo.util;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ValidationUtilsTest {

    @Test
    public void testInvalidCardNumber(){
        assertFalse(ValidationUtils.isValidCardNumber("5454"));
        assertFalse(ValidationUtils.isValidCardNumber("7987954151321654654844984984"));
        assertFalse(ValidationUtils.isValidCardNumber("NOT_A_NUMBER__:<"));
        assertFalse(ValidationUtils.isValidCardNumber("4498484616416544"));
    }

    @Test
    public void testValidCardNumber(){
       assertTrue(ValidationUtils.isValidCardNumber("4388576019611030"));
       assertTrue(ValidationUtils.isValidCardNumber("4388576019611022"));
       assertTrue(ValidationUtils.isValidCardNumber("5388576018900076"));
       assertTrue(ValidationUtils.isValidCardNumber("5388576018900084"));
    }

    @Test
    public void testInvalidExpirationDate(){
        assertFalse(ValidationUtils.isValidExpirationDate("YYMM"));
        assertFalse(ValidationUtils.isValidExpirationDate("1"));
        assertFalse(ValidationUtils.isValidExpirationDate("12345"));
        assertFalse(ValidationUtils.isValidExpirationDate("0016"));
        assertFalse(ValidationUtils.isValidExpirationDate("1300"));
    }

    @Test
    public void testValidExpirationDate(){
        assertTrue(ValidationUtils.isValidExpirationDate("1501"));
        assertTrue(ValidationUtils.isValidExpirationDate("1612"));
        assertTrue(ValidationUtils.isValidExpirationDate("1905"));
        assertTrue(ValidationUtils.isValidExpirationDate("1901"));
    }
}