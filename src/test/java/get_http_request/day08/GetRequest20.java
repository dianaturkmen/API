package get_http_request.day08;

import base_url.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class getRequest20 extends JsonPlaceHolderBaseUrl {

     /*
https://jsonplaceholder.typicode.com/todos/2
1) Status kodunun 200,
2) respose body'de,
         "completed": değerinin false
         "title": değerinin "quis ut nam facilis et officia qui"
         "userId" sinin 1 ve
    header değerlerinden
         "via" değerinin "1.1 vegur" ve
         "Server" değerinin "cloudflare" olduğunu test edin…
*/
    @Test
    public void test20(){
      spec04.pathParams("1", "todos", "2",2);
        HashMap<String, Object> expextedData=new HashMap<>();
        expextedData.put("sattusCode", 200);
        expextedData.put("completed", false);
        expextedData.put("userID", 1);
        expextedData.put("via", "1.1 vegur");
        expextedData.put("title","quis ut nam facilis et officia qui" );
        expextedData.put("Server", "cloudflare");

        Response response=given().spec(spec04).when().get("/{1}/{2}");
        response.prettyPrint();

        response.then().assertThat().statusCode((Integer)expextedData.get("statusCode"))
                .headers("via", equalTo(expextedData.get("via")),"server",equalTo("Server"))
                .body("userID",equalTo(expextedData.get("userID")),"title", equalTo(expextedData.get("title")));

    }
}
