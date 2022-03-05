package ru.kpfu.itis.akhmetova.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kpfu.itis.akhmetova.model.Weather;

import java.util.List;

public interface WeatherRepository extends JpaRepository<Weather, Integer> {
    List<Weather> findAllWeatherByCity(String city);
}

