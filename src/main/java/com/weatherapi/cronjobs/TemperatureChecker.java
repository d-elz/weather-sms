package com.weatherapi.cronjobs;

import com.weatherapi.services.TemperatureCheckerService;

import java.util.Timer;
import java.util.TimerTask;

public class TemperatureChecker extends TimerTask {

    private Timer timer;
    private int timesExecute;
    private TemperatureCheckerService temperatureCheckerService;
    private static int count = 0;

    public TemperatureChecker(){
    }

    public TemperatureCheckerService getTemperatureCheckerService() {
        return temperatureCheckerService;
    }

    public void setTemperatureCheckerService(TemperatureCheckerService temperatureCheckerService) {
        this.temperatureCheckerService = temperatureCheckerService;
    }

    public int getTimesExecute() {
        return timesExecute;
    }

    public void setTimesExecute(int timesExecute) {
        this.timesExecute = timesExecute;
    }

    public Timer getTimer() {
        return timer;
    }

    public void setTimer(Timer timer) {
        this.timer = timer;
    }

    @Override
    public void run() {
        count++;
        temperatureCheckerService.check();

        if(count > this.timesExecute){
            System.out.println("The job has executed " + this.timesExecute + " times. Canceling the job and stop the program.");
            this.timer.cancel();
        }
    }

}
