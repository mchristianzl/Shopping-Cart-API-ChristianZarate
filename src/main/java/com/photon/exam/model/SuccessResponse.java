package com.photon.exam.model;

import static com.photon.exam.util.Constants.SUCCESS_CODE;

public class SuccessResponse extends Response {

    public SuccessResponse(String message) {
        super(SUCCESS_CODE, message);
    }

}
