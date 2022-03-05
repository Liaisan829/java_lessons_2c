package ru.kpfu.itis.akhmetova.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kpfu.itis.akhmetova.model.Appeal;

import java.util.List;

public interface AppealRepository extends JpaRepository<Appeal, Integer> {
    List<Appeal> getAppealsByUserId(Integer id);

    List<Appeal> getAppealsByWeatherCity(String city);
}

