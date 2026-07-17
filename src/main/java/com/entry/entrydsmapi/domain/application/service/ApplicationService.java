package com.entry.entrydsmapi.domain.application.service;

import com.entry.entrydsmapi.domain.application.domain.Application;
import com.entry.entrydsmapi.domain.application.domain.ApplicationRepository;
import com.entry.entrydsmapi.domain.application.domain.Status;
import com.entry.entrydsmapi.domain.application.exception.ApplicationNotFoundException;
import com.entry.entrydsmapi.domain.user.domain.User;
import com.entry.entrydsmapi.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class ApplicationService {

    private final ApplicationRepository applicationRepository;
    private final UserFacade userFacade;

    public void deleteApplication(int year){

        User user = userFacade.getCurrentUser();

        Application application = applicationRepository.findByUserIdAndApplicationYear
                (user.getId(), year).orElseThrow(ApplicationNotFoundException::new);

        applicationRepository.delete(application);
    }

    public void submitApplication(int year){

        User user = userFacade.getCurrentUser();

        Application application = applicationRepository.findByUserIdAndApplicationYear
                (user.getId(), year).orElseThrow(ApplicationNotFoundException::new);

        application.submit();
    }
}
