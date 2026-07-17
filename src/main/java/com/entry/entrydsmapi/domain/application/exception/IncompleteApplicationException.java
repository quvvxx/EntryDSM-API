package com.entry.entrydsmapi.domain.application.exception;

public class IncompleteApplicationException extends RuntimeException{
    public IncompleteApplicationException(){
        super("필수 항목을 모두 작성해야 지원서를 제출할 수 있습니다.");
    }
}
