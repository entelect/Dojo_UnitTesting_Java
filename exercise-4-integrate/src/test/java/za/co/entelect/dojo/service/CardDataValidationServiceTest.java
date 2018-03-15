package za.co.entelect.dojo.service;

import org.junit.Test;
import za.co.entelect.dojo.enums.CardValidationErrorType;
import za.co.entelect.dojo.exceptions.ValidationException;

import static junit.framework.Assert.assertTrue;
import static junit.framework.Assert.fail;
import static org.junit.Assert.assertEquals;

public class CardDataValidationServiceTest {

    private static final String VALID_CARD_NUMBER_1 = "4388576019611022";
    private static final String VALID_CARD_NUMBER_2 = "5388576018900076";
    private static final String VALID_EXP_DATE = "1601";
    private static final String INVALID_VALID_EXP_DATE = "1316";

    private CardDataValidationService service = new CardDataValidationServiceImpl();

    @Test
    public void testNumberTooShort(){
        checkForException("TOOSHORT", "Expected invalid length", CardValidationErrorType.CARD_DATA_INVALID_LENGTH);
    }

    @Test
    public void testNumberTooLong(){
        checkForException("TOOOOOOOOOOOOOOOOOOOOOLong", "Expected invalid length", CardValidationErrorType.CARD_DATA_INVALID_LENGTH);
    }

    @Test
    public void testInvalidExpDate(){
        checkForException(VALID_CARD_NUMBER_1 + INVALID_VALID_EXP_DATE, "Expected invalid expiration date", CardValidationErrorType.INVALID_EXP_DATE);
    }

    @Test
    public void testValidCardData(){
        assertTrue(service.isValid(VALID_CARD_NUMBER_1 + VALID_EXP_DATE));
        assertTrue(service.isValid(VALID_CARD_NUMBER_2 + VALID_EXP_DATE));
    }

    private void checkForException(String cardData, String message, CardValidationErrorType expectedCardValidationErrorType) {
        try{
            service.isValid(cardData);
            fail(message);
        }catch(ValidationException e){
            assertEquals(expectedCardValidationErrorType, e.getCardValidationErrorType());
        }
    }
}