package com.entry.entrydsmapi.domain.application.presentation.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PersonalStatementRequest {

    @NotBlank(message = "자기소개서를 작성해주세요.")
    @Size(max = 1600, message = "자기소개서는 1600자 이하로 작성해야 합니다.")
    private String personalStatement;

}
