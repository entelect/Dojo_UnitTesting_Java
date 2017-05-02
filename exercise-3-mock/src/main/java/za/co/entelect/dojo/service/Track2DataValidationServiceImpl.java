package za.co.entelect.dojo.service;

import org.apache.commons.lang3.StringUtils;
import za.co.entelect.dojo.enums.CardValidationErrorType;
import za.co.entelect.dojo.exceptions.ValidationException;
import za.co.entelect.dojo.util.ValidationUtils;


public class Track2DataValidationServiceImpl implements Track2DataValidationService {

    private static final int CARD_END_INDEX = 16;
    private static final int TRACK2_LENGTH = 20;
    private static final int MONTH_START = 16;
    private static final int MONTH_END = 20;

    @Override
    public boolean isValid(String track2Number) {

        if(StringUtils.length(track2Number) != TRACK2_LENGTH){
            throw new ValidationException(CardValidationErrorType.TRACK2_INVALID_LENGTH);
        }
        if(!ValidationUtils.isValidCardNumber(track2Number.substring(0, CARD_END_INDEX))){
            throw new ValidationException(CardValidationErrorType.INVALID_CARD);
        }
        if(!ValidationUtils.isValidExpirationDate(track2Number.substring(MONTH_START, MONTH_END))){
            throw new ValidationException(CardValidationErrorType.INVALID_EXP_DATE);
        }

        return true;
    }
}
