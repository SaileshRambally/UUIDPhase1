package com.example.uuidphase1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/UserEntity")
public class UuidController {



    @Autowired
    public UuidController(UserService userService) {
        this.userService = userService;
    }
    private UserService userService;



@GetMapping
    public List<UserEntity> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public UserEntity getUserById(@PathVariable UUID id) {
        return (UserEntity) userService.getUserById(id);
    }

    @PostMapping
    public UserEntity createUser(@RequestBody UserEntity user) {
        return (UserEntity) (UserEntity) userService.saveUser((UserEntity) user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable UUID id) {
        userService.deleteUser(id);
    }
}
