package com.entry.entrydsmapi.domain.application.exception;

public class ApplicationNotFoundException extends RuntimeException{
    public ApplicationNotFoundException(){
        super("해당 지원서가 존재하지 않습니다.");
    }
}
