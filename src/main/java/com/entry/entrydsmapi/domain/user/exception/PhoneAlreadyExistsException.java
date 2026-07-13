package com.entry.entrydsmapi.domain.user.exception;

public class PhoneAlreadyExistsException extends RuntimeException{
    public PhoneAlreadyExistsException(){
        super("이미 사용중인 전화번호 입니다.");
    }
}
