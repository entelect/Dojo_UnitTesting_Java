package za.co.entelect.dojo.enums;

/**
 *
 */
public enum CardValidationErrorType {

    CC_DATA_INVALID_LENGTH("01", "Credit Card data is too short or too long"),
    INVALID_CARD("02", "Invalid card number received"),
    INVALID_EXP_DATE("03", "Invalid expiry date");

    private String code;
    private String message;

    private CardValidationErrorType(String aCode, String aMessage) {
        code = aCode;
        message = aMessage;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
