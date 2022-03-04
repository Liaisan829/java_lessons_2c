package ru.kpfu.itis.akhmetova.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kpfu.itis.akhmetova.model.Weather;

public interface WeatherRepository extends JpaRepository<Weather, Integer> {
}
