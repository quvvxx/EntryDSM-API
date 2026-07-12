package com.entry.entrydsmapi.domain.application;

import com.entry.entrydsmapi.domain.user.User;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Table(name = "applications")
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
}
