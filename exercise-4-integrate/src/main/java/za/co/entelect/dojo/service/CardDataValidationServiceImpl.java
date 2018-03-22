package za.co.entelect.dojo.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import za.co.entelect.dojo.enums.CardValidationErrorType;
import za.co.entelect.dojo.exceptions.ValidationException;
import za.co.entelect.dojo.util.ValidationUtils;

@Component
public class CardDataValidationServiceImpl implements CardDataValidationService {

    private static final int CARD_END_INDEX = 16;
    private static final int CARD_DATA_LENGTH = 20;
    private static final int MONTH_START = 16;
    private static final int MONTH_END = 20;

    @Override
    public boolean isValid(String creditCardNumber) {

        if(StringUtils.length(creditCardNumber) != CARD_DATA_LENGTH){
            throw new ValidationException(CardValidationErrorType.CARD_DATA_INVALID_LENGTH);
        }
        if(!ValidationUtils.isValidCardNumber(creditCardNumber.substring(0, CARD_END_INDEX))){
            throw new ValidationException(CardValidationErrorType.INVALID_CARD);
        }
        if(!ValidationUtils.isValidExpirationDate(creditCardNumber.substring(MONTH_START, MONTH_END))){
            throw new ValidationException(CardValidationErrorType.INVALID_EXP_DATE);
        }

        return true;
    }
}
