package com.group.libarayapp.controller.user;

import com.group.libarayapp.domain.user.User;
import com.group.libarayapp.dto.user.request.UserCreateRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    private final List<User> users = new ArrayList<>();

    @PostMapping("/user") // POST /user
    public void saveUser(@RequestBody UserCreateRequest request) {
        users.add(new User(request.getName(), request.getAge()));
    }
}
