package com.media.post.service;

import com.media.post.model.AppUser;

import java.io.IOException;
import java.util.Collection;

public interface AppUserService {

    AppUser create(AppUser server);
    Collection<AppUser> list();
    AppUser get(Long id);
}
