package za.co.entelect.dojo.exceptions;


import za.co.entelect.dojo.enums.ResponseEnum;

public class ValidationException extends RuntimeException {

    private final ResponseEnum responseEnum;

    public ValidationException(ResponseEnum aResponseEnum) {
        responseEnum = aResponseEnum;
    }

    public ResponseEnum getResponseEnum() {
        return responseEnum;
    }
}