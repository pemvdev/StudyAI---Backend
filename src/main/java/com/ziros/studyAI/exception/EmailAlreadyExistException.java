package com.ziros.studyAI.exception;

public class EmailAlreadyExistException extends RuntimeException{

    public EmailAlreadyExistException(String email){
        super("O email '" + email + "' já está em uso.");
    }
}
