package RegressionTesting;

import Utils.RestUtil;
import io.restassured.response.Response;
import org.junit.*;
import org.junit.runners.MethodSorters;

import java.util.*;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class Register {

    private static String appID;
    private static long randomId;


    @Test

    public void T1_appRegister() {
        String path = "https://partner-api.dev.pltzone.org/v1/app";
        randomId = System.currentTimeMillis();
        Response resp = given().
                contentType("application/json").
                body(" {\n" +
                        "  \n" +
                        "  \"description\": \"long\",\n" +
                        "  \"name\": \"Automation"+randomId+"\",\n" +
                        "   \"partnerProfile\": {\n" +
                        "    \"email\": \"anish.kumar@plantronics.com\",\n" +
                        "    \"firstName\": \"Anish\",\n" +
                        "    \"lastName\": \"Kumar\",\n" +
                        "    \"partnerName\": \"Automation"+randomId+"\"\n" +
                        "  }\n" +
                        "\n" +
                        "}").
                put(path);

        appID = resp.jsonPath().get("id");
        String body = resp.getBody().asString();
        System.out.println(body);



    }

    @Test
    public void T2_appAuthorization() {
        System.out.println(appID);

        String path = "https://partner-api.dev.pltzone.org/v1/partner/app/"+appID+"/authrequests?tenantApiCode=534ebed7-1a74-42c7-8315-608a81aeea8c&subscription=HEALTHREALTIME&subscription=HEALTHHISTORICAL&subscription=CALLREALTIME&subscription=CALLHISTORICAL&subscription=ASSETHISTORICAL&subscription=ASSETREALTIME";
        Response resp = given().
                contentType("application/json").
                put(path);
        resp.print();

        String appName = resp.jsonPath().get("name");
        //System.out.println(appName);
        Assert.assertEquals(appName,"Automation"+randomId);




    }
}





