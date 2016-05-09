package za.co.entelect.dojo.validation.enums;

public enum ResponseEnum {
    TRACK2_INVALID_LENGTH("01", "Track 2 data is too short or too long"),
    INVALID_CARD("02", "Invalid card number received"),
    INVALID_EXP_DATE("03", "Invalid expiry date"),
    INVALID_SERVICE_CODE("04", "Invalid service code");

    private String code;
    private String message;

    private ResponseEnum(String aCode, String aMessage) {
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
