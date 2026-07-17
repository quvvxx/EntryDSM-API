package com.entry.entrydsmapi.domain.application.service;

import com.entry.entrydsmapi.domain.application.domain.Application;
import com.entry.entrydsmapi.domain.application.domain.ApplicationRepository;
import com.entry.entrydsmapi.domain.application.domain.Status;
import com.entry.entrydsmapi.domain.application.exception.ApplicationNotFoundException;
import com.entry.entrydsmapi.domain.application.presentation.dto.request.PersonalInfoRequest;
import com.entry.entrydsmapi.domain.application.presentation.dto.request.PersonalInfoUpdateRequest;
import com.entry.entrydsmapi.domain.application.presentation.dto.response.PersonalInfoResponse;
import com.entry.entrydsmapi.domain.user.facade.UserFacade;
import com.entry.entrydsmapi.domain.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
@Transactional
@RequiredArgsConstructor
public class PersonalInfoService {

    private final ApplicationRepository applicationRepository;
    private final UserFacade userFacade;

    public void createApplication(PersonalInfoRequest request){

        Integer applicationYear = LocalDate.now().getYear();

        User user = userFacade.getCurrentUser();

        Application application = Application.builder()
                .user(user)
                .applicantName(user.getName())
                .birthDate(request.getBirthDate())
                .gender(request.getGender())
                .region(request.getRegion())
                .applicationYear(applicationYear)
                .status(Status.DRAFT)
                .build();

        applicationRepository.save(application);
    }

    @Transactional(readOnly = true)
    public PersonalInfoResponse readPersonalInfo(int year){

        User user = userFacade.getCurrentUser();
        Application application = applicationRepository.findByUserIdAndApplicationYear
                (user.getId(), year).orElseThrow(ApplicationNotFoundException::new);

        return PersonalInfoResponse.builder()
                .region(application.getRegion())
                .gender(application.getGender())
                .birthDate(application.getBirthDate())
                .applicantName(application.getApplicantName())
                .build();
    }

    public void updatePersonalInfo(PersonalInfoUpdateRequest request, int year){

        User user = userFacade.getCurrentUser();
        Application application = applicationRepository.findByUserIdAndApplicationYear
                        (user.getId(), year).orElseThrow(ApplicationNotFoundException::new);

        application.validateNotSubmitted();
        application.updatePersonalInfo(request.getBirthDate(), request.getGender(), request.getRegion());
    }
}
