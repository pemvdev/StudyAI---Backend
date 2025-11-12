package com.ziros.studyAI.exception;

public class InvalidCredentialsException extends RuntimeException {
    public InvalidCredentialsException() {
        super("Email ou senha Inválidos");
    }
}
