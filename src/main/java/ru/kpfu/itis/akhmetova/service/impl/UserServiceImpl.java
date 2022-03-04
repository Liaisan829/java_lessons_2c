package ru.kpfu.itis.akhmetova.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.kpfu.itis.akhmetova.dto.CreateUserDto;
import ru.kpfu.itis.akhmetova.dto.UserDto;
import ru.kpfu.itis.akhmetova.helper.PasswordHelper;
import ru.kpfu.itis.akhmetova.model.User;
import ru.kpfu.itis.akhmetova.repository.UserRepository;
import ru.kpfu.itis.akhmetova.service.UserService;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDto getUserByEmail(String email) {
        return userRepository.getUserByEmail(email);
    }

//    @Override
//    public UserDto getById(Integer id) {
//        return userRepository.findById(id).stream().map(UserDto::fromModel).findFirst().orElse(null);
//    }

    @Override
    public List<UserDto> getAll() {
        return userRepository.findAll().stream().map(UserDto::fromModel).collect(Collectors.toList());
    }

    @Override
    public UserDto save(CreateUserDto createUserDto) {
        return UserDto.fromModel(userRepository.save(new User(createUserDto.getName(), createUserDto.getEmail(), PasswordHelper.encrypt(createUserDto.getPassword()))));
    }
}
