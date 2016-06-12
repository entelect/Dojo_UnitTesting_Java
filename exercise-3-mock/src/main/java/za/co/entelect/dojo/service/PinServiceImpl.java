package za.co.entelect.dojo.service;

import za.co.entelect.dojo.ex3.enums.CardValidationErrorType;
import za.co.entelect.dojo.exceptions.ValidationException;

public class PinServiceImpl implements PinService {

    @Override
    public void validatePin(String pinBlock, String cardNumber) {
        String calculatedPinBlock = "FF" + cardNumber;
        if (!calculatedPinBlock.equals(pinBlock)) {
            throw new ValidationException(CardValidationErrorType.INVALID_PIN);
        }
    }
}
