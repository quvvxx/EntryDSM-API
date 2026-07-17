package com.entry.entrydsmapi.domain.application.service;

import com.entry.entrydsmapi.domain.application.domain.Application;
import com.entry.entrydsmapi.domain.application.domain.ApplicationRepository;
import com.entry.entrydsmapi.domain.application.exception.ApplicationNotFoundException;
import com.entry.entrydsmapi.domain.application.presentation.dto.request.PersonalStatementRequest;
import com.entry.entrydsmapi.domain.application.presentation.dto.response.PersonalStatementResponse;
import com.entry.entrydsmapi.domain.user.domain.User;
import com.entry.entrydsmapi.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class PersonalStatementService {

    private final UserFacade userFacade;
    private final ApplicationRepository applicationRepository;

    @Transactional(readOnly = true)
    public PersonalStatementResponse readPersonalStatement(int year) {

        User user = userFacade.getCurrentUser();
        Application application = applicationRepository.findByUserIdAndApplicationYear
                (user.getId(), year).orElseThrow(ApplicationNotFoundException::new);

        return new PersonalStatementResponse(application.getPersonalStatement());
    }

    public void createAndUpdatePersonalStatement(PersonalStatementRequest request, int year){

        User user = userFacade.getCurrentUser();
        Application application = applicationRepository.findByUserIdAndApplicationYear
                (user.getId(), year).orElseThrow(ApplicationNotFoundException::new);

        application.validateNotSubmitted();
        application.updatePersonalStatement(request.getPersonalStatement());
    }
}