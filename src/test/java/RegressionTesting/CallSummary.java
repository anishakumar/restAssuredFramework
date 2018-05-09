package RegressionTesting;

import Utils.RestUtil;
import io.restassured.response.Response;
import org.junit.*;
import org.junit.runners.MethodSorters;

import java.util.*;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class CallSummary {
    private String path = "https://partner-api.dev.pltzone.org/v1/reports/usage/tenant/534ebed7-1a74-42c7-8315-608a81aeea8c/callsummary?callStartFromDateTime=2015-06-01T21:06:18.804Z&callEndToDateTime=2019-06-08T21:06:18.804Z&page=0&count=10";

    @Test
    public void T1_CheckTenantId(){

        Response resp = given().
                header("appID", "abcd").
        when().
                get(path);

        //resp.print();

        String tenantID = resp.jsonPath().get("body['content'][0]['tenantId']");
        System.out.println(tenantID);
        Assert.assertEquals(tenantID,"534ebed7-1a74-42c7-8315-608a81aeea8c");


 }

    @Test
    public void T2_CheckTenantName(){

         Response resp = given().
                header("appID", "abcd").
                when().
                get(path);


        String tenantName = resp.jsonPath().get("body['content'][0]['tenantName']");
        System.out.println(tenantName);
        Assert.assertEquals(tenantName,"automation");


    }

    @Test
    public void T3_CheckFieldValues(){

        Response resp = given().
                header("appID", "abcd").
                when().
                get(path);
        resp.print();
        String family = resp.jsonPath().get("body['content'][0]['product']['family']");
        Assert.assertNotNull(family);
        System.out.println(family);


//        String tenantName = resp.jsonPath().get("body['content'][0]['tenantName']");
//        System.out.println(tenantName);
//        Assert.assertEquals(tenantName,"automation");


    }

}
