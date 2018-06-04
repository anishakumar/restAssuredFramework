package RegressionTesting;

import Utils.RestUtil;
import io.restassured.response.Response;
import org.junit.*;
import org.junit.runners.MethodSorters;

import java.util.*;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class DeviceInventory {
    private String path = "https://partner-api.dev.pltzone.org/v1/reports/assets/tenant/534ebed7-1a74-42c7-8315-608a81aeea8c/device/23E31E17CAE2FC4EA89366A8684C9235";

    @Test
    public void T1_CheckTenantId() {

        Response resp = given().
                header("appID", "35f8dffb-650b-42c5-af27-76be5bc2053d").
                when().
                get(path);

        resp.print();

        String tenantID = resp.jsonPath().get("tenantId");
        System.out.println(tenantID);
        Assert.assertEquals(tenantID, "534ebed7-1a74-42c7-8315-608a81aeea8c");


    }
}