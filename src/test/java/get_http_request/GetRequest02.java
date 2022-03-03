package get_http_request;

import io.restassured.response.Response;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetRequest02 {

    @Test
    public void test02(){
        String  url="https://reqres.in/api/users";

        Response response=given().when().get(url);
        //response.prettyPrint();
        //response.prettyPeek();
        response.then().log().all();
        response.then().assertThat().statusCode(200).contentType("application/json; charset=utf-8").statusLine("HTTP/1.1 200 OK");
    response.then().body("data[0].first_name", Matchers.equalTo("George"),"data[0].last_name",Matchers.equalTo("Bluth"),"data[0].email",Matchers.equalTo("george.bluth@reqres.in"));
   //response.then().body("data[1].id",)
    }

}
