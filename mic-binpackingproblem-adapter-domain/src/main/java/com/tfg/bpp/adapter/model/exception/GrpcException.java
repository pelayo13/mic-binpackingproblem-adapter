package com.tfg.bpp.adapter.model.exception;

import lombok.Getter;

@Getter
public class GrpcException extends BppException{

    private final ErrorType grpcErrorType;

    public GrpcException(String message, ErrorType grpcErrorType) {
        super(String.format("%s %s", grpcErrorType.getKey(), message));
        this.grpcErrorType = grpcErrorType;
    }

    public GrpcException(String message, Exception exception, ErrorType grpcErrorType) {
        super(String.format("%s %s", grpcErrorType.getKey(), message), exception);
        this.grpcErrorType = grpcErrorType;
    }

    @Override
    public ErrorType getErrorConstant() {
        return this.grpcErrorType;
    }
}
