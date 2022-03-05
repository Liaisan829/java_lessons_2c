package ru.kpfu.itis.akhmetova.dto;

import ru.kpfu.itis.akhmetova.model.Appeal;

public class AppealDto {
    private Integer id;
    private WeatherDto weatherDto;
    private UserDto userDto;

    public AppealDto(Integer id, WeatherDto weatherDto, UserDto userDto) {
        this.id = id;
        this.weatherDto = weatherDto;
        this.userDto = userDto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public WeatherDto getWeatherDto() {
        return weatherDto;
    }

    public void setWeatherDto(WeatherDto weatherDto) {
        this.weatherDto = weatherDto;
    }

    public UserDto getUserDto() {
        return userDto;
    }

    public void setUserDto(UserDto userDto) {
        this.userDto = userDto;
    }

    public static AppealDto fromModel(Appeal appeal){
        return new AppealDto(appeal.getId(), WeatherDto.fromModel(appeal.getWeather()), UserDto.fromModel(appeal.getUser()));
    }
}
