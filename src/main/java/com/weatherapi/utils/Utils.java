package com.weatherapi.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.weatherapi.config.Constants;

import java.util.HashMap;
import java.util.Map;

public class Utils {

    /**
     * Just convert Kelvin to Celsious.
     * @param temp
     * @return double
     */
    public static double kelvinToCelsious(double temp){
        return temp - Constants.KELVIN;
    }

    /**
     * Build a json object.
     * @param body
     * @param to
     * @param from
     * @return String
     */
    public static String constructRequestBody(String body,String to,String from) {
        String requestBody = "";
        try {
            Map<String, String> map = new HashMap<>();
            map.put("body", body);
            map.put("to", to);
            map.put("from", from);

            ObjectMapper objectMapper = new ObjectMapper();
            requestBody = objectMapper
                    .writerWithDefaultPrettyPrinter()
                    .writeValueAsString(map);
        }catch (JsonProcessingException jpe){
            System.out.println(jpe.getMessage());
        }
        return requestBody;
    }
}
