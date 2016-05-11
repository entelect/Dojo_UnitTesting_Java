package za.co.entelect.dojo.exceptions;

import za.co.entelect.dojo.enums.ResponseEnum;

public class AccountException extends RuntimeException {
    ResponseEnum responseEnum;

    public AccountException(ResponseEnum aResponseEnum) {
        super();
        responseEnum = aResponseEnum;
    }

    public ResponseEnum getResponseEnum() {
        return responseEnum;
    }
}
