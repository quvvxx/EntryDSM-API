package com.entry.entrydsmapi.domain.user.facade;

import com.entry.entrydsmapi.domain.user.domain.User;
import com.entry.entrydsmapi.domain.user.domain.UserRepository;
import com.entry.entrydsmapi.domain.user.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserFacade {

    private final UserRepository userRepository;

    public User getCurrentUser(){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Long id = Long.valueOf(authentication.getName());

        return userRepository.findById(id).orElseThrow(UserNotFoundException::new);
    }


}
