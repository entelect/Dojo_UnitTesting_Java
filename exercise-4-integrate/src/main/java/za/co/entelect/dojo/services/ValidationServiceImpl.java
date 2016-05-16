package za.co.entelect.dojo.services;

import org.springframework.stereotype.Component;
import za.co.entelect.dojo.enums.ResponseEnum;
import za.co.entelect.dojo.exceptions.ValidationException;

@Component
public class ValidationServiceImpl implements ValidationService {

    int[][] serviceCodeValues = new int[][]{
            {1,2,5,6,7,9},
            {0,2,4},
            {0,1,2,3,4,5,6,7}
    };

    @Override
    public boolean isValidCardNumber(String ccNumber) {
        int sum = 0;
        boolean alternate = false;

        if (ccNumber.length() > 19 || ccNumber.length() < 9) {
            return false;
        }

        for (int i = ccNumber.length() - 1; i >= 0; i--) {
            int n = Integer.parseInt(ccNumber.substring(i, i + 1));
            if (alternate) {
                n = n*2;
                if (n > 9) {
                    n = (n % 10) + 1;
                }
            }
            sum += n;
            alternate = !alternate;
        }
        return (sum % 10 == 0);
    }

    /**
     * @todo Implement this method according to the spec found in Track2Data_Spec
     * @param trackData - The in-theory un-altered track2 data as read from the card
     */
    @Override
    public void validateTrackData(String trackData) {
        if (trackData.length() != 23) {
            throw new ValidationException(ResponseEnum.TRACK2_INVALID_LENGTH);
        }
        String cardNumber = trackData.substring(0,16);
        if (!isValidCardNumber(cardNumber)) {
            throw new ValidationException(ResponseEnum.INVALID_CARD);
        }
        String expDate = trackData.substring(16,20);
        if (!validateExpiryDate(expDate)) {
            throw new ValidationException(ResponseEnum.INVALID_EXP_DATE);
        }
        String serviceCode = trackData.substring(20,23);
        if (!isValidServiceCode(serviceCode)) {
            throw new ValidationException(ResponseEnum.INVALID_SERVICE_CODE);
        }
    }

    private boolean validateExpiryDate(String expDate) {
        if (expDate.length() != 4) {
            return false;
        }

        int mm = Integer.parseInt(expDate.substring(2,4));
        return !(mm < 1 || mm > 12);
    }

    private boolean isValidServiceCode(String serviceCode) {

        if (serviceCode.length() != 3) {
            return false;
        }

        for(int i = 0; i < 3; i++) {
            int n = Integer.parseInt(serviceCode.substring(i,i+1));
            int[] validValues = serviceCodeValues[i];
            boolean needle = false;
            for (int k = 0; k < validValues.length; k++) {
                if (n == validValues[k]) {
                    needle = true;
                }
            }
            if (!needle) {
                return false;
            }
        }
        return true;
    }
}
