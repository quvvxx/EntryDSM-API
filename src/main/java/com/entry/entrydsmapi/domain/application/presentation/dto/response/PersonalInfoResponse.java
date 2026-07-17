package com.entry.entrydsmapi.domain.application.presentation.dto.response;

import com.entry.entrydsmapi.domain.application.domain.Gender;
import com.entry.entrydsmapi.domain.application.domain.Region;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Getter;
import java.time.LocalDate;

@Builder
@Getter
public class PersonalInfoResponse {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
    private LocalDate birthDate;
    private String applicantName;
    private Gender gender;
    private Region region;

}
