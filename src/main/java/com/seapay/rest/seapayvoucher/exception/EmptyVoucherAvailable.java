package com.seapay.rest.seapayvoucher.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class EmptyVoucherAvailable extends RuntimeException {
    private static final long serialVersionUID = -3916525550413865316L;


    public EmptyVoucherAvailable() {
        super();
    }

    public EmptyVoucherAvailable(String message) {
        super(message);
    }

    public EmptyVoucherAvailable(String message, Throwable cause) {
        super(message, cause);
    }
}
