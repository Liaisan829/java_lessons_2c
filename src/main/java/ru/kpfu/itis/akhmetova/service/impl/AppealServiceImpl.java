package ru.kpfu.itis.akhmetova.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.kpfu.itis.akhmetova.dto.AppealDto;
import ru.kpfu.itis.akhmetova.model.Appeal;
import ru.kpfu.itis.akhmetova.repository.AppealRepository;
import ru.kpfu.itis.akhmetova.service.AppealService;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AppealServiceImpl implements AppealService {

    private final AppealRepository appealRepository;

    @Autowired
    public AppealServiceImpl(AppealRepository appealRepository) {
        this.appealRepository = appealRepository;
    }

    @Override
    public List<AppealDto> getAppealsByUserId(Integer id) {
        return appealRepository.getAppealsByUserId(id).stream().map(AppealDto::fromModel).collect(Collectors.toList());
    }

    @Override
    public List<AppealDto> getAppealsByWeatherCity(String city) {
        return appealRepository.getAppealsByWeatherCity(city).stream().map(AppealDto::fromModel).collect(Collectors.toList());
    }

    @Override
    public AppealDto save(Appeal appeal) {
        return AppealDto.fromModel(appealRepository.save(appeal));
    }
}
