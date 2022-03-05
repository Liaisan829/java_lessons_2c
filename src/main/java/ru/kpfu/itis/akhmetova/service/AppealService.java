package ru.kpfu.itis.akhmetova.service;

import ru.kpfu.itis.akhmetova.dto.AppealDto;
import ru.kpfu.itis.akhmetova.model.Appeal;

import java.util.List;

public interface AppealService {
    List<AppealDto> getAppealsByUserId(Integer id);

    List<AppealDto> getAppealsByWeatherCity(String city);

    AppealDto save(Appeal appeal);
}
