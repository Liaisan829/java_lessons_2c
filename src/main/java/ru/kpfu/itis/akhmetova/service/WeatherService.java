package ru.kpfu.itis.akhmetova.service;

import ru.kpfu.itis.akhmetova.dto.WeatherDto;
import ru.kpfu.itis.akhmetova.model.Weather;

public interface WeatherService {
    Iterable<WeatherDto> getAllWeather();
    WeatherDto save(Weather weather);
}
