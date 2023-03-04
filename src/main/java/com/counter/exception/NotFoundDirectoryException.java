package com.counter.exception;


public class NotFoundDirectoryException extends RuntimeException {
    public final static Integer code = 601;

    public NotFoundDirectoryException(String msg) {
        super(msg);
    }
}
