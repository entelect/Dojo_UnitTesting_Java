package za.co.entelect.dojo.validation.exceptions;

import za.co.entelect.dojo.validation.enums.ResponseEnum;

public class ValidationException extends RuntimeException {
    ResponseEnum responseEnum;

    public ValidationException(ResponseEnum aResponseEnum) {
        super();
        responseEnum = aResponseEnum;
    }
}
