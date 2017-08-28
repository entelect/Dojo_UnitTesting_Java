package za.co.entelect.dojo.util;

import org.apache.commons.lang3.StringUtils;

public class ValidationUtils {

    private static final int CREDIT_CARD_LENGTH = 16;
    public static final int DEC = 12;
    public static final int JAN = 1;
    public static final int EXPIRY_DATE_LENGTH = 4;

    public static boolean isValidCardNumber(String ccNumber) {
        if (StringUtils.length(ccNumber) != CREDIT_CARD_LENGTH) {
            return false;
        }

        if(!isNumeric(ccNumber)){
            return false;
        }

        return true;
    }

    public static boolean isValidExpirationDate(String dateString) {
        if(StringUtils.length(dateString) != EXPIRY_DATE_LENGTH){
            return false;
        }

        if (!isNumeric(dateString)) {
            return false;
        }

        Integer month = Integer.valueOf(dateString.substring(2, 4));

        return month >= JAN && month <= DEC;
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
