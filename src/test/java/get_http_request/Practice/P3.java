package get_http_request.Practice;

import base_url.GMIBankBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class P3 extends GMIBankBaseUrl {

    //{
    //        "id": 59532,
    //        "firstName": "myCustomer1",
    //        "lastName": "Williamson",
    //        "middleInitial": "Davina Russel Pollich",
    //        "email": "Name1@gmail.com",

    //    }

@Test
    public void testP3  (){
    spec03.pathParams("first", "tp-customers", "second", 59532);
    Response response=given().spec(spec03).header("Authorization", "Bearer " +generateToken())
            .when().get("/{first}/{second}");
    response.prettyPrint();
    response.then().assertThat().statusCode(200).contentType(ContentType.JSON);

}
}


