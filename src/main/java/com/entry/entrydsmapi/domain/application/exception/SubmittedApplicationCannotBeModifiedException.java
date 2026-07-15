package com.entry.entrydsmapi.domain.application.exception;

public class SubmittedApplicationCannotBeModifiedException extends RuntimeException{
    public SubmittedApplicationCannotBeModifiedException(){
        super("이미 제출 된 지원서는 수정할 수 없습니다.");
    }
}
