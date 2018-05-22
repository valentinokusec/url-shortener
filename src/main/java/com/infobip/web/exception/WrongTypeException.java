
package com.infobip.web.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.BAD_REQUEST, reason="Wrong HTTP type")  // 404
public class WrongTypeException extends RuntimeException {
}