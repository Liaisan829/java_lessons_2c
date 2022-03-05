package ru.kpfu.itis.akhmetova.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.kpfu.itis.akhmetova.dto.AppealDto;
import ru.kpfu.itis.akhmetova.service.AppealService;

import java.util.List;

@RestController
public class AppealController {
    private final AppealService appealService;

    @Autowired
    public AppealController(AppealService appealService) {
        this.appealService = appealService;
    }

    @GetMapping("/appealBy/{id}")
    public List<AppealDto> getAppealsById(@PathVariable Integer id) {
        return appealService.getAppealsByUserId(id);
    }

    @GetMapping("/appealsBy/{city}")
    public List<AppealDto> getAppealsByCity(@PathVariable String city) {
        return appealService.getAppealsByWeatherCity(city);
    }
}
