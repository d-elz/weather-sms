package com.weatherapi.services;

import com.weatherapi.config.Constants;
import com.weatherapi.exceptions.RouteeException;
import com.weatherapi.model.SmsModel;
import com.weatherapi.model.WeatherModel;
import com.weatherapi.utils.Utils;

import java.io.IOException;

import static com.weatherapi.config.Constants.FAILED_TO_SEND_REQUEST;

public class TemperatureCheckerService {

    private String weatherUrl;
    private String city;
    private String apiKey;
    private String routeeBodyMore;
    private String routeeBodyLess;
    private String routeeTo;
    private String routeeFrom;
    private String routeeUrl;
    private HttpService httpService;

    public HttpService getHttpService() {
        return httpService;
    }

    public void setHttpService(HttpService httpService) {
        this.httpService = httpService;
    }

    public String getWeatherUrl() {
        return weatherUrl;
    }

    public void setWeatherUrl(String weatherUrl) {
        this.weatherUrl = weatherUrl;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getRouteeBodyMore() {
        return routeeBodyMore;
    }

    public void setRouteeBodyMore(String routeeBodyMore) {
        this.routeeBodyMore = routeeBodyMore;
    }

    public String getRouteeBodyLess() {
        return routeeBodyLess;
    }

    public void setRouteeBodyLess(String routeeBodyLess) {
        this.routeeBodyLess = routeeBodyLess;
    }

    public String getRouteeTo() {
        return routeeTo;
    }

    public void setRouteeTo(String routeeTo) {
        this.routeeTo = routeeTo;
    }

    public String getRouteeFrom() {
        return routeeFrom;
    }

    public void setRouteeFrom(String routeeFrom) {
        this.routeeFrom = routeeFrom;
    }

    public String getRouteeUrl() {
        return routeeUrl;
    }

    public void setRouteeUrl(String routeeUrl) {
        this.routeeUrl = routeeUrl;
    }

    /**
     * Check if the temperature of a specific city is greater than 20C. Get
     * city data from weather api. If it is we send a message through the
     * ROUTEE api to phone number.
     */
    public void check(){
        System.out.println(Constants.START_MESSAGE);

        String url = constructUrl(getWeatherUrl(), getCity() , getApiKey());
        try{
            WeatherModel whether = getWeatherData(url);
            double currentTemp = Utils.kelvinToCelsious( whether.getMain().getTemp());
            sendSmsMessage(currentTemp);
        }catch (RouteeException re){
            System.out.println(Constants.FAILED_TO_SEND_REQUEST + re.getMessage());
        }

        System.out.println(Constants.END_MESSAGE);
    }


    /**
     * Get data from weather api.
     * @param url
     * @return
     * @throws RouteeException
     * IOException – if an I/O error occurs when sending or receiving
     * InterruptedException – if the operation is interrupted
     */
    public WeatherModel getWeatherData(String url) throws RouteeException {
        WeatherModel whether;
        try {
            whether = httpService.sendGetRequest(url, WeatherModel.class);
        } catch (IOException | InterruptedException e) {
            throw new RouteeException(e.getMessage());
        }
        return whether;
    }

    /**
     * Send SMS message with the help of Routee api.
     * @param currentTemp
     * @return
     * @throws RouteeException
     * IOException – if an I/O error occurs when sending or receiving
     * InterruptedException – if the operation is interrupted
     */
    public void sendSmsMessage(double currentTemp) throws RouteeException {
        try {
            if(currentTemp > Constants.TWENTY){
                String requestBody = Utils.constructRequestBody(getRouteeBodyMore() + String.format("%.2f", currentTemp) + "C", getRouteeTo(), getRouteeFrom());

                SmsModel smsResponse = httpService.sendPostRequest(getRouteeUrl(), requestBody , SmsModel.class);
                System.out.println(messageLog(smsResponse));
            }else{
                String requestBody = Utils.constructRequestBody(getRouteeBodyLess() + String.format("%.2f", currentTemp) + "C", getRouteeTo(), getRouteeFrom());

                SmsModel smsResponse = httpService.sendPostRequest(getRouteeUrl(), requestBody , SmsModel.class);
                System.out.println(messageLog(smsResponse));
            }
        }catch (IOException | InterruptedException e){
            throw new RouteeException(e.getMessage());
        }
    }

    /**
     * Construct the url of weather api.
     * @param url
     * @param city
     * @param apiKey
     * @return String
     */
    private String constructUrl(String url , String city , String apiKey){
        return url + "?q=" + city + "&appid=" + apiKey;
    }

    /**
     * Check if the response is valid.
     * Construct the successful or error message.
     * @param smsResponse
     * @return String
     */
    private String messageLog(SmsModel smsResponse){
        if(smsResponse !=null && smsResponse.getTo() != null && !smsResponse.getTo().isBlank()){
            return Constants.SUCCESSFULL_MESSAGE + smsResponse.getTo();
        }
        return Constants.ERROR_READING_RESPONSE;
    }

}
