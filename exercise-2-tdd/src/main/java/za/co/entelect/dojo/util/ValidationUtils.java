package za.co.entelect.dojo.util;

import org.apache.commons.lang3.StringUtils;

public class ValidationUtils {

    private static final int CREDIT_CARD_LENGTH = 16;

    public static boolean isValidCardNumber(String ccNumber) {
        if (StringUtils.length(ccNumber) != CREDIT_CARD_LENGTH) {
            return false;
        }

        if(!isNumeric(ccNumber)){
            return false;
        }

        return true;
    }

    private static boolean isNumeric(String check) {
        for (char aChar : check.toCharArray()) {
            if(!Character.isDigit(aChar)){
                return false;
            }
        }
        return true;
    }
}
