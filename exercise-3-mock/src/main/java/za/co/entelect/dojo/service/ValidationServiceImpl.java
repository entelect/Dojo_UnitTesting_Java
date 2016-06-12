package za.co.entelect.dojo.service;

import za.co.entelect.dojo.ex3.enums.CardValidationErrorType;
import za.co.entelect.dojo.exceptions.ValidationException;

public class ValidationServiceImpl implements ValidationService {

    private static final int JAN = 1;
    private static final int DEC = 12;
    private static final int SERVICE_CODE_LENGTH = 3;
    private static final int CARD_NUMBER_BEGIN_INDEX = 0;
    private static final int CARD_NUMBER_END_INDEX = 16;
    private static final int EXPIRY_DATE_END_INDEX = 20;
    private static final int SERVICE_CODE_END_INDEX = 23;

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
            throw new ValidationException(CardValidationErrorType.TRACK2_INVALID_LENGTH);
        }
        String cardNumber = trackData.substring(CARD_NUMBER_BEGIN_INDEX, CARD_NUMBER_END_INDEX);
        if (!isValidCardNumber(cardNumber)) {
            throw new ValidationException(CardValidationErrorType.INVALID_CARD);
        }
        String expDate = trackData.substring(CARD_NUMBER_END_INDEX, EXPIRY_DATE_END_INDEX);
        if (!validateExpiryDate(expDate)) {
            throw new ValidationException(CardValidationErrorType.INVALID_EXP_DATE);
        }
        String serviceCode = trackData.substring(EXPIRY_DATE_END_INDEX, SERVICE_CODE_END_INDEX);
        if (!isValidServiceCode(serviceCode)) {
            throw new ValidationException(CardValidationErrorType.INVALID_SERVICE_CODE);
        }
    }

    private boolean validateExpiryDate(String expDate) {
        if (expDate.length() != 4) {
            return false;
        }

        int mm = Integer.parseInt(expDate.substring(2,4));
        return !(mm < JAN || mm > DEC);
    }

    private boolean isValidServiceCode(String serviceCode) {

        if (serviceCode.length() != SERVICE_CODE_LENGTH) {
            return false;
        }

        for(int i = 0; i < SERVICE_CODE_LENGTH; i++) {
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
