package za.co.entelect.dojo.exceptions;

import za.co.entelect.dojo.enums.ResponseEnum;

public class ValidationException extends RuntimeException {

    private ResponseEnum responseEnum;

    public ValidationException(ResponseEnum aResponseEnum) {
        responseEnum = aResponseEnum;
    }
}
