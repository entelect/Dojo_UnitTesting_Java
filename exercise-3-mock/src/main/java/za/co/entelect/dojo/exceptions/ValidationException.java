package za.co.entelect.dojo.exceptions;

import za.co.entelect.dojo.enums.ResponseEnum;

public class ValidationException extends RuntimeException {
    ResponseEnum responseEnum;

    public ValidationException(ResponseEnum aResponseEnum) {
        super();
        responseEnum = aResponseEnum;
    }
}
