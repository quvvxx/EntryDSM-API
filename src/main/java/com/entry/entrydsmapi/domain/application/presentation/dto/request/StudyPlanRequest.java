package com.entry.entrydsmapi.domain.application.presentation.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class StudyPlanRequest {

    @NotBlank(message = "학업계획서를 작성해주새요.")
    @Size(max = 1600, message = "학업계획서는 1600자 이하로 작성해야 합니다.")
    private String studyPlan;

}
