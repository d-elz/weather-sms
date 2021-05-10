package com.weatherapi.services;

import com.weatherapi.config.Constants;
import com.weatherapi.cronjobs.TemperatureChecker;
import java.util.Timer;

public class Cronjob {

    public static void temperatureCheckerStart(int period , int timesExecute){
        Timer timer = new Timer();

        HttpService httpService = new HttpService();
        httpService.setToken(Constants.TOKEN);

        TemperatureCheckerService checkerService = getTemperatureCheckerService(httpService);
        TemperatureChecker temperatureChecker = getTemperatureChecker(timer,timesExecute,checkerService);

        timer.scheduleAtFixedRate(temperatureChecker, 0, period * 60 * 1000);
    }

    private static TemperatureCheckerService getTemperatureCheckerService(HttpService httpService){
        TemperatureCheckerService checkerService = new TemperatureCheckerService();
        checkerService.setWeatherUrl(Constants.WEATHER_URL);
        checkerService.setCity(Constants.CITY);
        checkerService.setApiKey(Constants.API_KEY);
        checkerService.setRouteeBodyMore(Constants.ROUTEE_BODY_MORE);
        checkerService.setRouteeBodyLess(Constants.ROUTEE_BODY_LESS);
        checkerService.setRouteeFrom(Constants.ROUTEE_FROM);
        checkerService.setRouteeTo(Constants.ROUTEE_TO);
        checkerService.setRouteeUrl(Constants.ROUTEE_URL);
        checkerService.setHttpService(httpService);
        return checkerService;
    }

    private static TemperatureChecker getTemperatureChecker(Timer timer , int timesExecute , TemperatureCheckerService checkerService){
        TemperatureChecker temperatureChecker = new TemperatureChecker();
        temperatureChecker.setTimer(timer);
        temperatureChecker.setTimesExecute(timesExecute);
        temperatureChecker.setTemperatureCheckerService(checkerService);
        return temperatureChecker;
    }

}
