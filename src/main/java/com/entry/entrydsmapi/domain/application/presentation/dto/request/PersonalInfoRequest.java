package com.entry.entrydsmapi.domain.application.presentation.dto.request;

import com.entry.entrydsmapi.domain.application.domain.Gender;
import com.entry.entrydsmapi.domain.application.domain.Region;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class PersonalInfoRequest {

    @NotNull(message = "생년월일을 선택해주세요.")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
    private LocalDate birthDate;

    @NotNull(message = "성별을 선택해주세요.")
    private Gender gender;

    @NotNull(message = "지역을 선택해주세요.")
    private Region region;

}
