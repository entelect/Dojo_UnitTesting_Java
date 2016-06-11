package za.co.entelect.dojo.service;

import org.springframework.stereotype.Component;
import za.co.entelect.dojo.enums.ResponseEnum;
import za.co.entelect.dojo.exceptions.ValidationException;

@Component
public class PinServiceImpl implements PinService {

    @Override
    public void validatePin(String pinBlock, String cardNumber) {
        String calculatedPinBlock = "FF" + cardNumber;
        if (!calculatedPinBlock.equals(pinBlock)) {
            throw new ValidationException(ResponseEnum.INVALID_PIN);
        }
    }
}
