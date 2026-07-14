package com.entry.entrydsmapi.domain.user.service;

import com.entry.entrydsmapi.domain.user.domain.User;
import com.entry.entrydsmapi.domain.user.domain.UserRepository;
import com.entry.entrydsmapi.domain.user.exception.InvalidCredentialsException;
import com.entry.entrydsmapi.domain.user.presentation.dto.request.LoginRequest;
import com.entry.entrydsmapi.domain.user.presentation.dto.response.LoginResponse;
import com.entry.entrydsmapi.global.security.jwt.JwtProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtProvider jwtProvider;

    public LoginResponse Login(LoginRequest request){

        User user = userRepository.findByPhone(request.getPhone())
                .orElseThrow(InvalidCredentialsException::new);

        boolean matches = passwordEncoder.matches(request.getPassword(), user.getPassword());

        if(!matches) throw new InvalidCredentialsException();
        String accessToken = jwtProvider.generateAccessToken(user.getId());

        return new LoginResponse(accessToken);
    }

}
