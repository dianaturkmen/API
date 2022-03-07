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

public class P1 extends GMIBankBaseUrl {
        /*
http://www.gmibank.com/api/tp-customers/110472
    "id": 110472,
    "firstName": "Melva",
    "lastName": "Bernhard",
    "middleInitial": "A",

        }

1) MATCHERS CLASS
2) JSON PATH
3) De-Serialization
*/

@Test
public void test01(){
spec03.pathParams("first","tp-customers", "second", 110472 );

    Response response= given()
            .spec(spec03).header("Authorization", "Bearer "+ generateToken())
            .when()
            .get("/{first}/{second}");
    response.prettyPrint();
//De-Serialization
    Map<String,Object> map= new HashMap<>();
    map.put("firstName", "Melva");
    map.put("lastName", "Bernhard");
    map.put("middleInitial","A");
    System.out.println("Expected Data "+ map);
    Map <String, Object> actualData= response.as(HashMap.class);
    System.out.println("Actual Data" + actualData);
    Assert.assertEquals(map.get("firstName"), actualData.get("firstName"));
    Assert.assertEquals(map.get("lastName"), actualData.get("lastName"));
    Assert.assertEquals(map.get("middleInitial"), actualData.get("middleInitial"));

//Matcher ile
    response.then().assertThat()
            .body("firstName", equalTo("Melva"),
                "lastName", equalTo("Bernhard"),
                        "middleInitial", equalTo("A") );
//Json Path ile
    JsonPath json=response.jsonPath();
    Assert.assertEquals("Melva",json.getString("firstName"));
    Assert.assertEquals("Bernhard",json.getString("Bernhard"));
    Assert.assertEquals("A",json.getString("middleInitial"));
}
}