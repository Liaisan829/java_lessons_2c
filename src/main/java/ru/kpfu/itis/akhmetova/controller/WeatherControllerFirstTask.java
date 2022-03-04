package ru.kpfu.itis.akhmetova.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.kpfu.itis.akhmetova.DataAboutWeather;
import ru.kpfu.itis.akhmetova.helper.JsonParseHelper;

import java.util.Map;
import java.util.Optional;

@RestController
public class WeatherControllerFirstTask {
    DataAboutWeather DataAboutWeather = new DataAboutWeather();
    JsonParseHelper jsonParseHelper = new JsonParseHelper();

    @GetMapping("/weatherFirst")
    public Map<String, String> getWeather(@RequestParam Optional<String> city) throws JsonProcessingException {
        String result = DataAboutWeather.getDataAboutWeather(city.orElse("Kazan"));
        return jsonParseHelper.parseWeatherJson(result);
    }
}
