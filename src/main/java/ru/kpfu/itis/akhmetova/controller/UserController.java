package ru.kpfu.itis.akhmetova.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.kpfu.itis.akhmetova.dto.CreateUserDto;
import ru.kpfu.itis.akhmetova.dto.UserDto;
import ru.kpfu.itis.akhmetova.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
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

//    @PostMapping("/user")
//    @ResponseBody
//    public UserDto createUser(@Valid @RequestBody CreateUserDto createUserDto) {
//        return userService.signUp(createUserDto);
//    }

    @PostMapping("/sign-up")
    public String signUp(@ModelAttribute(name = "user") CreateUserDto createUserDto, HttpServletRequest request) {
        String url = request.getRequestURL().toString().replace(request.getServletPath(), "");
        userService.signUp(createUserDto, url);
        return "sign_up_success";
    }

    @GetMapping("/verify")
    public String verify(@Param("code") String code) {
        if(userService.verify(code)){
            return "verification_success";
        }
        else{
            return "verification_falied";
        }
    }
}