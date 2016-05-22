package za.co.entelect.dojo.exceptions;

import za.co.entelect.dojo.ex3.enums.ResponseEnum;

public class AccountException extends RuntimeException {
    ResponseEnum responseEnum;

    public AccountException(ResponseEnum aResponseEnum) {
        responseEnum = aResponseEnum;
    }

    public ResponseEnum getResponseEnum() {
        return responseEnum;
    }
}
