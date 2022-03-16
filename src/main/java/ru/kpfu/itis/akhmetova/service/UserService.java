package ru.kpfu.itis.akhmetova.service;

import ru.kpfu.itis.akhmetova.dto.CreateUserDto;
import ru.kpfu.itis.akhmetova.dto.UserDto;

import java.util.List;

public interface UserService {

    UserDto getUserByEmail(String email);
//    UserDto getById(Integer id);
    List<UserDto> getAll();
    UserDto signUp(CreateUserDto createUserDto, String url);

    boolean verify(String verificationCode);

    void sendVerificationMail(String mail, String name, String code, String url);
}
