package com.photon.exam.model;

import static com.photon.exam.util.Constants.ERROR_CODE;

public class ErrorResponse extends Response {

    public ErrorResponse(String message) {
        super(ERROR_CODE, message);
    }
}
