package ru.kpfu.itis.akhmetova.service;

import ru.kpfu.itis.akhmetova.dto.WeatherDto;
import ru.kpfu.itis.akhmetova.model.Weather;

import java.util.List;

public interface WeatherService {
    Iterable<WeatherDto> getAllWeather();
    WeatherDto save(Weather weather);
    List<WeatherDto> getAllWeatherByCity(String city);
}
