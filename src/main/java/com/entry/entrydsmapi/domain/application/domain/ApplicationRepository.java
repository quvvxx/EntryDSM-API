package com.entry.entrydsmapi.domain.application.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ApplicationRepository extends JpaRepository<Application, Long> {

    Optional<Application> findByUserIdAndApplicationYear(Long userId, Integer applicationYear);
}
