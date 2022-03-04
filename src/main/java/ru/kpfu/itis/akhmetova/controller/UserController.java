package ru.kpfu.itis.akhmetova.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.kpfu.itis.akhmetova.dto.CreateUserDto;
import ru.kpfu.itis.akhmetova.dto.UserDto;
import ru.kpfu.itis.akhmetova.service.UserService;

import javax.validation.Valid;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    public Iterable<UserDto> getAll() {
        return userService.getAll();
    }

//    @GetMapping("/user/{id}")
//    public UserDto get(@PathVariable Integer id) {
//        return userService.getById(id);
//    }

    @PostMapping("/user")
    public UserDto createUser(@Valid @RequestBody CreateUserDto createUserDto) {
        return userService.save(createUserDto);
    }
}