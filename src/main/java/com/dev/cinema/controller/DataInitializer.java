package com.dev.cinema.controller;

import com.dev.cinema.model.Role;
import com.dev.cinema.model.Roles;
import com.dev.cinema.model.User;
import com.dev.cinema.service.RoleService;
import com.dev.cinema.service.UserService;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {
    private final RoleService roleService;
    private final UserService userService;

    @Autowired
    public DataInitializer(RoleService roleService, UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }

    @PostConstruct
    private void inject() {
        Role admin = new Role();
        admin.setRoleName(Roles.ADMIN);
        roleService.add(admin);
        User adminUser = new User();
        adminUser.setRole(admin);
        adminUser.setEmail("admin@gmail.com");
        adminUser.setPassword("admin");
        userService.add(adminUser);

        Role user = new Role();
        user.setRoleName(Roles.USER);
        roleService.add(user);
    }
}
