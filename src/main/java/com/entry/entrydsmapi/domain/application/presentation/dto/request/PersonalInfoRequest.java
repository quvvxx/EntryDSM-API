package com.entry.entrydsmapi.domain.application.presentation.dto.request;

import com.entry.entrydsmapi.domain.application.domain.Gender;
import com.entry.entrydsmapi.domain.application.domain.Region;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import java.time.LocalDate;

@Getter
@Builder
public class PersonalInfoRequest {

    @NotNull(message = "생년월일을 선택해주세요.")
    private LocalDate birthDate;

    @NotNull(message = "성별을 선택해주세요.")
    private Gender gender;

    @NotNull(message = "지역을 선택해주세요.")
    private Region region;

}
