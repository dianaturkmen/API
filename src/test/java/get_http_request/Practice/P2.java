package get_http_request.Practice;

import base_url.GMIBankBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class P2 extends GMIBankBaseUrl{


    @Test
    public void testP2(){


        spec03.pathParams("first", "tp-customers", "second", 43703);
        Response response=given().spec(spec03).header("Authorization", "Bearer "+ generateToken())
                .when()
                .get("/{first}/{second}");
        response.prettyPrint();

        // "id": 43703,
        //        "firstName": "Alda",
        //        "lastName": "Monahan",
        //        "phoneNumber": "231-501-9849",

        //*****************De-Serialization**********************
        Map<String,Object> expectedData=new HashMap<>();
        expectedData.put("firstName","Alda");
        expectedData.put("lastName", "Monahan");
        expectedData.put("phoneNumber", "231-501-9849");
        System.out.println("Expected Data "+ expectedData);

        Map<String,Object> actualData= response.as(HashMap.class);
        System.out.println("Actual Data" + actualData);
        Assert.assertEquals(expectedData.get("firstName"), actualData.get("firstName"));
        Assert.assertEquals(expectedData.get("lastName"), actualData.get("lastName"));
        Assert.assertEquals(expectedData.get("phoneNumber"), actualData.get("phoneNumber"));
        System.out.println("De-Serialization ile dogrulama ");
        //*****************Matcher Class **********************
        response.then().assertThat().body("firstName", equalTo("Alda"), "lastName",
                equalTo("Monahan"),"phoneNumber", equalTo("231-501-9849") );
        System.out.println("MAtcher Calss ile dogrulama");
                //*****************Json Path **********************
        JsonPath json=response.jsonPath();
        Assert.assertEquals("Alda", json.getString("firstName"));
        Assert.assertEquals("Monahan", json.getString("lastName"));
        Assert.assertEquals("231-501-9849", json.getString("phoneNumber"));
        System.out.println("JsonPath ile dogrulama");


    }

}
