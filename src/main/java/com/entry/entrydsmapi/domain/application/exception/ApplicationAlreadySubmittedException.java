package com.entry.entrydsmapi.domain.application.exception;

public class ApplicationAlreadySubmittedException extends RuntimeException{
    public ApplicationAlreadySubmittedException(){
        super("이미 제출된 지원서 입니다.");
    }
}
