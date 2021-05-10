package com.weatherapi;

import com.weatherapi.services.Cronjob;

public class Application {

    public static void main(String[] args){
        System.out.println("Start application...");

        Cronjob.temperatureCheckerStart(10 , 10);
    }
}
