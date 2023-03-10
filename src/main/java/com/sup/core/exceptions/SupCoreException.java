package com.sup.core.exceptions;

import org.springframework.http.HttpStatus;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class SupCoreException extends SupCoreInternalException {

    HttpStatus status;

    public SupCoreException(HttpStatus status, String message) {
        super(message);
        this.status = status;
    }

    public SupCoreException(HttpStatus status, String message, Object... arguments) {
        super(String.format(message, arguments));
        this.status = status;
    }

}
