package ru.kpfu.itis.akhmetova;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class DataAboutWeather {
    private final String APPID = "50da205a9c76cfaf41a554bc57768910";
    public String getDataAboutWeather(String city) {

        String weatherUrl = "https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + APPID;

        try {
            URL url = new URL(weatherUrl);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestProperty("Content-Type", "application/json");

            connection.setRequestMethod("GET");

            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream())
            )) {
                StringBuilder content = new StringBuilder();
                String input;
                while ((input = reader.readLine()) != null) {
                    content.append(input);
                }
                connection.disconnect();
                return content.toString();
            }

        } catch ( IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
