package com.dev.cinema.service.impl;

import com.dev.cinema.lib.Inject;
import com.dev.cinema.lib.Service;
import com.dev.cinema.model.User;
import com.dev.cinema.service.UserService;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Inject
    private UserService userService;

    @Override
    public User add(User user) {
        return userService.add(user);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userService.findByEmail(email);
    }
}
