package ru.kpfu.itis.akhmetova.service.impl;

import org.springframework.stereotype.Component;
import ru.kpfu.itis.akhmetova.dto.WeatherDto;
import ru.kpfu.itis.akhmetova.model.Weather;
import ru.kpfu.itis.akhmetova.repository.WeatherRepository;
import ru.kpfu.itis.akhmetova.service.WeatherService;

import java.util.stream.Collectors;

@Component
public class WeatherServiceImpl implements WeatherService {

    private final WeatherRepository weatherRepository;

    public WeatherServiceImpl(WeatherRepository weatherRepository) {
        this.weatherRepository = weatherRepository;
    }

    @Override
    public Iterable<WeatherDto> getAllWeather() {
        return weatherRepository.findAll().stream().map(WeatherDto::fromModel).collect(Collectors.toList());
    }

    @Override
    public WeatherDto save(Weather weather) {
        return WeatherDto.fromModel(weatherRepository.save(new Weather(weather.getEmail(), weather.getTemp(), weather.getHumidity(), weather.getCity())));
    }
}
