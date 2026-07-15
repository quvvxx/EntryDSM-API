package com.entry.entrydsmapi.domain.user.presentation.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class LoginRequest {

    @NotBlank(message = "전화번호를 입력해주세요.")
    @Pattern(regexp = "^010\\d{8}$",
    message = "전화번호 형식이 올바르지 않습니다.")
    private String phone;

    @NotBlank(message = "비밀번호를 입력해주세요.")
    private String password;
}
