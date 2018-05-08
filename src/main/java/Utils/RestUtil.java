package Utils;

import io.restassured.*;
import io.restassured.response.Response;

public class RestUtil {

    public static void setBaseURI (String baseURI){
        RestAssured.baseURI = baseURI;
    }


}
