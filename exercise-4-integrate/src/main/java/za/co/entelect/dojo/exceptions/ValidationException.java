package za.co.entelect.dojo.exceptions;

import za.co.entelect.dojo.enums.CardValidationErrorType;

public class ValidationException extends RuntimeException {

    private CardValidationErrorType cardValidationErrorType;

    public ValidationException(CardValidationErrorType aCardValidationErrorType) {
        cardValidationErrorType = aCardValidationErrorType;
    }
}
