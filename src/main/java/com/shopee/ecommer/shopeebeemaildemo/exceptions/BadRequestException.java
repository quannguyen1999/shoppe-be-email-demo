package com.shopee.ecommer.shopeebeemaildemo.exceptions;

import com.shopee.ecommer.shopeebeemaildemo.constants.MessageErrors;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequestException extends RuntimeException {

    public BadRequestException(MessageErrors exception) {
        super(exception.toString());
    }

}