package ru.kpfu.itis.akhmetova.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kpfu.itis.akhmetova.DataAboutWeather;
import ru.kpfu.itis.akhmetova.dto.UserDto;
import ru.kpfu.itis.akhmetova.dto.WeatherDto;
import ru.kpfu.itis.akhmetova.helper.JsonParseHelper;
import ru.kpfu.itis.akhmetova.model.Weather;
import ru.kpfu.itis.akhmetova.service.UserService;
import ru.kpfu.itis.akhmetova.service.WeatherService;

import java.io.IOException;
import java.util.Map;
import java.util.Optional;

public class WeatherController {

    private final UserService userService;
    private final WeatherService weatherService;
    private JsonParseHelper jsonParseHelper;
    private DataAboutWeather dataAboutWeather;

    @Autowired
    public WeatherController(UserService userService, WeatherService weatherService) {
        this.userService = userService;
        this.weatherService = weatherService;
    }

    @GetMapping("/allWeather")
    public Iterable<WeatherDto> getAllWeather() {
        return weatherService.getAllWeather();
    }

    @GetMapping("/weatherSecond")
    public String getWeather(@RequestParam Optional<String> city) throws IOException {
        String email = "liaisan@mail.ru";
        System.out.println(email);
//        UserDto userDto = userService.getUserByEmail(email);
//        if (userDto != null) {
        String result = dataAboutWeather.getDataAboutWeather(city.orElse("Kazan"));
        System.out.println(result);
        if (result != null) {
            Map<String, String> parsedWeather = jsonParseHelper.parseWeatherJson(result);
            Weather weather = new Weather(email, parsedWeather.get("temp"), parsedWeather.get("humidity"), parsedWeather.get("name"));
            weatherService.save(weather);
            return "result";
        } else {
            return "No such city";
        }
//        } else {
//            return "null";
//        }
    }
}
