package com.entry.entrydsmapi.domain.application.service;


import com.entry.entrydsmapi.domain.application.domain.Application;
import com.entry.entrydsmapi.domain.application.domain.ApplicationRepository;
import com.entry.entrydsmapi.domain.application.exception.ApplicationNotFoundException;
import com.entry.entrydsmapi.domain.application.presentation.dto.request.StudyPlanRequest;
import com.entry.entrydsmapi.domain.application.presentation.dto.response.StudyPlanResponse;
import com.entry.entrydsmapi.domain.user.domain.User;
import com.entry.entrydsmapi.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class StudyPlanService {

    private final UserFacade userFacade;
    private final ApplicationRepository applicationRepository;

    @Transactional(readOnly = true)
    public StudyPlanResponse readStudyPlan(int year){

        User user = userFacade.getCurrentUser();
        Application application = applicationRepository.findByUserIdAndApplicationYear
                (user.getId(), year).orElseThrow(ApplicationNotFoundException::new);

        return new StudyPlanResponse(application.getStudyPlan());
    }

    public void createAndUpdateStudyPlan(StudyPlanRequest request, int year){

        User user = userFacade.getCurrentUser();
        Application application = applicationRepository.findByUserIdAndApplicationYear
                (user.getId(), year).orElseThrow(ApplicationNotFoundException::new);

        application.validateNotSubmitted();
        application.updateStudyPlan(request.getStudyPlan());
    }
}
