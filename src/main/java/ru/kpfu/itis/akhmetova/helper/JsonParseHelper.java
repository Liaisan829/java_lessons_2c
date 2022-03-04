package ru.kpfu.itis.akhmetova.helper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Map;

public class JsonParseHelper {
    public Map<String, String> parseWeatherJson(String json) throws JsonProcessingException {
        Map<String, String> map = new HashMap<>();
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(json);
        int temp = (int) (jsonNode.get("main").get("temp").asDouble() - 273.15);

        map.put("temp", String.valueOf(temp));
        map.put("humidity", jsonNode.get("main").get("humidity").asText());
        map.put("name", jsonNode.get("name").asText());

        return map;
    }
}
