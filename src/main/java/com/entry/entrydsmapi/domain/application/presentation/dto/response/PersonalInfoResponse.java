package com.entry.entrydsmapi.domain.application.presentation.dto.response;

import com.entry.entrydsmapi.domain.application.domain.Gender;
import com.entry.entrydsmapi.domain.application.domain.Region;
import lombok.Builder;
import lombok.Getter;
import java.time.LocalDate;

@Getter
@Builder
public class PersonalInfoResponse {

    private LocalDate birthDate;
    private String applicantName;
    private Gender gender;
    private Region region;

}
