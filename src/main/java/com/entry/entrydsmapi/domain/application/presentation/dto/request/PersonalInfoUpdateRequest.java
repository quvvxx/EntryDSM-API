package com.entry.entrydsmapi.domain.application.presentation.dto.request;

import com.entry.entrydsmapi.domain.application.domain.Gender;
import com.entry.entrydsmapi.domain.application.domain.Region;
import lombok.*;

import java.time.LocalDate;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class PersonalInfoUpdateRequest {

    private LocalDate birthDate;
    private Gender gender;
    private Region region;
}
