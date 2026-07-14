package com.entry.entrydsmapi.domain.user.service;

import com.entry.entrydsmapi.domain.user.domain.Role;
import com.entry.entrydsmapi.domain.user.domain.User;
import com.entry.entrydsmapi.domain.user.domain.UserRepository;
import com.entry.entrydsmapi.domain.user.exception.PhoneAlreadyExistsException;
import com.entry.entrydsmapi.domain.user.presentation.dto.request.SignUpRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SignUpService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void signUp(SignUpRequest request){

        if(userRepository.existsByPhone(request.getPhone())) throw new PhoneAlreadyExistsException();

        String encodePassword = passwordEncoder.encode(request.getPassword());

        User user = User.builder()
                .name(request.getName())
                .password(encodePassword)
                .phone(request.getPhone())
                .role(Role.USER)
                .build();

        userRepository.save(user);

    }
}
