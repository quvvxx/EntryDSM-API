package com.entry.entrydsmapi.global.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SuccessResponse {

    private String code;
    private String message;
}
