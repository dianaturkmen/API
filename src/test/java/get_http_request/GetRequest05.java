package get_http_request;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class GetRequest05 {

    @Test
    public void test05(){
/*https://jsonplaceholder.typicode.com/todos/123 url’ine
   accept type’i “application/json” olan GET request’i yolladigimda
   gelen response’un
			status kodunun 200
   		ve content type’inin “application/json”
			ve Headers’daki “Server” in “cloudflare”
			ve response body’deki “userId”’nin 7
			ve “title” in “esse et quis iste est earum aut impedit”
			ve “completed” bolumunun false oldugunu test edin
 */

String url= "https://jsonplaceholder.typicode.com/todos/123";

        Response response=given().then().when().get(url);
                        response.prettyPrint();

        response.then()
                .assertThat()
                .contentType(ContentType.JSON)
                .statusCode(200)

                .headers("Server", equalTo("cloudflare"), "Pragma", equalTo("no-cache"));

        response.then().assertThat().body("userId", equalTo(7),
                        "title", equalTo("esse et quis iste est earum aut impedit"),
                        "completed", equalTo(false));

    }
}