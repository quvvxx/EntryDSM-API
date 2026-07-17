package com.entry.entrydsmapi.domain.application.presentation.dto.request;

import com.entry.entrydsmapi.domain.application.domain.Gender;
import com.entry.entrydsmapi.domain.application.domain.Region;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
public class PersonalInfoUpdateRequest {

    private LocalDate birthDate;
    private Gender gender;
    private Region region;
}
