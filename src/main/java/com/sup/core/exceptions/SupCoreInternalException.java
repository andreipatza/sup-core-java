package com.sup.core.exceptions;

import lombok.Getter;

@Getter
public class SupCoreInternalException extends RuntimeException {

    public SupCoreInternalException(String message) {
        super(message);
    }

    public SupCoreInternalException(String message, Object... arguments) {
        super(String.format(message, arguments));
    }

    public SupCoreInternalException(Throwable cause, String message, Object... arguments) {
        super(String.format(message, arguments), cause);
    }

}
