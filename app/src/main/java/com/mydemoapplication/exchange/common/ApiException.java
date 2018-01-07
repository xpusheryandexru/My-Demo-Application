package com.mydemoapplication.exchange.common;

/**
 * Created by Kras on 03.01.2018.
 */

public class ApiException extends RuntimeException {

    private int code = 0;

    public ApiException(String message, int code) {
        super(message);
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public ApiException(Throwable cause) {
        super(cause);
    }
}
