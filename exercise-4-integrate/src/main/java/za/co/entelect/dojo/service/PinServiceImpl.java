package za.co.entelect.dojo.service;

import org.springframework.stereotype.Component;
import za.co.entelect.dojo.enums.CardValidationErrorType;
import za.co.entelect.dojo.exceptions.ValidationException;

@Component
public class PinServiceImpl implements PinService {

    @Override
    public void validatePin(String pinBlock, String cardNumber) {
        String calculatedPinBlock = "FF" + cardNumber;
        if (!calculatedPinBlock.equals(pinBlock)) {
            throw new ValidationException(CardValidationErrorType.INVALID_PIN);
        }
    }
}
