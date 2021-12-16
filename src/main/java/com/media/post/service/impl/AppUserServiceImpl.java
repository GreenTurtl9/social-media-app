package com.media.post.service.impl;

import com.media.post.model.AppUser;
import com.media.post.repo.AppUserRepository;
import com.media.post.service.AppUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class AppUserServiceImpl implements AppUserService {

    private final AppUserRepository userRepository;

    @Override
    public AppUser create(AppUser server) {
        return null;
    }

    @Override
    public Collection<AppUser> list() {
        return null;
    }

    @Override
    public AppUser get(Long userId) {
        log.info("Fetching user by ID: {}", userId);
        return userRepository.findById(userId).get();
    }
}
