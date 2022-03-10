package get_http_request.day06;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetRequest11 {

    String endPoint = "http://www.gmibank.com/api/tp-customers";
    String bearerToken = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJiYXRjaDQ0YXBpIiwiYXV0aCI6IlJPTEVfQ1VTVE9NRVIiLCJleHAiOjE2NDY1OTEwMDN9.bTmlOY3aJWUie4bJfWAlsmhYVi4XHl18rrhcSAi6OP9GnmbEudko8zSk602QUepI8E6LlfOjdH2_QEX62sjT_Q";

    @Test
    public void test(){

        Response response = given()
                .header("Authorization","Bearer " + bearerToken)
                .when().get(endPoint).then().extract().response();

        response.prettyPrint();
    }
}