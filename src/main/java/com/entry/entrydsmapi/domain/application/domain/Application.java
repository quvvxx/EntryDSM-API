package com.entry.entrydsmapi.domain.application.domain;

import com.entry.entrydsmapi.domain.user.domain.User;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Table(name = "applications",
uniqueConstraints = @UniqueConstraint(name = "uk_application", columnNames = {"user_id", "application_year"}))
public class Application {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false, name = "user_id")
    private User user;

    @Column(nullable = false, length = 50)
    private String applicantName;

    @Column(nullable = false)
    private LocalDate birthDate;

    @Column(nullable = false, length = 50)
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(nullable = false)
    private Integer applicationYear;

    @Column(nullable = false, length = 50)
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(nullable = false, length = 50)
    @Enumerated(EnumType.STRING)
    private Region region;

    @Column(length = 1600)
    private String studyPlan;

    @Column(length = 1600)
    private String personalStatement;

    @Builder
    public Application(String applicantName, LocalDate birthDate, Gender gender,
                       Region region, String studyPlan, String personalStatement, Integer applicationYear) {
        this.applicantName = applicantName;
        this.birthDate = birthDate;
        this.gender = gender;
        this.region = region;
        this.studyPlan = studyPlan;
        this.personalStatement = personalStatement;
        this.applicationYear = applicationYear;
    }
}
