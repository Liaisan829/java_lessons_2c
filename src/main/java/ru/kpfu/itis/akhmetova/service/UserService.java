package ru.kpfu.itis.akhmetova.service;

import ru.kpfu.itis.akhmetova.dto.CreateUserDto;
import ru.kpfu.itis.akhmetova.dto.UserDto;
import ru.kpfu.itis.akhmetova.dto.WeatherDto;

import java.util.List;

public interface UserService {

    UserDto getUserByEmail(String email);
//    UserDto getById(Integer id);
    List<UserDto> getAll();
    UserDto save(CreateUserDto createUserDto);
}
