package za.co.entelect.dojo.service;

import org.junit.Test;
import za.co.entelect.dojo.enums.ResponseEnum;
import za.co.entelect.dojo.exceptions.ValidationException;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import static junit.framework.Assert.fail;

public class Track2DataServiceTest {

    private static final String VALID_CARD_NUMBER_1 = "4388576019611022";
    private static final String VALID_CARD_NUMBER_2 = "5388576018900076";
    private static final String INVALID_CARD_NUMBER = "4498484616416544";
    private static final String VALID_EXP_DATE = "0116";
    private static final String INVALID_VALID_EXP_DATE = "1316";
    private static final String INVALID_SERVICE_CODE = "589";
    private static final String VALID_SERVICE_CODE = "542";

    private Track2DataService service = new Track2DataService();

    @Test
    public void testNumberTooShort(){
        checkForException("TOOSHORT", "Expected invalid length", ResponseEnum.TRACK2_INVALID_LENGTH);
    }

    @Test
    public void testNumberTooLong(){
        checkForException("TOOOOOOOOOOOOOOOOOOOOOLong", "Expected invalid length", ResponseEnum.TRACK2_INVALID_LENGTH);
    }

    @Test
    public void testInvalidCardNumber(){
        checkForException(INVALID_CARD_NUMBER + VALID_EXP_DATE + VALID_SERVICE_CODE, "Expected a invalid card number", ResponseEnum.INVALID_CARD);
    }

    @Test
    public void testInvalidExpDate(){
        checkForException(VALID_CARD_NUMBER_1 + INVALID_VALID_EXP_DATE + INVALID_SERVICE_CODE, "Expected invalid expiration date", ResponseEnum.INVALID_EXP_DATE);
    }

    @Test
    public void testInvalidServiceCode(){
        checkForException(VALID_CARD_NUMBER_2 + VALID_EXP_DATE + INVALID_SERVICE_CODE, "Expected invalid invalid service code", ResponseEnum.INVALID_SERVICE_CODE);
    }

    @Test
    public void testValidTrack2Number(){
        assertTrue(service.isValid(VALID_CARD_NUMBER_1 + VALID_EXP_DATE + VALID_SERVICE_CODE));
        assertTrue(service.isValid(VALID_CARD_NUMBER_2 + VALID_EXP_DATE + VALID_SERVICE_CODE));
    }

    private void checkForException(String track2Number, String message, ResponseEnum expectedResponseEnum) {
        try{
            service.isValid(track2Number);
            fail(message);
        }catch(ValidationException e){
            assertEquals(expectedResponseEnum, e.getResponseEnum());
        }
    }

}
