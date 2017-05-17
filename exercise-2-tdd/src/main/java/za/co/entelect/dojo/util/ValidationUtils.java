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

        int sum = 0;
        boolean alternate = false;

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


    private static boolean isNumeric(String check) {
        for (char aChar : check.toCharArray()) {
            if(!Character.isDigit(aChar)){
                return false;
            }
        }
        return true;
    }
}
