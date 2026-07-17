package com.entry.entrydsmapi.domain.application.presentation;

import com.entry.entrydsmapi.domain.application.presentation.dto.request.PersonalInfoRequest;
import com.entry.entrydsmapi.domain.application.presentation.dto.request.PersonalInfoUpdateRequest;
import com.entry.entrydsmapi.domain.application.presentation.dto.request.PersonalStatementRequest;
import com.entry.entrydsmapi.domain.application.presentation.dto.request.StudyPlanRequest;
import com.entry.entrydsmapi.domain.application.presentation.dto.response.PersonalInfoResponse;
import com.entry.entrydsmapi.domain.application.presentation.dto.response.PersonalStatementResponse;
import com.entry.entrydsmapi.domain.application.presentation.dto.response.StudyPlanResponse;
import com.entry.entrydsmapi.domain.application.service.ApplicationService;
import com.entry.entrydsmapi.domain.application.service.PersonalInfoService;
import com.entry.entrydsmapi.domain.application.service.PersonalStatementService;
import com.entry.entrydsmapi.domain.application.service.StudyPlanService;
import com.entry.entrydsmapi.global.response.SuccessResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/applications")
public class ApplicationController {

    private final ApplicationService applicationService;
    private final PersonalStatementService personalStatementService;
    private final StudyPlanService studyPlanService;
    private final PersonalInfoService personalInfoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createApplication(@RequestBody @Valid PersonalInfoRequest request){
        personalInfoService.createApplication(request);
    }

    @PatchMapping("/{year}/personal-info")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updatePersonalInfo(@PathVariable int year, @RequestBody PersonalInfoUpdateRequest request){
        personalInfoService.updatePersonalInfo(request, year);
    }

    @PatchMapping("/{year}/study-plan")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void createAndUpdateStudyPlan(@PathVariable int year, @RequestBody @Valid StudyPlanRequest request){
        studyPlanService.createAndUpdateStudyPlan(request, year);
    }

    @PatchMapping("/{year}/personal-statement")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void createAndUpdatePersonalStatement(@PathVariable int year, @RequestBody @Valid PersonalStatementRequest request){
        personalStatementService.createAndUpdatePersonalStatement(request, year);

    }

    @GetMapping("/{year}/personal-info")
    public PersonalInfoResponse readPersonalInfo(@PathVariable int year){
        return personalInfoService.readPersonalInfo(year);
    }

    @GetMapping("/{year}/personal-statement")
    public PersonalStatementResponse readPersonalStatement(@PathVariable int year){
        return personalStatementService.readPersonalStatement(year);
    }

    @GetMapping("/{year}/study-plan")
    public StudyPlanResponse readStudyPlan(@PathVariable int year){
        return studyPlanService.readStudyPlan(year);
    }

    @DeleteMapping("/{year}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteApplication(@PathVariable int year){
        applicationService.deleteApplication(year);
    }

    @PostMapping("/{year}/submit")
    public ResponseEntity<SuccessResponse> submitApplication(@PathVariable int year){
        applicationService.submitApplication(year);

        SuccessResponse response = SuccessResponse.builder()
                .code("APPLICATION_SUBMITTED")
                .message("지원서가 제출되었습니다.")
                .build();

        return ResponseEntity.ok(response);
    }

}
