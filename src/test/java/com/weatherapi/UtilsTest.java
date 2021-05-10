package com.weatherapi;

import com.weatherapi.utils.Utils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UtilsTest {

    @Test
    public void testConstructRequestBody(){
        assertEquals("{\n" +
                "  \"from\" : \"\",\n" +
                "  \"to\" : \"\",\n" +
                "  \"body\" : \"\"\n" +
                "}" , Utils.constructRequestBody("","","") );

        assertEquals("{\n" +
                "  \"from\" : \"TestFrom\",\n" +
                "  \"to\" : \"TestTo\",\n" +
                "  \"body\" : \"bodyTest\"\n" +
                "}" , Utils.constructRequestBody("bodyTest","TestTo","TestFrom") );

    }

    @Test
    public void testKelvinToCelsious(){
        assertEquals(27 , Utils.kelvinToCelsious(300) );
        assertEquals(-573 , Utils.kelvinToCelsious(-300) );
        assertEquals(-263 , Utils.kelvinToCelsious(10) );
        assertEquals(-273 , Utils.kelvinToCelsious(0) );
    }


}