package za.co.entelect.dojo.enums;

/**
 *
 */
public enum CardValidationErrorType {

    TRACK2_INVALID_LENGTH("01", "Track 2 data is too short or too long"),
    INVALID_CARD("02", "You do not exist. Go away."),
    INVALID_EXP_DATE("03", "Retirement pending"),
    INVALID_SERVICE_CODE("04", "Invalid service code"),
    INSUFFICIENT_FUNDS("05", "Work harder"),
    INVALID_PIN("06", "Arrest pending");

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
