package com.weatherapi.config;

public class Constants {

    // Credentials
    public static final String CITY = "Thessaloniki";
    public static final String API_KEY = "b385aa7d4e568152288b3c9f5c2458a5";
    public static final String WEATHER_URL = "http://api.openweathermap.org/data/2.5/weather";
    public static final String ROUTEE_URL = "https://connect.routee.net/sms";
    public static final String TOKEN = "59b275d8-f528-4f80-8444-1648c609fa3b";

    //Request Body of Routee
    public static final String ROUTEE_BODY_MORE = "Your name and Temperature more than 20C. ";
    public static final String ROUTEE_BODY_LESS = "Your name and Temperature less than 20C. ";
    public static final String ROUTEE_TO= "+306978745957";
    public static final String ROUTEE_FROM = "amdTelecom";

    // Messages
    public static final String ERROR_READING_RESPONSE = "Error on reading response";
    public static final String SUCCESSFULL_MESSAGE = "Message send successfully to client with phone number : ";
    public static final String FAILED_TO_SEND_REQUEST = "Failed to send GET or POST request: ";
    public static final String START_MESSAGE = "############# Start checking temperature ##############";
    public static final String END_MESSAGE = "############# End checking temperature ##############";

    public static final double KELVIN = 273.0;
    public static final double TWENTY = 20.0;


}
