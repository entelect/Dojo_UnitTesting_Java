package za.co.entelect.dojo.exceptions;

import za.co.entelect.dojo.enums.CardValidationErrorType;

public class AccountException extends RuntimeException {

    private CardValidationErrorType cardValidationErrorType;

    public AccountException(CardValidationErrorType aCardValidationErrorType) {
        cardValidationErrorType = aCardValidationErrorType;
    }

    public CardValidationErrorType getCardValidationErrorType() {
        return cardValidationErrorType;
    }
}
