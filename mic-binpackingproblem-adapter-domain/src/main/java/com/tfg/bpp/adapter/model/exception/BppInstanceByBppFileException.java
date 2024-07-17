package com.tfg.bpp.adapter.model.exception;

import lombok.Getter;

@Getter
public abstract class BppInstanceByBppFileException extends BppException{

    private final int errorLine;

    protected BppInstanceByBppFileException(String message, int errorLine) {
        super(message);
        this.errorLine = errorLine;
    }

    protected BppInstanceByBppFileException(String message, Exception exception, int errorLine) {
        super(message, exception);
        this.errorLine = errorLine;
    }

    public abstract ErrorType getErrorConstant();
}
