package za.co.entelect.dojo.service;

import org.junit.Test;
import za.co.entelect.dojo.enums.ResponseEnum;
import za.co.entelect.dojo.exceptions.ValidationException;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import static junit.framework.Assert.fail;

public class Track2DataServiceTest {

    private static final String INVALID_CARD_NUMBER = "49299002814036421603101";
    private static final String INVALID_DATE = "49299004814036421699101";
    private static final String INVALID_SERVICE_CODE = "49299004814036421603850";
    private static final String VALID = "49299004814036421603101";

    private Track2DataService service = new Track2DataService();

    @Test
    public void testNumberTooShort(){
        checkForException("TOOSHORT", "No invalid length", ResponseEnum.TRACK2_INVALID_LENGTH);
    }

    @Test
    public void testNumberTooLong(){
        checkForException("TOOOOOOOOOOOOOOOOOOOOOLong", "No invalid length", ResponseEnum.TRACK2_INVALID_LENGTH);
    }

    @Test
    public void testInvalidCardNumber(){
        checkForException(INVALID_CARD_NUMBER, "Not a valid card number", ResponseEnum.INVALID_CARD);
    }

    @Test
    public void testInvalidExpDate(){
        checkForException(INVALID_DATE, "No a valid date", ResponseEnum.INVALID_EXP_DATE);
    }

    @Test
    public void testInvalidServiceCode(){
        checkForException(INVALID_SERVICE_CODE, "No invalid service code", ResponseEnum.INVALID_SERVICE_CODE);
    }

    @Test
    public void testValidTrack2Number(){
        assertTrue(service.isValid(VALID));
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
