package com.dev.todoapp.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("get-all-user")
    public List<User> getUser() {
        return this.userService.getUser();
    }

    @GetMapping("get-user-by-id/{user_id}")
    public Optional<User> getUserById(@PathVariable("user_id") int user_id) {
        return this.userService.getUserById(user_id);
    }

    @PostMapping("add-user")
    public void registerNewUser(@RequestBody User user) {
        this.userService.addNewUser(user);
    }

    @DeleteMapping("delete-user/{userId}")
    public void deleteUser(@PathVariable("userId") int userId) {
        this.userService.deleteUser(userId);
    }

}
