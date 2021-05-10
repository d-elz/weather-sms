package com.weatherapi;

import com.weatherapi.config.Constants;
import com.weatherapi.cronjobs.TemperatureChecker;
import com.weatherapi.exceptions.RouteeException;
import com.weatherapi.services.HttpService;
import com.weatherapi.services.TemperatureCheckerService;
import com.weatherapi.utils.Utils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TemperatureCheckerServiceTest {

    @Test
    public void testKelvinToCelsious(){
        HttpService httpService = new HttpService();
        httpService.setToken("testToken");

        TemperatureCheckerService checkerService = new TemperatureCheckerService();
        checkerService.setWeatherUrl(Constants.WEATHER_URL);
        checkerService.setCity(Constants.CITY);
        checkerService.setApiKey(Constants.API_KEY);
        checkerService.setRouteeBodyMore(Constants.ROUTEE_BODY_MORE);
        checkerService.setRouteeBodyLess(Constants.ROUTEE_BODY_LESS);
        checkerService.setRouteeFrom(Constants.ROUTEE_FROM);
        checkerService.setRouteeTo(Constants.ROUTEE_TO);
        checkerService.setRouteeUrl("https://testRoute.com");
        checkerService.setHttpService(httpService);

        String actual = "";
        try {
            checkerService.getWeatherData("http://test.com/api");
        }catch (RouteeException re){
            actual = "WeatherExceptionHandle";
        }

        assertEquals("WeatherExceptionHandle" , actual );

        actual = "";
        try {
            checkerService.sendSmsMessage(20.0);
        }catch (RouteeException re){
            actual = "RouteeExceptionHandle";
        }

        assertEquals("RouteeExceptionHandle" , actual );
    }



}
