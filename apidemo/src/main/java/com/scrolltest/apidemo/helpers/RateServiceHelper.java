//<!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd" >
package com.scrolltest.apidemo.helpers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.scrolltest.apidemo.constants.Endpoints;
import com.scrolltest.apidemo.model.Rate;
import com.scrolltest.apidemo.utils.ConfigManager;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;

import java.lang.reflect.Type;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class RateServiceHelper {
    private static final String BASE_URL = ConfigManager.getInstance( ).getString("base.url");

    public RateServiceHelper() {
        RestAssured.useRelaxedHTTPSValidation( );
        RestAssured.baseURI = BASE_URL;
    }


    public List<Rate> getRate() {

        System.out.println(BASE_URL);

        Response response = RestAssured.given( ).log( ).all( ).contentType(ContentType.JSON)
                .get(Endpoints.GET_ALL_Rate)
                .andReturn( );

        System.out.println(response.prettyPrint());


        Type type = new TypeReference<List<Rate>>( ) {
        }.getType( );

        System.out.println(RestAssured.baseURI);


        assertEquals(response.getStatusCode( ), HttpStatus.SC_OK, "http status");
        List<Rate> rateList = response.as(type);
        System.out.println("response => " + rateList);
        return null;
    }


}
