package com.group.libarayapp.controller.user;

import com.group.libarayapp.dto.user.request.UserCreateRequest;
import com.group.libarayapp.dto.user.request.UserUpdateRequest;
import com.group.libarayapp.dto.user.response.UserResponse;
import com.group.libarayapp.service.fruit.AppleService;
import com.group.libarayapp.service.fruit.FruitService;
import com.group.libarayapp.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private final UserService userService;
    private final FruitService fruitService;


    public UserController(UserService userService, @Qualifier("appleService") FruitService fruitService) {
        this.userService = userService;
        this.fruitService = fruitService;
    }


    @PostMapping("/user") // POST /user
    public void saveUser(@RequestBody UserCreateRequest request) {
        userService.saveUser(request);
    }

    @GetMapping("/user")
    public List<UserResponse> getUsers() {
        return userService.getUsers();
    }

    @PutMapping("/user")
    public void updateUser(@RequestBody UserUpdateRequest request) {
        userService.updateUser(request);
    }

    @DeleteMapping("/user")
    public void deleteUser(@RequestParam String name) {
    }
}
