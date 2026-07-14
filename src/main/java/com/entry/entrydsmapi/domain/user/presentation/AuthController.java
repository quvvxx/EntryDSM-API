package com.entry.entrydsmapi.domain.user.presentation;

import com.entry.entrydsmapi.domain.user.presentation.dto.request.LoginRequest;
import com.entry.entrydsmapi.domain.user.presentation.dto.request.SignUpRequest;
import com.entry.entrydsmapi.domain.user.presentation.dto.response.LoginResponse;
import com.entry.entrydsmapi.domain.user.service.LoginService;
import com.entry.entrydsmapi.domain.user.service.SignUpService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final LoginService loginService;
    private final SignUpService signUpService;

    @PostMapping("/auth/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public void signUp(@RequestBody @Valid SignUpRequest request){
        signUpService.signUp(request);
    }

    @PostMapping("/auth/login")
    public LoginResponse login(@RequestBody @Valid LoginRequest request){
        return loginService.Login(request);
    }
}
