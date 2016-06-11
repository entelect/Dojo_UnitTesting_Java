package za.co.entelect.dojo.service;

import za.co.entelect.dojo.ex3.enums.ResponseEnum;
import za.co.entelect.dojo.exceptions.ValidationException;

public class PinServiceImpl implements PinService {

    @Override
    public void validatePin(String pinBlock, String cardNumber) {
        String calculatedPinBlock = "FF" + cardNumber;
        if (!calculatedPinBlock.equals(pinBlock)) {
            throw new ValidationException(ResponseEnum.INVALID_PIN);
        }
    }
}
